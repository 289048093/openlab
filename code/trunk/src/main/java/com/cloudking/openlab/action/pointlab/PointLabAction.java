package com.cloudking.openlab.action.pointlab;

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
import com.cloudking.openlab.service.pointlab.PointLabService;
import com.cloudking.openlab.vo.PointLabVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/pointLabManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "detail", type = "dispatcher", location = "/pointLab/pointLab_detail.jsp"),
		@Result(name = "success", type = "dispatcher", location = "/pointLab/pointLab_list.jsp") })
public class PointLabAction extends BaseAction<PointLabVO> {

	private static final String DETAIL = "detail";

	@SuppressWarnings("unused")
	@Resource
	private PointLabService pointLabService;

	@Action("/pointLab")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 通过id查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		// 通过id查询得到详细信息
		pointLabService.queryById(cloudContext);
		pointLabService.query(cloudContext);
		return DETAIL;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		pointLabService.query(cloudContext);
		return SUCCESS;
	}

}
