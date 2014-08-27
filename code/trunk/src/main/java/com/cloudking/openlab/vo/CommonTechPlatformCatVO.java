/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:56:55 AM
 */
package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * 公共技术服务平台
 * 
 * @author CloudKing
 */
public class CommonTechPlatformCatVO extends BaseVO {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 分类中添加单元
	 */
	private List<CommonTechPlatformVO> commonTechPlatformVOs;

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

	public List<CommonTechPlatformVO> getCommonTechPlatformVOs() {
		return commonTechPlatformVOs;
	}

	public void setCommonTechPlatformVOs(
			List<CommonTechPlatformVO> commonTechPlatformVOs) {
		this.commonTechPlatformVOs = commonTechPlatformVOs;
	}

}
