/**
 * Copyright(c) 2012 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.cloudking.openlab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.cloudking.openlab.entity.PropertyEntity;
import com.cloudking.openlab.util.LogUtil;
import com.cloudking.openlab.util.ProjectUtil;

/**
 * Property管理对象
 * 
 * @author CloudKing
 * 
 */
@SuppressWarnings("unchecked")
public final class PropertyManager {
    /**
     * xml配置：不包括的url
     */
    public static final String XML_OPENLAB_EXCLUDEAUTHURLS = "openlab/excludeAuthUrls";
    /**
     * xml配置：项目的home目录
     */
    public static final String XML_OPENLAB_OPENLABHOME = "openlab/openlabHome";
    /**
     * 
     */
    public static final String XML_OPENLAB_COREMANAGER_HOST = "openlab/coreManagerHost";
    /**
     * xmlProperty
     */
    private static Map<String, String> xmlProperty = new ConcurrentHashMap<String, String>();
    /**
     * dbProperty
     */
    private static Map<String, String> dbProperty = new ConcurrentHashMap<String, String>();
    /**
     * 配置文件路径
     */
    private static final File PROJECT_CONFIG_FILE = new File(Thread.currentThread().getContextClassLoader()
            .getResource("project-config.xml").getFile());
    /**
     * 文件下载目录
     */
    public static final String DOWNLOAD_DIR = "download";
    
    /**
     * 头像目录
     */
    public static final String HEADPIC_DIR="headPic";
    /**
     * 默认用户头像
     */
    public static final String DB_USER_DEFAULT_HEAD_PIC = "db_user_default_head_pic";
    /**
     * webservice ip
     */
    public static final String XML_VALID_WEBSERVICE_IP = "openlab/webserviceIP";
    public static final String XML_VALID_WEBSERVICE_PORT = "openlab/webservicePort";
    
    /**
     * email 是否开启
     */
    public static final String DB_EMAIL_ENABLE = "email_enable";
    /**
     * email 密码
     */
    public static final String DB_EMAIL_PASSWORD = "email_password";
    /**
     * email 用户名
     */
    public static final String DB_EMAIL_USERNAME = "email_username";
    /**
     * email host
     */
    public static final String DB_EMAIL_HOST = "email_host";
    /**
     * email port
     */
    public static final String DB_EMAIL_PORT = "email_port";
    /**
     * email form
     */
    public static final String DB_EMAIL_FROM = "email_from";
    /**
     * 找回密码邮件有效时间（小时）
     */
    public static final String DB_RESET_USER_PASSWORD_EMAIL_INVALID_TIME = "reset_user_password_email_invalid_time";
    /**
     * 显示在首页的专家的id
     */
    public static final String DB_SHOW_AT_INDEX_EXPERT_ID ="viewExpertID";
    /**
     * 仪器设备默认图片名
     */
    public static final String DB_EQUIPMENTPIC_DEFAULT = "db_equipmentpic_default";
    /**
     * 首页专家轮换时间
     */
    public static final String INDEX_EXPERT_CHANGE_TIME = "index_expert_change_time";
    public static final String INDEX_EXPERTS_IS_RANDOM = "index_experts_is_random";
    /**
     * 访问者统计
     */
    public static final String VISITOR_COUNT = "visitor_count";
    /**
     * 本机IP
     */
	public static final String XML_HOST = "openlab/Host";
    /**
     * 实例化对象
     */
    private static PropertyManager instance = new PropertyManager();
    /**
     * project-config.xml文件的Document对象
     */
    private Document document;

    /**
     * 私有化构造器
     */
    private PropertyManager(){

    }

    public static PropertyManager getInstance() {
        return instance;
    }

    /**
     * 初始化property
     * 
     * @throws Exception
     *             exc
     */
    public void initProperty() throws Exception {
        initXMLConfig();
        initDbProperty();
    }

