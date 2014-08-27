package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * NewsCatVO
 * 
 * @author CloudKing
 * 
 */
public class NewsCatVO extends BaseVO {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 新闻类别下的所有新闻单元
	 */
	private List<NewsVO> newsUnits;

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

	public List<NewsVO> getNewsUnits() {
		return newsUnits;
	}

	public void setNewsUnits(List<NewsVO> newsUnits) {
		this.newsUnits = newsUnits;
	}
}
