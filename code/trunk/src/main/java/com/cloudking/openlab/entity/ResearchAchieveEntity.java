/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:59:15 AM
 */
package com.cloudking.openlab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 科研成果
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_research_achieve")
public class ResearchAchieveEntity extends BaseEntity {

    /*
     * 基本信息
     */

    @Column(name = "NAME_")
    private String name;

    @Column(name = "DESC_", columnDefinition = "text")
    private String desc;

    @Column(name = "ADD_DATE_")
    private Date addDate;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;
    /**
	 * 供稿单位
	 */
	@Column(name = "PROVIDER_NAME_")
	private String providerName;
    /*
     * 关系
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID_")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEVEL_ID_")
    private ResearchLevelEntity level;

    /**
     * 供稿单位
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVIDER_ID_")
    private DeptEntity provider;

    public DeptEntity getProvider() {
        return provider;
    }

    public void setProvider(DeptEntity provider) {
        this.provider = provider;
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ResearchLevelEntity getLevel() {
        return level;
    }

    public void setLevel(ResearchLevelEntity level) {
        this.level = level;
    }

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

}
