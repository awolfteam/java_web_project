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
 * Servlet implementation class AddBillServlet
 */
@WebServlet("/AddBillServlet")
public class AddBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String billId = request.getParameter("billId");
		String productName = request.getParameter("billName");
		String productNum = request.getParameter("billNum");
		String tradeNum = request.getParameter("money");
		String billDate = request.getParameter("billDate");
		String proName = request.getParameter("proName");
		String productDesc = request.getParameter("discription");
		String isPay = request.getParameter("isPay");
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			runner.update("insert into bill1 values(null,?,?,?,?,?,?,?)", productName, productNum, tradeNum, isPay,
					proName, productDesc, billDate);

			response.sendRedirect("ShowBillServlet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
