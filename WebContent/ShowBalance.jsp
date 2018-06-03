<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 查询余额页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/3.jpg)">
<center>
<font face="楷体" size="4" color="#000">
查询余额
</font>
<br>
<br>
<table border="1">
<tr>
<td>用户Id</td>
<td>银行卡号</td>
<td>余额</td>
<td>开户日期</td>

</tr>
<%
HttpSession s=request.getSession();
List<String> li=(List<String>)s.getAttribute("table");
if(li!=null){
	for(int i=0;i<li.size();i=i+4){
		%>
		<tr>
		<td><%=li.get(i) %></td>
		<td><%=li.get(i+1) %></td>
		<td><%=li.get(i+2) %></td>
		<td><%=li.get(i+3) %></td>
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