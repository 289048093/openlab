package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.ResearchLevelEntity;
import com.cloudking.openlab.entity.TechTransferCatEntity;

@Repository("techTransferCatDAO")
public class TechTransferCatDAO extends BaseDAO<TechTransferCatEntity> {
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<TechTransferCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from TechTransferCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<TechTransferCatEntity>) list(hql);
	}
	
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<TechTransferCatEntity> listPubliced(PageInfo pageInfo) throws SQLException {
		String hql = "select catEntity_ from TechTransferCatEntity catEntity_ where  catEntity_.publiced=1 ";
		// 分页查询
		List<?> queryResult = pageQuery(hql, null,null,pageInfo);
		return (List<TechTransferCatEntity>) queryResult;
	}
}
