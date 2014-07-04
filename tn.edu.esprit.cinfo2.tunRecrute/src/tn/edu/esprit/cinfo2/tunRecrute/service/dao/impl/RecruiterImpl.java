package tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces.IRecruiter;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class RecruiterImpl implements IRecruiter {

	@Override
	public boolean addRecruiter(Recruiter recruiter) {
		ResultSet rs = null;
		int idMember = 0;
		int updateCount = 0;
		boolean isAdded = false;
		Connection connection = (Connection) MySqlUtilities.GiveMeConnection();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOfBirth = dateFormat.format(recruiter.getDateOfBirth());
		try {

			Statement st = connection.createStatement();

			String memberQuery = "INSERT INTO member VALUES ("
					+ recruiter.getId() + ",'" + recruiter.getLogin() + "','"
					+ recruiter.getPassword() + "','"
					+ recruiter.getFirstName() + "','"
					+ recruiter.getLastName() + "','" + recruiter.getEmail()
					+ "','" + dateOfBirth + "')";

			st.executeUpdate(memberQuery);
			updateCount = st.getUpdateCount();
			rs = (ResultSet) st.getGeneratedKeys();
			if (rs.next() && updateCount != 0) {
				System.out.println("Member is inserted !!");
				idMember = rs.getInt(1);
				String strQuerry = "INSERT INTO recruiter " + "VALUES ("
						+ recruiter.getId() + ",'"
						+ recruiter.getOrganizationName() + "','"
						+ recruiter.getOrganizationDescription() + "','"
						+ recruiter.getOrganizationAddress() + "','"
						+ recruiter.getOrganizationDomain() + "','"
						+ recruiter.getEmployeesNumber() + "','"
						+ recruiter.getOrganizationTurnover() + "'," + idMember
						+ ")";

				st.executeUpdate(strQuerry);
				updateCount = st.getUpdateCount();
				if (updateCount != 0) {
					System.out.println("Recruiter is inserted");
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
	public boolean deleteRecruiter(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isDeleted = false;
		int updateCount = 0;
		try {

			String strQuerry = "DELETE FROM member WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeUpdate(strQuerry);

			updateCount = st.getUpdateCount();

			if (updateCount != 0) {
				System.out.println("Recruiter is deleted");
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
	public boolean updateRecruiter(int id, Recruiter recruiter) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isUpdated = false;

		int updateCount = 0;
		try {

			Recruiter recruiterFound = findRecruiterById(id);

			if (recruiterFound == null) {
				System.out.println("Recruiter not found");
			} else {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateOfBirth = dateFormat.format(recruiter
						.getDateOfBirth());
				Statement st = connection.createStatement();
				String strQuerry = "UPDATE member set " + " login=" + "'"
						+ recruiter.getLogin() + "'" + ", password=" + "'"
						+ recruiter.getPassword() + "'" + ", firstName=" + "'"
						+ recruiter.getFirstName() + "'" + ", lastName=" + "'"
						+ recruiter.getLastName() + "'" + ", email=" + "'"
						+ recruiter.getEmail() + "'" + ", dateOfBirth=" + "'"
						+ dateOfBirth + "'" + " WHERE id ="
						+ recruiterFound.getId();

				st.executeUpdate(strQuerry);

				updateCount = st.getUpdateCount();

				if (updateCount != 0) {
					String strRecruiterQuerry = "UPDATE recruiter set "
							+ " organizationName=" + "'"
							+ recruiter.getOrganizationName()
							+ "'"
							+ ", organizationDescription="
							+ "'"
							+ recruiter.getOrganizationDescription()
							+ "'"
							+ ", organizationAddress="
							+ "'"
							+ recruiter.getOrganizationAddress()
							+ "'"
							+ ", organizationDomain="
							+ "'"
							+ recruiter.getOrganizationDomain()
							+ "'"
							+ ", employeesNumber="
							+ "'"
							+ recruiter.getEmployeesNumber()
							+ "'"
							+ ", organizationTurnover="
							+ "'"
							+ recruiter.getOrganizationTurnover()
							+ "'"
							+ " WHERE id =" + recruiterFound.getIdRecruiter();

					st.executeUpdate(strRecruiterQuerry);

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
	public List<Recruiter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recruiter findRecruiterById(int id) {

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

			String strQuerry = "SELECT * FROM recruiter WHERE id =" + id + "";
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

				String organizationName = resultSet
						.getString("organizationName");
				String organizationDescription = resultSet
						.getString("organizationDescription");
				String organizationAddress = resultSet
						.getString("organizationAddress");
				String organizationDomain = resultSet
						.getString("organizationDomain");
				int employeesNumber = resultSet.getInt("employeesNumber");
				long organizationTurnover = resultSet
						.getLong("organizationTurnover");

				Recruiter recruiter = new Recruiter(idMember, login, password,
						firstName, lastName, email, dateOfBirth, id,
						organizationName, organizationDescription,
						organizationAddress, organizationDomain,
						employeesNumber, organizationTurnover);

				return recruiter;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
