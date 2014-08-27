package com.cloudking.openlab.action.applyorder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.ApplyOrderDAO;
import com.cloudking.openlab.entity.ApplyOrderEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.service.applyorder.ApplyOrderService;
import com.cloudking.openlab.service.equipment.EquipmentService;
import com.cloudking.openlab.util.MailUtil;
import com.cloudking.openlab.vo.ApplyOrderVO;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/applyOrderManager")
@Results( {
		@Result(name = "success", type = "dispatcher", location = "/Equipment/equipment_sq_success.jsp"),
		@Result(name = "successIndustryTest", type = "dispatcher", location = "/industryTest/industryTest_sq_success.jsp"),
		@Result(name = "industryTestApplyError", type = "dispatcher", location = "/industryTest/industryTest_sq_error.jsp"),
		@Result(name = "equipmentApplyError", type = "dispatcher", location = "/Equipment/equipment_sq_error.jsp"),
		@Result(name = "applydetail", type = "dispatcher", location = "/userCenter/ApplyOrder_Detail.jsp"),
		@Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
		@Result(name = "download", type = "stream", params = { "contentType",
				"application/octet-stream", "inputName",
				"cloudContext.params.file", "allowCaching", "false", "encode",
				"true", "contentDisposition",
				"attachment;filename=%{#request.cloudContext.params.filename}" }) })
public class ApplyOrderAction extends BaseAction<ApplyOrderVO> {

	@Resource
	private ApplyOrderService applyOrderService;
	private static final String SUCCESSINDUSTERYTEST = "successIndustryTest";
	private static final String INDUSTERYTEST_APPLYERROR = "industryTestApplyError";
	private static final String EQUIPMENT_APPLYERROR = "equipmentApplyError";
	private static final String APPLYDETAIL = "applydetail";

	@Resource
	private EquipmentService equipmentService;
	@Resource
	private ApplyOrderDAO applyOrderDAO;

	@Action("/applyOrder")
	public String execute() throws Exception {

		return INPUT;
	}

	/**
	 * 使用或预约
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public String appinted() throws SQLException {

		if (cloudContext.getVo().getEquipmentId() != null) {
			if (!cloudContext.getSuccessIngoreWarn()) {
				return EQUIPMENT_APPLYERROR;
			}
			if (cloudContext.getLoginedUser() == null) {
				cloudContext.addErrorMsg("你还未登录或会话超时，请重新登录");
				return EQUIPMENT_APPLYERROR;
			}
			applyOrderService.add(cloudContext);
			if (cloudContext.getSuccessIngoreWarn()) {
				// 查询预约订单
				ApplyOrderEntity applyOrderEntity = applyOrderService
						.queryById(cloudContext.getVo().getId());
				if (applyOrderEntity != null) {
					// 发送邮件
					MailUtil.sendMail("大学城仪器设备预约使用申请",
							"您好：你申请的仪器设备预约使用申请已提交完成；预约号为:【"
									+ applyOrderEntity.getOrdrNum()
									+ "】，请注意审核结果！！", applyOrderEntity.getUser()
									.getEmail(), true);
					// 发送给管理员
					UserEntity sys = equipmentService
							.queryEquipmentSystem(applyOrderEntity
									.getEquipment().getId());
					if (sys != null) {
						MailUtil.sendMail("大学城仪器设备预约使用申请", "仪器设备:【"
								+ applyOrderEntity.getEquipment().getName()
								+ "】有新的预约订单【" + applyOrderEntity.getOrdrNum()
								+ "】，请您及时处理!!!", sys.getEmail(), true);
					}
				}
			}
			return cloudContext.getSuccessIngoreWarn() ? SUCCESS
					: EQUIPMENT_APPLYERROR;

		} else {
			if (!cloudContext.getSuccessIngoreWarn()) {
				return INDUSTERYTEST_APPLYERROR;
			}
			if (cloudContext.getLoginedUser() == null) {
				cloudContext.addErrorMsg("你还未登录或会话超时，请重新登录");
				return INDUSTERYTEST_APPLYERROR;
			}
			if (getRequest().getSession(false) == null) {
				cloudContext.addErrorMsg("Session has been invalidated!");
			}
			applyOrderService.add(cloudContext);
			if (cloudContext.getSuccessIngoreWarn()) {
				// 查询预约订单
				ApplyOrderEntity applyOrderEntity = applyOrderService
						.queryById(cloudContext.getVo().getId());
				if (applyOrderEntity != null) {
					// 发送邮件
					MailUtil.sendMail("大学城行业检测预约使用申请",
							"您好：你申请的行业检测预约使用申请已提交完成；预约号为:【"
									+ applyOrderEntity.getOrdrNum()
									+ "】，请注意审核结果！！", applyOrderEntity.getUser()
									.getEmail(), true);
				}
			}
			return cloudContext.getSuccessIngoreWarn() ? SUCCESSINDUSTERYTEST
					: INDUSTERYTEST_APPLYERROR;
		}

	}

	/**
	 * 个人中心查询 仪器设备订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryEquipmentOrderByUser() throws Exception {
		applyOrderService.queryEquipmentOrderByUser(cloudContext);
		return JSON;
	}

	/**
	 * 个人中心查询 行业检测订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryIndustryOrderByUser() throws Exception {
		applyOrderService.queryIndustryTestOrderByUser(cloudContext);
		return JSON;
	}

	/**
	 * 关闭订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveCloseApplyOrder() throws Exception {
		applyOrderService.updateCloseApplyOrder(cloudContext);
		return JSON;

	}

	public String showEquipmentOrderDetail() throws Exception {
		applyOrderService.showEquipmentOrderDetail(cloudContext);
		return APPLYDETAIL;
	}

	/**
	 * 查询仪器设备预约时间是否空闲
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findDayOrderByEquipment() throws Exception {
		applyOrderService.findDayOrderByEquipment(cloudContext);

		return JSON;
	}

	/**
	 * 查询行业检测预约时间是否空闲
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findDayOrderByIndustryTest() throws Exception {
		applyOrderService.findDayOrderByIndustryTest(cloudContext);

		return JSON;
	}

	/**
	 * 用户检测报告下载
	 */
	public String download() throws SQLException, IOException {
		String url = PropertyManager.getInstance().getXMLProperty(
				PropertyManager.XML_OPENLAB_COREMANAGER_HOST)
				+ "/applyOrderManager/applyOrder!downloadReport.action?cloudContext.vo.id="
				+ cloudContext.getVo().getId();
		ApplyOrderEntity apply = applyOrderDAO
				.get(cloudContext.getVo().getId());
		try {
			URLConnection conn = new URL(url).openConnection();
			InputStream is = conn.getInputStream();
			cloudContext.addParam("file", is);
			cloudContext.addParam("filename", apply.getUrl());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return DOWNLOAD;
	}

}
