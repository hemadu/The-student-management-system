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
               <li><a >大学生涯规划</a></li>
<!--               <li class="active">Data</li>-->
               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
           </ol>

<div class="panel panel-warning"  data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
<div class="panel-body no-padding" style="padding: 0px;">

<table class="table table-striped">
<thead>
<tr class="warning">
    <th>NO</th>
    <th>时间</th>
    <th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach var="plan" items="${pageInfo}" varStatus="status">
    <tr>
    <td>${status.count}</td>
    <td>${plan.year}</td>
        <td>
            <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/planUpdate?id=${plan.id}" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
        </td>
    </tr>
</c:forEach>
    </tbody>

    </table>

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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/nolist.js"></script>

</body>
</html>
