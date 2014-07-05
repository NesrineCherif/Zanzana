package tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces.ICandidate;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class CandidateImpl implements ICandidate {

	@Override
	public boolean addCandidate(Candidate candidate) {
		int idMember = 0;
		int updateCount = 0;
		boolean isAdded = false;
		Connection connection = (Connection) MySqlUtilities.GiveMeConnection();
		try {
			MemberImpl memberImpl = new MemberImpl();
			Statement st = connection.createStatement();

			idMember = memberImpl.addMember(candidate);
			if (idMember != 0) {

				String strQuerry = "INSERT INTO candidate " + "VALUES ("
						+ candidate.getIdCandidate() + ",'"
						+ candidate.getResume() + "','" + candidate.getCvPath()
						+ "'," + idMember + ")";

				st.executeUpdate(strQuerry);
				updateCount = st.getUpdateCount();
				if (updateCount != 0) {
					System.out.println("Candidate is inserted");
					isAdded = true;
				}

				st.close();
				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteCandidate(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isDeleted = false;
		int updateCount = 0;
		try {

			String strQuerry = "DELETE FROM member WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeUpdate(strQuerry);

			updateCount = st.getUpdateCount();

			if (updateCount != 0) {
				System.out.println("Candidate is deleted");
				isDeleted = true;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updateCandidate(int id, Candidate candidate) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isUpdated = false;

		int updateCount = 0;
		try {

			Candidate candidateFound = findCandidateById(id);

			if (candidateFound == null) {
				System.out.println("Candidate not found");
			} else {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateOfBirth = dateFormat.format(candidate
						.getDateOfBirth());
				Statement st = connection.createStatement();
				String strQuerry = "UPDATE member set " + " login=" + "'"
						+ candidate.getLogin() + "'" + ", password=" + "'"
						+ candidate.getPassword() + "'" + ", firstName=" + "'"
						+ candidate.getFirstName() + "'" + ", lastName=" + "'"
						+ candidate.getLastName() + "'" + ", email=" + "'"
						+ candidate.getEmail() + "'" + ", dateOfBirth=" + "'"
						+ dateOfBirth + "'" + " WHERE id =" + candidateFound.getId();

				st.executeUpdate(strQuerry);

				updateCount = st.getUpdateCount();

				if (updateCount != 0) {
					String strCandidateQuerry = "UPDATE candidate set "
							+ " resume=" + "'" + candidate.getResume() + "'"
							+ ", cvPath=" + "'" + candidate.getCvPath()+"'"

							+ " WHERE id =" + candidateFound.getIdCandidate();

					st.executeUpdate(strCandidateQuerry);

					updateCount = st.getUpdateCount();
					if (updateCount != 0) {
						isUpdated = true;
					}
				}

				st.close();
				connection.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public List<Candidate> findAll() {
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

			String strQuerry = "SELECT * FROM candidate ";
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

	@Override
	public Candidate findCandidateById(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;
		ResultSet memberResultSet = null;

		String login = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		Date dateOfBirth = null;

		try {

			String strQuerry = "SELECT * FROM candidate WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
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
						firstName, lastName, email, dateOfBirth, id, resume,
						cvPath);

				return candidate;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
