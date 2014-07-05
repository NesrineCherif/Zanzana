package tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces.IJobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class JobOffersImpl implements IJobOffers {

	@Override
	public boolean addJobOffer(JobOffers jobOffer) {
		int updateCount = 0;
		boolean isAdded = false;
		Connection connection = (Connection) MySqlUtilities.GiveMeConnection();
		try {

			Statement st = connection.createStatement();

			String strQuerry = "INSERT INTO joboffers " + "VALUES ("
					+ jobOffer.getId() + ",'" + jobOffer.getName() + "','"
					+ jobOffer.getDescription() + "','"
					+ jobOffer.getTestLink() + "'," + jobOffer.getIdRecruiter()
					+ ")";

			st.executeUpdate(strQuerry);
			updateCount = st.getUpdateCount();
			if (updateCount != 0) {
				System.out.println("Job Offer is inserted");
				isAdded = true;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteJobOffer(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isDeleted = false;
		int updateCount = 0;
		try {

			String strQuerry = "DELETE FROM joboffers WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeUpdate(strQuerry);

			updateCount = st.getUpdateCount();

			if (updateCount != 0) {
				System.out.println("Job Offer is deleted");
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
	public boolean updateJobOffer(int id, JobOffers jobOffer) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isUpdated = false;

		int updateCount = 0;
		try {

			JobOffers jobOfferFound = findJobOffersById(id);

			if (jobOfferFound == null) {
				System.out.println("JobOffer not found");
			} else {

				Statement st = connection.createStatement();
				String strCandidateQuerry = "UPDATE joboffers set " + " name="
						+ "'" + jobOffer.getName() + "'" + ", description="
						+ "'" + jobOffer.getDescription() + "'" + ", testLink="
						+ "'" + jobOffer.getTestLink() + "'" + " WHERE id ="
						+ jobOfferFound.getId();

				st.executeUpdate(strCandidateQuerry);

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
	public List<JobOffers> findAll() {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		List<JobOffers> jobOffers = new ArrayList<JobOffers>();

		try {

			String strQuerry = "SELECT * FROM joboffers ";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idJobOffer = resultSet.getInt("id");
				int idRecruiter = resultSet.getInt("id_recruiter");

				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String testLink = resultSet.getString("testLink");

				JobOffers jobOffer = new JobOffers(idJobOffer, name,
						description, testLink, idRecruiter);

				jobOffers.add(jobOffer);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobOffers;
	}

	@Override
	public JobOffers findJobOffersById(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		try {

			String strQuerry = "SELECT * FROM joboffers WHERE id =" + id + "";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idRecruiter = resultSet.getInt("id_recruiter");

				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String testLink = resultSet.getString("testLink");

				JobOffers jobOffer = new JobOffers(id, name, description,
						testLink, idRecruiter);

				return jobOffer;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
