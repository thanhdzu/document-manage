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
 * Servlet implementation class DoEditAccountPW
 */
@WebServlet("/doEditAccountPW")
public class DoEditAccountPW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditAccountPW() {
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
		
		int id = Integer.parseInt(request.getParameter("idp"));
		String pass = (String)request.getParameter("txtPass");
			
			try {
				user.updatePassword(id, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				UserAccount use = null;
				
				try {
					use =  user.getAccountByID(id);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("use", use);
	
		
		String status = null;
		status = "Cập nhật thành công!";
	
			
		
		
		//PrintWriter out = response.getWriter();
		//response.setHeader("Refresh", "3; url=editAccount");
	
		request.setAttribute("stat", status);
		//response.sendRedirect(request.getContextPath() + "/editAccount");
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/user_edit.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
}
