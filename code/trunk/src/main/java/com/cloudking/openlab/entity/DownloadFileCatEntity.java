/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Aug 27, 2013  11:02:20 AM
 */
package com.cloudking.openlab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cloudking.openlab.BaseEntity;

/**
 * 文件下载分类
 * 
 * @author CloudKing
 */
@Entity
@Table(name = "tb_download_file_cat")
public class DownloadFileCatEntity extends BaseEntity {

	@Column(name = "NAME_")
	private String name;

	@Column(name = "DESC_")
	private String desc;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cat", targetEntity = DownloadFileEntity.class)
	private List<DownloadFileEntity> downloadFile;
	/**
	 * 是否公开
	 */
	@Column(name = "PUBLICED_")
	private Boolean publiced;

	public Boolean getPubliced() {
		return publiced;
	}

	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}

	public List<DownloadFileEntity> getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(List<DownloadFileEntity> downloadFile) {
		this.downloadFile = downloadFile;
	}

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

}
