package com.cloudking.openlab.action.test.expert;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.cloudking.openlab.dao.ExpertDAO;
import com.cloudking.openlab.dao.ExpertQuestionAnswerDAO;
import com.cloudking.openlab.dao.ExpertQuestionDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.ExpertEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;


@RunWith(SpringJUnit4ClassRunner.class) // 用于配置spring中测试的环境 
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class ,TransactionalTestExecutionListener.class})//监听
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})//用于指定配置文件所在的位置 
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback =true)
public class ExpertTest {
    @Resource
    UserDAO userDAO;
    @Resource
    ExpertDAO expertDAO;
    @Resource
	private ExpertQuestionDAO expertQuestionDAO;
    @Resource
    private ExpertQuestionAnswerDAO expertQuestionAnswerDAO;
    @BeforeClass
    public static void beforeClass() {}
    
    @Test
    public void insertTest() throws SQLException{
        ExpertEntity ee = new ExpertEntity();
        ee.setAddTime(new Date());
        ee.setSex(Constant.USER_SEX_MAN);
        ee.setUsername("testuser111");
        ee.setRealname("test realname");
        ee.setPassword("test password");
        ee.setStatus(Constant.USER_NORMAL_STATE);
        expertDAO.insert(ee);
        UserEntity ue = ee;
        //userDAO.delete(ue);
        System.out.println(ee instanceof ExpertEntity);
    }
    @Test
    public void deleteExpertTest() throws SQLException{
        expertDAO.get(7L);
    }
    @Test
    public void userToExpertTest() throws SQLException{
        UserEntity ue = new ExpertEntity();
        ue.setAddTime(new Date());
        ue.setSex(Constant.USER_SEX_MAN);
        ue.setUsername("testuser111");
        ue.setRealname("test realname");
        ue.setPassword("test password");
        ue.setStatus(Constant.USER_NORMAL_STATE);
        userDAO.insert(ue);
        ExpertEntity ee = (ExpertEntity) ue;
        System.out.println(ee.getUsername());
        ee.setTitle("test title");
        expertDAO.update(ee);
        System.out.println(ee.getTitle());
    }
    
    @Test
    public void MsgCountTest() throws SQLException{
    	System.out.println(expertQuestionDAO.LoginUserQuestions(1L));
//    	 String hql = "select count(u_.id) " +
//    	 		"from UserEntity u_ " +
//    	 		"left join u_.receiveQuestions rq_ " +
//    	 		"left join u_.sendQuestions sq_ " +
//    	 		"left join rq_.answers ra_ " +
//    	 		"left join sq_.answers sa_ " +
//    	 		"where (rq_.isView=false or (ra_.isView=false and ra_.answerer.id<>:userId) or (sa_.isView=false and sa_.answerer.id<>:userId)) and u_.id=:userId";
//         Object res = expertDAO.uniqueResultObject(hql,"userId",3L);
//         System.out.println(res);
    }
    @Test
    public void AnswerSET()throws SQLException{
    	System.out.println(expertQuestionAnswerDAO.getExpertQuestionAnswersByCtatid(3l));
    }
    
    @AfterClass
    public static void afterClass(){}
}
