package com.cloudking.openlab.service.commontechplatform;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.CommonTechPlatformCatDAO;
import com.cloudking.openlab.dao.CommonTechPlatformDAO;
import com.cloudking.openlab.dao.DeptDAO;
import com.cloudking.openlab.entity.CommonTechPlatformCatEntity;
import com.cloudking.openlab.entity.CommonTechPlatformEntity;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.CommonTechPlatformCatVO;
import com.cloudking.openlab.vo.CommonTechPlatformVO;

@Service("commonTechPlatformService")
public class CommonTechPlatformService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private CommonTechPlatformDAO commonTechPlatformDAO;
	@Resource
	private CommonTechPlatformCatDAO commonTechPlatformCatDAO;
	@Resource
	private DeptDAO deptDAO;

	/**
	 * 通过单元Id 获得详情
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void queryById(CloudContext<CommonTechPlatformVO> cloudContext)
			throws SQLException {
		CommonTechPlatformEntity commonTechEntity = commonTechPlatformDAO
				.get(cloudContext.getVo().getId());
		if (commonTechEntity == null) {
			cloudContext.addErrorMsg("公共技术服务平台不存在，请刷新后重试！");
			return;
		}
		//供稿单位
		String provider=commonTechEntity.getProviderName();
		DeptEntity dept = null;
		if (!StringUtil.isBlank(provider)) {
			if (provider.matches("\\d+")) {
				Long providerId = Long.parseLong(provider);
				dept = deptDAO.get(providerId);
				commonTechEntity.setProviderName(dept.getName());
			}
		}
		BeanUtils.copyProperties(commonTechEntity, cloudContext.getVo());// 把entity中的值赋给vo
	}

	/**
	 * 查询
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void query(CloudContext<CommonTechPlatformVO> cloudContext)
			throws SQLException {
		CommonTechPlatformVO commonTechPlatformVO = null;
		CommonTechPlatformCatVO commonTechPlatformCatVO = null;
		List<CommonTechPlatformCatEntity> commonTechPlatformCatEntitys = new ArrayList<CommonTechPlatformCatEntity>();
		List<CommonTechPlatformEntity> commonTechPlatformEntitys = new ArrayList<CommonTechPlatformEntity>();
		List<CommonTechPlatformVO> commonTechPlatformVOs = new ArrayList<CommonTechPlatformVO>();
		List<CommonTechPlatformCatVO> commonTechPlatformCatVOs = new ArrayList<CommonTechPlatformCatVO>();
		commonTechPlatformEntitys = commonTechPlatformDAO.query(cloudContext
				.getLongParam("catId"), cloudContext.getPageInfo());
		if (commonTechPlatformEntitys != null) {
			for (CommonTechPlatformEntity e : commonTechPlatformEntitys) {
				commonTechPlatformVO = new CommonTechPlatformVO();
				BeanUtils.copyProperties(e, commonTechPlatformVO);
				commonTechPlatformVOs.add(commonTechPlatformVO);
			}
		}
		commonTechPlatformCatEntitys = commonTechPlatformCatDAO.listPubliced();
		if (commonTechPlatformCatEntitys != null) {
			for (CommonTechPlatformCatEntity e : commonTechPlatformCatEntitys) {
				commonTechPlatformCatVO = new CommonTechPlatformCatVO();
				BeanUtils.copyProperties(e, commonTechPlatformCatVO);
				commonTechPlatformCatVOs.add(commonTechPlatformCatVO);
			}
		}
		cloudContext.addParam("commonTechPlatformCatVOs",
				commonTechPlatformCatVOs);
		cloudContext.addParam("commonTechPlatformVOs", commonTechPlatformVOs);
	}
	
	public List<CommonTechPlatformVO> query() throws SQLException{
		
		List<CommonTechPlatformEntity>  list=	commonTechPlatformDAO.query();
		List<CommonTechPlatformVO>  vos=	new ArrayList<CommonTechPlatformVO>();
		CommonTechPlatformVO vo=null;
		for (CommonTechPlatformEntity comm : list) {
			vo=new CommonTechPlatformVO();
			BeanUtils.copyProperties(comm, vo);
			vos.add(vo);
		}
		return vos;
	}
	
	
	
}
