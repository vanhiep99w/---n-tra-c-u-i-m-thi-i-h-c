package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {

	private static Connection conn = null;
	private Config con;
	
	public ConnectDB() {

	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(con.URL.getvalue(), con.USERNAME.getvalue(), con.PASS.getvalue());
			System.out.println(con.URL.getvalue());
			System.out.println("Kết nối thành công");
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại");
			e.printStackTrace();
		}
		return conn;
	}

	
}

