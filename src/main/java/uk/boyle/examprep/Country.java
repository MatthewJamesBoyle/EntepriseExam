package uk.boyle.examprep;

import java.util.Set;

public class Country {

	private long id;
	private String ISO3166;
	private String name;
	private Set<Site> hasSites;
	private Set<Document> requiredDocuments;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getISO3166() {
		return ISO3166;
	}
	public void setISO3166(String iSO3166) {
		ISO3166 = iSO3166;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Site> getHasSites() {
		return hasSites;
	}
	public void setHasSites(Set<Site> hasSites) {
		this.hasSites = hasSites;
	}
	public Set<Document> getRequiredDocuments() {
		return requiredDocuments;
	}
	public void setRequiredDocuments(Set<Document> requiredDocuments) {
		this.requiredDocuments = requiredDocuments;
	}

}