package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectDB;
import Object.Business;

/**
 * Servlet implementation class DeleteBusiness
 */
@WebServlet("/deleteBusiness")
public class DeleteBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBusiness() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void deleteDocumentByID(int id) throws SQLException, Exception{
		 String sql = "delete from documents where id_business=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
    public static void deleteOrderByID(int id) throws SQLException, Exception{
		 String sql = "delete from orders where id_document=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement ps = conn.openConnect().prepareStatement(sql);
		 ps.setInt(1, id);
		 ps.executeUpdate();
		 
	}
    

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbus = request.getParameter("id");
		Business bus = new Business();
		int idbu = Integer.parseInt(idbus);
			try {
				
				deleteDocumentByID(idbu);
				bus.deleteBusinessByID(idbu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		 response.sendRedirect(request.getContextPath() + "/businessList");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
