package tn.edu.esprit.cinfo2.tunRecrute.service.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

public class Business {

	public boolean authentification(String login, String password) {
		boolean authentified = false;
		Connection connection = MySqlUtilities.GiveMeConnection();

		try {

			String strQuerry = "SELECT count(*) FROM member  WHERE Login = '"
					+ login + "' AND Password = '" + password + "'";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					System.out.println("Invalid Login/Password .. try again");
				} else {
					System.out.println("Welcome " + login);
					authentified = true;
				}
			}
			st.close();
			connection.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return authentified;
	}

}
