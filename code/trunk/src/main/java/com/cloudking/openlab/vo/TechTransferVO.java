/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:00:59 AM
 */
package com.cloudking.openlab.vo;

import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */
public class TechTransferVO extends BaseVO {

    private String title;

    private String content;

    private Byte status;

    private Long userId;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

}
