<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LGP BANK</title>
</head>
<body>
	<div id="titleLogo" align="left">
		<img src="/springmvc/images/titleLogo.png" width="1165" height="85" />
	</div>
	<form id="form" name="form" method="post" action="modifyUserInfo.do">
	  <table width="296" border="0">
        <tr>
          <td width="81" height="34">用户名</td>
          <td width="199"><input type="text" name="username" value="${sessionScope.username}" readonly /></td>
        </tr>
        <tr>
          <td height="34">生日</td>
          <td><input type="text" id="birthday" name="birthday" value="${sessionScope.userinfo.birthday}" /></td>
        </tr>
        <tr>
          <td height="30">性别</td>
          <td><input type="text" id="gender" name="gender" value="${sessionScope.userinfo.gender}" /></td>
        </tr>
      </table>
      <p>
        <input type="submit" name="submit" id="submit" value="提交修改" />
      </p>
	</form>
</body>
</html>