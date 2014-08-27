package com.cloudking.openlab.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;


/**
 * 仪器设备
 * 
 * @author CloudKing_hxl
 * 
 */

@Entity
@Table(name = "tb_equipment")
public class EquipmentEntity extends BaseEntity {
	/**
	 * 设备名称
	 */
	@Column(name = "NAME_")
	private String name;
	/**
	 * 设备描述
	 */
	@Column(name = "DESC_", columnDefinition = "text")
	private String desc;
	/**
	 * 型号
	 */
	@Column(name = "MODEL_")
	private String model;

	/**
	 * 生产商
	 */
	@Column(name = "PRODUCER_")
	private String producer;

	/**
	 * 价格
	 */
	@Column(name = "PRICE_")
	private BigDecimal price;

	/**
	 * 等级
	 */
	@Column(name = "GRADE_")
	private String grade;

	/**
	 * 图片
	 */
	@Column(name = "PIC_")
	private String pic;

	/**
	 * 联系人
	 */
	@Column(name = "CONTACT_")
	private String contact;

	/**
	 * 联系人电话
	 */
	@Column(name = "PHONE_")
	private String phone;
	/**
	 * 登记时间
	 */
	@Column(name = "ADD_TIME_", nullable = false, unique = false)
	private Date addTime;

	/**
	 * 修改时间
	 */
	@Column(name = "MODIFY_TIME_", nullable = false, unique = false)
	private Date modifyTime;

	/**
	 * 购置时间
	 */
	@Column(name = "PURCHASE_DATE", nullable = false, unique = false)
	private Date purchaseDate;
	/**
	 * 状态
	 */
	@Column(name = "STATUS_", nullable = false, unique = false)
	private Byte status;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;

	/**
	 * 是否可预约
	 */
	@Column(name = "APPLICABLE_")
	private Boolean applicable;
	/**
	 * 预约时，跳转的url。用于不在本系统预约的设备
	 */
	@Column(name = "REDIRECTURL_")
	private String redirectURL;
	/*
	 * 关系
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAT_ID_")
	private EquipmentCatEntity cat;
	/**
	 * 实验室
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAB_ID_")
	private PointLabEntity lab;


	/**
	 * 技术平台
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMON_TECH_PLATFORM_ID_")
	private CommonTechPlatformEntity commonTechPlatform;

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}



	public EquipmentCatEntity getCat() {
		return cat;
	}

	public void setCat(EquipmentCatEntity cat) {
		this.cat = cat;
	}

	public PointLabEntity getLab() {
		return lab;
	}

	public void setLab(PointLabEntity lab) {
		this.lab = lab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Boolean getApplicable() {
		return applicable;
	}

	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}
	
	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public CommonTechPlatformEntity getCommonTechPlatform() {
		return commonTechPlatform;
	}

	public void setCommonTechPlatform(CommonTechPlatformEntity commonTechPlatform) {
		this.commonTechPlatform = commonTechPlatform;
	}

}
