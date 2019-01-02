<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/springmvc/js/homepage.js"></script>
<title>欢迎</title>
</head>
<body>
	您好, ${sessionScope.username} !<br/><br/><br/>
	欢迎来到本行。这是您第 ${sessionScope.userinfo.loginTime} 次来到本行，上次登录时间: ${sessionScope.userinfo.lastLoginTime}

	<br />
	<a href="#"><img src="/springmvc/images/personalInfo.png" onclick="maintainPersonInfo()" /></a>
	<a href="#"><img src="/springmvc/images/myAccount.png" onclick="showAccount()" /></a>
		
	<br />
	<a href="#"><img src="/springmvc/images/myBills.png" onclick="showBills()" /></a>
	<a href="#"><img src="/springmvc/images/transferMoney.png" onclick="transferMoney()" /></a>
</body>
</html>