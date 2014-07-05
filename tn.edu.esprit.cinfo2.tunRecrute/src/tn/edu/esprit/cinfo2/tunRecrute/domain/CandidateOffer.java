package tn.edu.esprit.cinfo2.tunRecrute.domain;

public class CandidateOffer {
	private int id;
	private int idCandidate;
	private int idJobOffer;

	public CandidateOffer(int id, int idCandidate, int idJobOffer) {
		super();
		this.id = id;
		this.idCandidate = idCandidate;
		this.idJobOffer = idJobOffer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idCandidate;
		result = prime * result + idJobOffer;
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
		if (id != other.id)
			return false;
		if (idCandidate != other.idCandidate)
			return false;
		if (idJobOffer != other.idJobOffer)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public int getIdJobOffer() {
		return idJobOffer;
	}

	public void setIdJobOffer(int idJobOffer) {
		this.idJobOffer = idJobOffer;
	}

	@Override
	public String toString() {
		return "CandidateOffer [id=" + id + ", idCandidate=" + idCandidate
				+ ", idJobOffer=" + idJobOffer + "]";
	}

}
