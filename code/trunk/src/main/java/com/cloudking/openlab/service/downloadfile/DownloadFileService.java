package com.cloudking.openlab.service.downloadfile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.DownloadFileCatDAO;
import com.cloudking.openlab.dao.DownloadFileDAO;
import com.cloudking.openlab.entity.DownloadFileCatEntity;
import com.cloudking.openlab.entity.DownloadFileEntity;
import com.cloudking.openlab.vo.DownloadFileCatVO;
import com.cloudking.openlab.vo.DownloadFileVO;

@Service("downloadFileService")
public class DownloadFileService extends BaseService {
    @SuppressWarnings("unused")
    @Resource
    private DownloadFileDAO downloadFileDAO;

    @Resource
    private DownloadFileCatDAO downloadFileCatDAO;

    /**
     * 查询
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void query(CloudContext<DownloadFileVO> cloudContext) throws SQLException {
        List<DownloadFileEntity> downloadFileEntitys;
        List<DownloadFileCatEntity> downloadFileCatEntitys;
        String name = cloudContext.getVo().getName();
        String desc = cloudContext.getVo().getDesc();
        // 得到下载文件
        downloadFileEntitys = downloadFileDAO.query(name, desc, cloudContext.getLongParam("catId"), cloudContext
                        .getPageInfo());
        // 得到下载分类
        downloadFileCatEntitys = downloadFileCatDAO.listPubliced();
        // vo转换
        List<DownloadFileVO> downloadFile = new ArrayList<DownloadFileVO>();
        DownloadFileVO downloadFileVO = null;
        List<DownloadFileCatVO> downloadFileCat = new ArrayList<DownloadFileCatVO>();
        DownloadFileCatVO downloadFileCatVO = null;
        if (downloadFileEntitys != null) {
            for (DownloadFileEntity e : downloadFileEntitys) {
                downloadFileVO = new DownloadFileVO();
                BeanUtils.copyProperties(e, downloadFileVO);
                downloadFileVO.setUrl("downloadFileManager/downloadFile!downloadFile.action?cloudContext.vo.id="
                                + downloadFileVO.getId());
                downloadFile.add(downloadFileVO);
            }

        }
        if (downloadFileCatEntitys != null) {
            for (DownloadFileCatEntity e : downloadFileCatEntitys) {
                downloadFileCatVO = new DownloadFileCatVO();
                BeanUtils.copyProperties(e, downloadFileCatVO);
                downloadFileCat.add(downloadFileCatVO);
            }
        }
        cloudContext.addParam("downloadFile", downloadFile);
        cloudContext.addParam("downloadFileCat", downloadFileCat);
    }
}
