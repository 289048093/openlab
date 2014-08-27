package com.cloudking.openlab.entity;

/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:56:55 AM
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;


/**
 * 公共技术服务平台
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_common_tech_platform")
public class CommonTechPlatformEntity extends BaseEntity {

	/**
	 * 名称
	 */
	@Column(name = "NAME_")
	private String name;

	/**
	 * 描述
	 */
	@Column(name = "DESC_", columnDefinition = "text")
	private String desc;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;
	/**
	 * 联系人
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID_")
	private UserEntity user;

	/**
	 * 部门
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPT_")
	private DeptEntity dept;
	/**
	 * 类别
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAT_ID_")
	private CommonTechPlatformCatEntity cat;
    /**
     * 设备
     */
	@OneToMany(mappedBy = "commonTechPlatform", cascade = CascadeType.ALL)
	private List<EquipmentEntity> equipment;
	/**
	 * 供稿单位
	 */
	@Column(name = "PROVIDER_NAME_")
	private String providerName;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public List<EquipmentEntity> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<EquipmentEntity> equipment) {
		this.equipment = equipment;
	}

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}

	public CommonTechPlatformCatEntity getCat() {
		return cat;
	}

	public void setCat(CommonTechPlatformCatEntity cat) {
		this.cat = cat;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DeptEntity getDept() {
		return dept;
	}

	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}

}
