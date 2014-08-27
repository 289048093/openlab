package com.cloudking.openlab.action.researchachieve;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.researchachieve.ResearchAchieveService;
import com.cloudking.openlab.vo.ResearchAchieveVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/researchAchieveManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class ResearchAchieveAction extends BaseAction<ResearchAchieveVO>{
	@SuppressWarnings("unused")
	@Resource
	private ResearchAchieveService researchAchieveService;
	
	@Action("/researchAchieve")
	public String execute() throws Exception {

		return INPUT;
	}
	

}