    /**
     * 保存xml属性
     */
    private synchronized void saveXmlProperties() {
        // Write data out to a temporary file first.
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PROJECT_CONFIG_FILE), "UTF-8"));
            OutputFormat prettyPrinter = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(writer, prettyPrinter);
            xmlWriter.write(document);
        } catch (Exception e) {
            LogUtil.fatal(e.getMessage(), e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    LogUtil.fatal(e1.getMessage(), e1);
                }
            }
        }

    }

    /**
     * 初始化xml配置
     * 
     * @throws Exception
     *             exc
     */
    private void initXMLConfig() throws Exception {
        SAXReader reader = new SAXReader(false);
        document = reader.read(PROJECT_CONFIG_FILE);

        //openlab/excludeAuthUrls
        Element excludeAuthUrls = (Element) document.selectSingleNode(XML_OPENLAB_EXCLUDEAUTHURLS);
        xmlProperty.put(XML_OPENLAB_EXCLUDEAUTHURLS, excludeAuthUrls.getTextTrim());

        //openlab/openlabHome
        Element homeDir = (Element) document.selectSingleNode(XML_OPENLAB_OPENLABHOME);
        xmlProperty.put(XML_OPENLAB_OPENLABHOME, homeDir.getTextTrim());

    }

    /**
     * 初始化数据库属性
     * 
     * @throws Exception
     *             exc
     */
    private void initDbProperty() throws Exception {
        EntityManager em = ProjectUtil.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query = em.createQuery("from PropertyEntity order by key desc");
            List<PropertyEntity> propertyEntities = query.getResultList();
            transaction.commit();
            for (PropertyEntity propertyEntity : propertyEntities) {
                dbProperty.put(propertyEntity.getKey(), propertyEntity.getValue());
            }
        } finally {
            em.close();
        }
    }

    /**
     * 设置数据库的值
     * 
     * @param key
     * @param value
     * @throws Exception
     *             exc
     */
    public synchronized void setDBProperty(String key, String value) throws Exception {
        EntityManager em = ProjectUtil.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query = em.createQuery("update PropertyEntity set value=:value where key=:key");
            query.setParameter("key", key);
            query.setParameter("value", value);
            query.executeUpdate();
            transaction.commit();
            dbProperty.put(key, value);
        } finally {
            em.close();
        }
    }
    public String getDbProperty(String key) {
        return getDbProperty(key,false);
    }
    /**
     * 获取数据库的值
     * 
     * @param key
     * @return
     */
    public String getDbProperty(String key,Boolean force) {
        EntityManager em = ProjectUtil.getEntityManager();
        try {
            //先判断dbProperty是否存在，不存在再判断数据库是否存在
            if (force || dbProperty.get(key) == null) {
                Query query = em.createQuery("from PropertyEntity  where key=:key ");
                query.setParameter("key", key);
                PropertyEntity propertyEntity = null;
                try {
                    propertyEntity = (PropertyEntity) (query.getSingleResult());
                } catch (NoResultException e) {
                }
                if (propertyEntity != null) {
                    dbProperty.put(key, propertyEntity.getValue());
                }
            }
            return dbProperty.get(key);
        } finally {
            em.close();
        }
    }

    /**
     * ，设置xml文件
     * 
     * @param key
     * @param value
     * @throws Exception
     *             exc
     */
    public synchronized void setXMLProperty(String key, String value) throws Exception {
        xmlProperty.put(key, value);
        Element keyElement = (Element) document.selectSingleNode(key);
        if (keyElement != null) {
            keyElement.setText(value.trim());
            saveXmlProperties();
        }
    }

    /**
     * 获取XML属性
     * 
     * @param key
     * @return
     */
    public String getXMLProperty(String key) {
        if (xmlProperty.get(key) == null) {
            try {
                SAXReader reader = new SAXReader(false);
                document = reader.read(PROJECT_CONFIG_FILE);
                Element elementTmp = (Element) document.selectSingleNode(key);
                xmlProperty.put(key, elementTmp.getTextTrim());
            } catch (DocumentException e) {
                LogUtil.fatal(e);
            }
        }
        return xmlProperty.get(key);
    }

}
