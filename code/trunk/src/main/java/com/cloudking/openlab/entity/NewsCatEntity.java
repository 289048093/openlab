/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:57:27 AM
 */
package com.cloudking.openlab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 新闻分类
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_news_cat")
public class NewsCatEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4116146997299426583L;
	/**
	 * 名称
	 */
	@Column(name = "NAME_")
	private String name;
	/**
	 * 描述
	 */
	@Column(name = "DESC_")
	private String desc;
	/**
	 * 新闻
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "newsCat", targetEntity = NewsEntity.class)
	private List<NewsEntity> news;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}

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

	public List<NewsEntity> getNews() {
		return news;
	}

	public void setNews(List<NewsEntity> news) {
		this.news = news;
	}

}
