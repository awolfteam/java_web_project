package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import model.User;
import tools.C3P0Utils;

/**
 * Servlet implementation class ShowUserListServlet
 */
@WebServlet("/showUser")
public class ShowUserListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Long pageCount = 10l;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		Long dataCount;
		Long page;

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			Map<String, Object> map = runner.query("SELECT COUNT(*) as count from user", new MapHandler());
			dataCount = (Long) map.get("count");

		} catch (SQLException e1) {
			dataCount = 0l;
			e1.printStackTrace();
		}

		if (dataCount % pageCount == 0) {
			page = dataCount / pageCount;
		} else {
			page = dataCount / pageCount + 1;
		}

		request.setAttribute("page", page);

		String str = request.getParameter("nowPage");

		Integer nowPage;
		if (str == null || str.length() == 0) {
			nowPage = 1;
		} else {
			// 如果传递的有pageNum参数，我们将它直接转成数字
			nowPage = Integer.valueOf(str);
		}

		request.setAttribute("nowPage", nowPage);

		long offset = (nowPage - 1) * pageCount;

		try {
			List<User> user = runner.query("select * from user limit ?,?", new BeanListHandler<User>(User.class),
					offset, pageCount);
			request.setAttribute("user", user);
			request.setAttribute("count", 1);
			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
