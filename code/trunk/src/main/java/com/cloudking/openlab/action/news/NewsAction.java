package com.cloudking.openlab.action.news;

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
import com.cloudking.openlab.service.news.NewsService;
import com.cloudking.openlab.vo.NewsVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/newsManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "detail", type = "dispatcher", location = "/news/news_detail.jsp"),
		@Result(name = "success", type = "dispatcher", location = "/news/news_list.jsp") })
public class NewsAction extends BaseAction<NewsVO> {

	private final static String DETAIL = "detail";

	@Resource
	private NewsService newsService;

	@Action("/news")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 通过id详细新闻
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		// 通过id查询得到详细信息
		newsService.queryById(cloudContext);
		newsService.query(cloudContext);
		return DETAIL;
	}

	/**
	 * 查询所有新闻及所有新闻类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		newsService.query(cloudContext);
		return SUCCESS;
	}
}
