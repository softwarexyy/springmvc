package com.yancy.service;

import java.util.List;

import com.yancy.model.AccInfo;

/**
 * 账号信息服务
 * @author Yancy
 *
 */
public interface AccInfoService {

	public List<String> getSubAcc(String username);	// 获取下挂账号
	
	public AccInfo getAccInfoDetail(String account);	// 查询单条账号的详细信息
}
