package com.cloudking.openlab.action.techtransferandresearchachieve;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.service.researchachieve.ResearchAchieveService;
import com.cloudking.openlab.service.techtransfer.TechTransferService;
import com.cloudking.openlab.vo.techTransferAndResearchAchieveVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/techTransferAndResearchAchieveManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/techTransferAndResearchAchieve/techTransferAndResearchAchieve.jsp"),
		@Result(name = "researchachievedetail", type = "dispatcher", location = "/techTransferAndResearchAchieve/researchAchieve_detail.jsp"),
		@Result(name = "transferdetail", type = "dispatcher", location = "/techTransferAndResearchAchieve/techTransfer_detail.jsp"),
		@Result(name = "researchachievelist", type = "dispatcher", location = "/techTransferAndResearchAchieve/researchAchieve_list.jsp"),
		@Result(name = "transferlist", type = "dispatcher", location = "/techTransferAndResearchAchieve/techTranfer_list.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp") })
public class techTransferAndResearchAchieveAction extends
		BaseAction<techTransferAndResearchAchieveVO> {

	private static final String RESEARCHACHIEVEDETAIL = "researchachievedetail";
	private static final String TRANSFERDETAIL = "transferdetail";
	private static final String RESEARCHACHIEVELIST = "researchachievelist";
	private static final String TRANSFERLIST = "transferlist";
	@Resource
	private ResearchAchieveService achieveService;

	@Resource
	private TechTransferService techTransferService;

	@Override
	@Action("/techTransferAndResearchAchieve")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 查询科技成果与技术转移
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String query() throws SQLException {
		achieveService.query(cloudContext); // 查询科研成果列表
		techTransferService.query(cloudContext); // 查询技术转移

		return SUCCESS;
	}

	/**
	 * 科技成果详情
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String researchAchieveDetail() throws SQLException {
		achieveService.queryById(cloudContext);
		achieveService.query(cloudContext); // 查询科研成果列表
		return RESEARCHACHIEVEDETAIL;
	}

	/**
	 * 技术转移详情
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String transferDetail() throws SQLException {
		techTransferService.queryById(cloudContext);
		techTransferService.query(cloudContext);
		return TRANSFERDETAIL;
	}

	/**
	 * 查询科研成果
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String queryResearchAchieve() throws SQLException {
		achieveService.query(cloudContext); // 查询科研成果列表
		return RESEARCHACHIEVELIST;

	}

	/**
	 * 查询技术转移
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String queryTransfer() throws SQLException {
		techTransferService.query(cloudContext); // 查询技术转移列表
		return TRANSFERLIST;

	}

}
