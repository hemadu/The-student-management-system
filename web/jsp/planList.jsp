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
               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button"  class="btn btn-default"><a style="text-decoration: none;"  href="${pageContext.request.contextPath}/jsp/planAdd.jsp"><i class="fa fa-plus" aria-hidden="true"></i>增加</a></button>

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
            <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/plan/update?id=${plan.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
            <button style="padding: 2px 6px;text-decoration: none;color: white;" type="button" class="btn btn-sm btn-danger deleteSector"><a style="text-decoration: none;color: white;" class="deleteNo" href="javascript:del(${plan.id})" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button>
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
<script>
    // if(confirm("是否删除 ")){
    //     location.href="..goods?action=del&id="+id;
    // }
function del(obj){
    if(confirm("是否删除 ")){
$.ajax({
type:"GET",
url:"${pageContext.request.contextPath }/plan/del/"+obj ,
// data:{method:"deluser",uid:obj.attr("userid")},
dataType:"json",
success:function(data){
if(data.delResult == "true"){//删除成功：移除删除行
alert("删除成功");
}else if(data.delResult == "false"){//删除失败
alert("对不起，删除失败");
}else if(data.delResult == "notexist"){
alert("对不起，该班级不存在");
}
},
error:function(data){
alert("对不起，删除失败");
}
});
}
    location.reload();
}
</script>
</body>
</html>
