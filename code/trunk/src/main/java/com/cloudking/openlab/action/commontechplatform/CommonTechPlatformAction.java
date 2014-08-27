package com.cloudking.openlab.action.commontechplatform;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.commontechplatform.CommonTechPlatformService;
import com.cloudking.openlab.vo.CommonTechPlatformVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/commonTechPlatformManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "detail", type = "dispatcher", location = "/commonTechPlatform/commonTechPlatform_detail.jsp"),
		@Result(name = "success", type = "dispatcher", location = "/commonTechPlatform/commonTechPlatform_list.jsp") })
public class CommonTechPlatformAction extends BaseAction<CommonTechPlatformVO> {

	private static final String DETAIL = "detail";

	@SuppressWarnings("unused")
	@Resource
	private CommonTechPlatformService commonTechPlatformService;

	@Action("/commonTechPlatform")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 获取单元详情与分类列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		// 通过id查询得到详细信息
		commonTechPlatformService.queryById(cloudContext);
		commonTechPlatformService.query(cloudContext);
		return DETAIL;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		commonTechPlatformService.query(cloudContext);
		return SUCCESS;
	}

}
