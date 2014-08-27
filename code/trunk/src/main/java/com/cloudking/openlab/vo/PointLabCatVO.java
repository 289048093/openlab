/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:08:11 AM
 */
package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * 重点实验室类别
 * 
 * @author CloudKing
 */
public class PointLabCatVO extends BaseVO {

	private String name;

	private String desc;

	private List<PointLabVO> pointLab;

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

	public List<PointLabVO> getPointLab() {
		return pointLab;
	}

	public void setPointLab(List<PointLabVO> pointLab) {
		this.pointLab = pointLab;
	}

}
