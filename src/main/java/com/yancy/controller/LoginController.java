/**
 * ��������
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

	@RequestMapping(value = "/welcome")
	public String hello() {
		System.out.println(" --- ���ο͵�½ --- ");
		return "welcome"; // ��ʵ�ǰ�springmvc.xml�����ļ��е�ǰ��׺����һ�� ��"/hello.html"
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
	public String login(User model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println(" --- �л�Ա���е�¼����... --- ");

		// ���ֻ�ȡҳ��������ݵķ�ʽ��
		System.out.println(" --- 1ǰ�˴�����û�����---" + model.getUsername());
		System.out.println(" --- 1ǰ�˴�����û�����---" + request.getParameter("username"));
		String usernameForm = model.getUsername();
		String passwordForm = model.getPassword();

		/*********************************
		 * �������ݿ��ѯ���� ** ����һ ����ʹ��Spring��mybatis���Ʒ�ת
		 *******************************/
		// SqlSession sqlSession = MybatisUtil.getSession(); // ��ʼ��sqlSession
		// UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// // ����User����
		// User user = userMapper.selectOneUserByName(usernameForm); //�����ݿ��ȡ���û���¼
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
		// return "redirect:/ycylogin.html"; // redirect��ˢ������Ļ��ۣ������һ�����������ڵڶ�������ǰ
		// }

		/*********************************
		 * �������ݿ��ѯ���� ** ������ ��Spring + mybatis, �Լ��ֶ�����UserService����,����Service�㷽��
		 *******************************/
//		UserService userv;
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userv = ctx.getBean(UserService.class);
//		boolean loginSuccess = userv.login(usernameForm, passwordForm);
//		System.out.println(" === ���û��Ƿ���֤ͨ�� �� " + loginSuccess);
//		return (loginSuccess == true) ? "homePage" : "redirect:/ycylogin.html";
		

		/*********************************
		 * �������ݿ��ѯ���� ** ������ ��Spring + mybatis, ������ע��"@Resource"�Զ�����UserService����
		 *******************************/
		boolean loginSuccess = userservice.login(usernameForm, passwordForm);
		System.out.println(" === ���û��Ƿ���֤ͨ�� �� " + loginSuccess);
		return (loginSuccess == true) ? "homePage2" : "redirect:/index.html";

	}
}