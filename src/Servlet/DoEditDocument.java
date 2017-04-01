package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.Business;
import Object.Category;
import Object.Classes;
import Object.Document;
import Object.Teacher;

/**
 * Servlet implementation class DoEditDocument
 */
@WebServlet("/doEditDocument")
public class DoEditDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditDocument() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String docname = (String)request.getParameter("txtDoc");
		int cate = Integer.parseInt(request.getParameter("selCat"));
		int tea = Integer.parseInt(request.getParameter("selTea"));
		float point = Float.parseFloat(request.getParameter("txtPoint"));
		String stu = (String)request.getParameter("txtStu");
		int bus = Integer.parseInt(request.getParameter("selBus"));
		int cla = Integer.parseInt(request.getParameter("selCla"));
		int stat = Integer.parseInt(request.getParameter("rdoStat"));
		
		Document docs = null;
		docs =  new Document(id, docname, cate, tea, point, stu, bus, cla, stat);
			
		try {
			doc.updateDocument(docs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	
		
		//response.sendRedirect(request.getContextPath() + "/userList");
		//response.sendRedirect(request.getContextPath() + "/editAccount");
		Document docss =null;
		try {
			docss = doc.getDocumentByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Document", docss);
		String status = null;
		status = "Cập nhật thành công!";
		request.setAttribute("stat", status);
			
		List<Business> listBus = null;
		List<Classes> listCla = null;
		List<Category> listCat = null;
		List<Teacher> listTea = null;
		
			try {
				listBus = Business.getAllBusiness();
				listCla = Classes.getAllClass();
				listCat = Category.getAllCategory();
				listTea = Teacher.getAllTeacher();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("BusList", listBus);	
		request.setAttribute("ClaList", listCla);
		request.setAttribute("CatList", listCat);
		request.setAttribute("TeaList", listTea);
		
		//PrintWriter out = response.getWriter();
		//response.setHeader("Refresh", "3; url=editAccount");
		//response.sendRedirect(request.getContextPath()+"/editDocument");
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/doc_edit.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
