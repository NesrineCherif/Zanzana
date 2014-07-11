package tn.edu.esprit.cinfo2.tunRecrute.service.business;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.RecruiterImpl;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class JobOffersBusiness {
	
	public List<JobOffers> findJobOfferByKeyWord(String keyWord) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		List<JobOffers> jobOffers = new ArrayList<JobOffers>();

		try {

			String strQuerry = "SELECT * FROM joboffers WHERE name like '%"+keyWord+"%' or description like '%"+keyWord+"%'";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idJobOffer = resultSet.getInt("id");
				int idRecruiter = resultSet.getInt("id_recruiter");

				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String testLink = resultSet.getString("testLink");

				RecruiterImpl recruiterImpl = new RecruiterImpl();

				JobOffers jobOffer = new JobOffers(idJobOffer, name,
						description, testLink,
						recruiterImpl.findById(idRecruiter));

				jobOffers.add(jobOffer);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobOffers;
	}
	
	public List<JobOffers> findJobOfferByRecruiter(int id_recruiter) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		List<JobOffers> jobOffers = new ArrayList<JobOffers>();

		try {

			String strQuerry = "SELECT * FROM joboffers WHERE id_recruiter="+id_recruiter;
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idJobOffer = resultSet.getInt("id");
				int idRecruiter = resultSet.getInt("id_recruiter");

				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String testLink = resultSet.getString("testLink");

				RecruiterImpl recruiterImpl = new RecruiterImpl();

				JobOffers jobOffer = new JobOffers(idJobOffer, name,
						description, testLink,
						recruiterImpl.findById(idRecruiter));

				jobOffers.add(jobOffer);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobOffers;
	}

}
