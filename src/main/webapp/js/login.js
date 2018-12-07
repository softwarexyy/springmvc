function loginFunction() {
	// 空白用户名判空
	if(!(document.getElementById("username").value)) {
		alert("用户名不能为空哟");
		return;
	}
	// 空白密码判空
	if(!(document.getElementById("password").value)) {
		alert("密码不能为空哟");
		return;
	}
}

/**
 * 验证登录是否成功
 * 如果登录成功，跳转到homePage2
 * 如果登录失败，则在页面显示错误
 */
function loginCheck() {
	// 空白用户名判空
	if(!(document.getElementById("username").value)) {
		alert("用户名不能为空哟");
		return false;
	}
	// 空白密码判空
	if(!(document.getElementById("password").value)) {
		alert("密码不能为空哟");
		return false;
	}
	var successflag = true;
	$.ajax({
		type: "post",
		url: "app/loginCheck.do",
		dataType: "json",
		data: {
			username: $("#username").val(),
			password: $("#password").val()
		},
		async: false,	//此处采用同步，等待ajax返回才会给successflag赋值，否则successflag不一定拿到ajax赋值结果
		success: function(data) {
			if(data.result == "success") {
				//$(location).attr("href", "app/loginToHomepage.do");	//重定向到登录主页,只能用get，此方法不行
				//$("#loginForm").submit();	//此处提交表单，到成功主页
				successflag = true;
			} else {
				alert("登录失败了...x_x");
				successflag = false;
			}
		},
		error: function(data) {
			alert("error" + data.responseText);
		}
	});
	return successflag;
}