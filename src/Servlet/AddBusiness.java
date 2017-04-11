package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.Business;

/**
 * Servlet implementation class AddBusiness
 */
@WebServlet("/addBusiness")
public class AddBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBusiness() {
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
		String bus = (String)request.getParameter("txtBusName");
		String err = null;
		Business busi = new Business();
		try {
			busi.insertBusiness(bus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err="Thêm lỗi!";
		}
		err = "Thêm thành công!";
		request.setAttribute("err", err);
		 response.sendRedirect(request.getContextPath() + "/businessList");
		doGet(request, response);
	}

}
