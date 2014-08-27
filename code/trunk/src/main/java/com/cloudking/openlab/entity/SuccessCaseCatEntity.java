/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:01:32 AM
 */
package com.cloudking.openlab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 成功案例分类
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_success_case_cat")
public class SuccessCaseCatEntity extends BaseEntity {

    @Column(name = "NAME_")
    private String name;

    @Column(name = "DESC_", length = 2000)
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
