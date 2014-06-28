package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Candidate;

public interface ICandidate {

	public boolean addCandidate(Candidate candidate);

	public boolean deleteCandidate(int id);

	public boolean updateCandidate(int id, Candidate candidate);

	public List<Candidate> findAll();

	public Candidate findCandidateById(int id);
}
