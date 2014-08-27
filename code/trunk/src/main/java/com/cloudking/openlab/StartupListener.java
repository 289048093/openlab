/**
 * Copyright(c) 2012 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.cloudking.openlab;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.impl.StdScheduler;

import com.cloudking.openlab.util.ProjectUtil;

import com.cloudking.openlab.util.LogUtil;

/**
 * 启动之后的监听器
 * 
 * @author xgj
 * 
 */
public class StartupListener implements ServletContextListener {
	/**
	 * 销毁
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * 初始化
	 */
	public void contextInitialized(ServletContextEvent event) {
		try {
			ProjectUtil.initSpringContext(event.getServletContext());
			PropertyManager.getInstance().initProperty();
			UrlInterceptorManager.getInstance().initExcludeAuthUrls();
			createDirs();
			triggerQuartz();
			synchronizeDBVisitorCount();
		} catch (Exception e) {
			LogUtil.error(e);
		}

	}

	/**
	 * 创建目录
	 */
	public void createDirs() {
		File homeDir = ProjectUtil.getHomeDir();
		if (!homeDir.exists()) {
			ProjectUtil.forceCreateDir(homeDir);
		}
		File headPicDir = ProjectUtil.getHeadPic();
		if (!headPicDir.exists()) {
			ProjectUtil.forceCreateDir(headPicDir);
		}
		File equipmentPicDir = ProjectUtil.getEquipmentDir();
		if (!equipmentPicDir.exists()) {
			ProjectUtil.forceCreateDir(equipmentPicDir);
		}
	}

	/**
	 * 触发quartz
	 * 
	 * @throws Exception
	 *             所有异常
	 */
	private void triggerQuartz() throws Exception {
		StdScheduler stdScheduler = (StdScheduler) ProjectUtil.getSpringBean("schedulerFactory");
		stdScheduler.start();
	}

	private void synchronizeDBVisitorCount() {
		SessionListener.sessionCount = Integer.parseInt(PropertyManager.getInstance().getDbProperty(
						PropertyManager.VISITOR_COUNT));
	}
}
