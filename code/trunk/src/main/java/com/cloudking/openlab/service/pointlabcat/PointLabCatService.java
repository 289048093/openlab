package com.cloudking.openlab.service.pointlabcat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.PointLabCatDAO;

/**
 * 重点实验室分类
 * 
 * @author cloudKing
 * 
 */
@Service("pointLabCatService")
public class PointLabCatService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private PointLabCatDAO pointLabCatDAO;
}
