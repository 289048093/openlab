package com.cloudking.openlab.service.expertquestionanswer;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.ExpertQuestionAnswerDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.dao.ExpertQuestionDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.ExpertQuestionAnswerEntity;
import com.cloudking.openlab.entity.ExpertQuestionEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.vo.ExpertQuestionAnswerVO;
import com.cloudking.openlab.util.ProjectUtil;

@Service("expertQuestionAnswerService")
public class ExpertQuestionAnswerService extends BaseService{
	/**
	 * 引入对应的dao
	 */
	@Resource
	private ExpertQuestionAnswerDAO expertQuestionAnswerDAO;
	/**
	 * 引入user的dao
	 */
	@Resource
	private UserDAO userDAO;
	/**
	 * 引入问题的dao
	 */
	@Resource
	private ExpertQuestionDAO expertQuestionDAO;
	/**
	 * 添加回答
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void addExepertAnswer(CloudContext<ExpertQuestionAnswerVO> cloudContext) throws SQLException{
		ExpertQuestionAnswerEntity eqaEntity = new ExpertQuestionAnswerEntity();
		BeanUtils.copyProperties(cloudContext.getVo(), eqaEntity);
		String content = ProjectUtil.clearScript(eqaEntity.getContent());
		eqaEntity.setContent(content);
		eqaEntity.setAddDate(new Date());
		eqaEntity.setIsView(false);
		UserEntity loginuser = userDAO.get(cloudContext.getLoginedUser().getId());
		if (loginuser!=null) {
			eqaEntity.setAnswerer(loginuser);
		}else {
			cloudContext.addErrorMsg("当前没有用户登录");
		}
		ExpertQuestionEntity xzeqEntity = expertQuestionDAO.get(cloudContext.getVo().getQuestionId());
		if (xzeqEntity != null) {
			eqaEntity.setQuestion(xzeqEntity);
		}else{
			cloudContext.addErrorMsg("不存在的问题");
		}
		//条件通过，保存
		expertQuestionAnswerDAO.insert(eqaEntity);
	}

}
