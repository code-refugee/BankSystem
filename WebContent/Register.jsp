<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--这是一个注册页面，能提供验证码 ，新加 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function again(obj) {
		obj.src = "imageServlet?" + Math.random();
	}
</script>
</head>
<body style="background: url(image/3.jpg)">
	<center>
	<%
List<String> info=(List<String>)request.getAttribute("lnew");  
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
	<Font face="正楷" size="4" color="#000">新用户注册</Font>
	<br>
	<br>
		<form action="RegisterServlet" method="post">
			<label>姓名:</label><input type="text" name="newname" /><br>
			<br> <label>密码:</label><input type="password" name="newpwd1" /><br>
			<br> <label>确认密码:</label><input type="password" name="newpwd2" /><br>
			<br> <label>验证码:</label> <input type="text" name="randomCode"
				value="区分大小写" />&nbsp;<img title="点击更换"
				onclick="javascript:again(this);" src="imageServlet"> <br /> <br />
			<input type="submit" value="提交">
		</form>
		<br> <br> 返回<a href="Login.jsp">主界面</a>
	</center>
</body>
</html>