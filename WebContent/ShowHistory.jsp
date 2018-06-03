<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 查看交易历史 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/3.jpg)">
<center>
<Font face='正楷' size='4' color='#000'>查看交易历史</Font>
<br>
<br>
<table border='1'>
<tr>
<td>转出卡号</td>
<td>转入卡号</td>
<td>客户姓名</td>
<td>转账金额</td>
<td>交易日期</td>
</tr>
<%
HttpSession s=request.getSession();
List<String> li=(List<String>)s.getAttribute("his");
if(li!=null){
	for(int i=0;i<li.size();i=i+5){
		%>
		<tr>
		<td><%=li.get(i) %></td>
		<td><%=li.get(i+1) %></td>
		<td><%=li.get(i+2) %></td>
		<td><%=li.get(i+3) %></td>
		<td><%=li.get(i+4) %></td>
		</tr>
		<%
	}
} 
%>
</table>
<br>
<br>
<font face="楷体" size="4" color="#000">
<a href="MainPage.jsp">返回主界面</a>
</font>
</center>
</body>
</html>