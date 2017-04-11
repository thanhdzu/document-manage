package servlet2;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectDB;
import Object.Document;
import Object.Order;

/**
 * Servlet implementation class RecieveOrder
 */
@WebServlet("/recieveOrder")
public class RecieveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecieveOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public static void updateDate(int idord ,String dat) throws Exception
	{
		
		ConnectDB con = new ConnectDB();
	
		String query="update orders set  receive_time=? where id_order=?";
				
		PreparedStatement ps=con.openConnect().prepareStatement(query);  // generates sql query
		ps.setString(1, dat);
		ps.setInt(2, idord);
	
		ps.executeUpdate(); // execute it on test database
		System.out.println("update inserted");
		
		//ps.close();
		con.closeConnet();

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Order ord = new Order();
		Document doc = new Document();
		Date dNow = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd  hh:mm:ss");

	    
	      	String creDate =ft.format(dNow).toString();
		try {
			ord.updateStatus(id, 1);
			updateDate(id, creDate);
			doc.updateStatus(ord.idDoc(id), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/acceptOrderList");
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
