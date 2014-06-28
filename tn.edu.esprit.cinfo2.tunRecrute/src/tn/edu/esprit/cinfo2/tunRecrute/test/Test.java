package tn.edu.esprit.cinfo2.tunRecrute.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

public class Test {
	public static void main(String[] args) {
		Connection connection = MySqlUtilities.GiveMeConnection(); 
        try {
			Statement statement = connection.createStatement();
			String sql = "drop table if ...."; 
			statement.execute(sql); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
}
