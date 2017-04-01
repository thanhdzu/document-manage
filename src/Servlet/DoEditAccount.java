package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.UserAccount;

/**
 * Servlet implementation class DoEditAccount
 */
@WebServlet("/doEditAccount")
public class DoEditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditAccount() {
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
		request.setCharacterEncoding("utf-8");
		UserAccount user = new UserAccount();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String usename = (String)request.getParameter("txtUser");
		String pass = (String)request.getParameter("txtPass");
		String name = (String)request.getParameter("txtName");
		String phone = (String)request.getParameter("txtPhone");
		String mail = (String)request.getParameter("txtEmail");
		String level = (String)request.getParameter("rdoLevel");
		boolean a;
		int b = Integer.parseInt(level);
		int c;
		if (b==1)
			a = true;
		else
			a = false;
		UserAccount use = null;
		use =  new UserAccount(id, usename, name, mail, phone, a);
			
		try {
			user.updateAccountNoPSW(use);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pass!="")
		{try {
			user.updatePassword(id, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		
		
	
		
		//response.sendRedirect(request.getContextPath() + "/userList");
		//response.sendRedirect(request.getContextPath() + "/editAccount");
		UserAccount us =null;
		try {
			us = user.getAccountByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("use", us);
		String status = null;
		status = "Cập nhật thành công!";
		request.setAttribute("stat", status);
			
		
		
		//PrintWriter out = response.getWriter();
		//response.setHeader("Refresh", "3; url=editAccount");
	
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/user_edit.jsp");
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

	
}
