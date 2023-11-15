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
						<form id="userForm" class="form-horizontal" name="userForm" method="post" action="${pageContext.request.contextPath }/data/updateexe">
							<input type="hidden"  name="id" value="${data.id}"/>

							<div class="form-group">
								<label  class="col-sm-2 control-label">名称</label>
								<div class="col-sm-8">
									<input type="text" readonly="readonly" class="form-control1" name="name"  value="${data.name}">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">成绩</label>
								<div class="col-sm-8">
									<input type="text" readonly="readonly" class="form-control1" name="score"  value="${data.score}">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">类别</label>
								<div class="col-sm-8">
									<select name="type" disabled="disabled"  class="form-control1" style="height: 35px;width:90px;margin-right: 40px;padding:0 5px;border: 1px solid #e0e0e0;font-size: 0.85em;" >
												<option value="0"
														<c:if test="${data.type==0}">
															selected
														</c:if>
														class="form-control1">学科成绩</option>
										<option value="1"
												<c:if test="${data.type==1}">
													selected
												</c:if>
												class="form-control1">获得奖状</option>
										<option value="2"
												<c:if test="${data.type==2}">
													selected
												</c:if>
												class="form-control1">获得证书</option>
									</select>
								</div>
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

</body>
</html>
