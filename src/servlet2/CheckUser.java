package servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.UserAccount;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
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
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {

	            String connectionURL = "jdbc:mysql://localhost:3306/project"; // students is my database name
	            Connection connection = null;
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            connection = DriverManager.getConnection(connectionURL, "root", "");
	            String uname = request.getParameter("txtUser");
	            PreparedStatement ps = connection.prepareStatement("select username from user where username=?");
	            ps.setString(1,uname);
	            ResultSet rs = ps.executeQuery();
	             
	            if (!rs.next()) {
	                out.println("");
	            }
	            else{
	            out.println("<font color=red><p id=status>Đã được sử dụng!</p></font>");
	            }
	            out.println();



	        } catch (Exception ex) {

	            out.println("Error ->" + ex.getMessage());

	        } finally {
	            out.close();
	        }
	}

}
