/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:10:44 AM
 */
package com.cloudking.openlab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * @author CloudKing
 */
@Entity
@Table(name = "tb_ApplyOrder")
public class ApplyOrderEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME_")
	private String ordrNum;

	/**
	 * 用户描述
	 */
	@Column(name = "DESC_")
	private String desc;

	/**
	 * 管理描述
	 */
	@Column(name = "SYS_DESC_")
	private String sysDesc;

	/**
	 * 价格
	 */
	@Column(name = "RENT")
	private Double rent;
	/**
	 * 申请时间
	 */
	@Column(name = "APPLY_DATE_")
	private Date applyDate;
	/**
	 * 预约时间
	 */
	@Column(name = "APPOINTED_DATE_")
	private Date appointedDate;
	/**
	 * 领域
	 */
	@Column(name = "AREA_")
	private String area;
	/**
	 * 路径
	 */
	@Column(name = "URL_")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "EQUIPMENT_ID_")
	private EquipmentEntity equipment;

	@ManyToOne
	@JoinColumn(name = "INDUSTRY_TEST_ID_")
	private IndustryTestEntity industryTest;

	@ManyToOne
	@JoinColumn(name = "USER_ID_")
	private UserEntity user;

	@Column(name = "STATUS_")
	private String status; // 0 已审核 1 未审核 默认 1

	/**
	 * 预约使用开始时间
	 */
	@Column(name = "SUB_BENGIN_DATE_")
	private Date subBeginDate;

	/**
	 * 预约使用的结束
	 */
	@Column(name = "SUB_END_DATE_")
	private Date subEndDate;

	/**
	 * 是否接受管理员调整时间
	 */
	@Column(name = "AD_JUST_")
	private String adjust;

	/**
	 * 订单类型：系统订单/用户订单
	 */
	@Column(name = "TYPE")
	private Byte type;

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getAdjust() {
		return adjust;
	}

	public void setAdjust(String adjust) {
		this.adjust = adjust;
	}

	public Date getSubBeginDate() {
		return subBeginDate;
	}

	public void setSubBeginDate(Date subBeginDate) {
		this.subBeginDate = subBeginDate;
	}

	public Date getSubEndDate() {
		return subEndDate;
	}

	public void setSubEndDate(Date subEndDate) {
		this.subEndDate = subEndDate;
	}

	public EquipmentEntity getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentEntity equipment) {
		this.equipment = equipment;
	}

	public IndustryTestEntity getIndustryTest() {
		return industryTest;
	}

	public void setIndustryTest(IndustryTestEntity industryTest) {
		this.industryTest = industryTest;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getOrdrNum() {
		return ordrNum;
	}

	public void setOrdrNum(String ordrNum) {
		this.ordrNum = ordrNum;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getAppointedDate() {
		return appointedDate;
	}

	public void setAppointedDate(Date appointedDate) {
		this.appointedDate = appointedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSysDesc() {
		return sysDesc;
	}

	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
