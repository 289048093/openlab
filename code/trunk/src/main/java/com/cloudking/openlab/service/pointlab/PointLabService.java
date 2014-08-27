package com.cloudking.openlab.service.pointlab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.PointLabCatDAO;
import com.cloudking.openlab.dao.PointLabDAO;
import com.cloudking.openlab.entity.PointLabCatEntity;
import com.cloudking.openlab.entity.PointLabEntity;
import com.cloudking.openlab.vo.PointLabCatVO;
import com.cloudking.openlab.vo.PointLabVO;

@Service("pointLabService")
public class PointLabService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private PointLabDAO pointLabDAO;

	// 引入实验室分类DAO
	@Resource
	private PointLabCatDAO pointLabCatDAO;

	/**
	 * 通过ID查询重点实验室的详情
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void queryById(CloudContext<PointLabVO> cloudContext)
			throws SQLException {
		PointLabEntity pointLabEntity = pointLabDAO.get(cloudContext.getVo()
				.getId());
		if (pointLabEntity == null) {
			cloudContext.addErrorMsg("重点实验室不存在，请从新刷新");
			return;
		}
		BeanUtils.copyProperties(pointLabEntity, cloudContext.getVo());
	}

	/**
	 * 实验室
	 */
	public List<PointLabVO> query() throws SQLException {
		List<PointLabVO> iNTestCatVOs = new ArrayList<PointLabVO>();
		List<PointLabEntity> labEntities = pointLabDAO.list();
		PointLabVO labVO = null;
		for (PointLabEntity lab : labEntities) {
			labVO = new PointLabVO();
			BeanUtils.copyProperties(lab, labVO);
			iNTestCatVOs.add(labVO);
		}
		return iNTestCatVOs;
	}

	/**
	 * 查询
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void query(CloudContext<PointLabVO> cloudContext)
			throws SQLException {
		List<PointLabEntity> pointLabEntitys = null;
		List<PointLabCatEntity> pointLabCatEntitys = null;
		PointLabVO pointLabVO = null;
		PointLabCatVO pointLabCatVO = null;
		// 查处所有的实验室
		pointLabEntitys = pointLabDAO.query(cloudContext.getLongParam("catId"),
				cloudContext.getPageInfo());
		// 查询出所有的类别
		pointLabCatEntitys = pointLabCatDAO.listPubliced();
		// 实验室集合
		List<PointLabVO> pointLabVOs = new ArrayList<PointLabVO>();
		// 实验室分类集合
		List<PointLabCatVO> pointLabCatVOs = new ArrayList<PointLabCatVO>();
		if (pointLabEntitys != null) {
			for (PointLabEntity e : pointLabEntitys) {
				pointLabVO = new PointLabVO();
				BeanUtils.copyProperties(e, pointLabVO);
				pointLabVOs.add(pointLabVO);
			}
		}
		if (pointLabCatEntitys != null) {
			for (PointLabCatEntity e : pointLabCatEntitys) {
				pointLabCatVO = new PointLabCatVO();
				BeanUtils.copyProperties(e, pointLabCatVO);
				pointLabCatVOs.add(pointLabCatVO);
			}
			cloudContext.addParam("pointLabCatVOs", pointLabCatVOs);
			cloudContext.addParam("pointLabVOs", pointLabVOs);
		}
	}
}
