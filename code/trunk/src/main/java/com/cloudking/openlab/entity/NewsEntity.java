/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:57:27 AM
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
 * 新闻
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_news")
public class NewsEntity extends BaseEntity {
	/**
	 * 标题
	 */
	@Column(name = "TITLE_")
	private String title;
	/**
	 * 关键字
	 */
	@Column(name = "KEY_WORDS_")
	private String keyWords;
	/**
	 * 内容
	 */
	@Column(name = "CONTENT_", columnDefinition = "text")
	private String content;
	/**
	 * 添加时间
	 */
	@Column(name = "ADD_DATE_")
	private Date addDate;
	/**
	 * 修改时间
	 */
	@Column(name = "MODIFY_DATE_")
	private Date modifyDate;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;
	/**
	 * 置顶（不置顶时为0，置顶时为1)
	 */
	@Column(name = "TOP_")
	private Byte top;
	/**
	 * 新闻类别
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAT_ID_")
	private NewsCatEntity newsCat;
	/**
	 * 阅读次数
	 */
	@Column(name = "COUNT_")
	private Integer count;
	/**
	 * 供稿单位
	 */
	@Column(name = "PROVIDER_NAME_")
	private String providerName;

	public Byte getTop() {
		return top;
	}

	public void setTop(Byte top) {
		this.top = top;
	}

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}

	public NewsCatEntity getNewsCat() {
		return newsCat;
	}

	public void setNewsCat(NewsCatEntity newsCat) {
		this.newsCat = newsCat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
}
