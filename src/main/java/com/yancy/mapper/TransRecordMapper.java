package com.yancy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yancy.model.TransRecord;

/**
 * 操作交易流水表to_bill接口
 * 
 * @author Yancy
 *
 */
public interface TransRecordMapper {

	/**
	 * 根据时间和条数查询交易记录
	 * 
	 * @param startTime
	 *            查询起始时间
	 * @param endTime
	 *            结束时间
	 * @param pageStart
	 *            起始位置
	 * @param pageQty
	 *            条数
	 * @return 交易记录的List列表
	 */
	public List<TransRecord> getTransRecordByTimeAndPage(@Param("userid") String userid,
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime, 
			@Param("pageStart") int pageStart,
			@Param("pageQty") int pageQty);
}
