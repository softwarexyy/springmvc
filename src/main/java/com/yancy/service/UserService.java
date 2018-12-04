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
	 * 用户登录验证
	 * @param username
	 * @param password
	 * @return 验证通过返回true
	 */
	public boolean login(String username, String password);
}
