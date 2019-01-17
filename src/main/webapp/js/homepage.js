/**
 * 发送ajax请求 查询 账户信息
 * @returns
 */
function showAccount(argUsername) {
	alert(argUsername);
	$.ajax({
		type: "post",
		url: "/springmvc/showAccount.do",
		dataType: "json",
		data: {	// 传输的数据，应取session中的username值
			username: argUsername,
			username1: "123"
		},
		async: false,	//此处采用同步，等待ajax返回才会给successflag赋值，否则successflag不一定拿到ajax赋值结果
		success: function(data) {
			alert("success" + data.result);
		},
		error: function(data) {
			alert("failed" + data);
		}
	});
}

/**
 * 发送ajax请求 查询 账单信息
 * @returns
 */
function showBills() {
	alert("敬请期待");
}

function transferMoney() {
	alert("敬请期待");
}
