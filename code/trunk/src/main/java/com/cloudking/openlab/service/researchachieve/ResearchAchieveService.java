package com.cloudking.openlab.service.researchachieve;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.DeptDAO;
import com.cloudking.openlab.dao.ResearchAchieveDAO;
import com.cloudking.openlab.entity.DeptEntity;
import com.cloudking.openlab.entity.ResearchAchieveEntity;
import com.cloudking.openlab.service.researchlevel.ResearchLevelService;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.ResearchLevelVO;
import com.cloudking.openlab.vo.techTransferAndResearchAchieveVO;

@Service("researchAchieveService")
public class ResearchAchieveService extends BaseService {
    @Resource
    private ResearchAchieveDAO researchAchieveDAO;

    @Resource
    private ResearchLevelService researchLevelService;
    @Resource
    private DeptDAO deptDAO;

    /**
     * 查询所有的科研成果
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void query(CloudContext<techTransferAndResearchAchieveVO> cloudContext) throws SQLException {
        List<ResearchAchieveEntity> achieveEntities = null;
        List<ResearchLevelVO> researchLevelVOs = null;
        techTransferAndResearchAchieveVO achieveVO = null;
        // 查询出所有的级别
        researchLevelVOs = researchLevelService.queryAll();
        // 查处所有的实验室
        achieveEntities = researchAchieveDAO.query(cloudContext.getLongParam("levelId"), cloudContext.getPageInfo());
        List<techTransferAndResearchAchieveVO> achieveVOs = new ArrayList<techTransferAndResearchAchieveVO>();
        if (achieveEntities != null) {
            for (ResearchAchieveEntity re : achieveEntities) {
                achieveVO = new techTransferAndResearchAchieveVO();
//				achieveVO.setUserName(re.getUser().getRealname());
                BeanUtils.copyProperties(re, achieveVO);
                achieveVOs.add(achieveVO);

            }
        }
        cloudContext.addParam("achieveVOs", achieveVOs);
        cloudContext.addParam("researchLevelVOs", researchLevelVOs);

    }

    /**
     * 通过ID查询科研成果的详情
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void queryById(CloudContext<techTransferAndResearchAchieveVO> cloudContext) throws SQLException {
        ResearchAchieveEntity achieveEntity = researchAchieveDAO.get(cloudContext.getVo().getId());
        if (achieveEntity == null) {
            cloudContext.addErrorMsg("科研成果已不存在");
            return;
        }
        //供稿单位
        String provider = achieveEntity.getProviderName();
        DeptEntity dept = null;
        if (!StringUtil.isBlank(provider)) {
            if (provider.matches("\\d+")) {
                Long providerId = Long.parseLong(provider);
                dept = deptDAO.get(providerId);
                achieveEntity.setProviderName(dept.getName());
            }
        }
//		cloudContext.getVo().setUserName(achieveEntity.getUser().getRealname());
        BeanUtils.copyProperties(achieveEntity, cloudContext.getVo());
    }

}