package com.cloudking.openlab.action.newscat;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.newscat.NewsCatService;
import com.cloudking.openlab.vo.NewsCatVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/newsCatManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class NewsCatAction extends BaseAction<NewsCatVO> {

	@SuppressWarnings("unused")
	@Resource
	private NewsCatService newsCatService;

	@Action("/newsCat")
	public String execute() throws Exception {
		return INPUT;
	}
}
