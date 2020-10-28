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

import model.Bill;
import tools.C3P0Utils;

/**
 * Servlet implementation class ShowBillServlet
 */
@WebServlet("/ShowBillServlet")
public class ShowBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
//		
//		String sql ="SELECT bid,productName,productNum,tradeNum,isPay,proName,productDesc,billDate FROM bill1,provider WHERE bill1.p_id=provider.pid";
//		try {
//			List<Bill> bill = runner.query(sql, new BeanListHandler<Bill>(Bill.class));
//			request.setAttribute("bill", bill);
//			request.setAttribute("count", 1);
//			request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("oooooo");
	}

}
