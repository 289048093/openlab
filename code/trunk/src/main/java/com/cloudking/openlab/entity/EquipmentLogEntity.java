/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Oct 24, 2013  1:53:16 PM
 */
package com.cloudking.openlab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 仪器设备日志
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_equipement_log")
public class EquipmentLogEntity extends BaseEntity {

    /**
     * 日志描述
     */
    @Column(name = "DESC_")
    private String desc;
    /**
     * 添加时间
     */
    @Column(name = "ADD_DATE_")
    private Date addDate;
    /**
     * 仪器设备
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EQUIPMENT_ID_")
    private EquipmentEntity equipment;
    /**
     * 操作人
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID_")
    private UserEntity user;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public EquipmentEntity getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEntity equipment) {
        this.equipment = equipment;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
