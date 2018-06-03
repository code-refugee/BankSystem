package com.bank.servlet;
import com.bank.dao.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bank.loginbean.*;
/**
 * Servlet implementation class ShowCardServlet
 */
@WebServlet("/ShowCardServlet")
public class ShowCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String i=request.getParameter("where");
		String useid=(String)session.getAttribute("useid");
		List<String> li=new ArrayList<String>();
		Client c=new Client();
		c.setUseId(useid);
		UseCard uc=new UseCard();
		li=uc.findCard(c);
		session.setAttribute("table", li);
		//根据where的值来决定转跳到哪个页面
		if("0".equals(i)){
			response.sendRedirect("SavelnMoney.jsp");
		}
		if("1".equals(i)){
			response.sendRedirect("TakeOutMoney.jsp");
		}
		if("2".equals(i)){
			response.sendRedirect("ShowBalance.jsp");
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
