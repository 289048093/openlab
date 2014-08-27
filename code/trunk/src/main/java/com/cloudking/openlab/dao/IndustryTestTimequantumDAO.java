package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.IndustryTestTimequantumEntity;
import com.cloudking.openlab.entity.TimequantumEntity;
/**
 * 仪器使用时间段
 * @author Administrator
 *
 */
@Repository("industryTestTimequantumDAO")
public class IndustryTestTimequantumDAO  extends BaseDAO<TimequantumEntity>{
	
	public  List<IndustryTestTimequantumEntity> queryByIndustryTestId(Long id) throws SQLException{
		String hql="select t from  IndustryTestTimequantumEntity t  where t.entity.id=:id   and endDate>now()";
		
		return list(hql, "id", id);
	}

}
