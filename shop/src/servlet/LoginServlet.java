package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import model.User;
import tools.C3P0Utils;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		String check_codeString = req.getParameter("check_code");
		String save_code = (String) req.getSession().getAttribute("check_code");

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {

			User user = runner.query("select username,password,issupper from user where username = ? and password = ?",
					new BeanHandler<User>(User.class), username, password);

			if (user != null&&check_codeString.equals(save_code)) {
				req.getSession().setAttribute("isLogin", true);
				req.getSession().setAttribute("loginer", user);


				resp.sendRedirect(req.getContextPath() + "/admin_index.html");
			} else if (check_codeString.equals(save_code)) {
//					PrintWriter out = resp.getWriter();
//					out.write("验证码错误");
				resp.getWriter().print("<script>alert('验证码错误');window.history.back()</script>");

			} else {
				// 登录失败
				// 向前端进行输出，可以输出普通字符，也可以是前端代码，这样浏览器会对前端代码进行执行
				resp.getWriter().print("<script>alert('用户名或密码错误');window.history.back()</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
