package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.NewsCatEntity;

/**
 * 
 * @author cloudKing
 * 
 */
@Repository("newsCatDAO")
public class NewsCatDAO extends BaseDAO<NewsCatEntity> {
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<NewsCatEntity> listPubliced() throws SQLException {
		String hql = "select newsCat_ from NewsCatEntity newsCat_ where  newsCat_.publiced=1 ";
		return (List<NewsCatEntity>) list(hql);
	}
}
