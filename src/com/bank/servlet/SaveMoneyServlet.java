package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.bank.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.loginbean.*;
/**
 * Servlet implementation class SaveMoneyServlet
 */
@WebServlet("/SaveMoneyServlet")
public class SaveMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String money=request.getParameter("money");
		float f=Float.parseFloat(money);
		String cardid=request.getParameter("cardid");
		List<String> li=new ArrayList<String>();
		if(money==null||"".equals(money)){
			li.add("请输入存款金额");
		}
		if(f<0){
			li.add("输入金额必须大于0");
		}
		if(li.size()==0){
			Card ca=new Card();
			ca.setCardId(cardid);
			ca.setMoney(f);
			UseCard uc=new UseCard();
			if(uc.inCreaseMoney(ca)){
				PrintWriter out=response.getWriter();
				out.print("<script>alert('Success');window.location.href='ShowCardServlet?where=0'</script>");
			}
		}
		if(li.size()!=0){
			request.setAttribute("li", li);
			request.getRequestDispatcher("SaveMoney.jsp").forward(request, response);
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
