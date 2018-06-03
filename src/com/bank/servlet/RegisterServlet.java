package com.bank.servlet;

/*用于处理注册的servlet*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.wb.web.*;
import com.bank.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bank.loginbean.*;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newname=request.getParameter("newname");
		String newpsw1=request.getParameter("newpwd1");
		String newpsw2=request.getParameter("newpwd2");
		String randomCode=request.getParameter("randomCode");
		HttpSession s=request.getSession();
		String re=(String)s.getAttribute("RANDOMVALIDATECODEKEY");
		List<String> lnew=new ArrayList<String>();
		Client c=new Client();
		UseDao ud=new UseDao();
		if(newname==null||"".equals(newname)){
			lnew.add("请输入姓名");
		}
		if(newpsw1==null||"".equals(newpsw1)){
			lnew.add("请输入密码");
		}
		if(randomCode==null||"".equals(randomCode)){
			lnew.add("请输入验证码");
		}
		if(newpsw1!=null&&"".equals(newpsw1)==false&&newpsw2==null||
				newpsw1!=null&&"".equals(newpsw1)==false&&"".equals(newpsw2)){
			lnew.add("请再次输入密码");
		}
		if(newpsw1!=null&&"".equals(newpsw1)==false&&newpsw2!=null&&"".equals(newpsw2)==false
				&&newpsw1.equals(newpsw2)==false){
			lnew.add("输入的两次密码不一致");
		}
		if(randomCode!=null&&"".equals(randomCode)==false&&randomCode.equals(re)==false){
			lnew.add("验证码错误");
		}
		if(lnew.size()==0){
			//提交的没错误时系统自动生成用户名，返回并添加
			String newid=ud.createNewId();
			c.setUseId(newid);
			c.setUseName(newname);
			c.setPassWd(newpsw1);
			ud.addClient(c);
			s.setAttribute("newid", newid);
			response.sendRedirect("RegisterSuccess.jsp");
		}
		if(lnew.size()!=0){
			request.setAttribute("lnew", lnew);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
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
