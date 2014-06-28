package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.JobOffers;

public interface IJobOffers {

	public boolean addJobOffer(JobOffers jobOffer);

	public boolean deleteJobOffer(int id);

	public boolean updateJobOffer(int id, JobOffers jobOffer);

	public List<JobOffers> findAll();

	public JobOffers findJobOffersById(int id);
}
