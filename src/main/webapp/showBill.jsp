<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/springmvc/js/jquery.min.js"></script>
<script type="text/javascript" src="/springmvc/js/showBill.js"></script>
<script type="text/javascript" src="/springmvc/js/searchList.js" ></script>
<script type="text/javascript" src="/springmvc/js/pageScroll.js" ></script>
<title>我的账单|小金猪银行</title>
</head>
<body onload="initPageScroll()">
<p>
	<img src="/springmvc/images/titleLogo.png" width="1165" height="85" />
</p>
<p>
	起止日期：   
  	<input id="startTime" type="date" value="2017-12-01"/> 
 	 至
    <input id="endTime" type="date" value="2019-02-01"/>
    &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="qryButton" value="查询" onclick="showBillAndClearState('${sessionScope.userinfo.id}', 0, 10)"/>
</p>

<table id="billTable" width="800" border="0">
  <tr bgcolor="#DCFAD1">
    <td>日期</td>
    <td>金额</td>
    <td>交易类型</td>
    <td>备注</td>
  </tr>
</table>
<div>
	<a href="javascript:void(0);" onclick="prev('${sessionScope.userinfo.id}')">上一页</a>
	<a href="javascript:void(0);" onclick="next('${sessionScope.userinfo.id}')">下一页</a>
	第<a id="pageCur"></a>页 共<a id="pageSum"></a>页
</div>

<p><a href="/springmvc/homepage.jsp"><img src="/springmvc/images/returnToHomepage.png" width="180" height="35" /></a></p>
</body>
</html>