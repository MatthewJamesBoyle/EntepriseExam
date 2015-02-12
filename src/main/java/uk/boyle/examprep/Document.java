package uk.boyle.examprep;

import java.util.Set;

public class Document {
	private long id;
	private String name;
	private Set<Country> requiredIn;
	private Set<Trial> trials;

	public Document() {

	}

	public Set<Trial> getTrials() {
		return trials;
	}

	public void setTrials(Set<Trial> trials) {
		this.trials = trials;
	}

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

	public Set<Country> getRequiredIn() {
		return requiredIn;
	}

	public void setRequiredIn(Set<Country> requiredIn) {
		this.requiredIn = requiredIn;
	}

}
