package com.cloudking.openlab.service.industrytestcat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.IndustryTestCatDAO;
import com.cloudking.openlab.entity.IndustryTestCatEntity;
import com.cloudking.openlab.vo.IndustryTestCatVO;

@Service("industryTestCatService")
public class IndustryTestCatService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private IndustryTestCatDAO industryTestCatDAO;
	/**
	 * 查询所有行业分类
	 * @return
	 * @throws SQLException
	 */
	public List<IndustryTestCatVO> query() throws SQLException{
	List<IndustryTestCatVO>  iNTestCatVOs=new ArrayList<IndustryTestCatVO>();
	List<IndustryTestCatEntity> industryTestCatEntities=industryTestCatDAO.listPubliced();
	IndustryTestCatVO industryTestCatVO=null;
	for (IndustryTestCatEntity cat : industryTestCatEntities) {
		industryTestCatVO=new IndustryTestCatVO();
		BeanUtils.copyProperties(cat, industryTestCatVO);
		iNTestCatVOs.add(industryTestCatVO);
	}
		return 	iNTestCatVOs;
	}
}
