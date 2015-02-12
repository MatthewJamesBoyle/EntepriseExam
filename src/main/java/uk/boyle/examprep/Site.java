package uk.boyle.examprep;

import java.util.Set;

public class Site {

	private long id;
	private String name;
	private Set<Patient> registeredPatients;
	private Set<Trial> registeredFor;
	private Country residesIn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Patient> getRegisteredPatients() {
		return registeredPatients;
	}

	public void setRegisteredPatients(Set<Patient> registeredPatients) {
		this.registeredPatients = registeredPatients;
	}

	public Set<Trial> getRegisteredFor() {
		return registeredFor;
	}

	public void setRegisteredFor(Set<Trial> registeredFor) {
		this.registeredFor = registeredFor;
	}

	public Country getResidesIn() {
		return residesIn;
	}

	public void setResidesIn(Country residesIn) {
		this.residesIn = residesIn;
	}
}