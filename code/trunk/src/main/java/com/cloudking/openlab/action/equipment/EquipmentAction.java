package com.cloudking.openlab.action.equipment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.List;

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
import com.cloudking.openlab.service.commontechplatform.CommonTechPlatformService;
import com.cloudking.openlab.service.equipment.EquipmentService;
import com.cloudking.openlab.service.equipmentcat.EquipmentCatService;
import com.cloudking.openlab.service.pointlab.PointLabService;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.EquipmentCatVO;
import com.cloudking.openlab.vo.EquipmentVO;

/**
 * 用户
 * 
 * @author CloudKing
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/equipmentManager")
@Results( {
				@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
				@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
				@Result(name = "download", type = "stream", params = { "contentType", "application/octet-stream",
								"inputName", "file", "allowCaching", "false", "encode", "true", "contentDisposition",
								"attachment;filename=%{#request.cloudContext.params.fileName}" }),
				@Result(name = "query", type = "dispatcher", location = "/Equipment/equipment_list.jsp"),
				@Result(name = "detail", type = "dispatcher", location = "/Equipment/equipment_detail.jsp"),
				@Result(name = "appointed", type = "dispatcher", location = "/Equipment/appointed.jsp"), })
public class EquipmentAction extends BaseAction<EquipmentVO> {
	private static final String QUERY = "query";
	private static final String DETAIL = "detail";
	private static final String APPOINTED = "appointed";

	@Resource
	private EquipmentService equipmentService;

	@Resource
	private EquipmentCatService equipmentCatService;

	@Resource
	private PointLabService labService;

	@Resource
	private CommonTechPlatformService commonTechPlatformService;

	private InputStream file;

	@Override
	@Action("/equipment")
	public String execute() throws Exception {
		return INPUT;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	/*
	 * 查询
	 */
	public String query() throws Exception {
		cloudContext.addParam("equipmentVOs", equipmentService.query(cloudContext));
		//仪器分类
		List<EquipmentCatVO> equipmentCatVOs = equipmentCatService.query();
		cloudContext.addParam("equipmentCatVOs", equipmentCatVOs);
		//实验室
		cloudContext.addParam("labVOs", labService.query());
		//技术平台
		cloudContext.addParam("comms", commonTechPlatformService.query());
		//当前选中技术平台
		cloudContext.addParam("cloudContext.vo.commId", cloudContext.getVo().getCommId());
		//当前选中仪器分类
		cloudContext.addParam("cloudContext.vo.catId", cloudContext.getVo().getCatId());
		//当前选中仪器实验室
		cloudContext.addParam("cloudContext.vo.labId", cloudContext.getVo().getLabId());
		return QUERY;
	}

	/**
	 * 预约
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String appointed() throws SQLException {
		equipmentService.queryById(cloudContext);
		return APPOINTED;
	}

	public String queryById() throws Exception {
		equipmentService.queryById(cloudContext);
		return DETAIL;
	}

	public String showPic() {
		String pic = cloudContext.getStringParam("pic");
		if (StringUtil.isBlank(pic) || "null".equals(pic)) {
			pic = "";
		}
		String defaultPic = PropertyManager.getInstance().getDbProperty(PropertyManager.DB_EQUIPMENTPIC_DEFAULT);
		File picFile = new File(ProjectUtil.getEquipmentDir(), StringUtil.isBlank(pic) ? defaultPic : pic);
		if (!picFile.exists()) {
			synchronized (this) {
			//如果文件不存在则先到服务器下载
				String url = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_OPENLAB_COREMANAGER_HOST)
								+ "/equipmentManager/equipment!showPic.action?cloudContext.params.pic=" + pic;
				HttpURLConnection conn = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					conn = (HttpURLConnection) new URL(url).openConnection();
					conn.addRequestProperty("http.keepAlive", "false");
					is = conn.getInputStream();
					os = new FileOutputStream(picFile);
					IOUtils.copy(is, os);
				} catch (MalformedURLException e) {
				} catch (IOException e) {
				} finally {
					if (conn != null)
						conn.disconnect();
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(os);
				}
			}
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(picFile);
			os = getResponse().getOutputStream();
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		return NONE;
	}
}
