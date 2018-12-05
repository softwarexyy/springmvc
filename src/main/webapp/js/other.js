/**
 * ajaxc传输数据
 * @returns
 */
function sendDataAjax() {
	$(document).ready(function() {
		$("#btn1").click(function() { //btn1不存在，此功能暂时禁用
			$.post("app/ajaxlogin.do", { //传入json数据
					username: $("#username").val(),
					password: $("#password").val()
				},
				function(data, status) {
					alert("数据：" + data + "\n状态：" + status);
					if(data == "fail") {
						alert("登录失败，请重试!");
					} else if(data == "success") {
						alert("恭喜! 登录成功");
					}
				});
		});
	});
}