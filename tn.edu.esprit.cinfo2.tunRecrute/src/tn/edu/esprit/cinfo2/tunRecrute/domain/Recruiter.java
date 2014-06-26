package tn.edu.esprit.cinfo2.tunRecrute.domain;

import java.util.Date;

public class Recruiter extends Member {
	private int id;
	private String organizationName;
	private String organizationDescription;
	private String organizationAddress;
	private String organizationDomain;
	private int employeesNumber;
	private long organizationTurnover;



	public Recruiter(int id, String login, String password, String firstName,
			String lastName, String email, Date dateOfBirth, int id2,
			String organizationName, String organizationDescription,
			String organizationAddress, String organizationDomain,
			int employeesNumber, long organizationTurnover) {
		super(id, login, password, firstName, lastName, email, dateOfBirth);
		id = id2;
		this.organizationName = organizationName;
		this.organizationDescription = organizationDescription;
		this.organizationAddress = organizationAddress;
		this.organizationDomain = organizationDomain;
		this.employeesNumber = employeesNumber;
		this.organizationTurnover = organizationTurnover;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + employeesNumber;
		result = prime * result + id;
		result = prime
				* result
				+ ((organizationAddress == null) ? 0 : organizationAddress
						.hashCode());
		result = prime
				* result
				+ ((organizationDescription == null) ? 0
						: organizationDescription.hashCode());
		result = prime
				* result
				+ ((organizationDomain == null) ? 0 : organizationDomain
						.hashCode());
		result = prime
				* result
				+ ((organizationName == null) ? 0 : organizationName.hashCode());
		result = prime * result
				+ (int) (organizationTurnover ^ (organizationTurnover >>> 32));
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
		Recruiter other = (Recruiter) obj;
		if (employeesNumber != other.employeesNumber)
			return false;
		if (id != other.id)
			return false;
		if (organizationAddress == null) {
			if (other.organizationAddress != null)
				return false;
		} else if (!organizationAddress.equals(other.organizationAddress))
			return false;
		if (organizationDescription == null) {
			if (other.organizationDescription != null)
				return false;
		} else if (!organizationDescription
				.equals(other.organizationDescription))
			return false;
		if (organizationDomain == null) {
			if (other.organizationDomain != null)
				return false;
		} else if (!organizationDomain.equals(other.organizationDomain))
			return false;
		if (organizationName == null) {
			if (other.organizationName != null)
				return false;
		} else if (!organizationName.equals(other.organizationName))
			return false;
		if (organizationTurnover != other.organizationTurnover)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationDescription() {
		return organizationDescription;
	}

	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getOrganizationDomain() {
		return organizationDomain;
	}

	public void setOrganizationDomain(String organizationDomain) {
		this.organizationDomain = organizationDomain;
	}

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public long getOrganizationTurnover() {
		return organizationTurnover;
	}

	public void setOrganizationTurnover(long organizationTurnover) {
		this.organizationTurnover = organizationTurnover;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", organizationName=" + organizationName
				+ ", organizationDescription=" + organizationDescription
				+ ", organizationAddress=" + organizationAddress
				+ ", organizationDomain=" + organizationDomain
				+ ", employeesNumber=" + employeesNumber
				+ ", organizationTurnover=" + organizationTurnover + "]";
	}

}
