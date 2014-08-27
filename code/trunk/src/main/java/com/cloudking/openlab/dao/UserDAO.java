/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.cloudking.openlab.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.entity.UserEntity;
import com.cloudking.openlab.util.Constant;

/**
 * @author CloudKing
 */
@Repository("userDAO")
public final class UserDAO extends BaseDAO<UserEntity> {
    /**
     * 通过用户名获取用户 有就返回true
     * 
     * @param username
     * @return
     * @throws SQLException
     *             sql exc
     */
    public UserEntity findUserByUsername(String username) throws SQLException {
        return uniqueResult("select u_  from UserEntity   u_  where u_.username=:username", "username", username);
    }

    /**
     * 根据用户名和密码查询用户
     * 
     * @param username
     *            用户名
     * @param password
     *            md5加密密码
     * @return 当前登录用户
     * @throws SQLException
     *             sql异常
     */
    @SuppressWarnings("unchecked")
    public UserEntity findUserByUsernameAndPassword(String username, String password) throws SQLException {
        return uniqueResult(
                        " select u  from UserEntity u where u.username=:username and u.password=:password and u.status!=:status ",
                        new String[] { "username", "password","status" }, new Object[] { username, password,Constant.USER_DELETE_STATE });
    }

    public UserEntity findUserByEmail(String email) throws SQLException {
       return uniqueResult(" select u  from UserEntity   u  where u.email=:email  ", "email", email);
    }
    public UserEntity findUserById(Long id)throws SQLException{
    	  return uniqueResult(" select u  from UserEntity   u  where u.id=:id  ", "id", id);
    }

}
