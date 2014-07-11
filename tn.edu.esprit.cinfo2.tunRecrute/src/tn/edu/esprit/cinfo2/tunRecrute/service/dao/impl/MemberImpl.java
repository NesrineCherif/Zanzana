package tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Member;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces.IGenericDao;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class MemberImpl implements IGenericDao<Member> {
	private static MemberImpl instancesof;

	public MemberImpl() {
	}

	public int addMember(Object member) {
		ResultSet rs = null;
		int updateCount = 0;
		int idMember = 0;
		Connection connection = (Connection) MySqlUtilities.GiveMeConnection();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOfBirth = dateFormat.format(((Member) member)
				.getDateOfBirth());
		try {

			Statement st = connection.createStatement();

			String memberQuery = "INSERT INTO member VALUES ("
					+ ((Member) member).getId() + ",'"
					+ ((Member) member).getLogin() + "','"
					+ ((Member) member).getPassword() + "','"
					+ ((Member) member).getFirstName() + "','"
					+ ((Member) member).getLastName() + "','"
					+ ((Member) member).getEmail() + "','" + dateOfBirth + "')";

			st.executeUpdate(memberQuery);
			updateCount = st.getUpdateCount();
			rs = (ResultSet) st.getGeneratedKeys();
			if (rs.next() && updateCount != 0) {
				System.out.println("Member is inserted");
				idMember = rs.getInt(1);

			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idMember;
	}

	@Override
	public boolean remove(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isDeleted = false;
		int updateCount = 0;
		try {

			String strQuerry = "DELETE FROM member WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeUpdate(strQuerry);

			updateCount = st.getUpdateCount();

			if (updateCount != 0) {
				System.out.println("Member is deleted");
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
	public boolean update(int id, Member member) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isUpdated = false;

		int updateCount = 0;
		try {

			Member memberFound = findById(id);

			if (memberFound == null) {
				System.out.println("Member not found");
			} else {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateOfBirth = dateFormat.format(member.getDateOfBirth());
				Statement st = connection.createStatement();
				String strQuerry = "UPDATE member set " + " login=" + "'"
						+ member.getLogin() + "'" + ", password=" + "'"
						+ member.getPassword() + "'" + ", firstName=" + "'"
						+ member.getFirstName() + "'" + ", lastName=" + "'"
						+ member.getLastName() + "'" + ", email=" + "'"
						+ member.getEmail() + "'" + ", dateOfBirth=" + "'"
						+ dateOfBirth + "'" + " WHERE id ="
						+ memberFound.getId();

				st.executeUpdate(strQuerry);

				updateCount = st.getUpdateCount();

				if (updateCount != 0) {
					isUpdated = true;

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
	public List<Member> findAll() {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet memberResultSet = null;

		int id = 0;
		String login = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		Date dateOfBirth = null;
		List<Member> members = new ArrayList<Member>();

		try {

			String memberQuerry = "SELECT * FROM member ";
			Statement stMember = connection.createStatement();
			stMember.executeQuery(memberQuerry);
			memberResultSet = (ResultSet) stMember.getResultSet();
			while (memberResultSet.next()) {
				id = memberResultSet.getInt("Id");
				login = memberResultSet.getString("login");
				password = memberResultSet.getString("password");
				firstName = memberResultSet.getString("firstName");
				lastName = memberResultSet.getString("lastName");
				email = memberResultSet.getString("email");
				dateOfBirth = memberResultSet.getDate("dateOfBirth");

				Member member = new Member(id, login, password, firstName,
						lastName, email, dateOfBirth);
				members.add(member);

			}

			stMember.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public Member findById(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet memberResultSet = null;

		String login = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		Date dateOfBirth = null;

		try {

			String memberQuerry = "SELECT * FROM member WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeQuery(memberQuerry);
			memberResultSet = (ResultSet) st.getResultSet();
			while (memberResultSet.next()) {
				login = memberResultSet.getString("login");
				password = memberResultSet.getString("password");
				firstName = memberResultSet.getString("firstName");
				lastName = memberResultSet.getString("lastName");
				email = memberResultSet.getString("email");
				dateOfBirth = memberResultSet.getDate("dateOfBirth");

				Member member = new Member(id, login, password, firstName,
						lastName, email, dateOfBirth);

				return member;

			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static MemberImpl getInstanceof() {
		if (instancesof == null)
			instancesof = new MemberImpl();

		return instancesof;
	}

	@Override
	public boolean add(Member object) {
		return false;
	}

}
