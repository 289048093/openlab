/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Oct 16, 2013  10:17:31 AM
 */
package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.EquipmentUsedLogEntity;

/**
 * @author CloudKing
 */
@Repository("equipmentUsedLogDAO")
public class EquipmentUsedLogDAO extends BaseDAO<EquipmentUsedLogEntity> {

    /**
     * 根据订单号查询(最新的一条 id 最大)
     * 
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    public EquipmentUsedLogEntity queryOrderNum(String ordrNum) throws SQLException {
        String hql = "select e from EquipmentUsedLogEntity e inner join e.applyOrder as o where o.ordrNum=:ordrNum order by e.id desc";
        List<EquipmentUsedLogEntity> equipmentUsedLogEntities = list(hql, "ordrNum", ordrNum);
        if (equipmentUsedLogEntities.size() > 0) {
            return equipmentUsedLogEntities.get(0);
        } else {
            return null;
        }
    }
    /**
     * 仪器服务排名
     * @return
     * @throws SQLException
     */
    public  List<Object[]>  hqIndexContent()throws SQLException{
    	String hql = "select count(ul_.id) as ci_,e_.name as en_,e_.id as ei_ from EquipmentUsedLogEntity ul_ left join ul_.applyOrder ao_ left join ao_.equipment e_ group by e_.id";
        List<Object[]> list = list(hql);
        if(list == null || list.size()==0){
        	return new ArrayList<Object[]>();
        }
        Collections.sort(list,new Comparator<Object[]>(){
        public int compare(Object[] o1, Object[] o2) {
        	return Integer.parseInt(o2[0].toString())-Integer.parseInt(o1[0].toString());
        }});
        List<Object[]> l = new ArrayList<Object[]>();
        int size = list.size()>8?8:list.size();
        for(int i=0;i<size;i++){
           l.add(list.get(i));
        }
    	return l;
    }

}
