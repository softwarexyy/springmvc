package com.yancy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yancy.mapper.UserMapper;
import com.yancy.model.*;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;	//初始化数据库操作对象

	/**
	 * 根据用户名获取用户信息
	 */
	public User getUserByName(String name) {
		return mapper.selectOneUserByName(name);
	}

	/**
	 * 用户登录，传入前端输入的username和password，验证二者是否符合
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 符合返回true
	 */
	public boolean login(String username, String password) {
		User user = mapper.selectOneUserByName(username);
		if (user == null || !password.equals(user.getPassword()))
			return false;
		else
			return true;
	}
}
