package uiv6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {

	final static String SERVER = "localhost";
	final static String USER = "root";
	final static String PASS = "whycantiusemyfingerprint";
	final static Integer PORT = 3306;
	final static String DB_NAME = "macro_calculator";
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DB_NAME;

	// Connect to the database
	public Connection connect() {
		Connection conn = null;
		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Database Connected!");
		} catch (Exception ex) {
			System.out.println("Database Connection Failed: " + ex.getMessage()); // Error message
		}
		return conn;
	}

	// Close connection
	public void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Database Connection Closed.");
			}
		} catch (SQLException ex) {
			System.out.println("Error Closing Connection: " + ex.getMessage()); // Error message
		}
	}
}