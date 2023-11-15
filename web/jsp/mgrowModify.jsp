<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="/jsp/script.jsp"%>
</head>
<body>
<div id="wrapper">
	<!-- Navigation -->
	<%@include file="/jsp/top.jsp"%>
	<div id="page-wrapper">
		<div class="graphs">
			<div class="xs">
				<ol class="breadcrumb" style="font-size: 1.3em;line-height: 1.5px;padding: 8px 5px;">
					<li><a>成长圈</a></li>
					<!--               <li class="active">Data</li>-->
					<button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>

				</ol>
				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form id="userForm" class="form-horizontal" name="userForm" method="post" action="${pageContext.request.contextPath }/grow/updateexe">
							<input type="hidden"  name="id" value="${grow.id}"/>
							<div class="form-group">
								<label  class="col-sm-2 control-label">图片</label>
								<div class="col-sm-8">
								<img src="${pageContext.request.contextPath}/images/${grow.pic}" id="show" style="max-width:40px;margin-left: 30px;margin-bottom: 10px;"/>
							</div>
							<input  type="hidden" class="common-text required" id="img"  name="pic" value="${grow.pic}">
							</div>

							<div class="form-group">
								<label  class="col-sm-2 control-label">标题</label>
								<div class="col-sm-8">
									<input readonly="readonly" type="text" class="form-control1" name="title"  value="${grow.title}">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">类别</label>
								<div class="col-sm-8">
									<input readonly="readonly"  type="text" class="form-control1" name="type"  value="${grow.type}">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">时间</label>
								<div class="col-sm-8">
									<input readonly="readonly" type="text" class="form-control1" name="date"  value="${grow.date}">
								</div>
							</div>

							<div class="form-group">
								<label  class="col-sm-2 control-label">内容</label>
								<div class="col-sm-8"  id="editor">

								</div>
								<input type="hidden" id="content" name="content"/>
							</div>

<%--							<label id="picker" class="col-sm-2 control-label">选择头像</label>--%>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-wrapper -->
</div>

<!-- /#wrapper -->
<!-- Nav CSS -->

<!--外层的div-->
<%@include file="/jsp/bottom.jsp"%>
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">

<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/webuploader/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/wangEditor/wangEditor.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/webuploader/webuploader.css"/>
<script>
	var uploader = WebUploader.create({
		// swf文件路径
		swf : '${pageContext.request.contextPath }/webuploader/Uploader.swf',//高版本浏览器可以不要
		// 文件接收服务端。
		server : '${pageContext.request.contextPath }/upfile',
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : '#picker',
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize : false
	});
	//当选择文件之后，就开始上传
	uploader.on('fileQueued', function(file) {
		// 选中文件时要做的事情，比如在页面中显示选中的文件并添加到文件列表，获取文件的大小，文件类型等
		uploader.upload();//可以选择之后就上传
	});
	//上传成功后
	uploader.on("uploadSuccess", function(file, response) {
		alert("上传成功!");
		$("#show").attr("src","${pageContext.request.contextPath }/images/"+response.filename).show();
		$("#img").val(response.filename);//获取服务响应的文件名
	});

	//富文本框
	var E = window.wangEditor;
	var editor = new E('#editor');
	editor.customConfig.uploadFileName = 'file';
	editor.customConfig.uploadImgServer = '${pageContext.request.contextPath }/upload';

	//当内容改变时修改content
	editor.customConfig.onchange = function (html) {
		$("#content").val(html);
	}
	$("#content").val('${grow.content}');
	editor.create();
	//给富文本框赋值
	editor.txt.html('${grow.content}');
</script>
</body>
</html>
