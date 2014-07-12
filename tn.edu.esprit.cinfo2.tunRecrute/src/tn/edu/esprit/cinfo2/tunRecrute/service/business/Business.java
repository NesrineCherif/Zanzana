package tn.edu.esprit.cinfo2.tunRecrute.service.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;
import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;
import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.CandidateOfferImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.JobOffersImpl;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl.RecruiterImpl;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

public class Business {

	public Map<String, Object> authentification(String login, String password) {
		boolean authentified = false;
		Connection connection = MySqlUtilities.GiveMeConnection();
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			String strQuerry = "SELECT * FROM member  WHERE Login = '" + login
					+ "' AND Password = '" + password + "' LIMIT 1";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				if (rs.getInt("id") != 0) {
					System.out.println("Welcome " + login);
					authentified = true;

					RecruiterImpl recruiterImpl = new RecruiterImpl();
					Recruiter recruiter = recruiterImpl
							.findRecruiterByMemberId(rs.getInt("id"));
					CandidateImpl candidateImpl = new CandidateImpl();
					Candidate candidate = candidateImpl
							.findCandidateByMemberId(rs.getInt("id"));
					if (recruiter != null) {
						result.put("UserType", "Recruiter");
						result.put("Value", recruiter);
					} else if (candidate != null) {

						result.put("UserType", "Candidate");
						result.put("Value", candidate);
					}
					return result;

				} else {
					System.out.println("Invalid Login/Password .. try again");
				}
			}
			st.close();
			connection.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public boolean postJobOffer(Recruiter recruiter, JobOffers jobOffer) {
		jobOffer.setRecruiter(recruiter);
		JobOffersImpl jobOffersImpl = new JobOffersImpl();
		return jobOffersImpl.add(jobOffer);
	}

	public boolean applyForJobOffer(Candidate candidate, JobOffers jobOffer) {
		CandidateOffer candidateOffer = new CandidateOffer(0, candidate,
				jobOffer,0,"new");
		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
		return candidateOfferImpl.add(candidateOffer);
	}

	public void checkJobApplication(int id) {
		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
		CandidateOffer candidateOffer = candidateOfferImpl.findById(id);
		candidateOffer.setStatus("viewed");
		candidateOfferImpl.update(id, candidateOffer);
	}
	
	public void callForInterview(int id) {
		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
		CandidateOffer candidateOffer = candidateOfferImpl.findById(id);
		candidateOffer.setStatus("called for interview");
		candidateOfferImpl.update(id, candidateOffer);
	}
	
	public void hire(int id) {
		CandidateOfferImpl candidateOfferImpl = new CandidateOfferImpl();
		CandidateOffer candidateOffer = candidateOfferImpl.findById(id);
		candidateOffer.setStatus("hired");
		candidateOfferImpl.update(id, candidateOffer);
	}

}
