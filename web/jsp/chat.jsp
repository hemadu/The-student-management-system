<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/10/8
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div  class="tab-content" style="margin-left: 120px;width: 1000px;">
    <c:forEach var="message" items="${messageList}" varStatus="status">

    <textarea readonly class="common-textarea" cols="30" style="width: 100%;height: 350px;" rows="10">
	${message.users.name}                                         时间:   ${message.time}
	：${message.content}
								</textarea>
    </c:forEach>
</body>
</html>
