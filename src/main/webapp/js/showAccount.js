/**
 * 发送ajax请求 查询 账户信息
 * @returns
 */
function getSubAccount(username) {
	$.ajax({
		type: "post",
		url: "/springmvc/getSubAccount.do",
		dataType: "json",
		data: {	// 传输的数据，应取session中的username值
			username: username,
			username1: "123"
		},
		async: false,	//此处采用同步，等待ajax返回才会给successflag赋值，否则successflag不一定拿到ajax赋值结果
		success: function(data) {
			$("#accout").append("<option value='0'>----请选择账户----</option>");
			for (var i=0; i<data.length; i++) {	// 在下拉列表中添加查询出的账号
				$("#accout").append("<option value='" + data[i] + "'>" + data[i] + "</option>");
			}
		},
		error: function(data) {
			alert("failed" + data);
		}
	});
}
