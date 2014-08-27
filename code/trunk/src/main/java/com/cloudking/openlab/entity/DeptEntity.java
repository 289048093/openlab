/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 8, 2013  3:26:29 PM
 */
package com.cloudking.openlab.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * @author CloudKing
 */
@Entity
@Table(name = "tb_dept")
public class DeptEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME_")
	private String name;

	@Column(name = "DESC_", columnDefinition = "text")
	private String desc;

	@OneToMany(mappedBy = "dept")
	private List<PointLabEntity> pointLabs;

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

	public List<PointLabEntity> getPointLabs() {
		return pointLabs;
	}

	public void setPointLabs(List<PointLabEntity> pointLabs) {
		this.pointLabs = pointLabs;
	}

}
