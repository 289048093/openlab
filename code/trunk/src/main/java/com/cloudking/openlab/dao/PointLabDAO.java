package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.entity.PointLabEntity;

@Repository("pointLabDAO")
public class PointLabDAO extends BaseDAO<PointLabEntity> {

	@SuppressWarnings("unchecked")
	public List<PointLabEntity> query(Long catId, PageInfo pageInfo)
			throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select pointLab_ from PointLabEntity pointLab_ left join pointLab_.cat cat_ where (cat_ is null or cat_.publiced=1) and pointLab_.publiced=1 ");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (catId != null) {
			queryQL.append(" and  pointLab_.cat.id =:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		// 排序
		queryQL.append(" order by pointLab_.id desc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<PointLabEntity>) queryResult;
	}
	
	/**
	 * 查询所属部门
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public DeptEntity queryDept(Long id) throws SQLException{
		String hql="select dept from  PointLabEntity pointLab_  left join pointLab_.dept  dept where pointLab_.id=:id";
		return (DeptEntity) uniqueResultObject(hql, "id", id);
	}
}
