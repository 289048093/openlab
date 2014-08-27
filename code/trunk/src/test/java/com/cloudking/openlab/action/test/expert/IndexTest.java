/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 12, 2013  10:53:58 AM
 */
package com.cloudking.openlab.action.test.expert;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.cloudking.openlab.dao.EquipmentDAO;
import com.cloudking.openlab.dao.EquipmentUsedLogDAO;
import com.cloudking.openlab.entity.EquipmentUsedLogEntity;
import com.cloudking.openlab.service.quartz.CloudKingScheduler;

/**
 * @author CloudKing
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境 
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
//监听
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
//用于指定配置文件所在的位置 
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class IndexTest {

    @Resource
    private EquipmentDAO equipmentDAO;
    @Resource
    private EquipmentUsedLogDAO equipmentUsedLogDAO;
    @Resource
    private CloudKingScheduler cKingScheduler;

    @Test
    public void countTest() throws SQLException {

        String hql = "select count(s_.id) from EquipmentUsedLogEntity s_";
        System.out.println(equipmentUsedLogDAO.uniqueResultObject(hql));

        String orderHql = "select count(id) from ApplyOrderEntity";
        System.out.println(equipmentUsedLogDAO.uniqueResultObject(orderHql));

        hql = "update EquipmentUsedLogEntity eul_ set eul_.endDate=:now where eul_.endDate is null and (select count(ao_.id) from eul_.applyOrder ao_ where ao_.subEndDate<=:now)>0";
        equipmentUsedLogDAO.updateByJPQL(hql, new String[] { "now" }, new Object[] { new Date() });

        cKingScheduler.quartzEveryMinuteTask();

    }

    @Test
    public void equipmentServiceCountTest() throws SQLException{
        String hql = "select count(ul_.id) as ci_,e_.name as en_,e_.id as ei_ from EquipmentUsedLogEntity ul_ left join ul_.applyOrder ao_ left join ao_.equipment e_ group by e_.id";
        List<Object[]> list = equipmentUsedLogDAO.list(hql);
        Collections.sort(list,new Comparator<Object[]>(){
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return Integer.parseInt(o1.toString())-Integer.parseInt(o2[0].toString());
            }});
        for(Object[] l:list){
            //l[0] Long count; l[1] String name; l[2] Long id
            System.out.println(l[0].toString()+l[1]+l[2]);
        }
        
    }
}
