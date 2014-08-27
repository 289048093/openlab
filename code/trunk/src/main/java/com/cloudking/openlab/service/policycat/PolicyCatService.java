package com.cloudking.openlab.service.policycat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.PolicyCatDAO;

@Service("policyCatService")
public class PolicyCatService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private PolicyCatDAO policyCatDAO;
}
