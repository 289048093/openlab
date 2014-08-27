package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.ResearchAchieveEntity;

@Repository("researchAchieveDAO")
public class ResearchAchieveDAO extends BaseDAO<ResearchAchieveEntity> {

	@SuppressWarnings("unchecked")
	public List<ResearchAchieveEntity> query(Long levelId, PageInfo pageInfo)
			throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select re from ResearchAchieveEntity re left join re.user as u inner join re.level level_ where level_.publiced =1 and re.publiced=1");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (levelId != null) {
			queryQL.append(" and  level_.id =:levelId ");
			paramNames.add("levelId");
			paramValues.add(levelId);
		}
		// 排序
		queryQL.append(" order by re.id asc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<ResearchAchieveEntity>) queryResult;
	}

}
