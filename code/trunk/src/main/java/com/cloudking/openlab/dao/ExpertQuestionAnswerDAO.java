package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.ExpertQuestionAnswerEntity;

@Repository("expertQuestionAnswerDAO")
public class ExpertQuestionAnswerDAO  extends BaseDAO<ExpertQuestionAnswerEntity>{
	/**
	 * 根据问题的id获取本问题对应的回答
	 * @param catid
	 * @return
	 * @throws SQLException 
	 */
	public List<ExpertQuestionAnswerEntity> getExpertQuestionAnswersByCtatid(Long catid) throws SQLException{
		String hql = "select eqa_ from ExpertQuestionAnswerEntity eqa_ where eqa_.question.id=:eqid";
		return list(hql, "eqid", catid);
	}
}
