package com.yancy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yancy.mapper.AccInfoMapper;
import com.yancy.mapper.UserMapper;
import com.yancy.model.AccInfo;

/**
 * 账号信息服务实现类
 * @author Yancy
 *
 */
@Service
public class AccInfoServiceImpl implements AccInfoService {

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private AccInfoMapper accMapper;
	
	@Override
	public List<String> getSubAcc(String username) {
		// 根据用户名查询ID
		String userid = userMapper.selectUidByName(username);
		List<String> accList = new ArrayList<String>();
		accList = accMapper.getSubAccount(userid);
		return accList;
	}
}
