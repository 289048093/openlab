/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:12:14 AM
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
 * 
 * 专家问答回复
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_expert_question_answer")
public class ExpertQuestionAnswerEntity extends BaseEntity {

    /**
     * 回复内容
     */
    @Column(name = "CONTENT_")
    private String content;
    /**
     * 回复时间
     */
    @Column(name = "ADD_DATE_")
    private Date addDate;

    /**
     * 回答的对应问题
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID_")
    private ExpertQuestionEntity question;
    /**
     * 是否查看过
     */
    @Column(name = "IS_VIEW_")
    private Boolean isView;
    /**
     * 回复人
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTIONER_ID_")
    private UserEntity answerer;

    /**
     * 引用回复
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFERENCE_ANSWER_ID_")
    private ExpertQuestionAnswerEntity referenceAnswer;

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

    public ExpertQuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(ExpertQuestionEntity question) {
        this.question = question;
    }

   

    public Boolean getIsView() {
		return isView;
	}

	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public UserEntity getAnswerer() {
        return answerer;
    }

    public void setAnswerer(UserEntity answerer) {
        this.answerer = answerer;
    }

    public ExpertQuestionAnswerEntity getReferenceAnswer() {
        return referenceAnswer;
    }

    public void setReferenceAnswer(ExpertQuestionAnswerEntity referenceAnswer) {
        this.referenceAnswer = referenceAnswer;
    }

}
