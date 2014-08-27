/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:09:09 PM
 */
package com.cloudking.openlab.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;
import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */

public class AnswerVO extends BaseVO {
    /**
     * 提示问题
     */
    private String answer;
    /**
     * 提示问题
     */
    
    private RegQuestionVO regQuestionId;
    /**
     * 用户
     */
     
    private long userId;

   
    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	public RegQuestionVO getRegQuestionId() {
		return regQuestionId;
	}

	public void setRegQuestionId(RegQuestionVO regQuestionId) {
		this.regQuestionId = regQuestionId;
	}

   
}
