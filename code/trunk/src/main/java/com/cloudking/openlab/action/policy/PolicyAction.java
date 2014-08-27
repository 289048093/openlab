package com.cloudking.openlab.action.policy;

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
import com.cloudking.openlab.service.policy.PolicyService;
import com.cloudking.openlab.vo.PolicyVO;

/**
 * 政策法规
 * 
 * @author cloudKing
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/policyManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "detail", type = "dispatcher", location = "/policy/policy_detail.jsp"),
		@Result(name = "success", type = "dispatcher", location = "/policy/policy_list.jsp") })
public class PolicyAction extends BaseAction<PolicyVO> {

	private static final String DETAIL = "detail";

	@Resource
	private PolicyService policyService;

	@Action("/policy")
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
		policyService.queryById(cloudContext);
		policyService.query(cloudContext);
		return DETAIL;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		policyService.query(cloudContext);
		return SUCCESS;
	}
}
