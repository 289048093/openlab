package com.cloudking.openlab.service.policy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.DeptDAO;
import com.cloudking.openlab.dao.PolicyCatDAO;
import com.cloudking.openlab.dao.PolicyDAO;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.entity.PolicyCatEntity;
import com.cloudking.openlab.entity.PolicyEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.PolicyCatVO;
import com.cloudking.openlab.vo.PolicyVO;

/**
 * 政策法规service
 * 
 * @author cloudKing
 * 
 */
@Service("policyService")
public class PolicyService extends BaseService {
	@Resource
	private PolicyDAO policyDAO;

	@Resource
	private PolicyCatDAO policyCatDAO;
	@Resource
	private DeptDAO deptDAO;

	/**
	 * 通过id来查询
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void queryById(CloudContext<PolicyVO> cloudContext)
			throws SQLException {
		PolicyEntity policyEntity = policyDAO.get(cloudContext.getVo().getId());
		if (policyEntity == null) {
			cloudContext.addErrorMsg("政策法规不存在，请刷新后重试！");
			return;
		}
		//供稿单位
		String provider=policyEntity.getProviderName();
		DeptEntity dept = null;
		if (!StringUtil.isBlank(provider)) {
			if (provider.matches("\\d+")) {
				Long providerId = Long.parseLong(provider);
				dept = deptDAO.get(providerId);
				policyEntity.setProviderName(dept.getName());
			}
		}
		EntityManager em = ProjectUtil.getEntityManager();
		em.getTransaction().begin();
		Integer count = policyEntity.getCount();
		count = count == null ? 0 : count;
		policyEntity.setCount(++count);
		em.merge(policyEntity);
		em.getTransaction().commit();
		em.close();

		BeanUtils.copyProperties(policyEntity, cloudContext.getVo());// 把entity中的值赋给vo
	}

	/**
	 * 查询
	 * 
	 * @param cloudContext
	 * @throws SQLException
	 */
	public void query(CloudContext<PolicyVO> cloudContext) throws SQLException {
		List<PolicyEntity> policyEntitys = null;
		List<PolicyCatEntity> policyCatEntitys = null;
		// 置顶
		List<PolicyVO> policyVOs = new ArrayList<PolicyVO>();
		// 不置顶
		List<PolicyVO> unpolicyVOs = new ArrayList<PolicyVO>();
		List<PolicyCatVO> policyCatVOs = new ArrayList<PolicyCatVO>();
		PolicyVO policyVO = null;
		PolicyCatVO policyCatVO = null;
		// 查询政策法规
		policyEntitys = policyDAO.query(cloudContext.getVo().getTitle(),
				cloudContext.getLongParam("catId"), cloudContext.getPageInfo());
		if (policyEntitys != null) {
			for (PolicyEntity e : policyEntitys) {
				policyVO = new PolicyVO();
				
				if (e.getTop().equals(Constant.TOP)) {
					BeanUtils.copyProperties(e, policyVO);
					policyVOs.add(policyVO);
				} else {
					BeanUtils.copyProperties(e, policyVO);
					unpolicyVOs.add(policyVO);
				}
			}
		}
		// 查询政策法规所有分类
		policyCatEntitys = policyCatDAO.listPubliced();
		if (policyCatEntitys != null) {
			for (PolicyCatEntity e : policyCatEntitys) {
				policyCatVO = new PolicyCatVO();
				BeanUtils.copyProperties(e, policyCatVO);
				policyCatVOs.add(policyCatVO);
			}
		}
		cloudContext.addParam("topPolicyVOs", policyVOs);
		cloudContext.addParam("untopPolicyVOs", unpolicyVOs);
		cloudContext.addParam("policyCatVOs", policyCatVOs);
	}
}
