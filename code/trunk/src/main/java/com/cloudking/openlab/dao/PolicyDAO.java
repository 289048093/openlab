package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.PolicyEntity;
import com.cloudking.openlab.util.StringUtil;

/**
 * 
 * @author cloudKing
 * 
 */
@Repository("policyDAO")
public class PolicyDAO extends BaseDAO<PolicyEntity> {
	/**
	 * 查询
	 * 
	 * @param pageInfo
	 * @return
	 * @throws SQLException
	 */
	public List<PolicyEntity> query(String title, Long catId, PageInfo pageInfo)
			throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select policy_ from PolicyEntity policy_ inner join policy_.policyCat policyCat_ where policyCat_.publiced=1 and  policy_.publiced=1");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (!StringUtil.isBlank(title)) {
			queryQL.append(" and  policy_.title like :title ");
			paramNames.add("title");
			paramValues.add("%" + title + "%");
		}
		if (catId != null) {
			queryQL.append(" and  policy_.policyCat.id=:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		// 排序
		queryQL.append(" order by policy_.modifyDate desc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<PolicyEntity>) queryResult;
	}
}
