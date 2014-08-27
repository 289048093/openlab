package com.cloudking.openlab.service.index;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.LoginedUser;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.ApplyOrderDAO;
import com.cloudking.openlab.dao.CommonTechPlatformDAO;
import com.cloudking.openlab.dao.EquipmentCatDAO;
import com.cloudking.openlab.dao.EquipmentDAO;
import com.cloudking.openlab.dao.EquipmentUsedLogDAO;
import com.cloudking.openlab.dao.ExpertDAO;
import com.cloudking.openlab.dao.ExpertQuestionDAO;
import com.cloudking.openlab.dao.NewsDAO;
import com.cloudking.openlab.dao.PointLabDAO;
import com.cloudking.openlab.dao.PolicyDAO;
import com.cloudking.openlab.dao.ResearchAchieveDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.ApplyOrderEntity;
import com.cloudking.openlab.entity.EquipmentCatEntity;
import com.cloudking.openlab.entity.EquipmentEntity;
import com.cloudking.openlab.entity.ExpertEntity;
import com.cloudking.openlab.entity.NewsEntity;
import com.cloudking.openlab.entity.PolicyEntity;
import com.cloudking.openlab.entity.ResearchAchieveEntity;
import com.cloudking.openlab.vo.ApplyOrderVO;
import com.cloudking.openlab.vo.EquipmentCatVO;
import com.cloudking.openlab.vo.EquipmentLogVO;
import com.cloudking.openlab.vo.EquipmentVO;
import com.cloudking.openlab.vo.ExpertVO;
import com.cloudking.openlab.vo.IndexVO;
import com.cloudking.openlab.vo.KeyMappingValue;
import com.cloudking.openlab.vo.NewsVO;
import com.cloudking.openlab.vo.PolicyVO;
import com.cloudking.openlab.vo.ResearchAchieveVO;

/**
 * 前台首页取值的service
 * 
 * @author Administrator
 * 
 */
// PropertyManager.getInstance().getDbProperty(Pro)系统属性类，取值的方法
@Service("indexService")
public class IndexService extends BaseService {
    // 导入新闻dao
    @Resource
    private NewsDAO newsDao;
    // 导入政策法规的dao
    @Resource
    private PolicyDAO policyDAO;

    /*
     * 4:统计信息，导入对应的dao
     */
    // 设备
    @Resource
    private EquipmentDAO equipmentDAO;
    //用户
    @Resource
    private UserDAO userDAO;
    //使用记录
    @Resource
    private EquipmentUsedLogDAO equipmentUsedLogDAO;
    @Resource
    private ExpertQuestionDAO expertQuestionDAO;
    @Resource
    private CommonTechPlatformDAO commonTechPlatformDAO;
    /*
     * 5:设备的类别
     */
    @Resource
    private EquipmentCatDAO equipmentCatDAO;
    // 实验室
    @Resource
    private PointLabDAO pointDAO;

    /*
     * 6:指南，具体是新建一张表，新建一个页面来展示，还是死页面。不知道。。。
     * 指南果断不要了。嘎嘎
     */

    /*
     * 7：取出最新录入的设备的信息（我觉得在后台指定最好）取出一条详细的，包括图片 复用4的。
     */

    /*
     * 8:科研成果
     */
    @Resource
    private ResearchAchieveDAO researchAchieveDAO;
    @Resource
    private ApplyOrderDAO applyOrderDAO;
    /*
     * 9：出去一条在后台设置好的专家的信息。详细信息显示。
     */
    @Resource
    private ExpertDAO expertDAO;

