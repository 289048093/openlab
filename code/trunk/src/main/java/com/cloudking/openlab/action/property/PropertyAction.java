package com.cloudking.openlab.action.property;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.property.PropertyService;
import com.cloudking.openlab.vo.PropertyVO;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/propertymManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") ,
	@Result(name = "jump", type = "dispatcher", location = "/jump.jsp")})
public class PropertyAction  extends BaseAction<PropertyVO>{

	@SuppressWarnings("unused")
	@Resource
	private PropertyService propertyService;
	
	@Action("/property")
	public String execute() throws Exception {

		return INPUT;
	}
}
