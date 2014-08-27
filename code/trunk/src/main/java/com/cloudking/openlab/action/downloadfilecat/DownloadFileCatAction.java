package com.cloudking.openlab.action.downloadfilecat;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.downloadfilecat.DownloadFileCatService;
import com.cloudking.openlab.vo.DownloadFileCatVO;
import com.cloudking.openlab.vo.DownloadFileVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/downloadFileCatManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp") })
public class DownloadFileCatAction extends BaseAction<DownloadFileCatVO> {

	@SuppressWarnings("unused")
	@Resource
	private DownloadFileCatService downloadFileCatService;

	@Action("/downloadFileCat")
	public String execute() throws Exception {

		return INPUT;
	}
}
