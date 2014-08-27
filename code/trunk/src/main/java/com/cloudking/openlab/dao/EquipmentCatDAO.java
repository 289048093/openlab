package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.EquipmentCatEntity;

@Repository("equipmentCatDAO")
public class EquipmentCatDAO extends BaseDAO<EquipmentCatEntity> {
	/**
	 * 查询出公开的类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<EquipmentCatEntity> listPubliced() throws SQLException {
		String hql = "select catEntity_ from EquipmentCatEntity catEntity_ where  catEntity_.publiced=1 ";
		return (List<EquipmentCatEntity>) list(hql);
	}
}
