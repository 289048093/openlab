package com.cloudking.openlab.service.menu;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.MenuDAO;

@Service("menuService")
public class MenuService extends BaseService{
	@SuppressWarnings("unused")
	@Resource
	private MenuDAO menuDAO;

}
