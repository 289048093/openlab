package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.TimequantumEntity;
/**
 * 仪器使用时间段
 * @author Administrator
 *
 */
@Repository("timequantumDAO")
public class TimequantumDAO  extends BaseDAO<TimequantumEntity>{
	
	@SuppressWarnings("unchecked")
	public  List<TimequantumEntity> queryByEquipmentId(Long id) throws SQLException{
		String hql="select t from  TimequantumEntity t  where t.entity.id=:id and endDate>now() ";
		
		return list(hql, "id", id);
	}

}
