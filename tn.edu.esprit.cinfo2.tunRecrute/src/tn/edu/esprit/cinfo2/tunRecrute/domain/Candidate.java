package tn.edu.esprit.cinfo2.tunRecrute.domain;

import java.util.Date;

public class Candidate extends Member {
	private int id;
	private String resume;
	private String cvPath;

	
	public Candidate(int id, String login, String password, String firstName,
			String lastName, String email, Date dateOfBirth, int id2,
			String resume, String cvPath) {
		super(id, login, password, firstName, lastName, email, dateOfBirth);
		id = id2;
		this.resume = resume;
		this.cvPath = cvPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cvPath == null) ? 0 : cvPath.hashCode());
		result = prime * result + id;
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (cvPath == null) {
			if (other.cvPath != null)
				return false;
		} else if (!cvPath.equals(other.cvPath))
			return false;
		if (id != other.id)
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCvPath() {
		return cvPath;
	}

	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", resume=" + resume + ", cvPath="
				+ cvPath + "]";
	}

}
