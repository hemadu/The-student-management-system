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
               <li><a>我的好友</a></li>
<!--               <li class="active">Data</li>-->
           </ol>

           <div class="search-wrap" style="margin-left: 5px">
               <div class="search-content">
                   <form action="${pageContext.request.contextPath }/friends/query" method="post" name="queryForm">
                       <input type="hidden" name="pageIndex" value="1"/>
                       <div class="input-group">
                           <table class="search-tab">
                               <tbody><tr>
                                   <th width="50" >ID:</th>
                                   <td ><input style="margin-right: 100px;" type="text" name="fid" value="${fid}" class="form-control1 input-search" placeholder="请输入好友ID"></td>
                                   <td ><span class="input-group-btn">
                                    <button class="btn btn-success" type="submit"><i class="fa fa-search"></i></button>
                                        </span></td>
                               </tr>
                               </tbody>
                               <button  style="padding: 3px 6px;height: 30px;margin-left: 2px;float: right;" type="button"  class="btn btn-default"><a style="text-decoration: none;"  href="${pageContext.request.contextPath}/jsp/friendsAdd.jsp"><i class="fa fa-plus" aria-hidden="true"></i>添加</a></button>
                           </table>

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
<c:forEach var="friends" items="${pageInfo.list}" varStatus="status">
    <tr>
    <td>${friends.users.id}</td>
    <td>${friends.users.name}</td>
    <td>${friends.users.sex}</td>
    <td>${friends.users.age}</td>
    <td><img src="${pageContext.request.contextPath}/images/${friends.users.pic}"  style="max-width:35px;"></td>
    <td>${friends.users.phone}</td>

        <td>
        <c:if test="${friends.users.role!=0}">
                ${friends.users.role==1?"老师":"学生"}
        </c:if>
        </td>

        <td >

            <c:if test="${friends.users.role==2}">
            <c:if test="${userSession.role==2}">
                <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath }/data/getPk?id=${friends.users.id}"><i class="fa fa-star " aria-hidden="true"></i></a></button>
            </c:if>
                <button style="padding:2px 6px;" type="button" class="btn btn-sm btn-primary"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/manage/query?id=${friends.users.id}" ><i class="fa fa-search-minus " aria-hidden="true"></i></a></button>
            </c:if>

            <button  style="padding:2px 6px;" type="button" class="btn btn-sm btn-info"><a style="text-decoration: none;color: white;" class="updateNo" href="${pageContext.request.contextPath}/message/mupdate?id=${friends.users.id}" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
            <button style="padding: 2px 6px;text-decoration: none;color: white;" type="button" class="btn btn-sm btn-danger deleteSector"><a style="text-decoration: none;color: white;" class="deleteNo" href="javascript:del(${friends.id})" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button>

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
                url:"${pageContext.request.contextPath }/friends/del/"+obj ,
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
