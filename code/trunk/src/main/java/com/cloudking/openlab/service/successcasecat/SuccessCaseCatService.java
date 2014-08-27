package com.cloudking.openlab.service.successcasecat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.SuccessCaseCatDAO;

@Service("successCaseCatService")
public class SuccessCaseCatService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private SuccessCaseCatDAO successCaseCatDAO;

}

