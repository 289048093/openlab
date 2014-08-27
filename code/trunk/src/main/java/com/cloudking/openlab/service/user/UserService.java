/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.cloudking.openlab.service.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.cloudking.openlab.BaseService;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.LoginedUser;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.dao.CompanyDAO;
import com.cloudking.openlab.dao.ResetUserPasswordDAO;
import com.cloudking.openlab.dao.RightsDAO;
import com.cloudking.openlab.dao.UserDAO;
import com.cloudking.openlab.entity.CompanyEntity;
import com.cloudking.openlab.entity.ResetUserPasswordEntity;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.LogUtil;
import com.cloudking.openlab.util.MailUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.util.WebserviceUtil;
import com.cloudking.openlab.vo.UserVO;

/**
 * 用户service
 * 
 * @author CloudKing
 */
@SuppressWarnings("unused")
@Service("userService")
public class UserService extends BaseService {
    /**
     * userDAO
     */
    @Resource
    private UserDAO userDAO;
    @Resource
    private RightsDAO rightsDAO;
    @Resource
    private CompanyDAO companyDAO;
    @Resource
    private ResetUserPasswordDAO resetUserPasswordDAO;

    /**
     * 注销
     * 
     * @param cloudContext
     * @exception exc
     */
    public void logout(CloudContext<UserVO> cloudContext) {

    }

    /**
     * 登陆
     * 
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public void login(CloudContext<UserVO> cloudContext) throws SQLException {
        // 得到用户输入的姓名、密码及验证码
        String username = cloudContext.getVo().getUsername();
        UserEntity loginUser = null;
        String password = cloudContext.getVo().getPassword();
        String checkCode = cloudContext.getStringParam("checkCode");
        // 得到常量验证码
        String verifyCode = cloudContext.getStringParam(Constant.VERIFY_CODE);
        // 首先验证 验证码 验证码不通过直接返回
        if (!checkCode.equals(verifyCode)) {
            cloudContext.addErrorMsg("验证码错误");
            return;
        }
        String md5pwd = StringUtil.encrypt(username, password);
        // 用户名与加密后的密码去数据库中匹配
        loginUser = userDAO.findUserByUsernameAndPassword(username, md5pwd);
        // 如果是校园卡用户，并且通过校园卡号密码验证
        if (loginUser == null) {
            try {
                if (WebserviceUtil.validUsernameAndPwd(username, password)) {
                    // 验证是否在系统中登记
                    loginUser = userDAO.findUserByUsername(username);
                    if (loginUser == null) {
                        cloudContext.addParam("cardUserNoRegist", true);
                        return;
                    }
                } else {
                    cloudContext.addErrorMsg("用户名或密码错误!");
                    return;
                }
            } catch (AxisFault e) {
                cloudContext.addErrorMsg("服务器连接错误,请联系管理员");
                return;
            }
        }

        LoginedUser loginUserVO = new LoginedUser();
        BeanUtils.copyProperties(loginUser, loginUserVO);
        loginUserVO.setCompany(loginUser.getCompany());
        cloudContext.addParam(Constant.LOGINED_USER, loginUserVO);

        cloudContext.setLoginedUser(loginUserVO);
        cloudContext.addSuccessMsg("登录成功");

    }

    /**
     * 注册
     * 
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public void addRegister(CloudContext<UserVO> cloudContext) throws SQLException {
        // 判断注册用户名是否已经存在

        UserEntity userEntity = userDAO.findUserByUsername(cloudContext.getVo().getUsername());
        if (userEntity == null) {

            userEntity = new UserEntity();
            userEntity.setAddr(cloudContext.getVo().getAddr());
            userEntity.setEmail(cloudContext.getVo().getEmail());
            userEntity.setMobilePhone(cloudContext.getVo().getMobilePhone());
            userEntity.setRealname(cloudContext.getVo().getRealname());
            userEntity.setSex(cloudContext.getVo().getSex());
            userEntity.setUsername(cloudContext.getVo().getUsername());
            userEntity.setId(cloudContext.getVo().getId());
            userEntity.setTelPhone(cloudContext.getVo().getTelPhone());
            CompanyEntity company = new CompanyEntity();
            // company.setName(cloudContext.getVo().getCompany().getName());
            // if (company != null) {
            // companyDAO.insert(company);
            // }
            // userEntity.setCompany(company);
            userEntity.setCompany(cloudContext.getVo().getCompany());
            Date date = new Date();
            userEntity.setAddTime(date);
            userEntity.setStatus(Constant.USER_NORMAL_STATE);
            userEntity.setPassword(StringUtil.encrypt(cloudContext.getVo().getUsername(), cloudContext.getVo()
                            .getPassword()));
            userDAO.insert(userEntity);
            cloudContext.addSuccessMsg("注册成功");
        } else {
            cloudContext.addErrorMsg("用户名已存在");
        }
    }

    /**
     * @param cloudContext
     */
    public void query(CloudContext<UserVO> cloudContext) {
        // TODO Auto-generated method stub

    }

