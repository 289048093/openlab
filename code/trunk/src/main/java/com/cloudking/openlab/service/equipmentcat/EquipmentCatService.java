package com.cloudking.openlab.service.equipmentcat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.EquipmentCatDAO;
import com.cloudking.openlab.entity.EquipmentCatEntity;
import com.cloudking.openlab.vo.EquipmentCatVO;

@Service("equipmentCatService")
public class EquipmentCatService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private EquipmentCatDAO equipmentCatDAO;
	
	/**
	 * 查询所有仪器分类
	 * @return
	 * @throws SQLException
	 */
	public List<EquipmentCatVO> query() throws SQLException{
	List<EquipmentCatVO>  iNTestCatVOs=new ArrayList<EquipmentCatVO>();
	List<EquipmentCatEntity> catEntities=equipmentCatDAO.listPubliced();
	  EquipmentCatVO  catVO=null;
	for (EquipmentCatEntity cat : catEntities) {
		catVO=new EquipmentCatVO();
		BeanUtils.copyProperties(cat, catVO);
		iNTestCatVOs.add(catVO);
	}
		return 	iNTestCatVOs;
	}

}
