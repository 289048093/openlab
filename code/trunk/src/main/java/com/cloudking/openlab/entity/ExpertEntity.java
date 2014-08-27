/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Oct 12, 2013  11:49:17 AM
 */
package com.cloudking.openlab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 专家
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_expert")
public class ExpertEntity extends UserEntity {

    /**
     * 职称
     */
    @Column(name = "TITLE_")
    private String title;
    /**
     * 研究领域
     */
    @Column(name = "RESEARCH_AREA_")
    private String researchArea;
    /**
     * 描述信息
     */
    @Column(name = "DESC_",columnDefinition = "text")
    private String desc;
    
    /**
     * 是否显示在首页
     */
    @Column(name = "INDEXSHOW_")
    private Boolean indexShow;
    
    public Boolean getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(Boolean indexShow) {
		this.indexShow = indexShow;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
