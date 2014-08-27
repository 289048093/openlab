package com.cloudking.openlab.vo;

import java.util.Date;

import com.cloudking.openlab.BaseVO;

/**
 * NewsVO
 * 
 * @author CloudKing
 * 
 */
public class NewsVO extends BaseVO {
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻关键字
	 */
	private String keyWords;
	/**
	 * 新闻内容
	 */
	private String content;
	/**
	 * 新闻添加时间
	 */
	private Date addDate;
	/**
	 * 新闻修改时间
	 */
	private Date modifyDate;
	/**
	 * 新闻所在类别id
	 */
	private Integer catid;
	/**
	 * 新闻所在类别名称
	 */
	private String catname;
	/**
	 * 是否公开
	 */
	private Boolean publiced;
	/**
	 * 置顶（不置顶时为0，置顶时为1)
	 */
	private Byte top;
	/**
	 * 阅读次数
	 */
	private Integer count;
	/**
	 * 供稿单位
	 */
	private String providerName;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

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

	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

}
