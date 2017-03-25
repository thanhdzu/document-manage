package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Bool;

import Model.MD5Digest;
import Object.UserAccount;

/**
 * Servlet implementation class DoCreateAccount
 */
@WebServlet("/doCreateAccount")
public class DoCreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = new UserAccount();
		MD5Digest md = new MD5Digest();
		String use = (String)request.getParameter("txtUser");
		String psw = (String)request.getParameter("txtPass");
		String name = (String)request.getParameter("txtName");
		String pho = (String)request.getParameter("txtPhone");
		String mail = (String)request.getParameter("txtEmail");
		String lev = request.getParameter("rdoLevel");
		psw = md.getMD5(psw);
		boolean a;
		int b = Integer.parseInt(lev);
		int c;
		if (b==1)
			a = true;
		else
			a = false;
		UserAccount useri = new UserAccount(use, psw, name, mail, pho, a);
		String status = null;
		status = "Thêm thành công!";
		try {
			user.insertAccount(useri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 status = "Thêm lỗi!";
		}
		
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "3; url=createAccount");
	
		request.setAttribute("stat", status);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/user_add.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
