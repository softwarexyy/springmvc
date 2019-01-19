package com.yancy.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yancy.model.AccInfo;
import com.yancy.model.TransRecord;
import com.yancy.model.User;
import com.yancy.service.AccInfoService;
import com.yancy.service.TransRecordService;

/**
 * showBill.jsp页面中跳转的控制器
 * 
 * @author Yancy
 *
 */
@Controller
public class showBillController {

	@Resource
	private TransRecordService trService;

	/**
	 * 查询用户下挂账户
	 * 
	 * @return 下挂账号的list列表
	 */
	@RequestMapping(value = "/showBill", method = RequestMethod.POST)
	@ResponseBody
	public List<TransRecord> getBill(String userid, String startTime, String endTime, int pageStart, int pageQty) {
		System.out.println("showbill controller: " + userid + " " + startTime + " " + endTime + " " + pageStart + " " + pageQty);
		List<TransRecord> billList = trService.getTransRecordByTimeAndPage(userid, startTime, endTime, pageStart, pageQty);

		return billList;
	}
}
