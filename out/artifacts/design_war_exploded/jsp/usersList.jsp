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
               <li><a >
                   <c:if test="${userSession.role==1}">
                       学生列表
                   </c:if>
                   <c:if test="${userSession.role!=1}">
                       用户管理
                   </c:if>
                   </a></li>
<!--               <li class="active">Data</li>-->
                <c:if test="${userSession.role==1}">
               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button"  class="btn btn-default"><a style="text-decoration: none;"  href="${pageContext.request.contextPath}/jsp/gradeStuAdd.jsp"><i class="fa fa-plus" aria-hidden="true"></i>增加</a></button>
                </c:if>
           </ol>
           <div class="search-wrap" style="margin-left: 5px">
               <div class="search-content">
                   <form action="${pageContext.request.contextPath }/users/query" method="post" name="queryForm">
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
    <th>性别</th>
    <th>年龄</th>
    <th>头像</th>
    <th>电话</th>
    <th>身份</th>
    <th>操作</th>
</tr>
</thead>
<tbody>

<c:forEach var="users" items="${pageInfo.list}" varStatus="status">
    <c:if test="${users.id!=null}">
    <tr>
    <td>${users.id}</td>
    <td>${users.name}</td>
    <td>${users.sex}</td>
    <td>${users.age}</td>
    <td><img src="${pageContext.request.contextPath}/images/${users.pic}"  style="max-width:35px;"></td>
    <td>${users.phone}</td>

        <td>
        <c:if test="${users.role!=0}">
                ${users.role==1?"老师":"学生"}
        </c:if>
        </td>

        <td >
            <c:if test="${userSession.role==1}">
                <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/query?id=${users.id}" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
                <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/message/mupdate?id=${users.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
                <button style="padding:2px 6px;text-decoration: none;color: white;" type="button" class="btn btn-sm btn-danger deleteSector"><a style="text-decoration: none;color: white;" class="deleteNo" href="javascript:delStu(${users.grade.id})" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button>
            </c:if>
            <c:if test="${userSession.role==0}">
            <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/users/updateList?id=${users.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
            <button style="padding: 2px 6px;text-decoration: none;color: white;" type="button" class="btn btn-sm btn-danger deleteSector"><a style="text-decoration: none;color: white;" class="deleteNo" href="javascript:del(${users.id})" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button>
            </c:if>
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
<script>
    // if(confirm("是否删除 ")){
    //     location.href="..goods?action=del&id="+id;
    // }
    function del(obj){
        if(confirm("是否删除 ")){
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath }/users/del/"+obj ,
                // data:{method:"deluser",uid:obj.attr("userid")},
                dataType:"json",
                success:function(data){
                    if(data.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                    }else if(data.delResult == "false"){//删除失败
                        alert("对不起，删除失败");
                    }else if(data.delResult == "notexist"){
                        alert("对不起，该用户不存在");
                    }
                },
                error:function(data){
                    alert("对不起，删除失败");
                }
            });
        }
        location.reload();
    }


    function delStu(obj){
        if(confirm("是否删除 ")){
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath }/grade/delStu/"+obj ,
                // data:{method:"deluser",uid:obj.attr("userid")},
                dataType:"json",
                success:function(data){
                    if(data.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                    }else if(data.delResult == "false"){//删除失败
                        alert("对不起，删除失败");
                    }else if(data.delResult == "notexist"){
                        alert("对不起，该用户不存在");
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
