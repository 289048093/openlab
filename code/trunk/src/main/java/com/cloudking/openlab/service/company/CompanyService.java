package com.cloudking.openlab.service.company;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.CompanyDAO;

@Service("companyService")
public class CompanyService extends BaseService{
	@Resource
	private CompanyDAO companyDAO;

}
