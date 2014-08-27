package com.cloudking.openlab.service.news;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.DeptDAO;
import com.cloudking.openlab.dao.NewsCatDAO;
import com.cloudking.openlab.dao.NewsDAO;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.entity.NewsCatEntity;
import com.cloudking.openlab.entity.NewsEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.NewsCatVO;
import com.cloudking.openlab.vo.NewsVO;

/**
 * 新闻service
 * 
 * @author CloudKing
 * 
 */
@Service("newsService")
public class NewsService extends BaseService {

	@Resource
	private NewsDAO newsDAO;
	/**
	 * 引入分类的DAO
	 */
	@Resource
	private NewsCatDAO newsCatDAO;
	@Resource
	private DeptDAO deptDAO;

	/**
	 * 通过id 查询新闻的详情
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void queryById(CloudContext<NewsVO> cloudContext)
			throws SQLException {

		NewsEntity newsEntity = newsDAO.get(cloudContext.getVo().getId());
		if (newsEntity == null) {
			cloudContext.addErrorMsg("新闻不存在，请刷新后重试！");
			return;
		}
		// 供稿单位
		String provider = newsEntity.getProviderName();
		DeptEntity dept = null;
		if (!StringUtil.isBlank(provider)) {
			if (provider.matches("\\d+")) {
				Long providerId = Long.parseLong(provider);
				dept = deptDAO.get(providerId);
				newsEntity.setProviderName(dept.getName());
			}
		}

		EntityManager em = ProjectUtil.getEntityManager();
		em.getTransaction().begin();
		Integer count = newsEntity.getCount();
		count = count == null ? 0 : count;
		newsEntity.setCount(++count);
		em.merge(newsEntity);
		em.getTransaction().commit();
		em.close();

		BeanUtils.copyProperties(newsEntity, cloudContext.getVo());
	}

	/**
	 * 查询新闻及类别
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void query(CloudContext<NewsVO> cloudContext) throws SQLException {
		List<NewsEntity> newsEntitys = null;
		List<NewsCatEntity> newsCatEntitys = null;
		NewsVO newsVO = null;
		NewsCatVO newsCatVO = null;
		// 查出所有公开的新闻
		newsEntitys = newsDAO.query(cloudContext.getVo().getTitle(),
				cloudContext.getLongParam("catId"), cloudContext.getPageInfo());
		// 查询出所有公开的类别
		newsCatEntitys = newsCatDAO.listPubliced();
		// 置顶新闻集合
		List<NewsVO> topNewsVOs = new ArrayList<NewsVO>();
		// 不置顶新闻集合
		List<NewsVO> untopNewsVOs = new ArrayList<NewsVO>();
		// 新闻分类集合
		List<NewsCatVO> newsCatVOs = new ArrayList<NewsCatVO>();

		if (newsEntitys != null) {
			for (NewsEntity e : newsEntitys) {
				newsVO = new NewsVO();
				// 查询置顶新闻
				if (e.getTop().equals(Constant.TOP)) {
					BeanUtils.copyProperties(e, newsVO);
					topNewsVOs.add(newsVO);
				} else {
					BeanUtils.copyProperties(e, newsVO);
					untopNewsVOs.add(newsVO);
				}
			}
		}

		if (newsCatEntitys != null) {
			for (NewsCatEntity e : newsCatEntitys) {
				newsCatVO = new NewsCatVO();
				BeanUtils.copyProperties(e, newsCatVO);
				newsCatVOs.add(newsCatVO);
			}
		}
		cloudContext.addParam("newsCatVOs", newsCatVOs);
		cloudContext.addParam("topNewsVOs", topNewsVOs);
		cloudContext.addParam("untopNewsVOs", untopNewsVOs);
	}
}
