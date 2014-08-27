package com.cloudking.openlab.action.role;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.role.RoleService;
import com.cloudking.openlab.vo.RoleVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/roleManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class RoleAction  extends  BaseAction<RoleVO>{
	@SuppressWarnings("unused")
	@Resource
	private RoleService roleService;
	

	@Action("/role")
	public String execute() throws Exception {

		return INPUT;
	}

}
