package com.cloudking.openlab.action.industrytest;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.applyorder.ApplyOrderService;
import com.cloudking.openlab.service.industrytest.IndustryTestService;
import com.cloudking.openlab.service.industrytestcat.IndustryTestCatService;
import com.cloudking.openlab.vo.IndustryTestCatVO;
import com.cloudking.openlab.vo.IndustryTestVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/industryTestManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
		@Result(name = "query", type = "dispatcher", location = "/industryTest/industryTest.jsp"),
		@Result(name = "detail", type = "dispatcher", location = "/industryTest/industryTest_detail.jsp"),
		@Result(name = "appointed", type = "dispatcher", location = "/industryTest/appointed.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp") })
public class IndustryTestAction extends BaseAction<IndustryTestVO> {
	private static final String QUERY = "query";
	private static final String DETAIL = "detail";
	private static final String APPOINTED = "appointed";
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	@SuppressWarnings("unused")
	@Resource
	private IndustryTestService industryTestService;
	@Resource
	private ApplyOrderService applyOrderService;
	@Resource
	private IndustryTestCatService industryTestCatService;

	@Action("/industryTest")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {

		cloudContext.addParam("industryTestVOs", industryTestService
				.query(cloudContext));
		// 行业分类
		List<IndustryTestCatVO> industryTestCatVOs = industryTestCatService
				.query();
		cloudContext.addParam("industryTestCatVOs", industryTestCatVOs);
		// 当前选中行业分类
		cloudContext.addParam("cloudContext.vo.industryTestcatId", cloudContext
				.getVo().getIndustryTestcatId());
		return QUERY;
	}

	// 申请行业检测预约
	public String appointed() throws SQLException {
		industryTestService.queryById(cloudContext);
		return APPOINTED;

	}

	public String queryById() throws Exception {

		industryTestService.queryById(cloudContext);

		return DETAIL;
	}

	public String upload() throws Exception {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/images");
		if (image != null) {
			File savefile = new File(new File(realpath), UUID.randomUUID()
					.toString());
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			cloudContext.addSuccessMsg("上传文件成功");
		}
		return "success";
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
