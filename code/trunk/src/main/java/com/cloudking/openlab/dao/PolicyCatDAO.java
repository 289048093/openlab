package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.PolicyCatEntity;

/**
 * 
 * @author cloudKing
 * 
 */
@Repository("policyCatDAO")
public class PolicyCatDAO extends BaseDAO<PolicyCatEntity> {

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<PolicyCatEntity> getallCat() throws SQLException {
		return list();
	}

	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<PolicyCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from PolicyCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<PolicyCatEntity>) list(hql);
	}
}
