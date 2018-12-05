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
 * 获取XHR并发送get请求
 */
function loadXMLGet() {
	var xmlhttp;
	if(window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else { // code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET", "/ajax/demo_get.asp", true);
	xmlhttp.send();
}

/**
 * 获取XHR并发送post请求
 */
function loadXMLPost() {
	var xmlhttp;
	if(window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else { // code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;	//获取ajax的请求返回
		}
	}
	xmlhttp.open("POST", "/ajax/demo_post.asp", true);
	xmlhttp.send();
}

/**
 * ajax提交表单
 */
function submitForm(){
	document.getElementById("loginForm").submit();
}
