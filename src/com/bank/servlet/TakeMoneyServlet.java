package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UseCard;
import com.bank.loginbean.Card;

/**
 * Servlet implementation class TakeMoneyServlet
 */
@WebServlet("/TakeMoneyServlet")
public class TakeMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> li=new ArrayList<String>();
		Card ca=new Card();
		UseCard uc=new UseCard();
		String tmoney=request.getParameter("tmoney");
		String pd=request.getParameter("pd");
		String cardid=request.getParameter("cardid");
		float f=Float.parseFloat(tmoney);
		ca.setCardId(cardid);
		if(tmoney==null||"".equals(tmoney)){
			li.add("请输入取款金额");
		}
		if(pd==null||"".equals(pd)){
			li.add("请输入密码");
		}
		if(pd!=null&&"".equals(pd)==false&&tmoney!=null&&"".equals(tmoney)==false){
			if(uc.Islegal(ca, pd)){
				if(f<0){
					li.add("输入金额必须大于0");
				}else{
					if(uc.isEnough(ca, f)==false){
						li.add("余额不足");
					}
				}
			}else{
				li.add("密码错误");
			}
		}
		if(li.size()==0){
			if(uc.deCreaseMoney(ca,f)){
				PrintWriter out=response.getWriter();
				out.print("<script>alert('Success');window.location.href='ShowCardServlet?where=1'</script>");
			}
		}

		if(li.size()!=0){
			request.setAttribute("li", li);
			request.getRequestDispatcher("TakeMoney.jsp").forward(request, response);
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
