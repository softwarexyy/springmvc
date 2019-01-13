<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/springmvc/js/homepage.js"></script>
<script type="text/javascript" src="/springmvc/js/jquery.min.js"></script>
<title>LGP BANK</title>
</head>
<body>
	<div id="titleLogo" align="left">
		<img src="/springmvc/images/titleLogo.png" width="1165" height="85" />
	</div>
	<div id="text" align="left">
		您好, ${sessionScope.username} !<br/>
		欢迎来到本行。这是您第 ${sessionScope.userinfo.loginTime} 次来到本行，上次登录时间: ${sessionScope.userinfo.lastLoginTime}
		<br/>
	</div>

	<div id="buttonTable" align="left">
		<table width="800" border="0">
	  		<tr>
	    		<td height="80"><a href="/springmvc/personalInfo.jsp"><img src="/springmvc/images/personalInfo.png" width="231" height="37" /></a></td>
	    		<td><a href="/springmvc/showAccount.jsp"><img src="/springmvc/images/myAccount.png" width="231" height="37" /></a></td>
      		</tr>
	  		<tr>
	    		<td height="80"><a href="#"><img src="/springmvc/images/myBills.png" width="231" height="37" onclick="showBills()" /></a></td>
	    		<td><a href="#"><img src="/springmvc/images/transferMoney.png" width="231" height="37" onclick="transferMoney()" /></a></td>
      		</tr>
		</table>
	</div>
</body>
</html>