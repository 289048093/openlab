package com.cloudking.openlab.service.regquestion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.RegQuestionDAO;

@Service("regQuestionService")
public class RegQuestionService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private RegQuestionDAO regQuestionDAO;

}

