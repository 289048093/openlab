/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:56:55 AM
 */
package com.cloudking.openlab.vo;

import com.cloudking.openlab.BaseVO;

/**
 * 公共技术服务平台
 * 
 * @author CloudKing
 */
public class CommonTechPlatformVO extends BaseVO {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 联系人
	 */
	private Long userId;

	/**
	 * 单位
	 */

	private Long companyId;

	private Long catId;
	/**
	 * 是否公开
	 */
	private Boolean publiced;
	/**
	 * 供稿单位
	 */
	private String providerName;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

}
