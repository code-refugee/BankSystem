package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.loginbean.*;
import com.bank.dao.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("id");
		String password=request.getParameter("pwd");
		HttpSession session=request.getSession();
		List<String> info=new ArrayList<String>();
		if(name==null||"".equals(name)){
			info.add("用户名不能为空");
		}
		if(password==null||"".equals(password)){
			info.add("密码不能为空");
		}
		if(info.size()==0){
			Client c=new Client();
			c.setUseId(name);
			c.setPassWd(password);
			UseDao ud=new UseDao();
			try {
				if(ud.findLogin(c)){
					 session.setAttribute("username", c.getUseName());//用session保存用户名
					 session.setAttribute("useid", c.getUseId());//用session保存用户id
					 session.setAttribute("pw", c.getPassWd());//用session保存用户密码
					 response.sendRedirect("MainPage.jsp");
				}
				else{
					response.sendRedirect("LoginFailure.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(info.size()!=0){
			request.setAttribute("info", info);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
