package com.yancy.service;

import com.yancy.model.User;

/**
 * service接口
 * @author Yancy
 *
 */
public interface UserService {

	/**
	 * 根据用户名获取用户信息
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return 
	 */
	public boolean login(String username, String password);
	
	/**
	 * 注册用户
	 * @param username
	 * @param password
	 */
	public boolean register(String username, String password);
}
