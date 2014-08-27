/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:58:32 AM
 */
package com.cloudking.openlab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 科研成果级别
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_research_level")
public class ResearchLevelEntity extends BaseEntity {

    @Column(name = "NAME_")
    private String name;

    @Column(name = "DESC_",columnDefinition = "text")
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
