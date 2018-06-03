<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/5.jpg)">
<center>
<Font face="正楷" size="4" color="#000">
系统消息
<br>
<br>
<%
HttpSession s=request.getSession();
String id=(String)s.getAttribute("newid");
%>
注册成功，你的用户名为<%=id %>
<br>
<br>
返回<a href="Login.jsp">登录界面</a>
</Font>
</center>
</body>
</html>