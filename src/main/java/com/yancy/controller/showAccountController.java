package com.yancy.controller;

import java.io.IOException;
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
import com.yancy.model.User;
import com.yancy.service.AccInfoService;

/**
 * showAccount.jsp页面跳转至 我的账户 控制器
 * 
 * @author Yancy
 *
 */
@Controller
public class showAccountController {

	@Resource
	private AccInfoService accInfoService;
	
	@RequestMapping(value = "/showAccount", method = RequestMethod.POST)
	public void showAccount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String username = request.getParameter("username");
		System.out.println("showAccount传入的用户名：" + username);
		// 返回json数据
		response.setContentType("application/json");
		try {
			response.getWriter().println("{\"result\":\"success\"}"); // 拼装json报文
		} catch (IOException e) {
			System.out.println(" ===== 返回response失败 ==== ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询用户下挂账户
	 * @return 下挂账号的list列表
	 */
	@RequestMapping(value = "/getSubAccount", method = RequestMethod.POST)
	@ResponseBody
	public List<String> getSubAccount(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		list = accInfoService.getSubAcc(request.getParameter("username"));
		
		return list;
	}
	
	/**
	 * 查询某账号详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/qrySubAccountInfo", method = RequestMethod.POST)
	@ResponseBody
	public AccInfo qrySubAccountInfo(HttpServletRequest request) {
		AccInfo accInfo = new AccInfo();
		accInfo = accInfoService.getAccInfoDetail(request.getParameter("account"));
		return accInfo;
	}
}
