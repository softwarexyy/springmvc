package com.yancy.service;

import java.util.UUID;

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
	
	/**
	 * 用户注册
	 */
	public boolean register(String username, String password) {
		System.out.println(" ==== 新增一条用户  ==== ");
		User userSelect = getUserByName(username);
		if (userSelect != null) {
			System.out.println(" --- 注册的用户已存在 --- ");
			return false;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		String userid = UUID.randomUUID().toString().replaceAll("-",""); // 利用uuid生成不重复id
		user.setUserid(userid);
		mapper.insertUser(user);
		
		return true;
	}
}
