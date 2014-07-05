package tn.edu.esprit.cinfo2.tunRecrute.domain;

public class JobOffers {
	private int id;
	private String name;
	private String description;
	private String testLink;
	private int idRecruiter;

	public JobOffers() {
	}

	public JobOffers(int id, String name, String description, String testLink,
			int idRecruiter) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.testLink = testLink;
		this.idRecruiter = idRecruiter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + idRecruiter;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (idRecruiter != other.idRecruiter)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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

	public int getIdRecruiter() {
		return idRecruiter;
	}

	public void setIdRecruiter(int idRecruiter) {
		this.idRecruiter = idRecruiter;
	}

	@Override
	public String toString() {
		return "JobOffers [id=" + id + ", name=" + name + ", description="
				+ description + ", testLink=" + testLink + ", idRecruiter="
				+ idRecruiter + "]";
	}

}
