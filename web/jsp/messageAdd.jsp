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
					<li><a>留言板</a></li>
					<!--               <li class="active">Data</li>-->
				</ol>

				<div class="result-content" style="margin-left: 120px;width: 1000px;">
					<table class="result-tab" width="100%">
						<tr>
							<td>NO</td>
							<td>留言用户姓名</td>
							<td>留言时间</td>
						</tr>
						<c:forEach var="message" items="${messageList}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${message.users.name}</td>
								<td>${message.time}</td>

							</tr>
							<tr>
							<td colspan="3"><textarea readonly class="common-textarea" cols="30" style="width: 100%;height: 60px;" rows="10">${message.content}</textarea></td>

							</tr>
						</c:forEach>
					</table>
				</div>


				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form id="userForm" class="form-horizontal" name="userForm" method="post" action="${pageContext.request.contextPath }/message/add">

							<div class="form-group">
								<label  class="col-sm-2 control-label">回复</label>
								<textarea  class="common-textarea" id="content" name="content" style="margin-left: 16px;width: 64%;" cols="30"  rows="10"></textarea>
							</div>

<%--							<label id="picker" class="col-sm-2 control-label">选择头像</label>--%>

							<div class="form-group" style="margin-left: 500px;margin-top: 50px;" >
								<button type="submit" class="btn btn-primary" style="margin-right:40px">发送</button>
								<button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
							</div>
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
</body>
</html>
