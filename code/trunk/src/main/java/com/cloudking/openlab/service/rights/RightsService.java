package com.cloudking.openlab.service.rights;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.RightsDAO;

@Service("rightsService")
public class RightsService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private RightsDAO rightsDAO;

}
