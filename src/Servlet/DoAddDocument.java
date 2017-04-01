package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Object.Document;
import Object.UserAccount;
/**
 * Servlet implementation class DoAddDocument
 */
@WebServlet("/doAddDocument")
public class DoAddDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAddDocument() {
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
		Document doc = new Document();
		String docname = (String)request.getParameter("txtDoc");
		int cate = Integer.parseInt(request.getParameter("selCat"));
		int tea = Integer.parseInt(request.getParameter("selTea"));
		float point = Float.parseFloat(request.getParameter("txtPoint"));
		String student = (String)request.getParameter("txtStu");
		int bus = Integer.parseInt(request.getParameter("selBus"));
		int cla = Integer.parseInt(request.getParameter("selCla"));
		int stat = Integer.parseInt(request.getParameter("stat"));
		
		
		Document docs = new Document(1, docname, cate, tea, point, student, bus, cla, stat);
		String status = null;
		status = "Thêm thành công!";
		try {
			doc.insertDocument(docs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 status = "Thêm lỗi!";
		}
		
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "3; url=addDocument");
	
		request.setAttribute("stat", status);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/doc_add.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
