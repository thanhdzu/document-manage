package ServletClient;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Object.Business;
import Object.Category;
import Object.Classes;
import Object.Document;
import Object.Order;
import Object.Teacher;

/**
 * Servlet implementation class DoOrderDocument
 */
@WebServlet("/doOrderDocument")
public class DoOrderDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoOrderDocument() {
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
		Order ord = new Order();
		String daterecieve = request.getParameter("dtp");
		Date dNow = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd  hh:mm:ss");

	    
		String creDate =ft.format(dNow).toString();
		int idacc=1;
		String[] docs = request.getParameterValues("id");
		try {
			ord.insertOrder(docs, idacc, daterecieve,creDate);
			ord.updateOrderStatus(docs, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		//RequestDispatcher dispatcher = request.getServletContext()
				//.getRequestDispatcher("/index.jsp");
		//RequestDispatcher dispatcher = request.getServletContext()
		//.getRequestDispatcher("/view/orderDocument.jsp");
		//dispatcher.forward(request, response);
        response.sendRedirect(request.getContextPath()+"/home");
		doGet(request, response);
	}

}
