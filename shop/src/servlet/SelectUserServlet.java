package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import model.User;
import tools.C3P0Utils;

/**
 * Servlet implementation class SelectUserServlet
 */
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			User user1 = runner.query("select * from user where username = ?", new BeanHandler<User>(User.class),
					username);
			//System.out.println(user);
			request.setAttribute("user", user1);
			request.setAttribute("count", 2);
			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
