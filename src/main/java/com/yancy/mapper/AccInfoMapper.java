package com.yancy.mapper;

import java.util.List;

import com.yancy.model.AccInfo;

/**
 * 数据库层操作接口
 * @author Yancy
 *
 */
public interface AccInfoMapper {

	public AccInfo getAccInfoDetail(String userid, String account);	//获取账号详细信息
	
	public List<String> getSubAccount(String userid);	//获取用户下挂账号
}
