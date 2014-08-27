/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:08:11 AM
 */
package com.cloudking.openlab.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 重点实验室
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_point_lab")
public class PointLabEntity extends BaseEntity {

    @Column(name = "NAME_")
    private String name;

    @Column(name = "ADDR_")
    private String addr;

    @Column(name = "PHONE_")
    private String phone;
    /**
     * 成立时间
     */
    @Column(name = "BUILD_DATE_")
    private Date buildDate;

    /**
     * 成员
     */
    @ManyToMany
    @JoinTable(name = "tb_point_lab_bid_user", joinColumns = { @JoinColumn(name = "POINT_LAB_ID_", referencedColumnName = "ID_") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID_", referencedColumnName = "ID_") })
    private List<UserEntity> menbers;

    /**
     * 管理员
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID_")
    private UserEntity manager;

    /**
     * 实验室类别
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID_")
    private PointLabCatEntity cat;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;
    /**
     * 描述
     */
    @Column(name = "DESC_",columnDefinition = "text")
    private String desc;
    /**
     * 实验室/技术平台
     */
    @Column(name = "TYPE_")
    private Byte type;

    /**
     * 部门（北大，清华，哈工大）
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID_")
    private DeptEntity dept;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public DeptEntity getDept() {
        return dept;
    }

    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }

    public Boolean getPubliced() {
        return publiced;
    }

    public void setPubliced(Boolean publiced) {
        this.publiced = publiced;
    }

    public List<UserEntity> getMenbers() {
        return menbers;
    }

    public void setMenbers(List<UserEntity> menbers) {
        this.menbers = menbers;
    }

    public UserEntity getManager() {
        return manager;
    }

    public void setManager(UserEntity manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public PointLabCatEntity getCat() {
        return cat;
    }

    public void setCat(PointLabCatEntity cat) {
        this.cat = cat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
