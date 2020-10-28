package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import tools.C3P0Utils;

/**
 * Servlet implementation class UpdateBillServlet
 */
@WebServlet("/UpdateBillServlet")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("bid");
		String productName = request.getParameter("billName");
		String productNum = request.getParameter("billNum");
		String tradeNum = request.getParameter("money");
		String billDate = request.getParameter("billDate");
		String proName = request.getParameter("proName");
		String productDesc = request.getParameter("discription");
		String isPay = request.getParameter("isPay");
		String subType = request.getParameter("submit");

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		if (subType.equals("修改")) {
			try {
				runner.update(
						"update bill1 set productName=?,productNum=?,tradeNum=?,isPay=?,p_id=?,productDesc=?,billDate=? where bid=?",
						productName, productNum, tradeNum, isPay, proName, productDesc, billDate,id);
				response.sendRedirect("ShowBillServlet");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (subType.equals("删除")) {
			try {
				runner.update("delete from bill1 where bid=?", id);
				response.sendRedirect("ShowBillServlet");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
