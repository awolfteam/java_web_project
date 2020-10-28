package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	// 得到一个数据源（连接池）
	private static DataSource ds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		synchronized (C3P0Utils.class) {
			if (ds == null) {
				ds = new ComboPooledDataSource();
			}
			return ds;
		}
	}

	/**
	 * 得到数据库连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn;
		try {
			conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙。。。");
		}
	}

	/**
	 * 关闭所有资源连接
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void releaseAll(Connection conn, Statement ps, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}

}