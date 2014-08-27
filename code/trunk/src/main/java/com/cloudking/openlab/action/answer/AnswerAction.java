package com.cloudking.openlab.action.answer;
  
import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.answer.AnswerService;
import com.cloudking.openlab.vo.AnswerVO;
@SuppressWarnings("serial")
@Controller  
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/answerManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
 public class AnswerAction extends BaseAction<AnswerVO>{
	@SuppressWarnings("unused")
	@Resource
	private AnswerService answerService;
	

	@Action("/answer")
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		return INPUT;
	}

}
