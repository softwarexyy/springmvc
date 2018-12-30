/**
 * ��������
 */
package com.yancy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yancy.mapper.UserMapper;
import com.yancy.model.User;
import com.yancy.service.UserService;
import com.yancy.util.MybatisUtil;

/**
 * @author Yancy
 *
 */
@Controller
@RequestMapping(value = "/app")
public class LoginController {

	@Resource
	private UserService userservice;

	@RequestMapping(value = "/welcome1")
	public String hello1() {
		System.out.println(" --- 进入注册页 --- ");
		return "register";
	}

	/**
	 * �û���¼
	 * 
	 * @param model
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User model, HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
		System.out.println(" --- �л�Ա���е�¼����... --- ");

		// ���ֻ�ȡҳ������ݵķ�ʽ��
		System.out.println(" --- 1ǰ�˴�����û�����---" + model.getUsername());
		System.out.println(" --- 1ǰ�˴�����û�����---" + request.getParameter("username"));
		String usernameForm = model.getUsername();
		String passwordForm = model.getPassword();

		/*********************************
		 * 单纯用mybatis，没有使用spring
		 *******************************/
		// SqlSession sqlSession = MybatisUtil.getSession(); // 生成mybatis的sqlSession
		// UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// // ����User����
		// User user = userMapper.selectOneUserByName(usernameForm); //直接操作mybatis数据层
		// MybatisUtil.closeSession();
		//
		// if (user == null) {
		// System.out.println(" --- ��¼�û������� --- ");
		// }
		// System.out.println(" --- ��ѯ���Ķ���" + user + " --- ");
		// if (user != null && user.getPassword().equals(passwordForm)) {
		// httpSession.setAttribute("username", usernameForm);
		// return "homePage";
		// } else {
		// return "redirect:/ycylogin.html"; // redirect重定向到登录页
		// }

		/*********************************
		 * Spring + mybatis, 非注解方式生成userservice对象
		 *******************************/
		// UserService userv;
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// userv = ctx.getBean(UserService.class);
		// boolean loginSuccess = userv.login(usernameForm, passwordForm);
		// return (loginSuccess == true) ? "homePage" : "redirect:/ycylogin.html";

		/*********************************
		 * Spring + mybatis,使用"@Resource"注解方式生成UserService对象
		 *******************************/
		boolean loginSuccess = userservice.login(usernameForm, passwordForm);
		return (loginSuccess == true) ? "homePage2" : "redirect:/index.html";

	}

	/**
	 * 实现注册功能
	 * 
	 * @param model
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("--------------- 开始注册 -------------");
		String username = model.getUsername();
		String password = model.getPassword();
		boolean registerSuccess = userservice.register(username, password);
		System.out.println("--------------- 注册成功了吗？ -------" + registerSuccess);
		return (registerSuccess == true) ? "registerSuccess" : "registerFail";
	}

	/**
	 * 前端传入json数据，验证密码是否正确
	 * @param request 前端请求
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public void loginCheck(HttpServletRequest request, HttpServletResponse response) {
		// 用ajax传入的json数据
		System.out.println(" --- ajax传入的数据---" + request.getParameter("username"));
		System.out.println(" --- ajax传入的数据---" + request.getParameter("password"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean loginSuccess = userservice.login(username, password); // 验证登录密码
		System.out.println("===== loginSuccess? ====" + loginSuccess);

		// 返回json数据
		response.setContentType("application/json");
		try {
			if (loginSuccess == true) {
				response.getWriter().println("{\"result\":\"success\"}");	//拼装json报文
			}else {
				response.getWriter().println("{\"result\":\"fail\"}");
			}
		} catch (IOException e) {
			System.out.println(" ===== 返回response失败 ==== ");
			e.printStackTrace();
		}
	}
	/**
	 * 利用post提交表单跳转到homepage
	 * @param request 前端请求
	 * @param httpSession
	 * @return homepage
	 */
	@RequestMapping(value = "/loginToHomepage", method = RequestMethod.POST)
	public String processAjax(HttpServletRequest request, HttpServletResponse response) {
		// 前端ajax传入的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(" --- 收到登录用户 ---" + username);
		System.out.println(" --- 登录密码 ---" + password);
		
		try {
			response.getWriter().println("{\"result\":\"success\"}");	//拼装json数据返回给ajax
		} catch (IOException e) {
			System.out.println(" --- 返回response失败 --- ");
			e.printStackTrace();
		}
		
		return "homepage";
	}
	
}
