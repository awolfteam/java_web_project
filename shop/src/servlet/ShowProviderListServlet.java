package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.reserve;
import tools.C3P0Utils;

/**
 * Servlet implementation class ShowProviderServlet
 */
public class ShowProviderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		try {
			List<reserve> provider = runner.query("select * from provider", new BeanListHandler<reserve>(reserve.class));
			
			request.setAttribute("provider", provider);
			request.setAttribute("count", 1);
			request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
