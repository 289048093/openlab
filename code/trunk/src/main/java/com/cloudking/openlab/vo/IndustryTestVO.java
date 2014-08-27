/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:06:22 AM
 */
package com.cloudking.openlab.vo;

import java.util.List;

import javax.persistence.Column;

import com.cloudking.openlab.BaseVO;

/**
 * 行业检测
 * 
 * @author CloudKing
 */
public class IndustryTestVO extends BaseVO {

    private static final long serialVersionUID = -8011567335651439116L;

    private String name;

    private String content;
    /**
     * 检测项目
     */
    private String project;
    /**
     * 检测产品
     */
    private String product;
    private Long industryTestcatId;
    private String industryTestCatName;

    /**
     * 承接单位
     */
    private String undertakeUnit;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 价格
     */
    private Double price;

    private String email;


    /**
     * 是否公开
     */
    private Boolean publiced;

    /**
     * 是否可预约
     */
    private Boolean applicable;
    
    
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public Long getIndustryTestcatId() {
        return industryTestcatId;
    }

    public void setIndustryTestcatId(Long industryTestcatId) {
        this.industryTestcatId = industryTestcatId;
    }

    public String getIndustryTestCatName() {
        return industryTestCatName;
    }

    public void setIndustryTestCatName(String industryTestCatName) {
        this.industryTestCatName = industryTestCatName;
    }

}
