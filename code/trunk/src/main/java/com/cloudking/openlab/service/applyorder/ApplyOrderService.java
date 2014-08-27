package com.cloudking.openlab.service.applyorder;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.LoginedUser;
import com.cloudking.openlab.dao.ApplyOrderDAO;
import com.cloudking.openlab.dao.EquipmentDAO;
import com.cloudking.openlab.dao.IndustryTestDAO;
import com.cloudking.openlab.dao.TestScheduleDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.ApplyOrderEntity;
import com.cloudking.openlab.entity.EquipmentEntity;
import com.cloudking.openlab.entity.IndustryTestEntity;
import com.cloudking.openlab.entity.TestScheduleEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.DateUtil;
import com.cloudking.openlab.vo.ApplyOrderVO;
import com.cloudking.openlab.vo.EquipmentVO;
import com.cloudking.openlab.vo.IndustryTestVO;

@Service("applyOrderService")
public class ApplyOrderService extends BaseService {
	@Resource
	private ApplyOrderDAO applyOrderDAO;
	@Resource
	private IndustryTestDAO industryTestDAO;
	@Resource
	private UserDAO userDAO;
	@Resource
	private EquipmentDAO equipmentDAO;

	@Resource
	private TestScheduleDAO testScheduleDAO;

	private static long code;

	/**
	 * 根据行业检测编号获取行业检测信息
	 * 
	 * @param cloudContext
	 * @return
	 * @throws SQLException
	 */
	public IndustryTestEntity queryindustryTestById(
			CloudContext<ApplyOrderVO> cloudContext) throws SQLException {
		return industryTestDAO.get(cloudContext.getVo().getIndustryTestId());
	}

	/**
	 * 查询仪器设备记录
	 * 
	 * @param cloudContext
	 * @return
	 * @throws SQLException
	 */

	public EquipmentEntity queryEquipmentById(
			CloudContext<ApplyOrderVO> cloudContext) throws SQLException {
		return equipmentDAO.get(cloudContext.getVo().getEquipmentId());

	}

	/**
	 * 查询登录人仪器设备订单
	 * 
	 * @throws Exception
	 */
	public void queryEquipmentOrderByUser(
			CloudContext<ApplyOrderVO> cloudContext) throws Exception {
		LoginedUser loginedUser = (LoginedUser) ServletActionContext
				.getRequest().getSession().getAttribute(Constant.LOGINED_USER);
		if (loginedUser == null) {
			cloudContext.addErrorMsg("您还未登录，请先登录");
			return;
		}

		cloudContext.getVo().setUserId(loginedUser.getId());
		Collection<Object[]> applyOrderEntities = applyOrderDAO
				.query(cloudContext);
		List<ApplyOrderVO> orderVOs = copyApplyOrderVo(applyOrderEntities);
		cloudContext.addParam("equipmentOrders", orderVOs);

	}
	
	/**
	 * 
	 * @param cloudContext
	 * @throws Exception
	 */
	public void  findDayOrderByEquipment(CloudContext<ApplyOrderVO> cloudContext) throws Exception{
		Date startDate=null;
		Date endDate=null;
		if(!cloudContext.getVo().getDesc().equals("")){
	
			startDate=DateUtil.parseDateTime(cloudContext.getVo().getDesc()+" 00:00:00");
			endDate=DateUtil.parseDateTime(cloudContext.getVo().getDesc()+" 23:59:59");
		}else{
			startDate=DateUtil.parseDateTime(cloudContext.getVo().getSubBeginDateStr());
			endDate=DateUtil.parseDateTime(cloudContext.getVo().getSubEndDateStr());
			
		}
		cloudContext.addParam("orders", copyApplyOrderVo(applyOrderDAO.findDayOrderByEquipment(cloudContext.getVo().getEquipmentId(), startDate, endDate)));
	
		
		
	}
	public void  findDayOrderByIndustryTest(CloudContext<ApplyOrderVO> cloudContext) throws Exception{
		Date startDate=null;
		Date endDate=null;
		if(!cloudContext.getVo().getDesc().equals("")){
	
			startDate=DateUtil.parseDateTime(cloudContext.getVo().getDesc()+" 00:00:00");
			endDate=DateUtil.parseDateTime(cloudContext.getVo().getDesc()+" 23:59:59");
		}else{
			startDate=DateUtil.parseDateTime(cloudContext.getVo().getSubBeginDateStr());
			endDate=DateUtil.parseDateTime(cloudContext.getVo().getSubEndDateStr());
			
		}
		cloudContext.addParam("orders", copyApplyVoByIndustryTest(applyOrderDAO.findDayOrderByIndustryTest(cloudContext.getVo().getIndustryTestId(), startDate, endDate)));
	
		
		
	}
		

