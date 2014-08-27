/**
 * 
 */
package com.cloudking.openlab.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cloudking.openlab.PropertyManager;

/**
 * @author CloudKing 和当前项目有关的工具类
 */
public final class ProjectUtil {
	/**
	 * spring上下文
	 */
	private static WebApplicationContext applicationContext;
	/**
	 * 
	 */
	private static ThreadLocal<EntityManager> tl = new ThreadLocal<EntityManager>();
	/**
	 * entityManager
	 */
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("openlab_unit");

	/**
	 * 私有化构造器
	 */
	private ProjectUtil() {

	}

	/**
	 * 获取entityManager
	 * 
	 * @return
	 */
	public static synchronized EntityManager getEntityManager() {
		EntityManager em = tl.get();
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
			tl.set(em);
		}
		return em;
	}

	/**
	 * 初始化spring
	 * 
	 * @param servletContext
	 */
	public static void initSpringContext(ServletContext servletContext) {
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		applicationContext = wac;
	}

	/**
	 * 获取bean
	 * 
	 * @param key
	 * @return
	 */
	public static Object getSpringBean(String key) {
		return applicationContext.getBean(key);
	}

	/**
	 * 获取文件的HOME目录
	 * 
	 * @return
	 */
	public static File getHomeDir() {
		return new File(PropertyManager.getInstance().getXMLProperty(
				PropertyManager.XML_OPENLAB_OPENLABHOME));
	}

	/**
	 * 获取下载文件目录
	 * 
	 * @return
	 */
	public static File getDownloadDir() {
		return new File(getHomeDir().getAbsoluteFile() + "/"
				+ PropertyManager.DOWNLOAD_DIR);
	}
	
	public static File getEquipmentDir() {
		return new File(getHomeDir().getAbsoluteFile() + "/" + "equipment");
	}

	/**
	 * 获取头像文件目录
	 * 
	 * @return
	 */
	public static File getHeadPic() {
		return new File(getHomeDir().getAbsoluteFile() + "/"
				+ PropertyManager.HEADPIC_DIR);
	}

	/**
	 * 强制创建文件夹，如果父目录不存在则递归创建
	 * 
	 * @param file
	 */
	public static void forceCreateDir(File file) {
		if (file.exists()) {
			return;
		}
		String parentDirStr = file.getParent();
		if (parentDirStr != null) {
			File parent = new File(parentDirStr);
			if (!parent.exists()) {
				forceCreateDir(parent);
			}
		}
		file.mkdir();
	}

	/**
	 * 过滤脚本
	 */
	public static String clearScript(String dest) {
	    Pattern pattern = Pattern.compile("<\\s*/\\s*script");
	    Matcher matcher = pattern.matcher(dest);
	    Boolean res = matcher.find();
	    if(!res){return dest;}
	    StringBuffer buf = new StringBuffer();
	    while(res){
	        matcher.appendReplacement(buf, matcher.group().replaceFirst("^<", "&lt;"));
	        res = matcher.find();
	    }
		return buf.toString();
	}
}
