package com.cloudking.openlab.service.successcase;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.SuccessCaseDAO;

@Service("successCaseService")
public class SuccessCaseService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private SuccessCaseDAO successCaseDAO;

}