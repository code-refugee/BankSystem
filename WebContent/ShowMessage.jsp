<%@ page import="java.util.List" %>
<%@page import="java.util.Iterator"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 显示转账信息 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/4.jpg)">
<center>
<br>
<br>
转账信息确认
<br>
<br>
<%
HttpSession s=request.getSession();
List<String> io=(List<String>)request.getAttribute("li");  
if(io!=null){  
    Iterator<String> iter=io.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%>
<br>
<br>
<table border="1">
<tr>
<td>转出银行卡号</td>
<td><%=s.getAttribute("formid") %></td>
</tr>
<tr>
<td>转入银行卡号</td>
<td><%=s.getAttribute("toid") %></td>
</tr>
<tr>
<td>客户姓名</td>
<td><%=s.getAttribute("cname") %></td>
</tr>
<tr>
<td>转账金额</td>
<td><%=s.getAttribute("fomoney") %></td>
</tr>
<tr>
<td>交易日期</td>
<td><%=s.getAttribute("date") %></td>
</tr>
</table>
<br>
<br>
<a href="forwardServlet">确认转账</a>
<br>
<br>
返回<a href="ForwardMoney.jsp">上一页</a>
</center>
</body>
</html>