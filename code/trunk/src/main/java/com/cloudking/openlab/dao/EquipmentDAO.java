package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.EquipmentEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.EquipmentVO;

@Repository("equipmentDAO")
public final class EquipmentDAO extends BaseDAO<EquipmentEntity> {
	/**
	 * 查询
	 * 
	 * @param cloudContext
	 * @return
	 * @throws SQLException
	 */
	public List<Object[]> query(String name,String model ,Long catId,Long labId,Long commId, PageInfo pageInfo)
			throws SQLException {
		StringBuffer resultHQL = new StringBuffer(
				"select  ment,cat,lab,commonTechPlatform from EquipmentEntity ment  "
						+ "left join ment.cat as cat left join ment.lab as lab    left join ment.commonTechPlatform as commonTechPlatform where (ment.status=:status or ment.status=:status1) and ment.publiced=1");
		// 条件拼装列表
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		// name
		if (!StringUtil.isBlank(name)) {
			resultHQL.append(" and ment.name like :name ");
			paramNames.add("name");
			paramValues.add("%" +name + "%");
		}
		// model 型号
		if (!StringUtil.isBlank(model)) {
			resultHQL.append(" and ment.model like :model ");
			paramNames.add("model");
			paramValues.add("%" + model + "%");
		}
		// cat
		if (catId != null) {
			resultHQL.append(" and cat.id = :cat ");
			paramNames.add("cat");
			paramValues.add(catId);
		}
		// lab
		if (labId != null) {
			resultHQL.append(" and lab.id = :lab ");
			paramNames.add("lab");
			paramValues.add(labId);
		}
		//公共技术平台
		if (commId != null) {
			resultHQL.append(" and commonTechPlatform.id = :comm ");
			paramNames.add("comm");
			paramValues.add(commId);
		}
		// 状态 正常
		paramNames.add("status");
		paramValues.add(Constant.EQUIPMENTMAINTAIN_STATUS_NORMAL);
		// 状态 忙碌
		paramNames.add("status1");
		paramValues.add(Constant.EQUIPMENTMAINTAIN_STATUS_BUSY);
		// 排序
		resultHQL.append("  order by ment.addTime desc ");
		// List<EquipmentEntity> equipmentEntities = new
		// ArrayList<EquipmentEntity>();
		List<Object[]> resultQuery = pageQuery(resultHQL.toString(), paramNames,
				paramValues, pageInfo);
		// cloudContext.getPageInfo().setDataCount(equipmentEntities.size());
		return (List<Object[]>) resultQuery;
	}

	public EquipmentEntity queryById(CloudContext<EquipmentVO> cloudContext)
			throws SQLException {
		EquipmentEntity equipmentEntity = uniqueResult(
				"select ment from EquipmentEntity ment  "
						+ "left join ment.cat as cat left join ment.lab as lab  left join lab.dept as dept  left join ment.commonTechPlatform as commonTechPlatform where ment.id=:ment",
				"ment", cloudContext.getVo().getId());
		return equipmentEntity;
	}

	/**
	 * 获取最新录入的设备的信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public EquipmentEntity getZheNewEquipment() throws SQLException {
		String hql = "from EquipmentEntity e_ where e_.id=(select max(e2_.id) from  EquipmentEntity e2_ where e2_.addTime=(select max(addTime) from EquipmentEntity e2_)))";
		EquipmentEntity equipmentEntity = uniqueResult(hql);
		return equipmentEntity;
	}
	  /**
     * 查询仪器设备的管理员信息
     * @param id
     * @return
     * @throws SQLException
     */
    public UserEntity queryEquipmentSystem(long id) throws SQLException{
    	String hql="select manager from EquipmentEntity  eq left join eq.lab.manager  as manager  where eq.id=:id";
    	
    	return (UserEntity) uniqueResultObject(hql, "id", id);
    	
    }
}
