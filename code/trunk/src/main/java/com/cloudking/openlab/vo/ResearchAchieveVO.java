/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:59:15 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

/**
 * 科研成果
 * 
 * @author CloudKing
 */
public class ResearchAchieveVO extends BaseVO {

    private String name;

    private String desc;

    private Date addDate;

    /*
     * 关系
     */

    private Long userId;

    private Long levelId;
    /**
     * 是否公开
     */
    private Boolean publiced;
    /**
     * 供稿单位
     */
    private Long providerId;
    private String providerName;

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

}
