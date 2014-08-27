/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:02:20 AM
 */
package com.cloudking.openlab.vo;

import java.util.List;

import com.cloudking.openlab.BaseVO;

/**
 * 文件下载分类
 * 
 * @author CloudKing
 */
public class DownloadFileCatVO extends BaseVO {

	private String name;

	private String desc;

	private List<DownloadFileVO> downloadFile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<DownloadFileVO> getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(List<DownloadFileVO> downloadFile) {
		this.downloadFile = downloadFile;
	}

}
