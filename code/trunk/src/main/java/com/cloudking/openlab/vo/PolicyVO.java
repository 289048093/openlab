/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  10:58:32 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */
public class PolicyVO extends BaseVO {
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 关键字
	 */
	private String keyWords;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 添加时间
	 */
	private Date addDate;
	/**
	 * 修改时间
	 */
	private Date modifyDate;
	/**
	 * 所在类别id
	 */
	private Integer catId;
	/**
	 * 是否公开
	 */
	private Boolean publiced;
	/**
	 * 置顶（不置顶时为0，置顶时为1)
	 */
	private byte top;
	/**
	 * 阅读次数
	 */
	private Integer count;
	/**
	 * 供稿单位
	 */
	private String providerName;

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

	public byte getTop() {
		return top;
	}

	public void setTop(byte top) {
		this.top = top;
	}

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
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

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}
}
