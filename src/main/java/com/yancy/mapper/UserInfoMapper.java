package com.yancy.mapper;

import com.yancy.model.UserInfo;

/**
 * 查询用户个人信息的CRUD
 * @author Yancy
 *
 */
public interface UserInfoMapper {
	public UserInfo qryUserInfoByName(String username);	//查询个人信息
	public void updateLoginTime(int newLoginTime, String username);	// 更新用户登录次数
	public void updateLastLoginTime(String newLastLoginTime, String username);	// 更新上次登录时间
}
