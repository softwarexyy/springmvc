package com.yancy.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yancy.model.User;

/**
 * showAccount.jsp页面跳转至 我的账户 控制器
 * 
 * @author Yancy
 *
 */
@Controller
public class showAccountController {

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
	 * TODO: 返回用户下挂账号
	 * @return 下挂账号的list列表
	 */
	@RequestMapping(value = "/getSubAccount", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<String> getSubAccount() {
		System.out.println("ArrayList requestmapping");
		ArrayList<String> list = new ArrayList<String>();
		list.add("6524 8546 8797 4564 556");
		list.add("6524 8546 8797 4564 789");
		return list;
	}
}
