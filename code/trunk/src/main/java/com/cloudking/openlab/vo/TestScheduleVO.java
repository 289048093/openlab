package com.cloudking.openlab.vo;

import javax.persistence.Column;

import com.cloudking.openlab.BaseVO;

public class TestScheduleVO  extends BaseVO{

	private static final long serialVersionUID = 4464894748877337417L;
	//当前进度
	private String scheduleName;
	//当前环节负责单位
	private String responsibleDept;	
	//当前环节负责人
	 private String principal;
	//当前环节负责人联系电话
	 private String phone;
	//当前环节负责人联系email
	 private String email;
	//检测报告存放地址(http)
	private String storeUrl;
	private Long applyOrderId;
	
	public Long getApplyOrderId() {
		return applyOrderId;
	}
	public void setApplyOrderId(Long applyOrderId) {
		this.applyOrderId = applyOrderId;
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public String getResponsibleDept() {
		return responsibleDept;
	}
	public void setResponsibleDept(String responsibleDept) {
		this.responsibleDept = responsibleDept;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStoreUrl() {
		return storeUrl;
	}
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	 
	 
	 
}
