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
<Font face="正楷" size='4' color='#000'>
<br>
<br>
系统消息
<%
HttpSession se=request.getSession();
String s=(String)se.getAttribute("suc");
%>
<br>
<br>
<%=s %>
<br>
<br>
返回<a href="ForwardMoney.jsp">转账界面</a>
</Font>
</center>
</body>
</html>