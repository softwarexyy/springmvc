package com.yancy.service;

import com.yancy.model.User;
import com.yancy.model.UserInfo;

/**
 * service接口
 * @author Yancy
 *
 */
public interface UserService {

	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * 登录֤
	 * @param username
	 * @param password
	 * @return 
	 */
	public boolean login(String username, String password);
	
	/**
	 * 注册
	 * @param username
	 * @param password
	 */
	public boolean register(String username, String password);
	
	/**
	 * 登录之后相关操作(1:返回当前用户信息；2:刷新用户登录次数和上次登录时间)
	 * @param username
	 * @return
	 */
	public UserInfo doAfterLogin(String username);
}
