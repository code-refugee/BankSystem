<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 转账页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/4.jpg)">
<center>
<Font face="楷体" size="4" color="#000">
<br>
<br>
银行卡转账
<br>
<%
List<String> io=(List<String>)request.getAttribute("lis");  
if(io!=null){  
    Iterator<String> iter=io.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%>
<form action="confirmMessageServlet" method="post">
<br><br>请输入转出卡号：           <input type="text" name="formid" size="24">
<br><br>请输入转入卡号：           <input type="text" name="toid" size="24">
<br><br>请输入客户姓名:     <input type="text" name="cname" size="24">
<br><br>请输入转账金额：           <input type="text" name="fomoney" size="24">
<br><br>请输入转出卡号密码： <input type="password" name="pasd" size="25">
<br><br><input type="submit" value="转账">
</form>
<br>
<br>
返回<a href="MainPage.jsp">主界面</a>
</Font>
</center>
</body>
</html>