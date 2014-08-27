package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.NewsEntity;
import com.cloudking.openlab.util.StringUtil;

/**
 * 
 * @author cloudKing
 * 
 */
@Repository("newsDAO")
public class NewsDAO extends BaseDAO<NewsEntity> {
	/**
	 * 查询
	 * 
	 * @param pageInfo
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<NewsEntity> query(String title, Long catId, PageInfo pageInfo)
			throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select news_ from NewsEntity news_ left join news_.newsCat cat_ where (cat_ is null or cat_.publiced=1) and news_.publiced=1 ");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (!StringUtil.isBlank(title)) {
			queryQL.append(" and  news_.title like :title ");
			paramNames.add("title");
			paramValues.add("%" + title + "%");
		}
		if (catId != null) {
			queryQL.append(" and  news_.newsCat.id =:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		// 排序
		queryQL.append(" order by news_.modifyDate desc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<NewsEntity>) queryResult;
	}
}
