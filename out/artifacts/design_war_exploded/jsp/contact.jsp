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
					<li><a >欢迎您：${userSession.name}</a></li>
					<li><a >ID：${userSession.id}</a></li>
					<!--               <li class="active">Data</li>-->
				</ol>
				<div class="tab-content" style="width: 1200px;height: 500px;padding-left: 120px;">

					<div class="Compose-Message">
						<form id="userForm" class="form-horizontal" name="userForm" method="post" action="${pageContext.request.contextPath }/message/madd">

						<div class="panel panel-default">
							<div class="panel-heading">
								您可以通过电话或邮件联系我们
							</div>
							<div class="panel-body">
								<div class="alert alert-info">
									电话：437400 |
									电子邮箱：437400@gmail.com
								</div>
								<hr>
								<label>邮件内容： </label>
								<textarea rows="6"i d="content" name="content" class="form-control1 control2"></textarea>
								<hr>
								<button type="submit" class="btn btn-primary" style="margin-right:40px">发送邮件</button>
							</div>
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
<!-- map -->
<link href="${pageContext.request.contextPath}/css/jqvmap.css" rel='stylesheet' type='text/css' />
<script src="${pageContext.request.contextPath}/js/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.vmap.world.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#vmap').vectorMap({
			map: 'world_en',
			backgroundColor: '#333333',
			color: '#ffffff',
			hoverOpacity: 0.7,
			selectedColor: '#666666',
			enableZoom: true,
			showTooltip: true,
			values: sample_data,
			scaleColors: ['#C8EEFF', '#006491'],
			normalizeFunction: 'polynomial'
		});
	});
</script>
<!-- //map -->
<!----Calender -------->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/clndr.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/clndr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/underscore-min.js" type="text/javascript"></script>
<script src= "${pageContext.request.contextPath}/js/moment-2.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/site.js" type="text/javascript"></script>

<!----End Calender -------->
</body>
</html>
