package servlet2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Object.UserAccount;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserAccount user = new UserAccount();
		UserAccount use = null;
		try {
			use = user.getUserLogin(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String erorr=null;
		HttpSession session=request.getSession(false);
		if(use !=null)
		{
				session.setAttribute("loginuser", use);
				//RequestDispatcher dispatcher = request.getServletContext()
				//		.getRequestDispatcher("/view/homeLogin.jsp");
				//dispatcher.forward(request, response);
				response.sendRedirect(request.getContextPath()+"/homeLogin");
				
		}
		else
		{
			erorr = "Tài khoản hoặc mật khẩu sai!";
			request.setAttribute("er", erorr);
			response.sendRedirect(request.getContextPath()+"/pageLogin");
		}
		doGet(request, response);
	}

}
