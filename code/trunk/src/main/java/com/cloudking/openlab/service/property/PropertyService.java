package com.cloudking.openlab.service.property;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.PropertyDAO;

@Service("propertyService")
public class PropertyService extends BaseService{
    @SuppressWarnings("unused")
	@Resource
	private PropertyDAO propertyDAO;
}