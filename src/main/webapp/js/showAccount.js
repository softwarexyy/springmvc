/**
 * 发送ajax请求 查询 账户信息
 * @returns
 */
function getSubAccount(argUsername) {
	alert(argUsername);
	$.ajax({
		type: "post",
		url: "/springmvc/getSubAccount.do",
		dataType: "json",
		data: {	// 传输的数据，应取session中的username值
			username: argUsername,
			username1: "123"
		},
		async: false,	//此处采用同步，等待ajax返回才会给successflag赋值，否则successflag不一定拿到ajax赋值结果
		success: function(data) {
			alert("success " + data.userid + data.username + data.password);	//测试返回的json报文
		},
		error: function(data) {
			alert("failed" + data);
		}
	});
}
