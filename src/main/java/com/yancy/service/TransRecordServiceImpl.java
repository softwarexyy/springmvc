package com.yancy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yancy.mapper.TransRecordMapper;
import com.yancy.model.TransRecord;

@Service
public class TransRecordServiceImpl implements TransRecordService {

	@Resource
	TransRecordMapper trMapper;
	
	@Override
	public List<TransRecord> getTransRecordByTimeAndPage(String startTime, String endTime, int pageStart, int pageQty) {
		List<TransRecord> transRecords = new ArrayList<TransRecord>();
		transRecords = trMapper.getTransRecordByTimeAndPage(startTime, endTime, pageStart, pageQty);
		return transRecords;
	}
}
