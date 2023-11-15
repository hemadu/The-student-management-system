function page_nav(num){
	document.queryForm.pageIndex.value = num;
	document.queryForm.submit();
}

var noObj;

//预约管理页面上点击删除按钮弹出删除框(nolist.jsp)
function deleteNo(obj){
	$.ajax({
		type:"GET",
		url:${pageContext.request.contextPath}+"/no/del/"+obj.attr("noid") ,
		// data:{method:"delno",uid:obj.attr("noid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除预约【"+obj.attr("noname")+"】失败");
				changeDLGContent("对不起，删除预约【"+obj.attr("noname")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，预约【"+obj.attr("noname")+"】不存在");
				changeDLGContent("对不起，预约【"+obj.attr("noname")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewNo的元素进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewNo").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=${pageContext.request.contextPath}+"/no/view?id="+ obj.attr("noid");
	});
	
	$(".updateNo").on("click",function(){
		var obj = $(this);
		window.location.href=${pageContext.request.contextPath}+"/no/updateNo?id="+ obj.attr("noid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteNo(noObj);
	});

	$(".deleteNo").on("click",function(){
		noObj = $(this);
		changeDLGContent("你确定要删除预约【"+noObj.attr("noname")+"】吗？");
		openYesOrNoDLG();
	});
	
	/*$(".deleteNo").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除预约【"+obj.attr("noname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:${pageContext.request.contextPath}+"/jsp/no.do",
				data:{method:"delno",uid:obj.attr("noid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除预约【"+obj.attr("noname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，预约【"+obj.attr("noname")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});