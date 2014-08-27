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
 * 技术转移
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_tech_transfer")
public class TechTransferEntity extends BaseEntity {

    @Column(name = "TITLE_")
    private String title;

    @Column(name = "CONTENT_", length = 2000)
    private String content;

    @Column(name = "STATUS_")
    private Byte status;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID_")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID_")
    private TechTransferCatEntity cat;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TechTransferCatEntity getCat() {
        return cat;
    }

    public void setCat(TechTransferCatEntity cat) {
        this.cat = cat;
    }

}
