<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/3.jpg)">
<center>
<Font face="楷体" size="4" color="#000">
取款金额填写
<br>
<br>
<%
List<String> info=(List<String>)request.getAttribute("li");  
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
<%
String cardid=(String)request.getParameter("cardid");
%>
目标银行卡号：<%=cardid %>
<br>
<br>
<Form action="TakeMoneyServlet" method="post">
请输入取款金额：     <input type="text" name="tmoney" size="24">
<br>
<br>
请输入银行卡密码：<input type="password" name="pd" size="25">
<br>
<input type="hidden" name="cardid" value=<%=cardid %>>
<br>
<input type="submit" value="取款">
</Form>
<br>
<br>
返回<a href="TakeOutMoney.jsp">上一页</a>
</Font>
</center>
</body>
</html>