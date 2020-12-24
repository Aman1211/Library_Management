package library.util;

import java.sql.*;

public class DBConnection {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/library";
		String username = "root";
		String password = "";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // loading mysql driver
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password); // attempting to connect to MySQL database
			System.out.println("Printing connection object " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
