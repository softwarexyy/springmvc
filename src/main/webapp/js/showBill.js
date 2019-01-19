/**
 * 处理TimeStamp类型成为JS类型 
 * 用法： 
 * var time = new Date(timeStamp).format("yyyy/MM/dd hh:mm:ss");
 */
Date.prototype.format = function(format) {
	var o = {
			"M+" : this.getMonth() + 1,// month
			"d+" : this.getDate(),// day
                "h+" : this.getHours(),// hour
                "m+" : this.getMinutes(),// minute
                "s+" : this.getSeconds(),// second
                "q+" : Math.floor((this.getMonth() + 3) / 3),// quarter
                "S" : this.getMilliseconds()
            // millisecond
            };
            if (/(y+)/.test(format) || /(Y+)/.test(format)) {
                format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            for ( var k in o) {
                if (new RegExp("(" + k + ")").test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
                }
            }
            return format;
        };

/**
 * 查询账单列表
 * 
 * @returns
 */
function showBill(userid) {
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
			pageStart : '0', // 默认起始位置
			pageQty : '10' // 默认一页数量
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