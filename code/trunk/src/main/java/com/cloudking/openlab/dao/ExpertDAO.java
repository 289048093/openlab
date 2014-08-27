package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.ExpertEntity;
import com.cloudking.openlab.util.Constant;
@Repository("expertDAO")
public class ExpertDAO extends BaseDAO<ExpertEntity>{
	//hql语句
	String hql;
	/**
	 * 根据不同的角色获取用户，专用于专家
	 * @param role 传入的角色对应的id。
	 * @return
	 * @throws SQLException 
	 */
	public List<ExpertEntity> getExpertsByRole(Long role) throws SQLException{
		hql = "select e_ from ExpertEntity e_ left join e_.roles r_ where r_.id=:role_ID order by e_.id desc";
		return pageQuery(hql,"role_ID",role, 0, 9);
	} 
	
	
	public List<ExpertEntity> query(PageInfo pageInfo) throws SQLException {
		StringBuilder queryQL = new StringBuilder(
		"select e_ from ExpertEntity e_ where e_.status=:normal");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (true) {
			paramNames.add("normal");
			paramValues.add(Constant.USER_NORMAL_STATE);
		}
		// 排序
		queryQL.append(" order by e_.id asc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<ExpertEntity> )queryResult;
	}
	/**
	 * 首页获取可以显示在前首页的专家
	 * @param isShowInIndex
	 * @return
	 * @throws SQLException
	 */
	public List<ExpertEntity> getExpertsByShowInIndex(boolean isShowInIndex)throws SQLException{
		hql = "select e_ from ExpertEntity e_ where e_.indexShow=:isShowInIndex";
		return list(hql, "isShowInIndex", isShowInIndex);
	}
}
