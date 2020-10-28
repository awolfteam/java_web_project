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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String s = request.getParameter("button");
		String id = request.getParameter("flag");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String issupper = request.getParameter("issupper");
		
		System.out.println(username +"-"+ id+"-"+sex+"-"+tel+"-"+email);
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		if (s.equals("修改")) {
			try {

//				String sql = "update user set password=?,sex=?,age=?,tel=?,email=?,address=?,issupper=? where username=?";
				// 调用方法
//				int num = runner.update(sql,
//						new Object[] { password, sex, age, tel, email, address, issupper, username });
//				System.out.println(num);
//				int num = runner.update(sql);

//				
				int is_ok=runner.update("update user set password=?,sex=?,age=?,tel=?,email=?,address=?,issupper=? where id=?",
						 password, sex, age, tel, email,address, issupper, id);
			
			
//				 System.out.println(is_ok>0?"成功":"失败");
//				sqlSession.commit();
//		        sqlSession.close();
//				response.sendRedirect(request.getContextPath() + "/ShowUserListServlet");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		if ("删除".equals(s)) {
			try {
//				 String sqlString= "delete from user where id="+   "'"+    id+"'";
//				 System.out.println(sqlString);
//				 runner.update(sqlString);
				 int num =runner.update("delete from user where id=?", id);
//				 System.out.println(num>0?"成功":"失败");

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		response.sendRedirect("ShowUserListServlet");
	}

}
