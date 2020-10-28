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

import model.User;
import tools.C3P0Utils;

/**
 * Servlet implementation class ShowUserListServlet
 */

public class ShowUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			List<User> user = runner.query("select * from user", new BeanListHandler<User>(User.class));
			request.setAttribute("user", user);
			request.setAttribute("count", 1);
			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
