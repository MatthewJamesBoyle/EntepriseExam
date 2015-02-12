package uk.boyle.examprep;

import java.util.Set;
import java.util.Set;

public class Trial {

	private long id;
	private String name;
	private Set<Drug> drugs;
	private Set<Patient> patients;
	private Set<Site> registeredAt;
	private Set<Document> documents;

	public Trial() {

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

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Set<Site> getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Set<Site> registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

}
