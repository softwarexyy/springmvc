package com.yancy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yancy.model.User;
import com.yancy.service.UserServiceImpl;

public class TestUserService {
	public static void main(String []args) {
		UserServiceImpl userv;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userv = ctx.getBean(UserServiceImpl.class);
		
		User user = userv.getUserByName("yancy");
		System.out.println(" === You have get: " + user + " === ");
	}
}
