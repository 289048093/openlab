package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.entity.EquipmentLogEntity;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.EquipmentLogVO;

@Repository("equipmentLogDAO")
public class EquipmentLogDAO extends BaseDAO<EquipmentLogEntity> {
	
	
	@SuppressWarnings("unchecked")
	public Collection<Object[]> query(CloudContext<EquipmentLogVO> cloudContext) throws NumberFormatException, SQLException{
		
		// 查询所有
		StringBuffer resultHQL = new StringBuffer(
				"select  log.id ,log.desc,eq.name,user.realname ,log.addDate from EquipmentLogEntity as  log  " +
				"left join   log.equipment  as eq    left join   log.user as  user where 1=1 ");

		// 记录数目统计
		StringBuffer countHQL = new StringBuffer(
				"select count(log.id) from EquipmentLogEntity as  log left join   log.equipment  as eq    left join   log.user as  user where 1=1  ");

		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();

		// 操作人员
		if (cloudContext.getLongParam("user")!=null) {
			resultHQL.append(" and user.id = :uid ");
			countHQL.append(" and user.id = :uid ");
			paramNames.add("uid");
			paramValues.add(cloudContext.getLongParam("user"));
		}
		// 关键字
		if (!StringUtil.isBlank(cloudContext.getVo().getDesc())) {
			resultHQL.append(" and log.desc like :desc ");
			countHQL.append(" and log.desc like :desc ");
			paramNames.add("desc");
			paramValues.add("%"+cloudContext.getVo().getDesc()+"%");
		}

		// 排序
		resultHQL.append("  order by  log.addDate desc ");

		// 查询总页数
		Integer count = Integer
				.parseInt(uniqueResultObject(
						countHQL.toString(),
						paramNames.toArray(paramNames
								.toArray(new String[paramNames.size()])),
						paramValues.toArray(new Object[paramValues.size()]))
						.toString());

		Collection<Object[]> voList = new ArrayList<Object[]>(count);
		if (count > 0) {
			// 分页查询
			voList = pageQuery(resultHQL.toString(),
					paramNames.toArray(paramNames.toArray(new String[paramNames
							.size()])), paramValues
							.toArray(new Object[paramValues.size()]),
					cloudContext.getPageInfo().getStart(), cloudContext
							.getPageInfo().getEachPageData());
		}
		   cloudContext.getPageInfo().setDataCount(count); 
		return voList;
		
	}
	
	

}
