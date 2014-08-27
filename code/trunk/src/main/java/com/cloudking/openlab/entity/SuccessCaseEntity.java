/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:01:32 AM
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
 * 成功案例
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_success_case")
public class SuccessCaseEntity extends BaseEntity {

    @Column(name = "TITLE_")
    private String title;

    @Column(name = "CONTENT_", length = 2000)
    private String content;

    /**
     * 解决方案
     */
    @Column(name = "SCHEME", length = 2000)
    private String scheme;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID_")
    private SuccessCaseCatEntity cat;

    public Boolean getPubliced() {
        return publiced;
    }

    public void setPubliced(Boolean publiced) {
        this.publiced = publiced;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public SuccessCaseCatEntity getCat() {
        return cat;
    }

    public void setCat(SuccessCaseCatEntity cat) {
        this.cat = cat;
    }

}
