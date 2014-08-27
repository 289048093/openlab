package com.cloudking.openlab.service.expertquestion;

import java.sql.SQLException;
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
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.ExpertDAO;
import com.cloudking.openlab.dao.ExpertQuestionAnswerDAO;
import com.cloudking.openlab.dao.ExpertQuestionDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.ExpertEntity;
import com.cloudking.openlab.entity.ExpertQuestionAnswerEntity;
import com.cloudking.openlab.entity.ExpertQuestionEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.ExpertQuestionAnswerVO;
import com.cloudking.openlab.vo.ExpertQuestionVO;
import com.cloudking.openlab.vo.ExpertVO;

@Service("expertQuestionService")
public class ExpertQuestionService extends BaseService {
    @SuppressWarnings("unused")
    //专家咨询的dao
    @Resource
    private ExpertQuestionDAO expertQuestionDAO;

    @Resource
    private ExpertQuestionAnswerDAO expertQuestionAnswerDAO;
    //专家信息的dao
    @Resource
    private ExpertDAO expertDAO;
    //用户dao
    @Resource
    private UserDAO userDAO;

    /**
     * 获取传入到前台专家列表的数据
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void query(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        if (cloudContext.getBooleanParam("pagesize_null_flag")) {
            cloudContext.getPageInfo().setNowPage((cloudContext.getPageInfo().getNowPage() + 5) / 5);
            cloudContext.getPageInfo().setEachPageData(5);
        }

        List<ExpertQuestionVO> classicseqlist = null;
        List<ExpertQuestionVO> historyeqlist = null;
        List<ExpertVO> elist = null;
        ExpertQuestionVO expertQuestionVO = null;
        ExpertVO expertVO = null;

        //经典问答
        List<ExpertQuestionEntity> classicseqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_CLASSIC);
        if (classicseqelist.size() > 0) {
            classicseqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : classicseqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVO);
                classicseqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //历史问答
        List<ExpertQuestionEntity> historyeqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_NO_CLASSIC);
        if (historyeqelist.size() > 0) {
            historyeqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity2 : historyeqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity2, expertQuestionVO);
                historyeqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //专家信息
        List<ExpertEntity> exlist = expertDAO.query(cloudContext.getPageInfo());
        if (exlist.size() > 0) {
            elist = new ArrayList<ExpertVO>();
            for (ExpertEntity expertEntity : exlist) {
                expertVO = new ExpertVO();
                BeanUtils.copyProperties(expertEntity, expertVO);
                expertVO.setHeadPic("userManager/user!showPic.action?cloudContext.params.headpic="
                                + expertEntity.getHeadPic());
                elist.add(expertVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        //把结果集，放到全局参数中
        cloudContext.addParam("classicsexperts", classicseqlist);
        cloudContext.addParam("historyexperts", historyeqlist);
        cloudContext.addParam("expertusers", elist);
    }

    /**
     * 获取传入到前台所有问答的数据
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void queryExpertQuestions(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionVO> classicseqlist = null;
        List<ExpertQuestionVO> historyeqlist = null;
        ExpertQuestionVO expertQuestionVO = null;
        List<ExpertQuestionVO> alleqslist = null;

        //经典问答
        List<ExpertQuestionEntity> classicseqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_CLASSIC);
        if (classicseqelist.size() > 0) {
            classicseqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : classicseqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVO);
                classicseqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //历史问答
        List<ExpertQuestionEntity> historyeqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_NO_CLASSIC);
        if (historyeqelist.size() > 0) {
            historyeqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity2 : historyeqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity2, expertQuestionVO);
                historyeqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //专家信息
        List<ExpertQuestionEntity> exqlist = expertQuestionDAO.query(cloudContext.getPageInfo());
        if (exqlist.size() > 0) {
            alleqslist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity3 : exqlist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity3, expertQuestionVO);
                alleqslist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        //把结果集，放到全局参数中
        cloudContext.addParam("classicsexperts", classicseqlist);
        cloudContext.addParam("historyexperts", historyeqlist);
        cloudContext.addParam("allexperts", alleqslist);
    }

    /**
     * 获取单独的专家信息
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void onceExpert(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionVO> classicseqlist = null;
        List<ExpertQuestionVO> historyeqlist = null;
        List<ExpertVO> elist = null;
        ExpertQuestionVO expertQuestionVO = null;
        ExpertVO expertVO = null;

        //经典问答
        List<ExpertQuestionEntity> classicseqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_CLASSIC);
        if (classicseqelist.size() > 0) {
            classicseqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : classicseqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVO);
                classicseqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //历史问答
        List<ExpertQuestionEntity> historyeqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_NO_CLASSIC);
        if (historyeqelist.size() > 0) {
            historyeqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity2 : historyeqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity2, expertQuestionVO);
                historyeqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }

        //本页的数据
        ExpertEntity oneExpert = expertDAO.get(cloudContext.getVo().getExpertId());
        if (oneExpert != null) {
            elist = new ArrayList<ExpertVO>();
            expertVO = new ExpertVO();
            BeanUtils.copyProperties(oneExpert, expertVO);
            expertVO
                            .setHeadPic("userManager/user!showPic.action?cloudContext.params.headpic="
                                            + oneExpert.getHeadPic());
            elist.add(expertVO);
        }
        //把结果集，放到全局参数中
        cloudContext.addParam("classicsexperts", classicseqlist);
        cloudContext.addParam("historyexperts", historyeqlist);
        cloudContext.addParam("expertusers", elist);
    }

    /**
     * 创建新的问题
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void addExpertQuestion(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        if (cloudContext.getLoginedUser() == null) {
            cloudContext.addErrorMsg("用户没有登录");
            return;
        }
        //当前用户
        UserEntity userentity = userDAO.get(cloudContext.getLoginedUser().getId());
        //被提问的专家
        UserEntity experUserEntity = userDAO.get(cloudContext.getVo().getExpertId());

        ExpertQuestionEntity eqEntity = new ExpertQuestionEntity();
        BeanUtils.copyProperties(cloudContext.getVo(), eqEntity);
        if (userentity != null) {
            eqEntity.setQuestioner(userentity);
        } else {
            cloudContext.addErrorMsg("用户没有登录");
            return;
        }
        if (experUserEntity != null) {
            eqEntity.setExpert(experUserEntity);
        }
        if (!(StringUtil.getStringByComma(eqEntity.getTitle()).length() > 0)) {
            cloudContext.addErrorMsg("问题标题不能为空");
            return;
        }
        if (!(StringUtil.getStringByComma(eqEntity.getContent()).length() > 0)) {
            cloudContext.addErrorMsg("问题内容不能为空");
            return;
        }
        eqEntity.setType(Constant.EXPERT_QUESTION_NO_CLASSIC);
        eqEntity.setView(false);
        eqEntity.setAddDate(new Date());
        expertQuestionDAO.insert(eqEntity);
    }

    /**
     * 前台所有人查看单条的问题
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void queryOneQuestionAddhf(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionVO> classicseqlist = null;
        List<ExpertQuestionVO> historyeqlist = null;
        ExpertQuestionVO expertQuestionVO = null;
        List<ExpertQuestionAnswerVO> eqaList = null;
        ExpertQuestionAnswerVO expertQuestionAnswerVO = null;
        //经典问答
        List<ExpertQuestionEntity> classicseqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_CLASSIC);
        if (classicseqelist.size() > 0) {
            classicseqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : classicseqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVO);
                classicseqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        //历史问答
        List<ExpertQuestionEntity> historyeqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_NO_CLASSIC);
        if (historyeqelist.size() > 0) {
            historyeqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity2 : historyeqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity2, expertQuestionVO);
                historyeqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        cloudContext.addParam("classicsexperts", classicseqlist);
        cloudContext.addParam("historyexperts", historyeqlist);
        //获取对应的问题
        ExpertQuestionEntity eqtmp = expertQuestionDAO.get(cloudContext.getVo().getId());
        if (eqtmp != null) {
            UserEntity quser = userDAO.get(eqtmp.getQuestioner().getId());
            expertQuestionVO = new ExpertQuestionVO();
            BeanUtils.copyProperties(eqtmp, expertQuestionVO);
            expertQuestionVO.setQuestionerName(quser.getRealname());
            String content = ProjectUtil.clearScript(expertQuestionVO.getContent());
            expertQuestionVO.setContent(content);
            cloudContext.addParam("theExpert", expertQuestionVO);
        } else {
            cloudContext.addErrorMsg("选择的问题不存在");
        }
        //问题对应的回答
        List<ExpertQuestionAnswerEntity> eqaentitylist = expertQuestionAnswerDAO.getExpertQuestionAnswersByCtatid(eqtmp
                        .getId());
        if (eqaentitylist != null && eqaentitylist.size() > 0) {
            eqaList = new ArrayList<ExpertQuestionAnswerVO>();
            for (ExpertQuestionAnswerEntity expertQuestionAnswerEntity : eqaentitylist) {
                UserEntity quser = userDAO.get(expertQuestionAnswerEntity.getAnswerer().getId());
                expertQuestionAnswerVO = new ExpertQuestionAnswerVO();
                BeanUtils.copyProperties(expertQuestionAnswerEntity, expertQuestionAnswerVO);
                expertQuestionAnswerVO.setAnswererName(quser.getRealname());
                String content = ProjectUtil.clearScript(expertQuestionAnswerVO.getContent());
                expertQuestionAnswerVO.setContent(content);
                eqaList.add(expertQuestionAnswerVO);
            }
            cloudContext.addParam("experthds", eqaList);
        }
    }

    /**
     * 个人中心自己查看查看单条的问题
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void viewThisSelfOneQuestionAddhf(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionVO> classicseqlist = null;
        List<ExpertQuestionVO> historyeqlist = null;
        ExpertQuestionVO expertQuestionVO = null;
        List<ExpertQuestionAnswerVO> eqaList = null;
        ExpertQuestionAnswerVO expertQuestionAnswerVO = null;
        //经典问答
        List<ExpertQuestionEntity> classicseqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_CLASSIC);
        if (classicseqelist.size() > 0) {
            classicseqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : classicseqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVO);
                classicseqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        //历史问答
        List<ExpertQuestionEntity> historyeqelist = expertQuestionDAO
                        .queryExpertQuestion(Constant.EXPERT_QUESTION_NO_CLASSIC);
        if (historyeqelist.size() > 0) {
            historyeqlist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity2 : historyeqelist) {
                expertQuestionVO = new ExpertQuestionVO();
                BeanUtils.copyProperties(expertQuestionEntity2, expertQuestionVO);
                historyeqlist.add(expertQuestionVO);
            }
        } else {
            cloudContext.addErrorMsg("数据获取失败");
        }
        cloudContext.addParam("classicsexperts", classicseqlist);
        cloudContext.addParam("historyexperts", historyeqlist);
        //获取对应的问题
        ExpertQuestionEntity eqtmp = expertQuestionDAO.get(cloudContext.getVo().getId());
        if (eqtmp != null) {
            UserEntity quser = userDAO.get(eqtmp.getQuestioner().getId());
            expertQuestionVO = new ExpertQuestionVO();
            BeanUtils.copyProperties(eqtmp, expertQuestionVO);
            expertQuestionVO.setQuestionerName(quser.getRealname());
            String content = ProjectUtil.clearScript(expertQuestionVO.getContent());
            expertQuestionVO.setContent(content);
            cloudContext.addParam("theExpert", expertQuestionVO);
        } else {
            cloudContext.addErrorMsg("选择的问题不存在");
        }
        //问题对应的回答
        List<ExpertQuestionAnswerEntity> eqaentitylist = expertQuestionAnswerDAO.getExpertQuestionAnswersByCtatid(eqtmp
                        .getId());
        if (eqaentitylist != null && eqaentitylist.size() > 0) {
            eqaList = new ArrayList<ExpertQuestionAnswerVO>();
            for (ExpertQuestionAnswerEntity expertQuestionAnswerEntity : eqaentitylist) {
                if (expertQuestionAnswerEntity.getIsView() == false) {
                    expertQuestionAnswerEntity.setIsView(true);
                    expertQuestionAnswerDAO.update(expertQuestionAnswerEntity);
                }
                UserEntity quser = userDAO.get(expertQuestionAnswerEntity.getAnswerer().getId());
                expertQuestionAnswerVO = new ExpertQuestionAnswerVO();
                BeanUtils.copyProperties(expertQuestionAnswerEntity, expertQuestionAnswerVO);
                expertQuestionAnswerVO.setAnswererName(quser.getRealname());
                String content = ProjectUtil.clearScript(expertQuestionAnswerVO.getContent());
                expertQuestionAnswerVO.setContent(content);
                eqaList.add(expertQuestionAnswerVO);
            }
            cloudContext.addParam("experthds", eqaList);
        }
    }

    /**
     * 个人中心，点击查看但个问题的回答
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void viewUserCenterShowoneAnswers(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionAnswerVO> eqaList = null;
        ExpertQuestionAnswerVO expertQuestionAnswerVO = null;

        List<ExpertQuestionAnswerEntity> eqaentitylist = expertQuestionAnswerDAO
                        .getExpertQuestionAnswersByCtatid(cloudContext.getVo().getId());
        eqaList = new ArrayList<ExpertQuestionAnswerVO>();
        if (eqaentitylist != null && eqaentitylist.size() > 0) {
            for (ExpertQuestionAnswerEntity expertQuestionAnswerEntity : eqaentitylist) {
                if (expertQuestionAnswerEntity.getIsView() == false) {
                    expertQuestionAnswerEntity.setIsView(true);
                    expertQuestionAnswerDAO.update(expertQuestionAnswerEntity);
                }
                UserEntity quser = userDAO.get(expertQuestionAnswerEntity.getAnswerer().getId());
                expertQuestionAnswerVO = new ExpertQuestionAnswerVO();
                BeanUtils.copyProperties(expertQuestionAnswerEntity, expertQuestionAnswerVO);
                expertQuestionAnswerVO.setAnswererName(quser.getRealname());
                String content = ProjectUtil.clearScript(expertQuestionAnswerEntity.getContent());
                expertQuestionAnswerVO.setContent(content);
                eqaList.add(expertQuestionAnswerVO);
            }
        }
        cloudContext.addParam("userCenteroneAnwers", eqaList);
    }

    /**
     * 获取个人中心的数据
     * 
     * @throws SQLException
     */
    public void viewUserCenterContent(CloudContext<ExpertQuestionVO> cloudContext) throws SQLException {
        List<ExpertQuestionVO> expertQuestionVolist = null;
        ExpertQuestionVO expertQuestionVOTmp = null;
        LoginedUser loginedUser = (LoginedUser) ServletActionContext.getRequest().getSession().getAttribute(
                        Constant.LOGINED_USER);
        if (loginedUser == null) {
            cloudContext.addErrorMsg("您还未登录，请先登录");
            return;
        }
        //判断登录用户是不是专家
        ExpertEntity expertEntity = expertDAO.get(loginedUser.getId());
        if (expertEntity != null) {
            cloudContext.addParam("expertid", loginedUser.getId());
        } else {
            cloudContext.addParam("userid", loginedUser.getId());
        }
        Collection<ExpertQuestionEntity> ExpertQuestions = expertQuestionDAO.queryLoginUserQuestion(cloudContext);
        if (ExpertQuestions != null && ExpertQuestions.size() > 0) {
            expertQuestionVolist = new ArrayList<ExpertQuestionVO>();
            for (ExpertQuestionEntity expertQuestionEntity : ExpertQuestions) {
                expertQuestionVOTmp = new ExpertQuestionVO();
                if (expertEntity != null && expertQuestionEntity.isView() == false) {
                    expertQuestionEntity.setView(true);
                    expertQuestionDAO.update(expertQuestionEntity);
                }
                BeanUtils.copyProperties(expertQuestionEntity, expertQuestionVOTmp);
                expertQuestionVOTmp.setQuestionerName(expertQuestionEntity.getQuestioner().getRealname());
                expertQuestionVOTmp.setExpertName(expertQuestionEntity.getExpert().getRealname());
                expertQuestionVolist.add(expertQuestionVOTmp);
            }
        }
        cloudContext.addParam("expertQuestions", expertQuestionVolist);
    }
}