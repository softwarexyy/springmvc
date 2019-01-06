package com.yancy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yancy.model.UserInfo;
import com.yancy.service.UserService;

/**
 * 修改用户信息的Controller
 * @author Yancy
 *
 */
@Controller
public class modifyUserInfoController {
	@Resource
	private UserService userservice;
	
	@RequestMapping(value = "/modifyUserInfo")
	public String modifyUserInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		
		userservice.updateBirthday(birthday, username);
		userservice.updateGender(gender, username);
		
		UserInfo userInfo = userservice.qryUserInfo(username);
		session.setAttribute("userinfo", userInfo);	//改变session中的用户信息
		return "modifyUserInfoSuccess";	// 返回到 modifyUserInfoSuccess.jsp 页面
	}
}
