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

public class SelectProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String providerName = request.getParameter("providerName");
		String providerDesc = request.getParameter("providerDesc");

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			List<reserve> prov = runner.query(
					"SELECT * from provider where proName LIKE ? and proDesc like ?",
					new BeanListHandler<reserve>(reserve.class), '%' + providerName + '%', '%' + providerDesc + '%');
			request.setAttribute("pro", prov);
			request.setAttribute("count", 2);
			request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
