package com.cloudking.openlab.service.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.RoleDAO;

@Service("roleService")
public class RoleService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private RoleDAO roleDAO;

}