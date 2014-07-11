package tn.edu.esprit.cinfo2.tunRecrute.domain;

public class CandidateOffer {
	private int id;
	private Candidate candidate;
	private JobOffers jobOffer;
	private String status; 

	

	public CandidateOffer(int id, Candidate candidate, JobOffers jobOffer,
			String status) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.jobOffer = jobOffer;
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((jobOffer == null) ? 0 : jobOffer.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateOffer other = (CandidateOffer) obj;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		if (id != other.id)
			return false;
		if (jobOffer == null) {
			if (other.jobOffer != null)
				return false;
		} else if (!jobOffer.equals(other.jobOffer))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Candidate getCandidate() {
		return candidate;
	}



	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}



	public JobOffers getJobOffer() {
		return jobOffer;
	}



	public void setJobOffer(JobOffers jobOffer) {
		this.jobOffer = jobOffer;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "CandidateOffer [id=" + id + ", candidate=" + candidate
				+ ", jobOffer=" + jobOffer + ", status=" + status + "]";
	}

}
