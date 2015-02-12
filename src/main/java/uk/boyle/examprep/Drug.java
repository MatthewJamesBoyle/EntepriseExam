package uk.boyle.examprep;

import java.util.Set;

public class Drug {
	private long id;
	private String name;
	private String description;
	private Set<Trial> trials;
	private Set<Visit> distributedVisits;

	public Drug() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Trial> getTrials() {
		return trials;
	}

	public void setTrials(Set<Trial> trials) {
		this.trials = trials;
	}

	public Set<Visit> getDistributedVisits() {
		return distributedVisits;
	}

	public void setDistributedVisits(Set<Visit> distributedVisits) {
		this.distributedVisits = distributedVisits;
	}

}
