/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:02:20 AM
 */
package com.cloudking.openlab.vo;

import com.cloudking.openlab.BaseVO;

/**
 * 下载文件
 * 
 * @author CloudKing
 */
public class DownloadFileVO extends BaseVO {

    private String name;

    /**
     * 下载路径
     */
    private String url;

    private String desc;

    private Long catId;
    /**
     * 是否公开
     */
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

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

}
