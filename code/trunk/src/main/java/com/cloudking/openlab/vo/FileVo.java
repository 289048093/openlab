/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 6, 2013  4:29:55 PM
 */
package com.cloudking.openlab.vo;

import java.io.File;

import com.cloudking.openlab.BaseVO;


/**
 * @author CloudKing
 */
public class FileVo extends BaseVO {
    /**
     * 上传的文件
     */
    private File uploadFile;
    /**
     * 上传文件的文件名
     */
    private String uploadFileFileName;
    /**
     * 上传的文件类型
     */
    private String uploadFileContentType;

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }
}
