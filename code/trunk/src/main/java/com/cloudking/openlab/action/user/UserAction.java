/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.cloudking.openlab.action.user;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.LoginedUser;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.service.applyorder.ApplyOrderService;
import com.cloudking.openlab.service.user.UserService;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.util.ProjectUtil;
import com.cloudking.openlab.util.StringUtil;
import com.cloudking.openlab.vo.UserVO;

/**
 * 用户
 * 
 * @author CloudKing
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/userManager")
@Results( {
				@Result(name = "success", type = "dispatcher", location = "/index.jsp"),
				@Result(name = "download", type = "stream", params = { "contentType", "application/octet-stream",
								"inputName", "file", "allowCaching", "false", "encode", "true", "contentDisposition",
								"attachment;filename=%{#request.cloudContext.params.fileName}" }),
				@Result(name = "loginRedirect", type = "redirect", location = "%{#request.cloudContext.params.destPath}"),
				@Result(name = "loginSuccess", type = "redirect", location = "/index.jsp"),
				@Result(name = "login", type = "chain", location = "/indexManager/index!viewIndexContent.action"),
				@Result(name = "logout", type = "redirect", location = "/index.jsp"),
				@Result(name = "resetPassword", type = "dispatcher", location = "/user/reset_password.jsp"),
				@Result(name = "initUpdateResetPassword", type = "dispatcher", location = "/user/reset_password_update.jsp"),
				@Result(name = "resetPasswordSuccess", type = "dispatcher", location = "/user/reset_password_success.jsp"),
				@Result(name = "carduserRegist", type = "dispatcher", location = "/register/carduser_register.jsp"),
				@Result(name = "register", type = "dispatcher", location = "/register/register.jsp"),
				@Result(name = "center", type = "dispatcher", location = "/userCenter/userInfo.jsp") })
public class UserAction extends BaseAction<UserVO> {
	private static final String LOGINSUCCESS = "loginSuccess";
	private static final String LOGINREDIRECT = "loginRedirect";
	private static final String LOGOUT = "logout";
	private static final String REGISTER = "register";
	private static final String CARDUSERREGIST = "carduserRegist";
	private static final String RESETPASSWORD = "resetPassword";
	private static final String RESETPASSWORD_SUCCESS = "resetPasswordSuccess";
	private static final String INIT_UPDATE_RESET_PASSWORD = "initUpdateResetPassword";
	private static final String CENTER = "center";

	/**
	 * userService
	 */
	@Resource
	private UserService userService;
	/**
	 * 登录的用户
	 */
	private LoginedUser loginInfo;

	private InputStream file;

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	/**
	 * base
	 * 
	 * @throws Exception
	 *             exc
	 */
	@Action("/user")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	/**
	 * 查询
	 * 
	 * @throws Exception
	 *             所有不能处理的异常
	 */
	public String query() throws Exception {
		userService.query(cloudContext);
		return JSON;
	}

	/**
	 * 登录
	 * 
	 * @throws Exception
	 *             所有不能处理的异常
	 */
	public String login() throws Exception {

		cloudContext.addParam(Constant.VERIFY_CODE, getSession().getAttribute(Constant.VERIFY_CODE));
		if (StringUtil.isBlank(cloudContext.getVo().getUsername())) {
			cloudContext.addErrorMsg("用户名不能为空");
		}
		if (StringUtil.isBlank(cloudContext.getVo().getPassword())) {
			cloudContext.addErrorMsg("密码不能为空!");
		}
		if (StringUtil.isBlank(cloudContext.getStringParam("checkCode"))) {
			cloudContext.addErrorMsg("验证码不能为空!");
		}
		if (cloudContext.getSuccessIngoreWarn()) {
			userService.login(cloudContext);
			getSession().setAttribute("user", cloudContext.getVo());
			putLoginedUser(cloudContext.getLoginedUser());
		}
		return JSON;
	}

	/**
	 * 登录验证失败后登录
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String validOutLogin() throws SQLException {
		cloudContext.addParam(Constant.VERIFY_CODE, getSession().getAttribute(Constant.VERIFY_CODE));
		if (StringUtil.isBlank(cloudContext.getVo().getUsername())) {
			cloudContext.addErrorMsg("用户名不能为空");
		}
		if (StringUtil.isBlank(cloudContext.getVo().getPassword())) {
			cloudContext.addErrorMsg("密码不能为空!");
		}
		if (StringUtil.isBlank(cloudContext.getStringParam("checkCode"))) {
			cloudContext.addErrorMsg("验证码不能为空!");
		}
		if (cloudContext.getSuccessIngoreWarn()) {
			userService.login(cloudContext);
		}
		if (cloudContext.getSuccessIngoreWarn()) {
			if (cloudContext.getBooleanParam("cardUserNoRegist")) {
				return CARDUSERREGIST;
			}
			putLoginedUser(cloudContext.getLoginedUser());
			String url = cloudContext.getStringParam("path").trim();
			if (!StringUtil.isBlank(url) && !url.equals("null")) {
				cloudContext.addParam("destPath", url.replace(getRequest().getContextPath(), ""));
				return LOGINREDIRECT;
			}
			return LOGINSUCCESS;
		} else {
			getRequest().setAttribute("errorMsg", Arrays.toString(cloudContext.getErrorMsgList().toArray()));
			return LOGIN;
		}
	}

	/**
	 * 登录验证失败后登录
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String ajaxLogin() throws SQLException {
		cloudContext.addParam(Constant.VERIFY_CODE, getSession().getAttribute(Constant.VERIFY_CODE));
		if (StringUtil.isBlank(cloudContext.getVo().getUsername())) {
			cloudContext.addErrorMsg("用户名不能为空");
		}
		if (StringUtil.isBlank(cloudContext.getVo().getPassword())) {
			cloudContext.addErrorMsg("密码不能为空!");
		}
		if (StringUtil.isBlank(cloudContext.getStringParam("checkCode"))) {
			cloudContext.addErrorMsg("验证码不能为空!");
		}
		if (cloudContext.getSuccessIngoreWarn()) {
			userService.login(cloudContext);
		}
		if (cloudContext.getSuccessIngoreWarn()) {
			putLoginedUser(cloudContext.getLoginedUser());
		}
		return JSON;
	}

	/**
	 * 注册
	 * 
	 * @throws Exception
	 *             所有不能处理的异常
	 */
	// @Validations(requiredStrings = { @RequiredStringValidator(type =
	// ValidatorType.SIMPLE, fieldName = "userVO.userEntity.username", message =
	// "用户名必须存在") }, regexFields = { @RegexFieldValidator(type =
	// ValidatorType.SIMPLE, fieldName = "userVO.userEntity.username",
	// expression = "[\\w\\-]{4,12}", message = "用户名必须是4-12的字符") })
	public String register() throws Exception {
		if (!cloudContext.getSuccessIngoreWarn()) {// 表单重复提交了
			return SUCCESS;
		}
		userService.addRegister(cloudContext);
		return REGISTER;
	}

	/**
	 * 校内用户完善个人信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String addUserInfo() throws SQLException {
		userService.addUserInfo(cloudContext);
		return CARDUSERREGIST;
	}

	/**
	 * 注销
	 * 
	 * @throws Exception
	 *             所有不能处理的异常
	 */
	public String logout() throws Exception {
		getSession().invalidate();
		return LOGOUT;
	}

	/**
	 * 用户名验证
	 * 
	 * @return
	 * @throws Exception
	 *             exc
	 */
	public String initRegister() throws Exception {
		userService.initRegister(cloudContext);
		return JSON;
	}

	/**
	 * 验证email是否已被使用
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String findByEmail() throws SQLException {
		userService.findByEmail(cloudContext);
		return JSON;
	}

	/**
	 * 重置密码
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String initResetPassword() throws SQLException {
		if (!cloudContext.getSuccessIngoreWarn()) {// 表单重复提交了
			return RESETPASSWORD_SUCCESS;
		}
		cloudContext.addParam(Constant.VERIFY_CODE, getSession().getAttribute(Constant.VERIFY_CODE));
		HttpServletRequest request = getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
						+ "/";
		cloudContext.addParam("basePath", basePath);
		userService.addResetPassword(cloudContext);
		return cloudContext.getSuccessIngoreWarn() ? RESETPASSWORD_SUCCESS : RESETPASSWORD;
	}

	/**
	 * 个人中心修改
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String updateCenter() throws SQLException {
		String realname = null;
		// 得到文件名
		String fileName = imageFileName;
		if (fileName != null) {
			String suffix = fileName.substring(fileName.lastIndexOf("."));// 得到后缀
			realname = UUID.randomUUID().toString() + suffix;
			String errorMsg = uploadHeadPicToServer(image, realname, cloudContext.getStringParam("oldPic"));
			cloudContext.getVo().setHeadPic(realname);
			if (!StringUtil.isBlank(errorMsg)) {
				cloudContext.addErrorMsg(errorMsg);
			}
		}
		userService.updateCenter(cloudContext);
		userService.center(cloudContext);
		return CENTER;
	}

	/**
	 * post上传头像
	 * 
	 * @param headPic
	 * @param picName
	 * @param oldPic
	 * @return
	 */
	private String uploadHeadPicToServer(File headPic, String picName, String oldPic) {
		try {
			String managerHost = PropertyManager.getInstance().getXMLProperty(
							PropertyManager.XML_OPENLAB_COREMANAGER_HOST);
			String uploadHeadPicAction = managerHost + "/userManager/user!uploadHeadPic.action";
			String BOUNDARY = Long.toHexString(System.currentTimeMillis());// 定义数据分隔线
			URL url = new URL(uploadHeadPicAction);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			OutputStream out = new DataOutputStream(conn.getOutputStream());
			byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
			StringBuilder sb = new StringBuilder();
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data; name=\"cloudContext.params.oldHeadPicName\"\r\n\r\n");
			sb.append(oldPic + "\r\n");
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data;name=\"cloudContext.params.headPic\";filename=\"" + picName
							+ "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");
			byte[] data = sb.toString().getBytes("UTF-8");
			out.write(data);
			DataInputStream in = new DataInputStream(new FileInputStream(headPic));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			out.write("\r\n".getBytes()); //多个文件时，二个文件之间加入这个
			in.close();
			out.write(end_data);
			out.flush();
			out.close();
			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			String res = "";
			while ((line = reader.readLine()) != null) {
				res += line;
			}
			return res;
		} catch (Exception e) {
			return "服务器连接异常！" + e.getMessage();
		}
	}

	/**
	 * 个人中心密码修改
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String updatePassword() throws SQLException {
		userService.updatePassword(cloudContext);
		return JSON;
	}

	public String center() throws SQLException {
		userService.center(cloudContext);
		return CENTER;
	}

	/**
	 * 
	 * @return
	 */
	public String showPic() {
		String headpic = cloudContext.getStringParam("headpic");
		if (StringUtil.isBlank(headpic) || "null".equals(headpic)) {
			headpic = PropertyManager.getInstance().getDbProperty(PropertyManager.DB_USER_DEFAULT_HEAD_PIC);
		}
		String defaultPic = PropertyManager.getInstance().getDbProperty(PropertyManager.DB_USER_DEFAULT_HEAD_PIC);
		File picFile = new File(ProjectUtil.getHeadPic(), StringUtil.isBlank(headpic) ? defaultPic : headpic);
		if (!picFile.exists()) {
			synchronized (this) {
				String url = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_OPENLAB_COREMANAGER_HOST)
								+ "/userManager/user!showPic.action?cloudContext.params.headpic=" + headpic;
				HttpURLConnection conn = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestProperty("http.keepAlive", "false");
					is = conn.getInputStream();
					os = new FileOutputStream(picFile);
					IOUtils.copy(is, os);
				} catch (MalformedURLException e) {
				} catch (IOException e) {
				} finally {
					if (conn != null)
						conn.disconnect();
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(os);
				}
			}
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(picFile);
			os = getResponse().getOutputStream();
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String initUpdateResetPassword() throws SQLException {
		userService.initUpdateResetPassword(cloudContext);
		return INIT_UPDATE_RESET_PASSWORD;
	}

	public String resetPassword() throws SQLException {
		userService.updateResetPassword(cloudContext);
		return INIT_UPDATE_RESET_PASSWORD;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LoginedUser getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginedUser loginInfo) {
		this.loginInfo = loginInfo;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
