/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:06:22 AM
 */
package com.cloudking.openlab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 行业检测
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_industry_test")
public class IndustryTestEntity extends BaseEntity {

    private static final long serialVersionUID = 8914414750124577707L;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "CONTENT_", length = 2000)
    private String content;
    /**
     * 检测项目
     */
    @Column(name = "PROJECT_")
    private String project;
    /**
     * 检测产品
     */
    @Column(name = "PRODUCT_")
    private String product;

   
    /**
     * 承接单位
     */
    @Column(name = "UNDERTAKEUNIT_")
    private String undertakeUnit;

    /**
     * 负责人
     */
    @Column(name = "PRINCIPAL_")
    private String principal;

    /**
     * 联系电话
     */
    @Column(name = "PHONE_")
    private String phone;

    /**
     * 价格
     */
    @Column(name = "PRICE_")
    private Double price;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL_")
    private String email;
    /**
     * 是否公开
     */
    @Column(name = "PUBLICED_")
    private Boolean publiced;
    
    /**
     * 是否可预约
     */
    @Column(name="APPLICABLE_")
    private Boolean applicable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID_")
    private IndustryTestCatEntity industryTestcat;

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<IndustryTestTimequantumEntity> testTimequantumEntities;

    
    
    public Boolean getApplicable() {
		return applicable;
	}

	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}

	public Boolean getPubliced() {
        return publiced;
    }

    public void setPubliced(Boolean publiced) {
        this.publiced = publiced;
    }

    public List<IndustryTestTimequantumEntity> getTestTimequantumEntities() {
        return testTimequantumEntities;
    }

    public void setTestTimequantumEntities(List<IndustryTestTimequantumEntity> testTimequantumEntities) {
        this.testTimequantumEntities = testTimequantumEntities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUndertakeUnit() {
        return undertakeUnit;
    }

    public void setUndertakeUnit(String undertakeUnit) {
        this.undertakeUnit = undertakeUnit;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public IndustryTestCatEntity getIndustryTestcat() {
        return industryTestcat;
    }

    public void setIndustryTestcat(IndustryTestCatEntity industryTestcat) {
        this.industryTestcat = industryTestcat;
    }

}
