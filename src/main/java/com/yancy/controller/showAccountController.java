package com.yancy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * homepage.jsp页面跳转至 我的账户 控制器
 * 
 * @author Yancy
 *
 */
@Controller
public class showAccountController {

	@RequestMapping(value = "/showAccount", method = RequestMethod.POST)
	public void toAccountPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
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
}