	private List<ApplyOrderVO> copyApplyOrderVo(
			Collection<Object[]> applyOrderEntities) {
		List<ApplyOrderVO> orderVOs = new ArrayList<ApplyOrderVO>();
		ApplyOrderVO orderVO = null;
		for (Object[] o : applyOrderEntities) {
			orderVO = new ApplyOrderVO();
			orderVO.setOrdrNum((String) o[0]); // 订单号
			orderVO
					.setPic("equipmentManager/equipment!showPic.action?cloudContext.params.pic="
							+ o[1] + ""); // 图片
			orderVO.setEquipmentName((String) o[2]);
			orderVO.setModel((String) o[3]);
			orderVO.setRent((Double) o[4]);
			orderVO.setApplyDate((Date) o[5]);
			orderVO.setStatus((String) o[6]);
			orderVO.setDesc((String) o[7]);
			orderVO.setSubBeginDate((Date) o[8]);
			orderVO.setSubEndDate((Date) o[9]);
			orderVO.setId((Long) o[10]);
			orderVO.setContact((String) o[11]);
			orderVO.setPhone((String) o[12]);
			orderVO.setSysDesc((String) o[13]);
			orderVOs.add(orderVO);
		}
		return orderVOs;
	}

	/**
	 * 查询登录人行业检测订单
	 * 
	 * @throws Exception
	 */
	public void queryIndustryTestOrderByUser(
			CloudContext<ApplyOrderVO> cloudContext) throws Exception {

		LoginedUser loginedUser = (LoginedUser) ServletActionContext
				.getRequest().getSession().getAttribute(Constant.LOGINED_USER);
		if (loginedUser == null) {
			cloudContext.addErrorMsg("您还未登录，请先登录");
			return;
		}
		cloudContext.getVo().setUserId(loginedUser.getId());
		Collection<Object[]> applyOrderEntities=  applyOrderDAO.queryIndustryTest(cloudContext);
		List<ApplyOrderVO> orderVOs = copyApplyVoByIndustryTest(applyOrderEntities);
		cloudContext.addParam("industryTestOrders", orderVOs);
		
	}
	private List<ApplyOrderVO> copyApplyVoByIndustryTest(
			Collection<Object[]> applyOrderEntities) {
	

		List<ApplyOrderVO> orderVOs = new ArrayList<ApplyOrderVO>();
		ApplyOrderVO orderVO = null;
		for (Object[] o : applyOrderEntities) {
			orderVO = new ApplyOrderVO();
			orderVO.setOrdrNum((String) o[0]); // 订单号
			orderVO.setIndustryTestName((String) o[1]);
			orderVO.setRent((Double) o[2]);
			orderVO.setApplyDate((Date) o[3]);
			orderVO.setStatus((String) o[4]);
			orderVO.setDesc((String) o[5]);
			orderVO.setSubBeginDate((Date) o[6]);
			orderVO.setSubEndDate((Date) o[7]);
			orderVO.setId((Long) o[8]);
			orderVO.setPrincipal((String) o[9]);
			orderVO.setPhone((String) o[10]);
			orderVO.setSysDesc((String) o[11]);
			orderVO.setUrl((String) o[12]);
			orderVOs.add(orderVO);
		}
		return orderVOs;

	}

