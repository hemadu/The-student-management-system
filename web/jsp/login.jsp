<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/jsp/script.jsp"%></head>
<body id="login">
  <div class="login-logo">
 </div>
  <h2 class="form-heading" style="font-size: 35px;">登录</h2>
  <div class="app-cam">
	  <form class="loginForm" action="${pageContext.request.contextPath}/users/login" name="actionForm" id="actionForm"  method="post" >
		  <input name="username" id="username"  type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
		<input  name="password" id="password" type="password" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">

		  <div class="submit"><input type="submit"  value="登录"></div>

		<ul class="new" style="    margin: 0em 0 0 0;">
<%--			<li class="new_left"><p><a href="${pageContext.request.contextPath }/users/mquery">返回</a></p></li>--%>
			<li class="new_right"><p class="sign">没有账户 ?<a href="${pageContext.request.contextPath }/jsp/register.jsp"> 注册</a></p></li>
			<div class="clearfix"></div>
		</ul>
	</form>
  </div>
</body>
<script>

</script>
</html>
