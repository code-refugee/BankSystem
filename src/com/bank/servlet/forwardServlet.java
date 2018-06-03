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
import com.bank.loginbean.Trade;

/**
 * Servlet implementation class forwardServlet
 */
@WebServlet("/forwardServlet")
public class forwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se=request.getSession();
		String formid=(String)se.getAttribute("formid");
		String toid=(String)se.getAttribute("toid");
		String cname=(String)se.getAttribute("cname");
		String fomoney=(String)se.getAttribute("fomoney");
		String date=(String)se.getAttribute("date");
		String useid=(String)se.getAttribute("useid");
		float f=Float.parseFloat(fomoney);
		List<String> li=new ArrayList<String>();
		Card ca=new Card();
		Trade t=new Trade();
		UseCard uc=new UseCard();
		ca.setCardId(formid);
		if(uc.isEnough(ca, f)==false){
			li.add("余额不足");
		}
		if(li.size()==0){
			if(uc.deCreaseMoney(ca, f)){
				ca.setCardId(toid);
				ca.setMoney(f);
			}if(uc.inCreaseMoney(ca)){
				//同步交易记录
				t.setFormCardId(formid);
				t.setToCardId(toid);
				t.setTradeMoney(f);
				t.setTradeTime(date);
				t.setUseId(useid);
				uc.addHistroy(t);
				String s="您已向"+cname+"转账"+fomoney;
				se.setAttribute("suc", s);
				PrintWriter out=response.getWriter();
				out.print("<script>alert('Success');window.location.href='Success.jsp'</script>");
			}
		}
		if(li.size()!=0){
			request.setAttribute("li", li);
			request.getRequestDispatcher("ShowMessage.jsp").forward(request, response);
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
