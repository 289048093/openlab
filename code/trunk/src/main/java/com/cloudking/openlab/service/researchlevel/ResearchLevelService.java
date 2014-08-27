package com.cloudking.openlab.service.researchlevel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.dao.ResearchLevelDAO;
import com.cloudking.openlab.entity.ResearchAchieveEntity;
import com.cloudking.openlab.entity.ResearchLevelEntity;
import com.cloudking.openlab.vo.ResearchAchieveVO;
import com.cloudking.openlab.vo.ResearchLevelVO;

@Service("researchLevelService")
public class ResearchLevelService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private ResearchLevelDAO researchLevelDAO;

	/**
	 * 查询全部
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<ResearchLevelVO> queryAll() throws SQLException {

		List<ResearchLevelEntity> levelEntities = researchLevelDAO.listPubliced();
		List<ResearchLevelVO> achieveVOs = new ArrayList<ResearchLevelVO>();
		ResearchLevelVO levelVO = null;
		for (ResearchLevelEntity level : levelEntities) {
			levelVO = new ResearchLevelVO();
			BeanUtils.copyProperties(level, levelVO);
			achieveVOs.add(levelVO);

		}
		return achieveVOs;

	}
	/**
	 * 查询全部
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<ResearchLevelVO> queryAllByPage(PageInfo pageInfo) throws SQLException {

		List<ResearchLevelEntity> levelEntities = researchLevelDAO.listPubliced(pageInfo);
		List<ResearchLevelVO> achieveVOs = new ArrayList<ResearchLevelVO>();
		ResearchLevelVO levelVO = null;
		for (ResearchLevelEntity level : levelEntities) {
			levelVO = new ResearchLevelVO();
			BeanUtils.copyProperties(level, levelVO);
			achieveVOs.add(levelVO);

		}
		return achieveVOs;

	}

}