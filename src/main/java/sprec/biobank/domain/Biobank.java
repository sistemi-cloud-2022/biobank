package sprec.biobank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="biobanks")
public class Biobank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	//mettere tutti NOtNUll
	@Size(max=255)
	private String name;
	
	@Size(max=255)
	private String acronym;
	
	@Size(max=255)
	private String url;
	
	@Size(max=255)
	private String juristicPerson;
	
	@Size(max=255)
	private String country;
	
	//json?
	private String contactInformation;
	
	//text
	private String description;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setJuristicPerson(String juristicPerson){
		this.juristicPerson = juristicPerson;
	}
	
	public String getJuristicPerson() {
		return juristicPerson;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	
	public String getContactInformation() {
		return contactInformation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
