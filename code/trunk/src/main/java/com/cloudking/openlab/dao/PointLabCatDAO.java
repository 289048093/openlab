package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.PointLabCatEntity;

@Repository("pointLabCatDAO")
public class PointLabCatDAO extends BaseDAO<PointLabCatEntity> {
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<PointLabCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from PointLabCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<PointLabCatEntity>) list(hql);
	}
}
