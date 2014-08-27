/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:12:14 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cloudking.openlab.BaseEntity;
import com.cloudking.openlab.BaseVO;

/**
 * 
 * 专家问答回复
 * 
 * @author CloudKing
 */
public class ExpertQuestionAnswerVO extends BaseVO {

    /**
     * 回复内容
     */
    private String content;

    private Date addDate;
    /**
     * 主题
     */
    private Long questionId;

    /**
     * 回复人
     */
    private Long answererId;
    
    /**
     * 回复人
     */
    private String answererName;
    /**
     * 是否已经看过
     */
    private boolean isView;
    /**
     * 引用回复
     */

    private Long referenceAnswerId;

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

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getAnswererId() {
		return answererId;
	}

	public void setAnswererId(Long answererId) {
		this.answererId = answererId;
	}

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public Long getReferenceAnswerId() {
		return referenceAnswerId;
	}

	public void setReferenceAnswerId(Long referenceAnswerId) {
		this.referenceAnswerId = referenceAnswerId;
	}

	public String getAnswererName() {
		return answererName;
	}

	public void setAnswererName(String answererName) {
		this.answererName = answererName;
	}

 
}
