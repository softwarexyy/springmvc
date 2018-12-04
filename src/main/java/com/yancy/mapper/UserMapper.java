/**
 *  接口
 */
package com.yancy.mapper;

import java.awt.List;

import com.yancy.model.User;

/**
 * @author Yancy
 *
 */
public interface UserMapper {

	public User selectOneUser(String id); // 读取一条用户
	
	public User selectOneUserByName(String username);	// 根据用户名查询用户

	public List selectAllUser(); // 读取所有用户

	public void deleteUser(); // 删除所有用户

	public void insertUser(User user); // 新增一条用户
}
