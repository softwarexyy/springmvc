<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
<body>
	又见到你咯~${sessionScope.username}，新年快乐！<br/><br/><br/>
	这是您在本网站的个人信息：<br/>
	性别: ${sessionScope.userinfo.gender}<br/>
	生日: ${sessionScope.userinfo.birthday}<br/>
	登录次数: ${sessionScope.userinfo.loginTime}<br/>
	上次登录时间: ${sessionScope.userinfo.lastLoginTime}<br/>
</body>
</html>