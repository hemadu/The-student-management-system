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
					<li><a>好友PK</a></li>
					<!--               <li class="active">Data</li>-->
				</ol>
				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form id="userForm" class="form-horizontal" name="userForm" method="post" action="##">

							<div class="form-group">
								<label  class="col-sm-2 control-label">请选择您与好友的PK内容</label>
								<div class="col-sm-8">
									<select name="type" id="type" class="form-control1" >
										<option value="0" selected class="form-control1">学科成绩</option>
										<option value="1" class="form-control1">获得奖状</option>
										<option value="2" class="form-control1">获得证书</option>
									</select>
								</div>
							</div>

<%--							<label id="picker" class="col-sm-2 control-label">选择头像</label>--%>

							<div class="form-group" style="margin-left: 500px;margin-top: 50px;" >

								<button type="button"  class="btn btn-primary" style="margin-right:40px"><a style="text-decoration: none;color: white;"  href="javascript:pk()" >确认</a></button>
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
<script>
	function pk(){
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath }/data/pk/"+$("#type").val(),
			dataType:"json",
			success:function(data){
				if(data.Result == "true"){//删除成功：移除删除行
					alert("获胜");
				}else if(data.Result == "false"){//删除失败
					alert("败北");
				}else if(data.Result == "equal"){
					alert("平局");
				}
			},
			error:function(data){
				alert("对不起，操作失败");
			}
		});
		//location.reload();
	}
</script>
</body>
</html>
