/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.cloudking.openlab.util;

/**
 * 常量
 * 
 * @author xgj
 * 
 */
public interface Constant {
    /**
     * 登陆用户的信息
     */
    String LOGINED_USER = "userLogin";
    /**
     * 验证码
     */
    String VERIFY_CODE = "verifyCode";
    /**
     * 用户正常状态
     */
    String USER_NORMAL_STATE = "1";
    /**
     * 用户删除状态
     */
    String USER_DELETE_STATE = "0";
    /**
     * 用户男性
     */
    String USER_SEX_MAN = "1";
    /**
     * 用户女性
     */
    String USER_SEX_WOMAN = "0";

    /**
     * 角色持久化 是
     */
    String ROLE_PERSISTENCE_YES = "1";
    /**
     * 角色持久化 否
     */
    String ROLE_PERSISTENCE_NO = "0";

    /**
     * 订单类型 用户
     */
    Byte ORDER_TYPE_USER = 0;
    /**
     * 订单类型 系统
     */
    Byte ORDER_TYPE_SYSTEM = 1;
    /**
     * 置顶
     */
    Byte TOP = 1;
    /**
     * 不置顶
     */
    Byte UNTOP = 0;
    /**
     * 订单前缀
     */
    String ORDER_PREFIX = "DD";
    /**
     * 仪器设备状态 报废
     */
    byte EQUIPMENTMAINTAIN_STATUS_SCRAP = 0;

    /**
     * 仪器设备状态 正常
     */
    byte EQUIPMENTMAINTAIN_STATUS_NORMAL = 1;

    /**
     * 仪器设备状态 维护中
     */
    byte EQUIPMENTMAINTAIN_STATUS_MAINTAIN = 2;
    
    /**
	 * 仪器设备状态 忙碌
	 */
	byte EQUIPMENTMAINTAIN_STATUS_BUSY = 3;
    /**
     * 仪器设备维护类型 报废
     */
    String EQUIPMENTMAINTAIN_TYPE_SCRAP = "1";

    /**
     * 仪器设备维护类型 维护
     */
    String EQUIPMENTMAINTAIN_TYPE_MAINTAIN = "0";

    /**
     * 管理员角色
     */
    Long ROLE_MANAGER_ID = 1L;
    /**
     * 专家角色
     */
    Long ROLE_EXPERT_ID = 2L;
    /**
     * 普通用户角色
     */
    Long ROLE_COMMON_USER_ID = 3L;
    /**
     * 专家经典问答
     */
    Byte EXPERT_QUESTION_CLASSIC = 1;
    /**
     * 专家问答非经典
     */
    Byte EXPERT_QUESTION_NO_CLASSIC = 0;
    /**
     * 问题呗拒绝
     */
    Byte EXPERT_QUESTION_REFUSE = 2;
    /**
     * 订单待审核
     */
    String Order_NOAUDIT_STATUS = "0";

    /**
     * 订单已拒绝
     */
    String Order_REFUSE_STATUS = "1";

    /**
     * 订单已通过/待测中
     */
    String Order_YESPAY_STATUS = "2";

    /**
     * 订单已付款(待核实)
     */
    String Order_NOPAY_STATUS_NO = "3";
    /**
     * 订单已付款(已核实)
     */
    String Order_NOPAY_STATUS_YES = "6";

    /**
     * 订单(已关闭)
     */
    String Order_STATUS_CLOSE = "7";

    /**
     * 订单使用中/检测中
     */
    String Order_USE_STATUS = "4";

    /**
     * 订单已结束
     */
    String Order_END_STATUS = "5";

    /**
     * 时间段 可用
     */
    String TIMEQUANTUM_STATUS_YES = "0";
    /**
     * 时间段 已用
     */
    String TIMEQUANTUM_STATUS_NO = "1";
    /**
     * 新闻中通知公告类别ID
     */
    Long NEWS_NOTICE_ID = 1L;

    /**
     * 重点实验室:实验室类别
     */
    Byte POINTLAB_TYPE_IS_LAB = 1;

    /**
     * 重点实验室:技术平台类别
     */
    Byte POINTLAB_TYPE_IS_PLATFORM = 2;
}
