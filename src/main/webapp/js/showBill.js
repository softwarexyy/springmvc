var sumQty = 12; //TODO:这只是假设的总条数，实际上需要通过查询数据库总条数得出
var evryPageQty = 10; //每页条数
var pageQty = Math.ceil(sumQty / evryPageQty); //页面上展示的总页数
var page = 1;	//页面上展示的当前页号

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
 * 查询账单列表 并且清楚所有状态 回到初始状态
 * 
 * @returns
 */
function showBillAndClearState(userid, pageStart, pageQty) {
	// 清空账单列表
	$("#billTable tr:not(:first)").remove();
	page = 1;	// 当前页号重置为1
	$("#pageCur").text(page);
	
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

function initPageScroll() {
	$("#pageCur").text(page);
	$("#pageSum").text(pageQty);
}

function prev(userid) {
	if(page > 1) {
		page--;
		$("#pageCur").text(page);
		// 往前翻页查询
		searchList(userid, (page-1)*evryPageQty, evryPageQty);	//查询从第(page-1)*evryPageQty条记录开始的10条
	}
}

function next(userid) {
	if(page < pageQty) {
		page++;
		$("#pageCur").text(page);
		// 往后翻页查询
		searchList(userid, (page-1)*evryPageQty, evryPageQty);	//查询从第(page-1)*evryPageQty条记录开始的10条
	}
}