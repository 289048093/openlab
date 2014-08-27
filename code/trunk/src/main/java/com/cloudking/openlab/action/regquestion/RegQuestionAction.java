package com.cloudking.openlab.action.regquestion;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.regquestion.RegQuestionService;
import com.cloudking.openlab.vo.RegQuestionVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/regQuestionManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class RegQuestionAction extends BaseAction<RegQuestionVO>{
	@SuppressWarnings("unused")
	@Resource
	private RegQuestionService regQuestionService;
	
	@Action("/regQuestion")
	public String execute() throws Exception {

		return INPUT;
	}

}
