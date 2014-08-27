package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.TechTransferEntity;

@Repository("techTransferDAO")
public class TechTransferDAO extends BaseDAO<TechTransferEntity> {

	public List<TechTransferEntity> query(Long catId, PageInfo pageInfo)
			throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select te from TechTransferEntity  te left join  te.user as u  inner join te.cat cat_ where cat_.publiced=1 and te.publiced=1");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (catId != null) {
			queryQL.append(" and  te.cat.id =:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		// 排序
		queryQL.append(" order by te.id asc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<TechTransferEntity>) queryResult;
	}

}
