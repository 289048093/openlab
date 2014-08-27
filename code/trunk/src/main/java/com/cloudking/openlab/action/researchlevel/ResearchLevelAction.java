package com.cloudking.openlab.action.researchlevel;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.researchlevel.ResearchLevelService;
import com.cloudking.openlab.vo.ResearchLevelVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/researchLevelManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class ResearchLevelAction extends BaseAction<ResearchLevelVO>{
	@SuppressWarnings("unused")
	@Resource
	private ResearchLevelService researchLevelService;
	
	@Action("/researchLevel")
	public String execute() throws Exception {

		return INPUT;
	}

}
