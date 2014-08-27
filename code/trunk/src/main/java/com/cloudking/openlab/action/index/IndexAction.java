package com.cloudking.openlab.action.index;

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
import com.cloudking.openlab.service.index.IndexService;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.IndexVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/indexManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
			@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class IndexAction extends BaseAction<IndexVO>{
	//导入对应的service
	@Resource
	private IndexService indexService;
	@Action("/index")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	/**
	 * 获取所有的首页需要的数据
	 * @return
	 * @throws SQLException
	 */
	public String viewIndexContent() throws SQLException{
		cloudContext.setVo(indexService.indexAllContent(cloudContext));
		String errorMsg = (String) getRequest().getAttribute("errorMsg");
		if(!StringUtil.isBlank(errorMsg)){
		    cloudContext.addErrorMsg(errorMsg);
		}
		return SUCCESS;
	}
	
}
