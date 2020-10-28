
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
public class showPerson_info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userName");
//		System.out.println(username);
//		resp.getWriter().write(username);

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			User user1 = runner.query("select * from user where username = ?", new BeanHandler<User>(User.class),
					username);
			// System.out.println(user);
			request.setAttribute("user_info", user1);
//			System.out.println(user1.toString());

//			request.setAttribute("count", 2);
			request.getRequestDispatcher("person_info.jsp").forward(request, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
