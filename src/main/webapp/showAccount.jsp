<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/springmvc/js/showAccount.js"></script>
<script type="text/javascript" src="/springmvc/js/jquery.min.js"></script>
<script type="text/javascript">

</script>
<title>我的账户|小金猪银行</title>
</head>
<body onload="getSubAccount('<%=session.getAttribute("username") %>')"> <!-- 初始化页面 -->
	<div id="titleLogo" align="left">
		<img src="/springmvc/images/titleLogo.png" width="1165" height="85" />
	</div>
		<p>银行卡号：
			<select id="account" onchange="qryAccountInfo()">
				<option value="0">--- 请选择账号---</option>
			</select>
		</p>
		<p>总财富：
			<label id="sum"></label>
		</p>
        <br />
		<p>活期：
			<label id="currencydeposit"></label>
		</p>
		<p>定期：
			<label id="timedeposit"></label>
		</p>
		<p>其他理财：
			<label id="financialdeposit"></label>
		</p>
		<p><a href="/springmvc/homepage.jsp"><img src="/springmvc/images/returnToHomepage.png" width="180" height="35" /></a></p>
</body>
</html>