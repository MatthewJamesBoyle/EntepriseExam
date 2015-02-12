package uk.boyle.examprep;

import java.util.Date;
import java.util.Set;

public class Patient {

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", gender=" + gender
				+ ", dateRegistered=" + dateRegistered + ", visits=" + visits
				+ ", registeredAt=" + registeredAt + ", trial=" + trial + "]";
	}

	private long id;
	private String firstName, lastName;
	private Date dob;
	private Gender gender;
	private Date dateRegistered = new Date();
	private Set<Visit> visits;
	private Site registeredAt;
	private Trial trial;

	public Site getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Site registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Patient() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	public Trial getTrial() {
		return trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}

}
