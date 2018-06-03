package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.bank.dao.*;
import com.bank.loginbean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePwServlet
 */
@WebServlet("/ChangePwServlet")
public class ChangePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pw1=request.getParameter("boy1");
		String pw2=request.getParameter("boy2");
		String pw3=request.getParameter("boy3");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("useid");
		String pw=(String)session.getAttribute("pw");
		List<String> flog=new ArrayList<String>();
		
		if(pw1==null||"".equals(pw1)){
			flog.add("请输入原密码");
		}
		if(pw2==null||"".equals(pw2)){
			flog.add("请输入新密码");
		}
		if(pw2!=null&&"".equals(pw2)==false&&pw3==null||pw2!=null&&"".equals(pw2)==false&&"".equals(pw3)){
			flog.add("请再次输入密码");
		}
		if(pw2!=null&&"".equals(pw2)==false&&pw3!=null&&"".equals(pw3)==false&&pw2.equals(pw3)==false){
			flog.add("输入的两次密码不一致");
		}
		if(pw1!=null&&"".equals(pw1)==false&&pw2!=null&&"".equals(pw2)==false&&pw3!=null&&"".equals(pw3)==false&&pw2.equals(pw3)&&pw1.equals(pw)==false){
			flog.add("原密码错误");
		}
		if(flog.size()==0){
			Client c=new Client();
			c.setUseId(id);
			c.setPassWd(pw2);
			UseDao ud=new UseDao();
			if(ud.updatePw(c)){
				session.setAttribute("pw", c.getPassWd());
				
				/*密码修改成功后跳出弹窗提示修改成功并重新返回登录界面*/
				PrintWriter out=response.getWriter();
				out.print("<script>alert('Success');window.location.href='Login.jsp'</script>");
//				response.sendRedirect("ChangePwSuccess.jsp");
			}else{
				PrintWriter out=response.getWriter();
				out.print("<script>alert('Failure');window.location.href='ChangePw.jsp'</script>");
			}
		}
		if(flog.size()!=0){
			request.setAttribute("flog", flog);
			request.getRequestDispatcher("ChangePw.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
