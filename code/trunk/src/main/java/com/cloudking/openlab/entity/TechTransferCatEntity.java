/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:00:59 AM
 */
package com.cloudking.openlab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 技术转移分类
 * @author CloudKing
 */
@Entity
@Table(name = "tb_tech_transfer_cat")
public class TechTransferCatEntity extends BaseEntity {

    @Column(name = "NAME_")
    private String name;

    @Column(name = "DESC_")
    private String desc;
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
}
