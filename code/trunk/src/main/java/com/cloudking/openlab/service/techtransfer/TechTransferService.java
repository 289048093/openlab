package com.cloudking.openlab.service.techtransfer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.TechTransferDAO;
import com.cloudking.openlab.entity.TechTransferEntity;
import com.cloudking.openlab.service.techtransfercat.TechTransferCatService;
import com.cloudking.openlab.vo.TechTransferCatVO;
import com.cloudking.openlab.vo.techTransferAndResearchAchieveVO;

@Service("techTransferService")
public class TechTransferService extends BaseService {
    @SuppressWarnings("unused")
    @Resource
    private TechTransferDAO techTransferDAO;

    @Resource
    private TechTransferCatService techTransferCatService;

    /**
     * 查询所有的技术转移
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void query(CloudContext<techTransferAndResearchAchieveVO> cloudContext) throws SQLException {
        List<TechTransferEntity> techTransferEntities = null;
        List<TechTransferCatVO> techTransferCatVOs = null;
        techTransferAndResearchAchieveVO techTransferVO = null;
        // 查处所有的技术转移
        techTransferEntities = techTransferDAO.query(cloudContext.getLongParam("catId"), cloudContext.getPageInfo());
        // 查询出所有的分类
        techTransferCatVOs = techTransferCatService.queryAll();
        List<techTransferAndResearchAchieveVO> transferVOs = new ArrayList<techTransferAndResearchAchieveVO>();
        if (techTransferEntities != null) {
            for (TechTransferEntity te : techTransferEntities) {

                techTransferVO = new techTransferAndResearchAchieveVO();
                techTransferVO.setUserName(te.getUser().getRealname());
                BeanUtils.copyProperties(te, techTransferVO);
                transferVOs.add(techTransferVO);
            }
        }
        cloudContext.addParam("transferVOs", transferVOs);
        cloudContext.addParam("techTransferCatVOs", techTransferCatVOs);

    }

    /**
     * 通过ID查询科研成果的详情
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void queryById(CloudContext<techTransferAndResearchAchieveVO> cloudContext) throws SQLException {
        TechTransferEntity achieveEntity = techTransferDAO.get(cloudContext.getVo().getId());
        if (achieveEntity == null) {
            cloudContext.addErrorMsg("技术转移已不存在");
            return;
        }
        cloudContext.getVo().setUserName(achieveEntity.getUser().getRealname());
        BeanUtils.copyProperties(achieveEntity, cloudContext.getVo());
    }

}