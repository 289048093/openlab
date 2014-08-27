/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Oct 16, 2013  10:12:14 AM
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
 * 仪器设备使用记录
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_equipment_used_log")
public class EquipmentUsedLogEntity extends BaseEntity {
    /**
     * 开始使用时间
     */
    @Column(name = "START_DATE_")
    private Date startDate;
    /**
     * 结束使用时间
     */
    @Column(name = "END_DATE_")
    private Date endDate;
    /**
     * 手动修改时候的描述信息
     */
    @Column(name = "DESC_")
    private String desc;
    /**
     * 手动修改者
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITER_ID_")
    private UserEntity editer;
    /**
     * 开始使用时的管理员
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "START_USE_MANAGER_ID_")
    private UserEntity startUseManager;
    /**
     * 结束使用时的管理员
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "END_USE_MANAGER_ID_")
    private UserEntity endUseManager;
    /**
     * 订单
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLY_ORDER_ID_")
    private ApplyOrderEntity applyOrder;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public UserEntity getEditer() {
        return editer;
    }

    public void setEditer(UserEntity editer) {
        this.editer = editer;
    }


    public UserEntity getStartUseManager() {
        return startUseManager;
    }

    public void setStartUseManager(UserEntity startUseManager) {
        this.startUseManager = startUseManager;
    }

    public UserEntity getEndUseManager() {
        return endUseManager;
    }

    public void setEndUseManager(UserEntity endUseManager) {
        this.endUseManager = endUseManager;
    }

    public ApplyOrderEntity getApplyOrder() {
        return applyOrder;
    }

    public void setApplyOrder(ApplyOrderEntity applyOrder) {
        this.applyOrder = applyOrder;
    }

}
