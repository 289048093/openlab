/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:01:32 AM
 */
package com.cloudking.openlab.vo;

import com.cloudking.openlab.BaseVO;

/**
 * 成功案例
 * 
 * @author CloudKing
 */
public class SuccessCaseVO extends BaseVO {

    private String title;

    private String content;

    /**
     * 解决方案
     */
    private String scheme;

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

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

}