	/**
	 * 添加ApplyOrder记录
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 * @throws SQLException
	 */
	public void add(CloudContext<ApplyOrderVO> cloudContext)
			throws SQLException {

		ApplyOrderEntity applyOrderEntity = new ApplyOrderEntity();
		applyOrderEntity.setApplyDate(new Date()); // 申请时间
		// 行业检测
		IndustryTestEntity it = queryindustryTestById(cloudContext);
		applyOrderEntity.setIndustryTest(it); // 行业检测
		if(it!=null){
		// 领域
		String area = cloudContext.getVo().getArea().replace(",", "");
		/**
		 * 判断一下 领域是否为空 为空的话 用原来的 不为空的话 用客户选择的
		 */
		if (area == null || "".equals(area)) {
			// 得到原来的领域
			String baseArea = it.getIndustryTestcat().getName();
			applyOrderEntity.setArea(baseArea);
		} else {
			applyOrderEntity.setArea(area);
		}
		}
		applyOrderEntity.setEquipment(queryEquipmentById(cloudContext)); // 仪器设备
		applyOrderEntity.setRent(cloudContext.getVo().getRent()); // 价格
		String orderId = nextCode();
		applyOrderEntity.setOrdrNum(orderId);
		LoginedUser loginedUser = (LoginedUser) ServletActionContext
				.getRequest().getSession().getAttribute(Constant.LOGINED_USER);
		if (loginedUser != null) {
			UserEntity user = userDAO.get(loginedUser.getId());
			if (user != null) {
				applyOrderEntity.setUser(user);// 用户
			} else {
				cloudContext.addErrorMsg("你还未登录或会话超时，请重新登录");
				return;
			}
		}
		applyOrderEntity.setAdjust(cloudContext.getVo().getAdjust()); // 是否接受管理员调整
		applyOrderEntity.setStatus(Constant.Order_NOAUDIT_STATUS); // 状态 //未审核
		applyOrderEntity.setDesc(cloudContext.getVo().getDesc()); // 描述
		applyOrderEntity.setAppointedDate(cloudContext.getVo()
				.getAppointedDate()); // 预约时间
		applyOrderEntity
				.setSubBeginDate(cloudContext.getVo().getSubBeginDate()); // 使用开始时间
		applyOrderEntity.setType(Constant.ORDER_TYPE_USER); // 订单类型 用户
		applyOrderEntity.setSubEndDate(cloudContext.getVo().getSubEndDate()); // 使用结束时间
		applyOrderDAO.insert(applyOrderEntity);
		ApplyOrderVO vo = new ApplyOrderVO();
		EquipmentVO equipmentVO = new EquipmentVO();
		if (queryEquipmentById(cloudContext) != null) {
			BeanUtils.copyProperties(queryEquipmentById(cloudContext),
					equipmentVO); // 仪器信息
			vo.setEquipmentVO(equipmentVO);
		}
		if (queryindustryTestById(cloudContext) != null) {
			IndustryTestVO industryTestVO = new IndustryTestVO();
			BeanUtils.copyProperties(queryindustryTestById(cloudContext),
					industryTestVO); // 行业检测信息
			vo.setIndustryTestVO(industryTestVO);
		}
		// 返回订单信息
		BeanUtils.copyProperties(applyOrderDAO.get(applyOrderEntity.getId()),
				vo);
		// 如果是行业检测预约
		if (queryindustryTestById(cloudContext) != null) {
			IndustryTestEntity industryTestEntity = queryindustryTestById(cloudContext);
			// 添加行业检测进度信息
			TestScheduleEntity scheduleEntity = new TestScheduleEntity();
			scheduleEntity.setEmail(industryTestEntity.getEmail());// email
			scheduleEntity.setPhone(industryTestEntity.getPhone());// 电话
			scheduleEntity.setPrincipal(industryTestEntity.getPrincipal());// 责任人
			scheduleEntity.setResponsibleDept(industryTestEntity
					.getUndertakeUnit());// 单位
			scheduleEntity.setApplyOrderEntity(applyOrderDAO
					.get(applyOrderEntity.getId()));// 订单
			testScheduleDAO.insert(scheduleEntity);
		}

		cloudContext.setVo(vo);
	}

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static synchronized String nextCode() {
		code++;
		String str = new SimpleDateFormat("yyMMddhhmmss")
				.format(new java.util.Date());
		long m = Long.parseLong(str) * 10000;
		m += code;
		return Constant.ORDER_PREFIX + m;
	}

	public void updateCloseApplyOrder(CloudContext<ApplyOrderVO> cloudContext)
			throws SQLException {
		ApplyOrderEntity applyOrderEntity = applyOrderDAO.get(cloudContext
				.getVo().getId());
		if (applyOrderEntity != null) {
			applyOrderEntity.setStatus(Constant.Order_STATUS_CLOSE);
			applyOrderEntity.setDesc(cloudContext.getVo().getDesc());
			applyOrderDAO.update(applyOrderEntity);

		} else {
			cloudContext.addErrorMsg("订单已不存在");
		}

	}

	/**
	 * 根据编号查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ApplyOrderEntity queryById(Long id) throws SQLException {
		return applyOrderDAO.get(id);

	}

	public void showEquipmentOrderDetail(CloudContext<ApplyOrderVO> cloudContext)
			throws Exception {
		Collection<Object[]> applyOrderEntities = applyOrderDAO
				.query(cloudContext);
		List<ApplyOrderVO> orderVOs = copyApplyOrderVo(applyOrderEntities);
		if (orderVOs.size() > 0) {
			cloudContext.setVo(orderVOs.get(0));
		}
	}
}
