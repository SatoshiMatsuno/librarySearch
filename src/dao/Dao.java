package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Const.Const;

public class Dao {
	
	public Connection getConnectDb(Connection conn) throws SQLException {
		conn = DriverManager.getConnection(Const.JDBC_URL, Const.DB_USER, Const.DB_PASS);
		return conn;
	}
	
	public void closeConnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
