/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Oct 16, 2013  3:46:41 PM
 */
package com.cloudking.openlab.util;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.cloudking.openlab.PropertyManager;

/**
 * @author CloudKing
 */
public class WebserviceUtil {

    /**
     * 
     * @param employeeNo
     *            卡号
     * @param name
     *            姓名
     * @param sex
     *            性别
     * @param idType
     *            证件类型
     * @param idCode
     *            证件号码
     * @param websitepsw
     *            登录密码
     * @param email
     *            email
     * @throws AxisFault
     */
    public static Boolean validateEmployee(String employeeNo, String name, String sex, String idType, String idCode,
                    String websitepsw, String email) throws AxisFault {
        String ip = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_VALID_WEBSERVICE_IP);
        String port = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_VALID_WEBSERVICE_PORT);
        RPCServiceClient serviceClient = new RPCServiceClient();
        EndpointReference targetEPR = new EndpointReference("http://" + ip + ":" + port + "/ws/services/authemployee");//更改实际地址
        Options options = serviceClient.getOptions();
        options.setAction("validateEmployee");
        options.setTo(targetEPR);
        serviceClient.setTargetEPR(targetEPR);
        try {
            QName qnName = new QName("http://authemployee.ws.ecard.utsz.edu.cn", "queryEmployeeByID");

            boolean res = (Boolean) serviceClient.invokeBlocking(qnName, new Object[] { employeeNo, name, sex, idType,
                            idCode, websitepsw, email }, new Class[] { Boolean.class })[0];
            return res;
        } finally {
            serviceClient.cleanupTransport();
        }
    }
    /**
     * 验证校园卡号和密码
     * @param cardId
     * @param pwd
     * @return
     * @throws AxisFault
     */
    public static Boolean validUsernameAndPwd(String cardId,String pwd) throws AxisFault {
        return validateEmployee(cardId, null, null, null, null, pwd, null);
    }
    /**
     * 验证卡号是否存在
     * @param cardId
     * @return
     * @throws AxisFault
     */
    public static Boolean validUsernameExist(String cardId) throws AxisFault{
        return validateEmployee(cardId, null, null, null, null, null, null);
    }
}
