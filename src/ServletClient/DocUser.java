package ServletClient;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.Document;
import Object.Order;
import Object.UserAccount;

/**
 * Servlet implementation class DocUser
 */
@WebServlet("/docUser")
public class DocUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order ord = new Order();
		int id = Integer.parseInt(request.getParameter("idacc"));
		List<Order> list = null;
		try {
			list = Order.getOrderByAcc(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("orderList", list);
		List<UserAccount> listAcc = null;
		List<Document> listDoc = null;
	
		
			try {
				listAcc = UserAccount.getAllUser();
				listDoc = Document.getAllDocument();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("AccList", listAcc);	
		request.setAttribute("DocList", listDoc);
		;


		
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		//RequestDispatcher dispatcher = request.getServletContext()
				//.getRequestDispatcher("/index.jsp");
		RequestDispatcher dispatcher = request.getServletContext()
		.getRequestDispatcher("/view/doc_user.jsp");
		dispatcher.forward(request, response);
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
