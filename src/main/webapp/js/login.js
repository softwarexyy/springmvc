function loginFunction() {
	// 空白用户名判空
	if(!(document.getElementById("username").value)) {
		alert("用户名不能为空哟");
		return ;
	}
	// 空白密码判空
	if(!(document.getElementById("password").value)) {
		alert("密码不能为空哟");
		return ;
	}
}