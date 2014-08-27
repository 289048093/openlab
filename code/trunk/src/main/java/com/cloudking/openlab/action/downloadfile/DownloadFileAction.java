package com.cloudking.openlab.action.downloadfile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.DownloadFileDAO;
import com.cloudking.openlab.entity.DownloadFileEntity;
import com.cloudking.openlab.service.downloadfile.DownloadFileService;
import com.cloudking.openlab.vo.DownloadFileVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/downloadFileManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "download", type = "stream", params = { "contentType",
				"application/octet-stream", "inputName",
				"cloudContext.params.file", "allowCaching", "false", "encode",
				"true", "contentDisposition",
				"attachment;filename=%{#request.cloudContext.params.fileName}" }),
		@Result(name = "query", type = "dispatcher", location = "/DownloadCenter/downloadcenter.jsp") })
public class DownloadFileAction extends BaseAction<DownloadFileVO> {
	private static final String QUERY = "query";
	@Resource
	private DownloadFileService downloadFileService;

	@Resource
	private DownloadFileDAO downloadFileDAO;

	@Action("/downloadFile")
	public String execute() throws Exception {
		return INPUT;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		downloadFileService.query(cloudContext);
		return QUERY;
	}

	// 下载
	public String downloadFile() throws SQLException {
		String url = PropertyManager.getInstance().getXMLProperty(
				PropertyManager.XML_OPENLAB_COREMANAGER_HOST)
				+ "/downloadFileManager/downloadFile!downloadFile.action?cloudContext.vo.id="
				+ cloudContext.getVo().getId();
		DownloadFileEntity dfe = downloadFileDAO.get(cloudContext.getVo()
				.getId());
		// String fileName = dfe.getRealname();
		// cloudContext.getVo().setName(fileName);
		URLConnection conn = null;
		InputStream fis = null;
		try {
			conn = new URL(url).openConnection();
			fis = conn.getInputStream();
//			cloudContext.addParam("file", fis);
//			cloudContext.addParam("fileName", dfe.getRealname());
//			getResponse().setContentType("bin"); 
//			getResponse().setHeader("Content-disposition","attachment;filename="+dfe.getRealname());
			IOUtils.copy(fis, getResponse().getOutputStream());
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (fis != null)
					fis.close();
				getResponse().getOutputStream().close();
			} catch (IOException e) {
			}

		}
		return NONE;
	}
}
