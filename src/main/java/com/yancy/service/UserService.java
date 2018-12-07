package com.yancy.service;

import com.yancy.model.User;

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
}
