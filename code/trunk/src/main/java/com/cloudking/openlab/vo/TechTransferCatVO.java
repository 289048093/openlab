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
public class TechTransferCatVO extends BaseVO {

    private String name;

    private String desc;

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
}
