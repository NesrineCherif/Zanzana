package tn.edu.esprit.cinfo2.tunRecrute.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtilities {

	private static Connection myConnection;
	private static String url = "jdbc:mysql://localhost/tunrecrutdb";
	private static String user = "root";
	private static String password = "root";

	public static Connection GiveMeConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			myConnection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConnection;
	}
}
