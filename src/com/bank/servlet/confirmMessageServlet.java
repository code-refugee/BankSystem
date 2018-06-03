package com.bank.servlet;
/*确认转账信息的servlet*/
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bank.dao.*;
import com.bank.loginbean.*;
/**
 * Servlet implementation class confirmMessageServlet
 */
@WebServlet("/confirmMessageServlet")
public class confirmMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formid=request.getParameter("formid");
		String toid=request.getParameter("toid");
		String cname=request.getParameter("cname");
		String fomoney=request.getParameter("fomoney");
		String pasd=request.getParameter("pasd");
		Date day=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		float fo=Float.parseFloat(fomoney);
		List<String> lis=new ArrayList<String>();
		HttpSession s=request.getSession();
		Card ca=new Card();
		UseCard uc=new UseCard();
		
		if(formid==null||"".equals(formid)){
			lis.add("请输入转出卡号");
		}
		if(toid==null||"".equals(toid)){
			lis.add("请输入转入卡号");
		}
		if(cname==null||"".equals(cname)){
			lis.add("请输入客户姓名");
		}
		if(pasd==null||"".equals(pasd)){
			lis.add("请输入密码");
		}
		if(fomoney==null||"".equals(fomoney)){
			lis.add("请输入转账金额");
		}
		if(formid!=null&&"".equals(formid)==false&&toid!=null&&"".equals(toid)==false
				&&cname!=null&&"".equals(cname)==false&&pasd!=null&&"".equals(pasd)==false
				&&fomoney!=null&&"".equals(fomoney)==false){
			ca.setCardId(formid);
			if(uc.existsCardId(ca)){
				if(uc.Islegal(ca, pasd)==false){
					lis.add("银行卡密码错误");
				}
			}else{
				lis.add("转入卡号不存在");
			}
			ca.setCardId(toid);
			if(uc.existsCardId(ca)){
				if(uc.isUse(ca, cname)==false){
					lis.add("客户名与转入银行卡不匹配");
				}
			}else{
				lis.add("转出卡号不存在");
			}
			if(fo<0){
				lis.add("输入金额应该大于0");
			}
		}
		if(lis.size()==0){
			s.setAttribute("date", df.format(day));//传日期
			s.setAttribute("formid", formid);
			s.setAttribute("toid", toid);
			s.setAttribute("fomoney", fomoney);
			s.setAttribute("cname", cname);
			response.sendRedirect("ShowMessage.jsp");
		
		}
		if(lis.size()!=0){
			request.setAttribute("lis", lis);
			request.getRequestDispatcher("ForwardMoney.jsp").forward(request, response);
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
