/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:02:20 AM
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
 * 下载文件
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_download_file")
public class DownloadFileEntity extends BaseEntity {

    /**
     * 文件名
     */
    @Column(name = "NAME_")
    private String name;
    /**
     * 保存的真实文件名
     */
    @Column(name = "REALNAME_")
    private String realname;

    /**
     * 下载路径
     */
    @Column(name = "URL_")
    private String url;
    /**
     * 描述
     */
    @Column(name = "DESC_",columnDefinition = "text")
    private String desc;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;
    /**
     * 上传者
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPLOADER_ID_")
    private UserEntity uploader;
    /**
     * 类别
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID_")
    private DownloadFileCatEntity cat;

    public Boolean getPubliced() {
        return publiced;
    }

    public void setPubliced(Boolean publiced) {
        this.publiced = publiced;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public UserEntity getUploader() {
        return uploader;
    }

    public void setUploader(UserEntity uploader) {
        this.uploader = uploader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DownloadFileCatEntity getCat() {
        return cat;
    }

    public void setCat(DownloadFileCatEntity cat) {
        this.cat = cat;
    }

}
