package com.yancy.service;

import java.util.List;

import com.yancy.model.TransRecord;

/**
 * 交易记录操作接口
 * @author Yancy
 *
 */
public interface TransRecordService {
	
	/**
	 * 获取交易记录
	 * @param startTime
	 * @param endTime
	 * @param pageStart
	 * @param pageQty
	 * @return
	 */
	List<TransRecord> getTransRecordByTimeAndPage(String userid, String startTime, String endTime, int pageStart, int pageQty);
}
