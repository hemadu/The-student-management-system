<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <div class="col-md-12 graphs">
	   <div class="xs">
           <ol class="breadcrumb" style="font-size: 1.3em;line-height: 1.5px;padding: 8px 5px;">
               <li><a >学生评价</a></li>
<!--               <li class="active">Data</li>-->
           </ol>

           <div class="search-wrap" style="margin-left: 5px">
               <div class="search-content">
                   <form action="${pageContext.request.contextPath }/comment/query" method="post" name="queryForm">
                       <input type="hidden" name="pageIndex" value="1"/>
                       <div class="input-group">


                       </div><!-- Input Group -->
                   </form>
               </div>
           </div>

<div class="panel panel-warning" style="margin-top: 0em;" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
<div class="panel-body no-padding" style="padding: 0px;">
<table class="table table-striped">
<thead>
<tr class="warning">
    <th>ID</th>
    <th>姓名</th>
    <th>年级</th>
    <th>班级</th>
    <th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach var="comment" items="${pageInfo.list}" varStatus="status">
    <c:if test="${comment.users.id!=null}">
    <tr>
    <td>${comment.users.id}</td>
    <td>${comment.users.name}</td>
    <td>${comment.users.grade.grade}</td>
    <td>${comment.users.grade.name}</td>

        <td >
            <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/comment/update?id=${comment.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
   </td>
    </tr>
    </c:if>
</c:forEach>
    </tbody>
    </table>
    </div>
    </div>
           <c:import url="rollpage.jsp"></c:import>
       </div>
   </div>

      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
<!-- Nav CSS -->

<!--外层的div-->
<%@include file="/jsp/bottom.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/nolist.js"></script>

</body>
</html>
