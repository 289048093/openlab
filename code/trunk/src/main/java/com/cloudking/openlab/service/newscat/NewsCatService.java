package com.cloudking.openlab.service.newscat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.NewsCatDAO;

@Service("newsCatService")
public class NewsCatService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private NewsCatDAO newsCatDAO;

	
}
