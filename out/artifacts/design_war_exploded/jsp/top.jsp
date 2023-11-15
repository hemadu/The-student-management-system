<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>The student management system</title>
</head>
<body>
<nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand"  style="font-size: 22px;">The student management system</a>
    </div>
    <!-- /.navbar-header -->
    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/images/${userSession.pic}" alt=""/></a>
            <ul class="dropdown-menu">
<%--                <li class="m_2"><a href="${pageContext.request.contextPath }/users/update"><i class="fa fa-wrench"></i> 个人资料</a></li>--%>
                <li class="m_2"><a href="javascript:toUpdate()"><i class="fa fa-shield"></i> 修改密码</a></li>
                <li class="m_2"><a href="${pageContext.request.contextPath}/users/logout"><i class="fa fa-lock"></i> 退出</a></li>
            </ul>
        </li>
    </ul>

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
<%--                <li>--%>
<%--                    <a href="index.html"><i class="fa fa-dashboard fa-fw nav_icon"></i>首页</a>--%>
<%--                </li>--%>

    <li>
        <a href="${pageContext.request.contextPath }/jsp/index.jsp"><i class="fa fa-bars nav_icon"></i>首页</a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath }/users/update"><i class="fa fa-user nav_icon"></i> 个人信息</a>
    </li>

    <c:if test="${userSession.role==0}">
    <li>
            <a href="${pageContext.request.contextPath }/users/query"><i class="fa fa-users nav_icon"></i>用户信息修改</a>
    </li>
    </c:if>

    <c:if test="${userSession.role==1}">
        <li>
            <a href="${pageContext.request.contextPath }/friends/query"><i class="fa fa-users nav_icon"></i>我的好友</a>
            <a href="${pageContext.request.contextPath }/grade/query"><i class="fa fa-table nav_icon"></i>班级管理</a>
            <a href="${pageContext.request.contextPath }/jsp/comment.jsp"><i class="fa fa-book nav_icon"></i>学生评价</a>
            <a href="${pageContext.request.contextPath }/jsp/contact.jsp"><i class="fa fa-envelope nav_icon"></i>联系我们</a>
        </li>
    </c:if>

    <c:if test="${userSession.role==2}">
        <li>
            <a href="${pageContext.request.contextPath }/friends/query"><i class="fa fa-users nav_icon"></i>我的好友</a>
            <a href="${pageContext.request.contextPath }/plan/query"><i class="fa fa-indent nav_icon"></i>大学生涯规划</a>
            <a href="${pageContext.request.contextPath }/grow/query"><i class="fa fa-laptop nav_icon"></i>我的成长圈</a>
            <a href="${pageContext.request.contextPath }/data/query"><i class="fa fa-check-square-o nav_icon"></i>成绩信息</a>
            <a href="${pageContext.request.contextPath }/account/query"><i class="fa fa-book nav_icon"></i>小账本</a>
            <a href="${pageContext.request.contextPath }/jsp/contact.jsp"><i class="fa fa-envelope nav_icon"></i>联系我们</a>
        </li>
    </c:if>

    <li>
        <a href="${pageContext.request.contextPath }/message/query"><i class="fa fa-file-text-o nav_icon"></i>留言板</a>
    </li>
<%--    <c:if test="${userSession.role==1}">--%>
<%--        <li>--%>
<%--            <a href="${pageContext.request.contextPath }/jsp/sum.jsp"><i class="fa fa-level-up nav_icon"></i>统计</a>--%>
<%--        </li>--%>
<%--    </c:if>--%>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>

<script>
    function toUpdate(){
        $("#updatePassModal").modal("show");
    }
</script>
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/js/custom.js"></script>

</body>
</html>