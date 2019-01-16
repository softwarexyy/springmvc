package com.yancy.mapper;

import java.awt.List;

import com.yancy.model.User;

/**
 * @author Yancy
 *
 */
public interface UserMapper {

	public User selectOneUserById(String id);
	
	public User selectOneUserByName(String username);

	public List selectAllUser();

	public void deleteUser();

	public void insertUser(User user);
	
	public String selectUidByName(String username);	//根据用户名查询ID
}
