package com.cloudking.openlab.action.expertquestion;

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
import com.cloudking.openlab.service.expertquestion.ExpertQuestionService;
import com.cloudking.openlab.vo.ExpertQuestionVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/expertQuestionManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/expert/expert_list.jsp") ,
	@Result(name = "onesuccess", type = "dispatcher", location = "/expert/noce_expert.jsp"),
	@Result(name = "allsuccess", type = "dispatcher", location = "/expert/experts_list.jsp"),
	@Result(name = "addEQsuccess", type = "dispatcher", location = "/expert/add_success.jsp"),
	@Result(name = "showOnesuccess", type = "dispatcher", location = "/expert/expert_detail.jsp"),
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class ExpertQuestionAction  extends BaseAction<ExpertQuestionVO>{
	@SuppressWarnings("unused")
	@Resource
	private ExpertQuestionService expertQuestionService; 

	@Action("/expertQuestion")
	public String execute() throws Exception {

		return INPUT;
	}
	/**
	 * 前台遍历方法
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException{
		expertQuestionService.query(cloudContext);
		return SUCCESS;
	}
	
	/**
	 * 前台遍历方法
	 * @return
	 * @throws SQLException
	 */
	public String queryAll() throws SQLException{
		expertQuestionService.queryExpertQuestions(cloudContext);
		return "allsuccess";
	}
	
	/**
	 * 显示单个专家的信息
	 * @return
	 * @throws SQLException
	 */
	public String oneExpert() throws SQLException{
		expertQuestionService.onceExpert(cloudContext);
		return "onesuccess";
	}
	/**
	 * 创建新的问题
	 * @return
	 * @throws SQLException
	 */
	public String addExpertQuestion()throws SQLException{
		expertQuestionService.addExpertQuestion(cloudContext);
		return "addEQsuccess";
	}
	/**
	 * 前台普通详细显示单条的问题
	 * @return
	 * @throws SQLException
	 */
	public String showoneExpert()throws SQLException{
		expertQuestionService.queryOneQuestionAddhf(cloudContext);
		return "showOnesuccess";
	}
	/**
	 * 个人中心，查看自己的提问的回答。改变回答的状态
	 * @return
	 * @throws SQLException
	 */
	public String userCenterShowoneExpert() throws SQLException{
		expertQuestionService.viewThisSelfOneQuestionAddhf(cloudContext);
		return "showOnesuccess";
	}
	/**
	 * 个人中心，返回对应自己的问题
	 * @return
	 * @throws SQLException
	 */
	public String userCenterShowMyQuestion()throws SQLException{
		expertQuestionService.viewUserCenterContent(cloudContext);
		return JSON;
	}
	/**
	 * 个人中心，显示单条问答对应的所有回答
	 * @return
	 * @throws SQLException
	 */
	public String userCenterShowoneAnwers()throws SQLException{
		expertQuestionService.viewUserCenterShowoneAnswers(cloudContext);
		return JSON;
	}
}
