package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import tools.C3P0Utils;


public class AddProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String proName = request.getParameter("proName");		
		String proDesc = request.getParameter("proDesc");
		String contact = request.getParameter("contact");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String address = request.getParameter("address");
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		try {
			runner.update("insert into provider values(null,?,?,?,?,?,?)",proName,proDesc,contact,phone,fax,address);
			
			response.sendRedirect("ShowProviderListServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
