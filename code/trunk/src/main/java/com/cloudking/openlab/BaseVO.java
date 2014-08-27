/**
 * Copyright(c) 2012 ShenZhen CloudKing Technology Co., Ltd
 * All rights reserved.
 * Created on Oct 15, 2012  2:17:56 PM
 */
package com.cloudking.openlab;

import java.io.Serializable;

/**
 * 所有VO的父类
 * 
 * @author CloudKing
 */
public class BaseVO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5045088678053572064L;
    /**
     * ID
     */
    private Long id;

    /**
     * 获取ID
     * 
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
