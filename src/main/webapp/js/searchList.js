/**
 * 查询账单列表
 * 
 * @returns
 */
function showBillWithStartAndQty(userid, pageStart, pageQty) {
	// 清空账单列表
	$("#billTable tr:not(:first)").remove();
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	$.ajax({
		type : "post",
		url : "/springmvc/showBill.do",
		dataType : "json",
		data : {
			userid: userid,
			startTime : startTime,
			endTime : endTime,
			pageStart : pageStart, // 默认起始位置
			pageQty : pageQty // 默认一页数量
		},
		async : false, // 此处采用同步，等待ajax返回才会给successflag赋值，否则successflag不一定拿到ajax赋值结果
		success : function(data) {
			for (var i = 0; i < data.length; i++) { // 在下拉列表中添加查询出的账号
				// 在表格 billTable中添加数据
				var time = new Date(data[i].date).format("yyyy/MM/dd hh:mm:ss");	//转换时间格式
				var line = "<tr bgcolor=\"#D2E9FF\"><td>" + time + "</td><td>"
						+ data[i].amount + "</td><td>" + data[i].transType
						+ "</td><td>" + data[i].transRemark + "</td></tr>";
				$("#billTable").append(line);
			}
		},
		error : function(data) {
			alert("failed" + data);
		}
	});
}

function searchList(userid, pageStart, pageQty) {
//	alert("查询" + pageStart + "开始的" + pageQty + "个记录");
	showBillWithStartAndQty(userid, pageStart, pageQty);
}
