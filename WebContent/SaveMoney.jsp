<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 这是具体要存多少钱的页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/4.jpg)">
<center>
<font face="楷体" size="4" color="#000">
存款金额填写
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
<Form action="SaveMoneyServlet" method="post">
请填写存款金额:  <input type="text" name="money">
<input type="hidden" name="cardid" value=<%=cardid %>>
<br>
<br>
<input type="submit" value="存款">
</Form>
<br>
<br>
返回<a href="SavelnMoney.jsp">上一页</a>
</font>
</center>
</body>
</html>