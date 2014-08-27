/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 8, 2013  3:33:55 PM
 */
package com.cloudking.openlab.vo;

import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */
public class DeptVO extends BaseVO {

	private String name;
	private String desc;

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
}
