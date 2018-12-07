package com.yancy.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yancy.mapper.UserMapper;
import com.yancy.model.*;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;	//��ʼ�����ݿ��������

	/**
	 * 根据用户名查询用户
	 */
	public User getUserByName(String name) {
		return mapper.selectOneUserByName(name);
	}

	/**
	 * 根据username和password做登录判断
	 * 
	 * @param username
	 * @param password
	 * @return true/false
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
		User userSelect = getUserByName(username);
		if (userSelect != null) {
			System.out.println(" --- 用户已存在 --- ");
			return false;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		String userid = UUID.randomUUID().toString().replaceAll("-",""); // 根据uuid生成唯一的userid
		user.setUserid(userid);
		mapper.insertUser(user);
		
		return true;
	}
}
