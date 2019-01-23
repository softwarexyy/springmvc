var sumQty = 12; //总条数
var evryPageQty = 10; //每页条数
var pageQty = Math.ceil(sumQty / evryPageQty); //页数
var pageSum = Math.ceil(sumQty / evryPageQty) - 1;
var page = 0;

function initPageScroll() {
	$("#pageCur").text(page + 1);
	$("#pageSum").text(pageQty);
}

function prev() {
	if(page > 0) {
		page--;
	}
	$("#pageCur").text(page + 1);
	// 往前翻页查询
	searchList(page, 10);
}

function next() {
	if(page < pageSum) {
		page++;
	}
	$("#pageCur").text(page + 1);
	// 往后翻页查询
	searchList(page, 10);
}