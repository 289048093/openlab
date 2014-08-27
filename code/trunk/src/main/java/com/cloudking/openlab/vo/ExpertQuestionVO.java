/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:12:14 AM
 */
package com.cloudking.openlab.vo;

import java.util.Date;
import com.cloudking.openlab.BaseVO;

/**
 * @author CloudKing
 */
public class ExpertQuestionVO extends BaseVO {
	/*
	 * 问题标题
	 */
    private String title;
    /*
     * 问题内容
     */
    private String content;
    /*
     * 添加时间
     */
    private Date addDate;
    /*
     * 修改时间
     */
    private Date modifuDate;
    /*
     * 是否已经看过
     */
    private boolean isView;
    /*
     * 提问人
     */
    private Long questionerId;
    /*
     * 提问人姓名
     */
    private String questionerName;
    /*
     * 注明回答人
     */
    private Long expertId;
    /*
     * 回答人姓名
     */
    private String expertName;
    
    public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
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

    public Date getModifuDate() {
        return modifuDate;
    }

    public void setModifuDate(Date modifuDate) {
        this.modifuDate = modifuDate;
    }

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public Long getQuestionerId() {
		return questionerId;
	}

	public void setQuestionerId(Long questionerId) {
		this.questionerId = questionerId;
	}
	
	public String getQuestionerName() {
		return questionerName;
	}

	public void setQuestionerName(String questionerName) {
		this.questionerName = questionerName;
	}

	public Long getExpertId() {
		return expertId;
	}

	public void setExpertId(Long expertId) {
		this.expertId = expertId;
	}

  
}
