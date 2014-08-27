package com.cloudking.openlab.vo;

import java.util.Date;

/**
 * 用户
 * 
 * @author CloudKing
 */
public class ExpertVO extends UserVO {
	//本类独有
	/**
	 * 职称
	 */
	private String title;
	/**
	 * 研究领域
	 */
	private String researchArea;
	/**
	 * 描述信息
	 */
	private String desc;
	
	/**
	 * 是否显示在首页
	 */
	private Boolean indexShow;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResearchArea() {
		return researchArea;
	}
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Boolean getIndexShow() {
		return indexShow;
	}
	public void setIndexShow(Boolean indexShow) {
		this.indexShow = indexShow;
	}
	
}