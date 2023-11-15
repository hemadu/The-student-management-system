<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
   <%@include file="/jsp/script.jsp"%>
</head>
<body id="login">
  <div class="login-logo">
  </div>
  <h2 class="form-heading" style="font-size: 35px;">注册</h2>
  <form class="form-signin app-cam" action="${pageContext.request.contextPath }/users/add"  onsubmit="return check()">
      <p>输入您的个人信息</p>
      <input type="text" class="form-control1" placeholder="姓名" name="name" required autofocus="">
      <input type="text" class="form-control1" placeholder="年龄" name="age"  required autofocus="">
      <input type="text" class="form-control1" placeholder="电话" name="phone" required  autofocus="">
      <div class="radios">
        <label class="label_radio">
            <input name="sex" type="radio" value="男" checked=""> 男
        </label>
        <label class="label_radio">
            <input name="sex" type="radio" value="女"> 女
        </label>
	  </div>

	  <p> 请输入您的账户信息</p>
      <input type="text" class="form-control1" placeholder="用户名"  required name="username" autofocus="">
      <input type="password" id="newpass1" name="password"  required class="form-control1" placeholder="密码">
      <input type="password" id="newpass2" class="form-control1" required  placeholder="确认密码">

      <div class="radios" style="margin-bottom: 20px;">
          <label class="label_radio">
              <input name="role" type="radio" value="1" checked=""> 老师
          </label>
          <label class="label_radio">
              <input name="role" type="radio" value="2"> 学生
          </label>
      </div>
      <button class="btn btn-lg btn-success1 btn-block" type="submit" style="margin-left: 0px;">发送</button>
      <div class="registration">
          已有账户.
          <a class="" href="${pageContext.request.contextPath }/jsp/login.jsp">
              登录
          </a>
      </div>
  </form>
  <script>
      function check(){

        if($("#newpass1").val()!=$("#newpass2").val()){
              alert("两次密码不一致");
              return false;
          }else{
              return true;
          }
      }

  </script>
</body>
</html>