    /**
     * 找回密码
     */
    public void retrievePwd(CloudContext<UserVO> cloudContext) {
        // TODO Auto-generated method stub

    }

    /**
     * 用户名校验
     * 
     * @throws SQLException
     */
    public void initRegister(CloudContext<UserVO> cloudContext) throws SQLException {
        // 用户名判断
        String username = cloudContext.getVo().getUsername();
        UserEntity userEntity = userDAO.findUserByUsername(username);
        cloudContext.addParam("usernameExist", userEntity != null);
    }

    /**
     * 校外用户完善个人信息
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void addUserInfo(CloudContext<UserVO> cloudContext) throws SQLException {
        UserEntity userEntity = userDAO.findUserByUsername(cloudContext.getVo().getUsername());
        if (userEntity != null) {
            cloudContext.addErrorMsg("您已经修改过了，请勿重复提交");
            return;
        }
        userEntity = new UserEntity();
        userEntity.setAddr(cloudContext.getVo().getAddr());
        userEntity.setEmail(cloudContext.getVo().getEmail());
        userEntity.setMobilePhone(cloudContext.getVo().getMobilePhone());
        userEntity.setRealname(cloudContext.getVo().getRealname());
        userEntity.setSex(cloudContext.getVo().getSex());
        userEntity.setUsername(cloudContext.getVo().getUsername());
        userEntity.setId(cloudContext.getVo().getId());
        userEntity.setTelPhone(cloudContext.getVo().getTelPhone());
        userEntity.setCompany(cloudContext.getVo().getCompany());
        Date date = new Date();
        userEntity.setAddTime(date);
        userEntity.setStatus(Constant.USER_NORMAL_STATE);
        userEntity.setPassword("-");
        userDAO.insert(userEntity);
        cloudContext.addSuccessMsg("操作成功");
    }

    /**
     * 验证邮箱是否被使用
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void findByEmail(CloudContext<UserVO> cloudContext) throws SQLException {
        String email = cloudContext.getVo().getEmail();
        UserEntity userEntity = userDAO.findUserByEmail(email);
        cloudContext.addParam("emailExist", userEntity != null);
    }

    /**
     * 重置密码（邮件发送重置连接）
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void addResetPassword(CloudContext<UserVO> cloudContext) throws SQLException {
        String checkCode = cloudContext.getStringParam("checkCode");
        // 验证码
        String verifyCode = cloudContext.getStringParam(Constant.VERIFY_CODE);
        if (!checkCode.equals(verifyCode)) {
            cloudContext.addErrorMsg("验证码错误");
            return;
        }
        String email = cloudContext.getVo().getEmail();
        UserEntity userEntity = userDAO.findUserByEmail(email);
        if (userEntity == null) {
            cloudContext.addErrorMsg("该邮箱未注册用户");
            return;
        }
        try {
            if (WebserviceUtil.validUsernameExist(userEntity.getUsername())) {
                cloudContext.addErrorMsg("您是校园卡用户，重置密码请到大学城网站重置");
                return;
            }
        } catch (AxisFault e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("服务器连接失败：" + e.getMessage());
            return;
        }
        // 邮件发送 密码重置
        String key = UUID.randomUUID().toString();
        ResetUserPasswordEntity rupe = new ResetUserPasswordEntity();
        rupe.setKey(key);
        rupe.setUser(userEntity);
        rupe.setAddDate(new Date());
        resetUserPasswordDAO.insert(rupe);
        String basePath = cloudContext.getStringParam("basePath");
        String enableTime = PropertyManager.getInstance().getDbProperty(
                        PropertyManager.DB_RESET_USER_PASSWORD_EMAIL_INVALID_TIME, true);
        MailUtil
                        .sendMail(
                                        "大学城开放实验室服务平台用户找回密码",
                                        String
                                                        .format(
                                                                        "%1$s您好，您大学城开放实验室服务平台帐号：%2$s密码找回成功，请点击下面的密码修改按钮设置新密码 \r\n <br><br><center><a target='_blank' href='%3$s'><b>密码修改</b></a></center> <br>\r\n 或者复制下面的连接地址在浏览器中打开：<br><a href='%3$s' target='_blank'>%3$s</a> <br>\r\n 邮件%4$s小时内有效",
                                                                        userEntity.getRealname(),
                                                                        userEntity.getUsername(),
                                                                        basePath
                                                                                        + "userManager/user!initUpdateResetPassword.action?cloudContext.params.key="
                                                                                        + key, enableTime), email, true);
    }

    public void initUpdateResetPassword(CloudContext<UserVO> cloudContext) throws SQLException {
        String key = cloudContext.getStringParam("key");
        ResetUserPasswordEntity rupe = resetUserPasswordDAO.findByKey(key);
        if (rupe == null) {
            cloudContext.addErrorMsg("链接已失效，请重新找回");
            return;
        }
        BeanUtils.copyProperties(rupe.getUser(), cloudContext.getVo());
    }

    /**
     * 密码重置
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void updateResetPassword(CloudContext<UserVO> cloudContext) throws SQLException {
        String key = cloudContext.getStringParam("key");
        ResetUserPasswordEntity rupe = resetUserPasswordDAO.findByKey(key);
        if (rupe == null) {
            cloudContext.addErrorMsg("链接已失效，请重新找回");
            return;
        }
        UserEntity user = rupe.getUser();
        String newPwd = cloudContext.getVo().getPassword();
        String md5pwd = StringUtil.encrypt(user.getUsername(), newPwd);
        user.setPassword(md5pwd);
        userDAO.update(user);
        resetUserPasswordDAO.delete(rupe);
        cloudContext.addSuccessMsg("修改成功");
    }

    /**
     * 个人中心
     * 
     * @param cloudContext
     * @throws SQLException
     * @throws BeansException
     */
    public void center(CloudContext<UserVO> cloudContext) throws BeansException, SQLException {
        LoginedUser loginedUser = cloudContext.getLoginedUser();
        if (loginedUser == null) {
            cloudContext.addErrorMsg("您还未登录，请先登录");
            return;
        }
        UserEntity user = userDAO.findUserById(loginedUser.getId());
        BeanUtils.copyProperties(user, cloudContext.getVo());
        cloudContext.getVo().setHeadPic(
                        "userManager/user!showPic.action?cloudContext.params.headpic="
                                        + cloudContext.getVo().getHeadPic());
    }

