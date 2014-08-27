/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:56:55 AM
 */
package com.cloudking.openlab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 公共技术服务平台
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_common_tech_platform_cat")
public class CommonTechPlatformCatEntity extends BaseEntity {

	/**
	 * 名称
	 */
	@Column(name = "NAME_")
	private String name;

	/**
	 * 描述
	 */
	@Column(name = "DESC_")
	private String desc;
	/**
	 * 公共技术服务
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cat", targetEntity = CommonTechPlatformEntity.class)
	private List<CommonTechPlatformEntity> commonTechPlatform;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
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

	public List<CommonTechPlatformEntity> getCommonTechPlatform() {
		return commonTechPlatform;
	}

	public void setCommonTechPlatform(
			List<CommonTechPlatformEntity> commonTechPlatform) {
		this.commonTechPlatform = commonTechPlatform;
	}

}
