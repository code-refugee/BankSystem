<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 这是一个登录页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行账户管理系统</title>
</head>
<body style="background: url(image/1.jpg)">
<center>

<%
List<String> info=(List<String>)request.getAttribute("info");  
if(info!=null){  
    Iterator<String> iter=info.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%>
<br>
<br>
<font face="楷体" size="6" color="#000">银行账户管理系统登录平台</font>
<form action="LoginServlet" method="post">
<br>登录账户：  <input type="text" name="id" size="24">
<br>
<br>登录密码： <input type="password" name="pwd" size="25">
<br>
<br>
<input type="submit" name="submit1" value="登录" >
</form>
<br>
<br>
<br>
<a href="Register.jsp">注册</a>
</center>
</body>
</html>