    /**
     * 个人中心修改
     * 
     * @param cloudContext
     * @throws SQLException
     */
    public void updateCenter(CloudContext<UserVO> cloudContext) throws SQLException {
        // 通过id从数据库判断是否有该用户
        UserEntity userEntity = userDAO.get(cloudContext.getVo().getId());
        if (userEntity == null) {
            cloudContext.addErrorMsg("用户不存在，请刷新重试");
            return;
        }
        cloudContext.addParam("oldPic", userEntity.getHeadPic());
        if (cloudContext.getVo().getHeadPic() != null) {
            userEntity.setHeadPic(cloudContext.getVo().getHeadPic());
        }
        userEntity.setSex(cloudContext.getVo().getSex());
        userEntity.setAddr(cloudContext.getVo().getAddr());
        userEntity.setCompany(cloudContext.getVo().getCompany());
        userEntity.setEmail(cloudContext.getVo().getEmail());
        userEntity.setRealname(cloudContext.getVo().getRealname());
        userEntity.setMobilePhone(cloudContext.getVo().getMobilePhone());
        userEntity.setTelPhone(cloudContext.getVo().getTelPhone());
        userDAO.insert(userEntity);
        BeanUtils.copyProperties(userEntity, cloudContext.getVo());
        cloudContext.addSuccessMsg("更新成功");
    }

    public void updatePassword(CloudContext<UserVO> cloudContext) throws SQLException {
        System.out.println(cloudContext.getStringParam("xpass"));
        System.out.println(cloudContext.getStringParam("cfpass"));
        Long id = ((LoginedUser) ServletActionContext.getRequest().getSession().getAttribute(Constant.LOGINED_USER))
                        .getId();
        if (id == null) {
            cloudContext.addErrorMsg("用户未登录，或登录超时，请重新登录");
            return;
        }
        UserEntity user = userDAO.get(id);
        if (user == null) {
            cloudContext.addErrorMsg("用户不存在");
            return;
        }
        if (!cloudContext.getStringParam("xpass").equals(cloudContext.getStringParam("cfpass"))) {
            cloudContext.addErrorMsg("两次密码输入不一致");
            return;
        }
        if (!user.getPassword().equals(StringUtil.encrypt(user.getUsername(), cloudContext.getStringParam("ypass")))) {
            BeanUtils.copyProperties(user, cloudContext.getVo());
            cloudContext.addErrorMsg("原密码错误");
            return;
        }
        user.setPassword(StringUtil.encrypt(user.getUsername(), cloudContext.getStringParam("xpass")));
        userDAO.update(user);
        cloudContext.addSuccessMsg("密码修改成功");
    }
}
