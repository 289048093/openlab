package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.IndustryTestEntity;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.IndustryTestVO;

@Repository("industryTestDAO")
public class IndustryTestDAO extends BaseDAO<IndustryTestEntity> {
	/**
	 * 查询
	 * 
	 * @param cloudContext
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> query(
			String name,Long catId,PageInfo pageInfo) throws SQLException {
		StringBuffer resultHQL = new StringBuffer(
				"select test,cat from IndustryTestEntity test left join  test.industryTestcat cat  where cat.publiced=1 and test.publiced=1 ");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		// name
		if (!StringUtil.isBlank(name)) {
			resultHQL.append(" and test.name like :name ");
			paramNames.add("name");
			paramValues.add("%" + name + "%");
		}

		
		// cat
		if (catId != null) {
			resultHQL.append(" and cat.id = :cat ");
			paramNames.add("cat");
			paramValues.add(catId);
		}
		// 排序
		resultHQL.append("  order by test.id asc ");

		List<Object[]> resultQuery = pageQuery(resultHQL.toString(), paramNames,
				paramValues,pageInfo);
		return  resultQuery;
	}

	/**
	 * 根据编号查询
	 * 
	 * @param cloudContext
	 * @return
	 * @throws SQLException
	 */
	public IndustryTestEntity queryById(
			CloudContext<IndustryTestVO> cloudContext) throws SQLException {

		IndustryTestEntity industryTestEntity = uniqueResult(
				"select test from IndustryTestEntity test  left join fetch test.industryTestcat  cat where test.id=:id",
				"id", cloudContext.getVo().getId());

		return industryTestEntity;
	}

}
