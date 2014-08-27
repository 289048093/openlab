package com.cloudking.openlab.service.industrytest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.dao.IndustryTestCatDAO;
import com.cloudking.openlab.dao.IndustryTestDAO;
import com.cloudking.openlab.entity.IndustryTestCatEntity;
import com.cloudking.openlab.entity.IndustryTestEntity;
import com.cloudking.openlab.vo.IndustryTestCatVO;
import com.cloudking.openlab.vo.IndustryTestVO;

@Service("industryTestService")
public class IndustryTestService extends BaseService {
	@Resource
	private IndustryTestDAO industryTestDAO;
	// 领域DAO
	@Resource
	private IndustryTestCatDAO industryTestCatDAO;

	/**
	 * 查询所有的行业检测信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<IndustryTestVO> query(CloudContext<IndustryTestVO> cloudContext)
			throws SQLException {

		String name = cloudContext.getVo().getName();
		Long catId = cloudContext.getVo().getIndustryTestcatId();
		List<Object[]> industryTests = industryTestDAO.query(name, catId,
				cloudContext.getPageInfo());
		List<IndustryTestVO> industryTestvos = new ArrayList<IndustryTestVO>();
		IndustryTestVO industryTestVO = null;
		for (Object[] ob : industryTests) {
			industryTestVO = new IndustryTestVO();

			if (ob[0] != null) {
				BeanUtils.copyProperties((IndustryTestEntity) ob[0],
						industryTestVO);
			}
			IndustryTestCatEntity testCatEntity = (IndustryTestCatEntity) ob[1];
			if (testCatEntity != null) {
				industryTestVO.setIndustryTestcatId(testCatEntity.getId());
				industryTestVO.setIndustryTestCatName(testCatEntity.getName());
			}
			industryTestvos.add(industryTestVO);
		}
		return industryTestvos;
	}

	/**
	 * 行业检测申请预约详细信息
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	@SuppressWarnings("null")
	public void queryById(CloudContext<IndustryTestVO> cloudContext)
			throws SQLException {

		IndustryTestEntity industryTestEntity = industryTestDAO
				.queryById(cloudContext);

		if (industryTestEntity == null) {
			cloudContext.addErrorMsg("行业检测信息不存在，请刷新后重试！");
			return;
		}
		// //预约时间
		// List<IndustryTestTimequantumEntity> list=
		// industryTestTimequantumDAO.queryByIndustryTestId(industryTestEntity.getId());
		// List<IndustryTestTimequantumVO> industryTestTimequantumVOs=new
		// ArrayList<IndustryTestTimequantumVO>();
		// IndustryTestTimequantumVO industryTestTimequantumVO=null;
		// for (IndustryTestTimequantumEntity t : list) {
		// if(t.getStatus().equals(Constant.TIMEQUANTUM_STATUS_YES)){
		// industryTestTimequantumVO=new IndustryTestTimequantumVO();
		// BeanUtils.copyProperties(t, industryTestTimequantumVO);
		// industryTestTimequantumVOs.add(industryTestTimequantumVO);
		// }
		// }

		// cloudContext.getVo().setTimeCount(list.size()); //是否可以预约申请
		// 内容

		cloudContext.getVo().setIndustryTestCatName(
				industryTestEntity.getIndustryTestcat().getName()); // 分类名称
		// 分类Id
		cloudContext.getVo().setIndustryTestcatId(
				industryTestEntity.getIndustryTestcat().getId());
		// cloudContext.getVo().setIndustryTestTimequantumVOs(industryTestTimequantumVOs);
		// //预约时间段
		BeanUtils.copyProperties(industryTestEntity, cloudContext.getVo());// 把entity中的值赋给vo

		// 得到所有公开领域
		List<IndustryTestCatEntity> areaEntitys = industryTestCatDAO
				.listPubliced();
		List<IndustryTestCatVO> areaVOs = new ArrayList<IndustryTestCatVO>();
		IndustryTestCatVO areaVO = null;
		if (areaEntitys != null) {
			for (IndustryTestCatEntity e : areaEntitys) {
				areaVO = new IndustryTestCatVO();
				BeanUtils.copyProperties(e, areaVO);
				areaVOs.add(areaVO);
			}
		}
		cloudContext.addParam("area", areaVOs);
	}
}
