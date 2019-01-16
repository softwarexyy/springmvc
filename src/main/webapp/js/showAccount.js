/**
 * 查询下挂账号
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
			for (var i=0; i<data.length; i++) {	// 在下拉列表中添加查询出的账号
				$("#account").append("<option value='" + data[i] + "'>" + data[i] + "</option>");
			}
		},
		error: function(data) {
			alert("failed" + data);
		}
	});
}

/**
 * 查询某个账号的详细信息
 * @returns
 */
function qryAccount() {
	var acc = document.getElementById("account");
	alert(acc.options[acc.selectedIndex].value);
}