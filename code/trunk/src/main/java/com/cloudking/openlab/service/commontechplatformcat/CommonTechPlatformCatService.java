package com.cloudking.openlab.service.commontechplatformcat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.CommonTechPlatformCatDAO;

@Service("commonTechPlatformCatService")
public class CommonTechPlatformCatService extends BaseService {

	@SuppressWarnings("unused")
	@Resource
	private CommonTechPlatformCatDAO commonTechPlatformCatDAO;
}
