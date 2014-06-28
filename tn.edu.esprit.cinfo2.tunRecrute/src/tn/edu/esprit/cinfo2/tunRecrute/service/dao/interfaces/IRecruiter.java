package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Recruiter;

public interface IRecruiter {
	public boolean addRecruiter(Recruiter recruiter);

	public boolean deleteRecruiter(int id);

	public boolean updateRecruiter(int id, Recruiter recruiter);

	public List<Recruiter> findAll();

	public Recruiter findRecruiterById(int id);

}
