package tn.edu.esprit.cinfo2.tunRecrute.domain;

public class JobOffers {
	private int id;
	private String name;
	private String description;
	private String testLink;
	private Recruiter recruiter;

	public JobOffers() {
	}

	public JobOffers(int id, String name, String description, String testLink,
			Recruiter recruiter) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.testLink = testLink;
		this.recruiter = recruiter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((recruiter == null) ? 0 : recruiter.hashCode());
		result = prime * result
				+ ((testLink == null) ? 0 : testLink.hashCode());
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
		JobOffers other = (JobOffers) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recruiter == null) {
			if (other.recruiter != null)
				return false;
		} else if (!recruiter.equals(other.recruiter))
			return false;
		if (testLink == null) {
			if (other.testLink != null)
				return false;
		} else if (!testLink.equals(other.testLink))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTestLink() {
		return testLink;
	}

	public void setTestLink(String testLink) {
		this.testLink = testLink;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return "JobOffers [id=" + id + ", name=" + name + ", description="
				+ description + ", testLink=" + testLink + ", recruiter="
				+ recruiter + "]";
	}

}
