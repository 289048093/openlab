package com.cloudking.openlab.service.downloadfilecat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.dao.DownloadFileCatDAO;

@Service("downloadFileCatService")
public class DownloadFileCatService extends BaseService {
	@SuppressWarnings("unused")
	@Resource
	private DownloadFileCatDAO downloadFileCatDAO;
}