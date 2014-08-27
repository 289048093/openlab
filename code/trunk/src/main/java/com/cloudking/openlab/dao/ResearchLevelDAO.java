package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.ResearchAchieveEntity;
import com.cloudking.openlab.entity.ResearchLevelEntity;

@Repository("researchLevelDAO")
public class ResearchLevelDAO extends BaseDAO<ResearchLevelEntity> {
	/**
	 * 查询出公开的级别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<ResearchLevelEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from ResearchLevelEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<ResearchLevelEntity>) list(hql);
	}
	/**
	 * 查询出公开的级别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<ResearchLevelEntity> listPubliced(PageInfo pageInfo) throws SQLException {
		String hql = "select catEntity_ from ResearchLevelEntity catEntity_ where  catEntity_.publiced=1 ";
		// 分页查询
		List<?> queryResult = pageQuery(hql, null,null,pageInfo);
		return (List<ResearchLevelEntity>) queryResult;
	}
}
