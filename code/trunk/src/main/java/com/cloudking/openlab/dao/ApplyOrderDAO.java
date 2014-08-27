package com.cloudking.openlab.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.entity.ApplyOrderEntity;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.ApplyOrderVO;

@Repository("applyOrderDAO")
public class ApplyOrderDAO extends BaseDAO<ApplyOrderEntity> {

	@SuppressWarnings("unchecked")
	public Collection<Object[]> query(CloudContext<ApplyOrderVO> cloudContext)
			throws Exception {
		// 查询所有
		StringBuffer resultHQL = new StringBuffer(
				"select  o.ordrNum ,eq.pic,eq.name,eq.model,o.rent,o.applyDate,o.status,o.desc ,o.subBeginDate,o.subEndDate ,o.id,eq.contact,eq.phone ,o.sysDesc from  ApplyOrderEntity   as o  inner join  o.equipment as eq    inner join  o.user as user   where 1=1");

		// 记录数目统计
		StringBuffer countHQL = new StringBuffer(
				"select count(o.id) from  ApplyOrderEntity   as o  inner join  o.equipment as eq    inner join  o.user as user   where 1=1 ");

		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();

		// 订单号
		if (!StringUtil.isBlank(cloudContext.getVo().getOrdrNum())) {
			resultHQL.append(" and o.ordrNum like :ordrNum ");
			countHQL.append(" and o.ordrNum like :ordrNum ");
			paramNames.add("ordrNum");
			paramValues.add("%" + cloudContext.getVo().getOrdrNum() + "%");
		}
		
		if (cloudContext.getVo().getId()!=null) {
			resultHQL.append(" and o.id = :id ");
			countHQL.append(" and o.id = :id ");
			paramNames.add("id");
			paramValues.add( cloudContext.getVo().getId());
		}

		if(cloudContext.getVo().getUserId()!=null){
			System.out.println("================================================================");
		// 用户
			resultHQL.append(" and user.id=:user");
			countHQL.append(" and user.id=:user ");
		paramNames.add("user");
		paramValues.add(cloudContext.getVo().getUserId());
		}
		// 排序
		resultHQL.append("  order by  o.applyDate desc ");

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

	// 查到用户申请的设备
//	public int queryEquipmentNumber(CloudContext<ApplyOrderVO> cloudContext)
//			throws Exception {
//		int count = 0;
//		Set set = (Set) query(cloudContext);
//		count = set.size();
//		return count;
//	}

	@SuppressWarnings("unchecked")
	public Collection<Object[]> queryIndustryTest(
			CloudContext<ApplyOrderVO> cloudContext) throws Exception {
		// 查询所有
		StringBuffer resultHQL = new StringBuffer(
				"select  o.ordrNum ,test.name,o.rent,o.applyDate,o.status,o.desc ,o.subBeginDate,o.subEndDate ,o.id,test.principal,test.phone,o.sysDesc,o.url from  ApplyOrderEntity   as o  inner join  o.industryTest as test    inner join  o.user as user   where user.id=:user");

		// 记录数目统计
		StringBuffer countHQL = new StringBuffer(
				"select count(o.id) from  ApplyOrderEntity   as o  inner join  o.industryTest as test    inner join  o.user as user   where user.id=:user");

		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();

		// 订单号
		if (!StringUtil.isBlank(cloudContext.getVo().getOrdrNum())) {
			resultHQL.append(" and o.ordrNum like :ordrNum ");
			countHQL.append(" and o.ordrNum like :ordrNum ");
			paramNames.add("ordrNum");
			paramValues.add("%" + cloudContext.getVo().getOrdrNum() + "%");
		}

		// 用户
		paramNames.add("user");
		paramValues.add(cloudContext.getVo().getUserId());

		// 排序
		resultHQL.append("  order by  o.applyDate desc ");

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
	/**
	 * 查询仪器设备预约时间是否可用
	 * @param equipmentId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public Collection<Object[]> findDayOrderByEquipment(Long equipmentId,Date startDate,Date endDate)throws Exception{
		// 查询所有
		StringBuffer resultHQL = new StringBuffer(
				"select  o.ordrNum ,eq.pic,eq.name,eq.model,o.rent,o.applyDate,o.status,o.desc ,o.subBeginDate,o.subEndDate ,o.id,eq.contact,eq.phone ,o.sysDesc from  ApplyOrderEntity   as o  inner join  o.equipment as eq    left join  o.user as user   where 1=1");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if(equipmentId!=null && startDate!=null && endDate!=null){
			resultHQL.append(" and eq.id=:eq");
			resultHQL
			.append(" and ((:qs>o.subBeginDate and :qe<o.subEndDate) "
					+ "or (:qs<o.subEndDate and :qe>o.subEndDate) "
					+ "or (:qs<o.subBeginDate and :qe>o.subBeginDate))");
			        
			paramNames.add("qs");
			paramValues.add(startDate);
			paramNames.add("qe");
			paramValues.add(endDate);
			paramNames.add("eq");
			paramValues.add(equipmentId);
		}
		return list(resultHQL.toString(), paramNames, paramValues);
		
	}
	/**
	 * 查询仪器设备预约时间是否可用
	 * @param EquipmentId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public Collection<Object[]> findDayOrderByIndustryTest(Long testId,Date startDate,Date endDate)throws Exception{
		// 查询所有
		StringBuffer resultHQL = new StringBuffer(
				"select o.ordrNum ,test.name,o.rent,o.applyDate,o.status,o.desc ,o.subBeginDate,o.subEndDate ,o.id,test.principal,test.phone,o.sysDesc ,o.url from  ApplyOrderEntity   as o  inner join  o.industryTest as test    inner join  o.user as user   where 1=1");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if(testId!=null && startDate!=null && endDate!=null){
			resultHQL.append(" and test.id=:test");
			resultHQL
			.append(" and ((:qs>o.subBeginDate and :qe<o.subEndDate) "
					+ "or (:qs<o.subEndDate and :qe>o.subEndDate) "
					+ "or (:qs<o.subBeginDate and :qe>o.subBeginDate))");
			paramNames.add("qs");
			paramValues.add(startDate);
			paramNames.add("qe");
			paramValues.add(endDate);
			paramNames.add("test");
			paramValues.add(testId);
		}
		return list(resultHQL.toString(), paramNames, paramValues);
		
	}

}
