/**
 * Copyright(c) 2012 ShenZhen CloudKing Technology Co., Ltd
 * All rights reserved.
 * Created on Oct 15, 2012  2:17:56 PM
 */
package com.cloudking.openlab.service.quartz;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.SessionListener;
import com.cloudking.openlab.dao.ResetUserPasswordDAO;
import com.cloudking.openlab.entity.ResetUserPasswordEntity;
import com.cloudking.openlab.util.LogUtil;

/**
 * @author CloudKing 任务调度器
 */
public class CloudKingScheduler {

    @Resource
    private ResetUserPasswordDAO resetUserPasswordDAO;

    /**
     * 自定义任务
     * 
     * @throws Exception
     *             所有异常
     */
    public void quartzCkDatabaseBackUpTask() throws Exception {
    }

    /**
     * 每日任务
     * 
     * @throws Exception
     *             所有异常
     */
    public void quartzEveryDayTask() {
        synchronizeDBVisitorCount();
    }

    /**
     * 访问者统计同步数据库
     */
    private void synchronizeDBVisitorCount() {
        try {
            PropertyManager.getInstance().setDBProperty(PropertyManager.VISITOR_COUNT,
                            String.valueOf(SessionListener.sessionCount));
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    /**
     * 每分钟任务
     */
    public void quartzEveryMinuteTask() {
        try {
//            checkResetUserPassword(); //已在后台实现
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    /**
     * 检查重置密码的邮件是否失效
     * 
     * @throws SQLException
     */
    private void checkResetUserPassword() throws SQLException {
        List<ResetUserPasswordEntity> rupes = resetUserPasswordDAO.list();
        int invalidTime = Integer.parseInt(PropertyManager.getInstance().getDbProperty(
                        PropertyManager.DB_RESET_USER_PASSWORD_EMAIL_INVALID_TIME, true));
        Date now = null;
        Date date = null;
        for (ResetUserPasswordEntity e : rupes) {
            now = new Date();
            date = e.getAddDate();
            if (now.getTime() - date.getTime() >= 1000 * 60 * 60 * invalidTime) {
                resetUserPasswordDAO.delete(e);
            }
        }
    }
}
