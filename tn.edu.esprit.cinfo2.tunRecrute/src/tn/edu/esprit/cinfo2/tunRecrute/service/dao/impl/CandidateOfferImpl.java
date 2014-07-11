package tn.edu.esprit.cinfo2.tunRecrute.service.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;
import tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces.IGenericDao;
import tn.edu.esprit.cinfo2.tunRecrute.utilities.MySqlUtilities;

import com.mysql.jdbc.ResultSet;

public class CandidateOfferImpl implements IGenericDao<CandidateOffer> {
	private static CandidateOfferImpl instancesof;

	public CandidateOfferImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(CandidateOffer candidateOffer) {
		int updateCount = 0;
		boolean isAdded = false;
		Connection connection = (Connection) MySqlUtilities.GiveMeConnection();
		try {

			Statement st = connection.createStatement();

			String strQuerry = "INSERT INTO candidate_offer " + "VALUES ("
					+ candidateOffer.getId() + ","
					+ candidateOffer.getCandidate().getIdCandidate() + ","
					+ candidateOffer.getJobOffer().getId() + " ,'"
					+ candidateOffer.getStatus() + "' )";

			st.executeUpdate(strQuerry);
			updateCount = st.getUpdateCount();
			if (updateCount != 0) {
				System.out.println("Candidate_Offer is inserted");
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
	public boolean remove(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isDeleted = false;
		int updateCount = 0;
		try {

			String strQuerry = "DELETE FROM candidate_offer WHERE id =" + id
					+ "";
			Statement st = connection.createStatement();
			st.executeUpdate(strQuerry);

			updateCount = st.getUpdateCount();

			if (updateCount != 0) {
				System.out.println("Candidate_Offer is deleted");
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
	public boolean update(int id, CandidateOffer candidateOffer) {
		Connection connection = MySqlUtilities.GiveMeConnection();
		boolean isUpdated = false;

		int updateCount = 0;
		try {

			CandidateOffer candidateOfferFound = findById(id);

			if (candidateOfferFound == null) {
				System.out.println("candidateOffer not found");
			} else {

				Statement st = connection.createStatement();
				String strCandidateQuerry = "UPDATE candidate_offer set "
						+ " id_candidate=" + candidateOffer.getCandidate().getIdCandidate()
						+ ", id_jobOffer=" + candidateOffer.getJobOffer().getId()
						+ ", status='"+candidateOffer.getStatus()+"'"
						+ " WHERE id =" + candidateOfferFound.getId();

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
	public List<CandidateOffer> findAll() {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		List<CandidateOffer> candidateOffers = new ArrayList<CandidateOffer>();

		try {

			String strQuerry = "SELECT * FROM candidate_offer ";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idCandidateOffer = resultSet.getInt("id");
				int idCandidate = resultSet.getInt("id_candidate");
				int idJobOffer = resultSet.getInt("id_jobOffer");
				String status= resultSet.getString("status");
				CandidateImpl candidateImpl = new CandidateImpl();
				JobOffersImpl offersImpl = new JobOffersImpl();
				CandidateOffer candidateOffer = new CandidateOffer(
						idCandidateOffer, candidateImpl.findById(idCandidate),
						offersImpl.findById(idJobOffer),status);

				candidateOffers.add(candidateOffer);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidateOffers;
	}

	@Override
	public CandidateOffer findById(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		try {

			String strQuerry = "SELECT * FROM candidate_offer WHERE id =" + id
					+ "";
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idCandidateOffer = resultSet.getInt("id");
				int idJobOffer = resultSet.getInt("id_jobOffer");
				int idCandidate = resultSet.getInt("id_candidate");
				String status= resultSet.getString("status");
				CandidateImpl candidateImpl = new CandidateImpl();
				JobOffersImpl offersImpl = new JobOffersImpl();
				CandidateOffer candidateOffer = new CandidateOffer(
						idCandidateOffer, candidateImpl.findById(idCandidate),
						offersImpl.findById(idJobOffer),status);

				return candidateOffer;
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CandidateOffer> findAllByCandidate(int id) {
		Connection connection = MySqlUtilities.GiveMeConnection();

		ResultSet resultSet = null;

		List<CandidateOffer> candidateOffers = new ArrayList<CandidateOffer>();

		try {

			String strQuerry = "SELECT * FROM candidate_offer where id_candidate= "+id;
			Statement st = connection.createStatement();
			st.executeQuery(strQuerry);
			resultSet = (ResultSet) st.getResultSet();

			while (resultSet.next()) {
				int idCandidateOffer = resultSet.getInt("id");
				int idCandidate = resultSet.getInt("id_candidate");
				int idJobOffer = resultSet.getInt("id_jobOffer");
				String status= resultSet.getString("status");
				CandidateImpl candidateImpl = new CandidateImpl();
				JobOffersImpl offersImpl = new JobOffersImpl();
				CandidateOffer candidateOffer = new CandidateOffer(
						idCandidateOffer, candidateImpl.findById(idCandidate),
						offersImpl.findById(idJobOffer),status);

				candidateOffers.add(candidateOffer);
			}

			st.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidateOffers;
	}

	public static CandidateOfferImpl getInstanceof() {
		if (instancesof == null)
			instancesof = new CandidateOfferImpl();

		return instancesof;
	}
}
