<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
               <li><a >小账本</a></li>
<!--               <li class="active">Data</li>-->
               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;margin-top: 5px" type="button"  class="btn btn-default"><a style="text-decoration: none;"  href="${pageContext.request.contextPath}/jsp/accountAdd.jsp"><i class="fa fa-plus" aria-hidden="true"></i>增加</a></button>
           </ol>

           <div class="search-wrap" style="margin-left: 5px">
               <div class="search-content">
                   <form action="${pageContext.request.contextPath }/account/query" method="post" name="queryForm">
                       <input type="hidden" name="pageIndex" value="1"/>
                       <div class="input-group">


                       </div><!-- Input Group -->
                   </form>
               </div>
           </div>

<div class="panel panel-warning" style="margin-top: 0em;" account-widget="{&quot;draggable&quot;: &quot;false&quot;}" account-widget-static="">
<div class="panel-body no-padding" style="padding: 0px;">
<table class="table table-striped">
<thead>
<tr class="warning">
    <th>NO</th>
    <th>价格</th>
    <th>类别</th>
    <th>权限</th>
    <th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach var="account" items="${pageInfo.list}" varStatus="status">
    <tr>
    <td >${status.count}</td>
    <td >${account.price}</td>
        <td >
            <c:if test="${account.type==0}">
                餐饮美食
            </c:if>
            <c:if test="${account.type==1}">
                服装美容
            </c:if>
            <c:if test="${account.type==2}">
                生活日用
            </c:if>
            <c:if test="${account.type==3}">
                交通出行
            </c:if>
            <c:if test="${account.type==4}">
                休闲娱乐
            </c:if>
        </td>
    <td >${account.role==0?"支出":"收入"}</td>
<%--    <td style="line-height: 50px;" ><fmt:formatDate value="${account.time}" type="date"/>--%>
        <td >
            <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/account/update?id=${account.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
            <button style="padding: 2px 6px;text-decoration: none;color: white;" type="button" class="btn btn-sm btn-danger deleteSector"><a style="text-decoration: none;color: white;" class="deleteNo" href="javascript:del(${account.id})" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button>
        </td>
    </tr>
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
<script>
    // if(confirm("是否删除 ")){
    //     location.href="..goods?action=del&id="+id;
    // }
    function del(obj){
        if(confirm("是否删除 ")){
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath }/account/del/"+obj ,
                // account:{method:"deluser",uid:obj.attr("userid")},
                accountType:"json",
                success:function(account){
                    if(account.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                    }else if(account.delResult == "false"){//删除失败
                        alert("对不起，删除失败");
                    }else if(account.delResult == "notexist"){
                        alert("对不起，该医生不存在");
                    }
                },
                error:function(account){
                    alert("对不起，删除失败");
                }
            });
        }
        location.reload();
    }
</script>
</body>
</html>
