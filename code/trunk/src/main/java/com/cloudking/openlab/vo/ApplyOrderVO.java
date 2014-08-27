/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:10:44 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */
public class ApplyOrderVO extends BaseVO {

	private String ordrNum;

	private String desc;
	private String sysDesc;

	private Double rent; // 租金

	/**
	 * 申请时间
	 */
	private Date applyDate;
	/**
	 * 预约时间
	 */
	private Date appointedDate;
	private Long equipmentId;
	private String pic;
	private String equipmentName;
	private String model;
	private String contact; // 仪器设备联系人
	private String phone; // 电话
	private String principal; // 行业检测负责人
	private Long industryTestId;
	private String industryTestName;
	private Long userId;
	private EquipmentVO equipmentVO;
	private IndustryTestVO industryTestVO;
	private Date subBeginDate;
	private Date subEndDate;
	private String subBeginDateStr;
	private String subEndDateStr;
	private String adjust;
	private String status; // 0 已审核 1 未审核 默认 1
	/**
	 * 领域
	 * 
	 * @return
	 */
	private String area;
	/**
	 * 路径
	 * 
	 * @return
	 */
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public String getSubBeginDateStr() {
		return subBeginDateStr;
	}

	public void setSubBeginDateStr(String subBeginDateStr) {
		this.subBeginDateStr = subBeginDateStr;
	}

	public String getSubEndDateStr() {
		return subEndDateStr;
	}

	public void setSubEndDateStr(String subEndDateStr) {
		this.subEndDateStr = subEndDateStr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIndustryTestName() {
		return industryTestName;
	}

	public void setIndustryTestName(String industryTestName) {
		this.industryTestName = industryTestName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public IndustryTestVO getIndustryTestVO() {
		return industryTestVO;
	}

	public void setIndustryTestVO(IndustryTestVO industryTestVO) {
		this.industryTestVO = industryTestVO;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Long getIndustryTestId() {
		return industryTestId;
	}

	public void setIndustryTestId(Long industryTestId) {
		this.industryTestId = industryTestId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getSysDesc() {
		return sysDesc;
	}

	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}

}
