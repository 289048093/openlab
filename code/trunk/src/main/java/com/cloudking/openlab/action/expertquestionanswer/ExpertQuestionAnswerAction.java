package com.cloudking.openlab.action.expertquestionanswer;

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
import com.cloudking.openlab.service.expertquestionanswer.ExpertQuestionAnswerService;
import com.cloudking.openlab.vo.ExpertQuestionAnswerVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/expertQuestionAnswerManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class ExpertQuestionAnswerAction extends BaseAction<ExpertQuestionAnswerVO>{
 
	@SuppressWarnings("unused")
	@Resource
	private ExpertQuestionAnswerService expertQuestionAnswerService; 
	
	@Action("/expertQuestionAnswer")
	public String execute() throws Exception {

		return INPUT;
	}
	
	/**
	 * 回答问题
	 * @return
	 * @throws SQLException
	 */
	public String addEQA() throws SQLException{
		expertQuestionAnswerService.addExepertAnswer(cloudContext);
		return JSON;
	}
}