    public IndexVO indexAllContent(CloudContext<IndexVO> cloudContext) throws SQLException {
        /**
         * 定义变量
         */

        IndexVO indexVO = new IndexVO();
        // 仪器订单
        List<ApplyOrderVO> applyOrderVOList = null;
        ApplyOrderVO applyOrderVO = null;
        // 行业检测
        List<ApplyOrderVO> applyOrderVOIndustryTest = null;
        ApplyOrderVO applyOrderVOIndustry = null;
        // 2部分需要的变量
        List<NewsVO> newsVolist = null;
        List<NewsVO> newsNoticeVolist = null;
        NewsVO newsVO = null;
        List<PolicyVO> policyVolist = null;
        PolicyVO policyVO = null;
        // 4部分的变量
        List<String> statList = null;
        int statCount = 0;
        String statStr = null;
        // 第五部分
        List<EquipmentCatVO> equipmentCatVOList = null;
        EquipmentCatVO equipmentCatVOTmp = null;
        // 7部分变量
        EquipmentVO equipmentVO = null;
        List<EquipmentVO> equipmentVOlist = null;
        // 第8部分
        List<ResearchAchieveVO> researchAchieveVOlist = null;
        ResearchAchieveVO researchAchieveVOTmp = null;
        // 9部分变量
        List<ExpertVO> expertsList = null;
        ExpertVO expertVO = null;
        List<KeyMappingValue> kvlist = null;
        KeyMappingValue kvTmp = null;
        /*
         *获取当前登录用户 
         */
        LoginedUser loginUser = cloudContext.getLoginedUser();
        /**
         * 取值
         */
        //获取，用户有多少未处理问答
        if (loginUser != null) {
            int loginUserExpert = expertQuestionDAO.LoginUserQuestions(loginUser.getId());
            cloudContext.addParam("loginUserExperts", loginUserExpert);
        }
        // 获取用户申请的仪器数
        String queryHql = "select applyOrderEntity from  ApplyOrderEntity as applyOrderEntity  inner join  applyOrderEntity.equipment as eq inner join  applyOrderEntity.user as user where user.id=:user";
        if (loginUser != null) {
            List<ApplyOrderEntity> applyOrderEntity = applyOrderDAO.list(queryHql, "user", loginUser.getId());
            if (applyOrderEntity != null) {
                applyOrderVOList = new ArrayList<ApplyOrderVO>();
                for (ApplyOrderEntity a : applyOrderEntity) {
                    applyOrderVO = new ApplyOrderVO();
                    BeanUtils.copyProperties(a, applyOrderVO);
                    applyOrderVOList.add(applyOrderVO);
                }
            }
            indexVO.setApplyOrderVO(applyOrderVOList);
        }
        //获取关于登录用户的未处理问答
        //判断登录用户是不是专家
        if (loginUser != null) {

        }
        // 获取用户行业检测

        String queryHql2 = "select applyOrderEntity from  ApplyOrderEntity as applyOrderEntity inner join applyOrderEntity.industryTest as test inner join applyOrderEntity.user as user where user.id=:user";
        if (loginUser != null) {
            List<ApplyOrderEntity> applyOrderEntity = applyOrderDAO.list(queryHql2, "user", loginUser.getId());
            if (applyOrderEntity != null) {
                applyOrderVOIndustryTest = new ArrayList<ApplyOrderVO>();
                for (ApplyOrderEntity a : applyOrderEntity) {
                    applyOrderVOIndustry = new ApplyOrderVO();
                    BeanUtils.copyProperties(a, applyOrderVOIndustry);
                    applyOrderVOIndustryTest.add(applyOrderVO);
                }
            }
            indexVO.setApplyOrderVOIndustryTest(applyOrderVOIndustryTest);
        }

        // 新闻 inner join news_.newsCat cat where cat.publiced=1 and
        String hql = "select news_ from NewsEntity news_  where news_.newsCat.publiced=1 and news_.newsCat.id<>1 and news_.publiced=1 order by news_.modifyDate desc";
        List<NewsEntity> newsEntity = newsDao.pageQuery(hql, 0, 6);
        if (newsEntity != null) {
            newsVolist = new ArrayList<NewsVO>();
            for (NewsEntity newsEntity2 : newsEntity) {
                newsVO = new NewsVO();
                BeanUtils.copyProperties(newsEntity2, newsVO);
                newsVolist.add(newsVO);
            }
        }
        indexVO.setNewsList(newsVolist);
        // 通知公告
        String hql2 = "select news_ from NewsEntity news_ where news_.newsCat.publiced=1 and news_.newsCat.id=1 and news_.publiced=1 order by news_.modifyDate desc";
        List<NewsEntity> newsEntitys = newsDao.pageQuery(hql2, 0, 6);
        if (newsEntitys != null) {
            newsNoticeVolist = new ArrayList<NewsVO>();
            for (NewsEntity e : newsEntitys) {
                newsVO = new NewsVO();
                BeanUtils.copyProperties(e, newsVO);
                newsNoticeVolist.add(newsVO);
            }
        }
        indexVO.setNewsNoticeList(newsNoticeVolist);
        // 政策法规
        String hql3 = "select policy_ from PolicyEntity policy_ where policy_.policyCat.publiced=1 and  policy_.publiced=1 order by policy_.modifyDate desc";
        List<PolicyEntity> policyEntity = policyDAO.pageQuery(hql3, 0, 6);
        if (policyEntity != null && policyEntity.size() > 0) {
            policyVolist = new ArrayList<PolicyVO>();
            for (PolicyEntity policyEntity2 : policyEntity) {
                policyVO = new PolicyVO();
                BeanUtils.copyProperties(policyEntity2, policyVO);
                policyVolist.add(policyVO);
            }
            indexVO.setPolicyList(policyVolist);
        }
        // 4部分取值
        if (true) {
            statList = new ArrayList<String>();
        }
        statCount = equipmentDAO.count();
        statStr = "当前系统一共录入设备" + statCount + "件";
        statList.add(statStr);
        statCount = pointDAO.count();
        statStr = "当前系统共录入实验室" + statCount + "间";
        statList.add(statStr);
        statCount = commonTechPlatformDAO.count();
        statStr = "当前系统共录入技术平台" + statCount + "个";
        statList.add(statStr);
        statCount = userDAO.count();
        statStr = "当前系统共有用户" + statCount + "名";
        statList.add(statStr);
        statCount = equipmentUsedLogDAO.count();
        statStr = "当前系统共为用户提供" + statCount + "次服务";
        statList.add(statStr);
        indexVO.setEquipmentStatList(statList);

        // 第五部分
        List<EquipmentCatEntity> emcelsit = equipmentCatDAO.list();
        if (emcelsit != null) {
            equipmentCatVOList = new ArrayList<EquipmentCatVO>();
            for (EquipmentCatEntity equipmentCatEntity : emcelsit) {
                equipmentCatVOTmp = new EquipmentCatVO();
                BeanUtils.copyProperties(equipmentCatEntity, equipmentCatVOTmp);
                equipmentCatVOList.add(equipmentCatVOTmp);
            }
        }
        indexVO.setEquipmentCatList(equipmentCatVOList);
        //第六部分 一起服务排名
        List<Object[]> equl = equipmentUsedLogDAO.hqIndexContent();
        if (equl != null) {
            kvlist = new ArrayList<KeyMappingValue>();
            for (Object[] objects : equl) {
                kvTmp = new KeyMappingValue();
                kvTmp.setKey(objects[1].toString());
                kvTmp.setValue(objects[0].toString());
                kvlist.add(kvTmp);
            }
            cloudContext.addParam("fwph", kvlist);
        }
        // 7部分取值
        EquipmentEntity equipmentEntity = equipmentDAO.getZheNewEquipment();
        if (equipmentEntity != null) {
            equipmentVO = new EquipmentVO();
            BeanUtils.copyProperties(equipmentEntity, equipmentVO);
            equipmentVO.setPic("equipmentManager/equipment!showPic.action?cloudContext.params.pic="
                            + equipmentEntity.getPic());
        }
        indexVO.setEquipmentVO(equipmentVO);
        List<EquipmentEntity> equipmentEntityList = equipmentDAO.pageQuery(
                        "select e_ from EquipmentEntity e_ order by e_.addTime desc", 1, 4);
        if (equipmentEntityList != null && equipmentEntityList.size() > 0) {
            equipmentVOlist = new ArrayList<EquipmentVO>();
            for (EquipmentEntity equipmentEntity2 : equipmentEntityList) {
                equipmentVO = new EquipmentVO();
                BeanUtils.copyProperties(equipmentEntity2, equipmentVO);
                equipmentVOlist.add(equipmentVO);
            }
        }
        indexVO.setEquipmentVoList(equipmentVOlist);
        //科研成果
        List<ResearchAchieveEntity> rhelist = researchAchieveDAO.pageQuery(0, 8);
        if (rhelist != null) {
            researchAchieveVOlist = new ArrayList<ResearchAchieveVO>();
            for (ResearchAchieveEntity researchAchieveEntity : rhelist) {
                researchAchieveVOTmp = new ResearchAchieveVO();
                BeanUtils.copyProperties(researchAchieveEntity, researchAchieveVOTmp);
                researchAchieveVOlist.add(researchAchieveVOTmp);
            }
        }
        indexVO.setResearchAhieveList(researchAchieveVOlist);
        // 9：专家信息
        List<ExpertEntity> expertEntityList = expertDAO.getExpertsByShowInIndex(true);
        if (expertEntityList.size() > 0) {
            expertsList = new ArrayList<ExpertVO>();
            for (ExpertEntity expertEntity : expertEntityList) {
                expertVO = new ExpertVO();
                BeanUtils.copyProperties(expertEntity, expertVO);
                expertVO.setHeadPic("userManager/user!showPic.action?cloudContext.params.headpic="
                                + expertEntity.getHeadPic());
                expertsList.add(expertVO);
            }
            String isRandom = PropertyManager.getInstance()
                            .getDbProperty(PropertyManager.INDEX_EXPERTS_IS_RANDOM, true);
            if (isRandom.equals("1")) {
                Collections.shuffle(expertsList);
            }
        }
        //专家轮换时间设置
        /*String viewExpertId = PropertyManager.getInstance().getDbProperty(
        		PropertyManager.DB_SHOW_AT_INDEX_EXPERT_ID,true);*/
        String indexExpertChangeTime = PropertyManager.getInstance().getDbProperty(
                        PropertyManager.INDEX_EXPERT_CHANGE_TIME, true);
        cloudContext.addParam("expertChangeTime", indexExpertChangeTime);

        indexVO.setViewExperts(expertsList);
        return indexVO;
    }
}
