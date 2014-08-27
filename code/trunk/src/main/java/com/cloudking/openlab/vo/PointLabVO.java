/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:08:11 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

/**
 * 重点实验室
 * 
 * @author CloudKing
 */
public class PointLabVO extends BaseVO {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 成立时间
	 */
	private Date buildDate;

	/**
	 * 管理员
	 */
	private Integer managerId;

	/**
	 * 实验室类别
	 */
	private PointLabCatVO catVO;
	/**
	 * 描述
	 */
	private String desc;

	private Byte type;
	
	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public PointLabCatVO getCatVO() {
		return catVO;
	}

	public void setCatVO(PointLabCatVO catVO) {
		this.catVO = catVO;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
