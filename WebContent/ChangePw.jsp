<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 修改密码页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(image/3.jpg)">
<center>
<Font face="楷体" size="4" color="#000">
<%
List<String> info=(List<String>)request.getAttribute("flog");  
if(info!=null){  
    Iterator<String> iter=info.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%>
<br><br>修改登录密码
<Form action="ChangePwServlet" method="post">
<br><br><br>
原密码：  <input type="text" name="boy1" size="24">
<br><br>新密码：  <input type="password" name="boy2" size="25">
<br><br>确认密码:<input type="password" name="boy3" size="25">
<br><br><input type="submit" value="确认">
</Form>
<br><br>
返回<a href="MainPage.jsp">主界面</a>
</Font>
</center>
</body>
</html>