<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 主页面，当用户名密码都正确则进入该页面 -->
<!-- 顶部显示欢迎您+姓名 -->
<!-- 该页面有 修改密码、存款、取款、查询余额、查询交易历史、转账、返回登录页面按钮 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/2.jpg)">
<center>
<font face="楷体" size="6" color="#000">
<%
HttpSession s=request.getSession();
String info=(String)s.getAttribute("username");  
%>  
欢迎您，<%=info%>
<%   
%>
</font>
<Font face="宋体" size="4" color="#000">
<br><br><a href="ChangePw.jsp">修改密码</a>
<br><br><a href="ShowCardServlet?where=<%=0 %>">存款</a>
<br><br><a href="ShowCardServlet?where=<%=1 %>">取款</a>
<br><br><a href="ShowCardServlet?where=<%=2 %>">查询余额</a>
<br><br><a href="ShowHistory">查询交易历史</a>
<br><br><a href="ForwardMoney.jsp">转账</a>
</Font>
<Font face="楷体" size="5" color="#001">
<br>
<br>
<a href="Login.jsp">返回登录页面</a>
</Font>
</center>
</body>
</html>