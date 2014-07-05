package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.CandidateOffer;

public interface ICandidateOffer {
	public boolean addCandidateOffer(CandidateOffer candidateOffer);

	public boolean deleteCandidateOffer(int id);

	public boolean updateCandidateOffer(int id, CandidateOffer candidateOffer);

	public List<CandidateOffer> findAll();

	public CandidateOffer findCandidateOfferById(int id);
}
