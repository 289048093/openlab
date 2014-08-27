package com.cloudking.openlab.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;
@Entity
@Table(name = "tb_test_schedule")
public class TestScheduleEntity  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	//预约编号
	 @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="applyOrder_id")
	private ApplyOrderEntity applyOrderEntity;
	//当前进度
	@Column(name="SCHEDULE_NAME_")
	private String scheduleName;
	//当前环节负责单位
	@Column(name="RESPONSIBLE_DEPT_")
	private String responsibleDept;	
	//当前环节负责人
	 private String principal;
	//当前环节负责人联系电话
	 @Column(name="PHONE_")
	 private String phone;
	//当前环节负责人联系email
	 @Column(name="EMAIL")
	 private String email;
	//检测报告存放地址(http)
	 @Column(name="STOREURL")
	private String storeUrl;
	
	public ApplyOrderEntity getApplyOrderEntity() {
		return applyOrderEntity;
	}
	public void setApplyOrderEntity(ApplyOrderEntity applyOrderEntity) {
		this.applyOrderEntity = applyOrderEntity;
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
