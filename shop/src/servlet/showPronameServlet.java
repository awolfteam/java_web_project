package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alibaba.fastjson.JSON;

import model.reserve;
import tools.C3P0Utils;

/**
 * Servlet implementation class ShowProviderServlet
 */
@WebServlet("/showProname")
public class showPronameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		try {
			List<reserve> provider = runner.query("select * from provider", new BeanListHandler<reserve>(reserve.class));
			
			String proname = JSON.toJSONString(provider);
			response.getWriter().println(proname);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
