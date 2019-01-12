package com.yancy.mapper;

import com.yancy.model.AccInfo;

/**
 * 数据库层操作接口
 * @author Yancy
 *
 */
public interface AccInfoMapper {

	public AccInfo getAccInfoByID(String userid);
}
