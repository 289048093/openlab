package com.cloudking.openlab.service.techtransfercat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.dao.TechTransferCatDAO;
import com.cloudking.openlab.entity.TechTransferCatEntity;
import com.cloudking.openlab.vo.TechTransferCatVO;

@Service("techTransferCatService")
public class TechTransferCatService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private TechTransferCatDAO techTransferCatDAO;
	
	
	public List<TechTransferCatVO> queryAll() throws SQLException{
		List<TechTransferCatEntity> catEntities= 	techTransferCatDAO.listPubliced();
		List<TechTransferCatVO> catVOs=new ArrayList<TechTransferCatVO>();
		TechTransferCatVO catVO=null;
		for (TechTransferCatEntity c : catEntities) {
			catVO=new TechTransferCatVO();
			BeanUtils.copyProperties(c, catVO);
			catVOs.add(catVO);
			
		}
		return  catVOs;
	}
	public List<TechTransferCatVO> queryAllByPage(PageInfo pageInfo) throws SQLException{
		List<TechTransferCatEntity> catEntities= 	techTransferCatDAO.listPubliced(pageInfo);
		List<TechTransferCatVO> catVOs=new ArrayList<TechTransferCatVO>();
		TechTransferCatVO catVO=null;
		for (TechTransferCatEntity c : catEntities) {
			catVO=new TechTransferCatVO();
			BeanUtils.copyProperties(c, catVO);
			catVOs.add(catVO);
			
		}
		return  catVOs;
	}

}
