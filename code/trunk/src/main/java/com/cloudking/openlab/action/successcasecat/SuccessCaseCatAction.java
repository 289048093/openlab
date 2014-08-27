package com.cloudking.openlab.action.successcasecat;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.successcasecat.SuccessCaseCatService;
import com.cloudking.openlab.vo.SuccessCaseCatVO;


@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/successCaseCatManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class SuccessCaseCatAction extends BaseAction<SuccessCaseCatVO>{
	@SuppressWarnings("unused")
	@Resource
	private SuccessCaseCatService successCaseCatService;
	
	@Action("/successCaseCat")
	public String execute() throws Exception {

		return INPUT;
	}

}
