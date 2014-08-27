package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.DownloadFileEntity;
import com.cloudking.openlab.util.StringUtil;

@Repository("downloadFileDAO")
public class DownloadFileDAO extends BaseDAO<DownloadFileEntity> {

	/**
	 * 通过文件名与文件描述进行搜索
	 * 
	 * @param qName
	 * @param qDesc
	 * @param pageInfo
	 * @return
	 * @throws SQLException
	 */
	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public List<DownloadFileEntity> query(String qName, String qDesc,
			Long catId, PageInfo pageInfo) throws SQLException {
		StringBuilder queryQL = new StringBuilder(
				"select downloadFile_ from DownloadFileEntity downloadFile_ inner join downloadFile_.cat cat_ where cat_.publiced=1 and  downloadFile_.publiced=1 ");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		// 文件名称
		if (!StringUtil.isBlank(qName)) {
			queryQL.append(" and  downloadFile_.name like :name ");
			paramNames.add("name");
			paramValues.add("%" + qName + "%");
		}
		// 文件描述
		if (!StringUtil.isBlank(qDesc)) {
			queryQL.append(" and  downloadFile_.desc like :desc ");
			paramNames.add("desc");
			paramValues.add("%" + qDesc + "%");
		}
		// 文件类别
		if (catId != null) {
			queryQL.append(" and  downloadFile_.cat.id =:catId ");
			paramNames.add("catId");
			paramValues.add(catId);
		}
		// 排序
		queryQL.append("  order by downloadFile_.id asc");
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<DownloadFileEntity>) queryResult;
	}
}
