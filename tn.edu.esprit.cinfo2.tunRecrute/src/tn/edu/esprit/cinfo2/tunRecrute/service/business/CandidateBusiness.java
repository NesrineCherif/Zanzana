package tn.edu.esprit.cinfo2.tunRecrute.service.business;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class CandidateBusiness {
	
	public List<Candidate> findCandidateByResume(String keyWord) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;
		ResultSet memberResultSet = null;

		String login = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		Date dateOfBirth = null;
		List<Candidate> candidates = new ArrayList<Candidate>();

		try {

			String strQuerry = "SELECT * FROM candidate WHERE resume LIKE '%"+keyWord+"%'";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idCandidate = resultSet.getInt("id");
				int idMember = resultSet.getInt("id_member");

				String memberQuerry = "SELECT * FROM member WHERE id ="
						+ idMember + "";
				Statement stMember = connection.createStatement();
				stMember.executeQuery(memberQuerry);
				memberResultSet = (ResultSet) stMember.getResultSet();
				while (memberResultSet.next()) {
					login = memberResultSet.getString("login");
					password = memberResultSet.getString("password");
					firstName = memberResultSet.getString("firstName");
					lastName = memberResultSet.getString("lastName");
					email = memberResultSet.getString("email");
					dateOfBirth = memberResultSet.getDate("dateOfBirth");
				}

				String resume = resultSet.getString("resume");
				String cvPath = resultSet.getString("cvPath");

				Candidate candidate = new Candidate(idMember, login, password,
						firstName, lastName, email, dateOfBirth, idCandidate,
						resume, cvPath);

				candidates.add(candidate);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidates;
	}


}
