package Servlet;

import java.io.IOException;
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
 * Servlet implementation class EditDocument
 */
@WebServlet("/editDocument")
public class EditDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document doc = new Document();
		Document docs = null;
		List<Business> listBus = null;
		List<Classes> listCla = null;
		List<Category> listCat = null;
		List<Teacher> listTea = null;
		 String id = (String) request.getParameter("id");
		 	int iddoc =  Integer.parseInt(id);
	      String errorString = null;
	      try {
			docs = doc.getDocumentByID(iddoc);
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
			request.setAttribute("Document", docs);
	 
	      RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/admin/doc_edit.jsp");
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
