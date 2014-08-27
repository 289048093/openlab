package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.IndustryTestCatEntity;

@Repository("industryTestCatDAO")
public class IndustryTestCatDAO extends BaseDAO<IndustryTestCatEntity> {
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<IndustryTestCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from IndustryTestCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return list(hql);
	}
}
