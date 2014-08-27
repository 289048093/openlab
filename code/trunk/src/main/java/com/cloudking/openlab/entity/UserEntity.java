/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.cloudking.openlab.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 用户
 * 
 * @author xgj
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_user")
public class UserEntity extends BaseEntity {
    /**
     * 用户名
     */
    @Column(name = "USERNAME_", length = 20, nullable = false, unique = true)
    private String username;
    /**
     * 登陆密码
     */
    @Column(name = "PASSWORD_", columnDefinition = "CHAR(32)", length = 32, nullable = false)
    private String password;
    /**
     * 添加时间
     */
    @Column(name = "ADD_TIME_")
    private Date addTime;

    /**
     * 电子邮箱
     */
    @Column(name = "EMAIL_")
    private String email;
    /**
     * 手机
     */
    @Column(name = "MOBILEPHONE_")
    private String mobilePhone;
    /**
     * 电话
     */
    @Column(name = "TELPHONE_")
    private String telPhone;
    /**
     * 性别
     */
    @Column(name = "SEX_", length = 2)
    private String sex;

    /**
     * 真实姓名
     */
    @Column(name = "REALNAME_", length = 20, nullable = false)
    private String realname;
    /**
     * 头像
     */
    @Column(name = "HEAD_PIC_")
    private String headPic;
    /**
     * 地址
     */
    @Column(name = "ADDR_", length = 200)
    private String addr;

    /**
     * 最后一次登陆时间
     */
    @Column(name = "LASTLOGINTIME_")
    private Date lastLoginTime;
    /**
     * 状态
     */
    @Column(name = "STATUS_", length = 20, nullable = false)
    private String status;

    /**
     * 校内用户、校外用户
     */
    @Column(name = "TYPE_")
    private Byte type;
    /**
     * 所属单位
     */
    @Column(name = "COMPANY_")
    private String company;
//	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CompanyEntity.class)
//	@JoinColumn(name = "COMPANY_ID_")
//	private CompanyEntity company;

//	/**
//	 * 找回密码问题的答案
//	 */
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
//	private List<AnswerEntity> answers;
    /**
     * 角色
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_bid_roles", joinColumns = { @JoinColumn(name = "USER_ID_", referencedColumnName = "ID_") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID_", referencedColumnName = "ID_") })
    private List<RoleEntity> roles;

    /**
     * 我收到的问题（被提问的问题）
     */
    @OneToMany(mappedBy = "expert")
    private List<ExpertQuestionEntity> receiveQuestions;

    @OneToMany(mappedBy = "questioner")
    private List<ExpertQuestionEntity> sendQuestions;

    public List<ExpertQuestionEntity> getSendQuestions() {
        return sendQuestions;
    }

    public void setSendQuestions(List<ExpertQuestionEntity> sendQuestions) {
        this.sendQuestions = sendQuestions;
    }

    public List<ExpertQuestionEntity> getReceiveQuestions() {
        return receiveQuestions;
    }

    public void setReceiveQuestions(List<ExpertQuestionEntity> receiveQuestions) {
        this.receiveQuestions = receiveQuestions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

}