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
               <li><a >访问页面</a></li>
<!--               <li class="active">Data</li>-->
               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
           </ol>

<div class="panel panel-warning"     manage-widget="{&quot;draggable&quot;: &quot;false&quot;}" manage-widget-static="">
<div class="panel-body no-padding" style="padding: 0px;">
<table class="table table-striped">
<thead>
<tr class="warning">
    <th>访问内容</th>
    <th>查看</th>
</tr>
</thead>
<tbody>
<c:if test="${userSession.role==1}">
    <tr>
            <td>大学生涯规划</td>
            <td >
                <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/planQuery" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
            </td>
    </tr>
</c:if>
    <tr>
        <td>成长圈</td>
        <td >
            <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/growQuery" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
        </td>
    </tr>
    <tr>
        <td>成绩信息</td>
        <td >
            <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/dataQuery" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
        </td>
    </tr>
<%--    <td style="line-height: 50px;" ><fmt:formatDate value="${manage.time}" type="date"/>--%>
    </tr>
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
                url:"${pageContext.request.contextPath }/manage/del/"+obj ,
                // manage:{method:"deluser",uid:obj.attr("userid")},
                manageType:"json",
                success:function(manage){
                    if(manage.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                    }else if(manage.delResult == "false"){//删除失败
                        alert("对不起，删除失败");
                    }else if(manage.delResult == "notexist"){
                        alert("对不起，该医生不存在");
                    }
                },
                error:function(manage){
                    alert("对不起，删除失败");
                }
            });
        }
        location.reload();
    }
</script>
</body>
</html>
