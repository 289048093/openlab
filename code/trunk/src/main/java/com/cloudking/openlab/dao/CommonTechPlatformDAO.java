package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.CommonTechPlatformEntity;
import com.cloudking.openlab.entity.DeptEntity;

@Repository("commonTechPlatformDAO")
public class CommonTechPlatformDAO extends BaseDAO<CommonTechPlatformEntity> {

	@SuppressWarnings("unchecked")
	public List<CommonTechPlatformEntity> query(Long catId, PageInfo pageInfo)
			throws SQLException {
		StringBuffer resultHql = new StringBuffer(
				"select commonTechPlatform_ from CommonTechPlatformEntity commonTechPlatform_ left join commonTechPlatform_.cat cat_ where (cat_ is null or cat_.publiced=1) and commonTechPlatform_.publiced=1");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (catId != null) {
			resultHql.append(" and  commonTechPlatform_.cat.id =:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		resultHql.append(" order by commonTechPlatform_.id asc ");
		List<?> queryResult = pageQuery(resultHql.toString(), paramNames,
				paramValues, pageInfo);
		return (List<CommonTechPlatformEntity>) queryResult;
	}
	/**
	 * 查询所属部门
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public DeptEntity queryDept(Long id) throws SQLException{
		String hql="select dept from  CommonTechPlatformEntity commonTechPlatform_  left join commonTechPlatform_.dept  dept where commonTechPlatform_.id=:id";
		return (DeptEntity) uniqueResultObject(hql, "id", id);
	}
	public List<CommonTechPlatformEntity> query() throws SQLException{
		String hql="select commonTechPlatform_ from  CommonTechPlatformEntity commonTechPlatform_  left join commonTechPlatform_.dept  dept";
		
		return list(hql);
	}
}
