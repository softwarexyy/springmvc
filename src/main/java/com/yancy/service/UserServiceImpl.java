package com.yancy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yancy.mapper.UserInfoMapper;
import com.yancy.mapper.UserMapper;
import com.yancy.model.*;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper; // 生成mapper对象

	@Resource
	private UserInfoMapper uinfoMapper;

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
		String userid = UUID.randomUUID().toString().replaceAll("-", ""); // 根据uuid生成唯一的userid
		user.setUserid(userid);
		mapper.insertUser(user);

		return true;
	}

	/**
	 * 登录之后相关操作(1:返回当前用户信息；2:刷新用户登录次数和上次登录时间)
	 */
	public UserInfo doAfterLogin(String username) {
		UserInfo userInfo = new UserInfo();
		// 查询用户信息
		try {
			userInfo = uinfoMapper.qryUserInfoByName(username);
			if (userInfo == null) {
				System.out.println(" +++++++ " + "用户信息查询结果为空" + "+++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 刷新用户登录次数
		int loginTime = userInfo.getLoginTime();
		uinfoMapper.updateLoginTime(loginTime + 1, username);
		
		// 刷新用户登录时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newLastLoginTime = sdf.format(date);
		uinfoMapper.updateLastLoginTime(newLastLoginTime, username);
		
		return userInfo;
	}

	@Override
	public void updateBirthday(String birthday, String username) {
		uinfoMapper.updateBirthday(birthday, username);
	}

	@Override
	public void updateGender(String gender, String username) {
		uinfoMapper.updateGender(gender, username);
	}

	@Override
	public UserInfo qryUserInfo(String username) {
		UserInfo uinfo = uinfoMapper.qryUserInfoByName(username);
		return uinfo;
	}

}
