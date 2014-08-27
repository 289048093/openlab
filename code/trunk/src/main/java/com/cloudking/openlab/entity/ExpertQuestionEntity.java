/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:12:14 AM
 */
package com.cloudking.openlab.entity;

import java.util.Date;
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
 * 专家问题
 */
@Entity
@Table(name="tb_expert_question")
public class ExpertQuestionEntity extends BaseEntity {
	/**
	 * 提问的标题
	 */
	@Column(name = "TITLE_")
	private String title;
	/**
	 * 问题的内容
	 */
	@Column(name = "CONTENT_")
	private String content;
	/**
	 * 发问时间
	 */
	@Column(name = "ADD_DATE_")
	private Date addDate;
	/**
	 * 修改时间
	 */
	@Column(name = "MODIFY_DATE_")
	private Date modifyDate;
	/**
	 * 是否转给专家，问题提出后管理员审核，审核成功后转给专家
	 */
	@Column(name = "TO_EXPERT_")
	private Boolean toExpert;
	/**
	 * 问题类型，是否是经典问题等
	 */
	@Column(name = "TYPE_")
	private Byte type;
	/**
     * 是否查看过
     */
    @Column(name = "IS_VIEW_")
    private boolean isView;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="question")
    private List<ExpertQuestionAnswerEntity> answers;
    
	/**
	 * 提问用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTIONER_ID_")
	private UserEntity questioner;
	/**
	 * 回答人
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXPERT_ID_")
	private UserEntity expert;

	public List<ExpertQuestionAnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<ExpertQuestionAnswerEntity> answers) {
		this.answers = answers;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Boolean getToExpert() {
		return toExpert;
	}

	public void setToExpert(Boolean toExpert) {
		this.toExpert = toExpert;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public UserEntity getQuestioner() {
		return questioner;
	}

	public void setQuestioner(UserEntity questioner) {
		this.questioner = questioner;
	}

	public UserEntity getExpert() {
		return expert;
	}

	public void setExpert(UserEntity expert) {
		this.expert = expert;
	}

}
