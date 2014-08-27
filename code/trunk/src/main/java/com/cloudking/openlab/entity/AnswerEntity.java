/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:09:09 PM
 */
package com.cloudking.openlab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * @author CloudKing
 */
@Entity
@Table(name = "tb_answer")
public class AnswerEntity extends BaseEntity {
    /**
     * 提示问题
     */
    @Column(name = "ANSWER_", length = 30, nullable = false)
    private String answer;
    /**
     * 提示问题
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_QUESTION_ID_")
    private RegQuestionEntity regQuestion;
    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID_")   
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public RegQuestionEntity getRegQuestion() {
        return regQuestion;
    }

    public void setRegQuestion(RegQuestionEntity regQuestion) {
        this.regQuestion = regQuestion;
    }
}
