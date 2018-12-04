/**
 * 控制器类
 */
package com.yancy.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
		System.out.println(" --- 有游客登陆 --- ");
		return "register"; // 其实是把springmvc.xml配置文件中的前后缀连在一起 即"/hello.html"
	}

	/**
	 * 用户登录
	 * 
	 * @param model
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println(" --- 有会员进行登录操作... --- ");

		// 两种获取页面表单数据的方式：
		System.out.println(" --- 1前端传入的用户名：---" + model.getUsername());
		System.out.println(" --- 1前端传入的用户名：---" + request.getParameter("username"));
		String usernameForm = model.getUsername();
		String passwordForm = model.getPassword();

		/*********************************
		 * 进行数据库查询操作 ** 方法一 ：不使用Spring对mybatis控制反转
		 *******************************/
		// SqlSession sqlSession = MybatisUtil.getSession(); // 初始化sqlSession
		// UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// // 创建User对象
		// User user = userMapper.selectOneUserByName(usernameForm); //从数据库读取的用户记录
		// MybatisUtil.closeSession();
		//
		// if (user == null) {
		// System.out.println(" --- 登录用户不存在 --- ");
		// }
		// System.out.println(" --- 查询到的对象：" + user + " --- ");
		// if (user != null && user.getPassword().equals(passwordForm)) {
		// httpSession.setAttribute("username", usernameForm);
		// return "homePage";
		// } else {
		// return "redirect:/ycylogin.html"; // redirect是刷新请求的积累，否则第一个请求会积累在第二个请求前
		// }

		/*********************************
		 * 进行数据库查询操作 ** 方法二 ：Spring + mybatis, 自己手动创建UserService对象,调用Service层方法
		 *******************************/
		// UserService userv;
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// userv = ctx.getBean(UserService.class);
		// boolean loginSuccess = userv.login(usernameForm, passwordForm);
		// System.out.println(" === 该用户是否验证通过 ： " + loginSuccess);
		// return (loginSuccess == true) ? "homePage" : "redirect:/ycylogin.html";

		/*********************************
		 * 进行数据库查询操作 ** 方法三 ：Spring + mybatis, 不过由注解"@Resource"自动生成UserService对象
		 *******************************/
		boolean loginSuccess = userservice.login(usernameForm, passwordForm);
		System.out.println(" === 该用户是否验证通过 ： " + loginSuccess);
		return (loginSuccess == true) ? "homePage2" : "redirect:/index.html";

	}

	/**
	 * 从前端接收请求，实现用户注册功能
	 * 
	 * @param model
	 *            前端传递模型
	 * @param request
	 *            前端传递请求
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("--------------- 调用用户注册功能 -------------");
		String username = model.getUsername();
		String password = model.getPassword();
		boolean registerSuccess = userservice.register(username, password); // 调用service层注册方法
		return (registerSuccess == true) ? "registerSuccess" : "registerFail";
	}
}
