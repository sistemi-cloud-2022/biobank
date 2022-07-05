package sprec.biobank.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="rooms")
public class Room {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	private Date createdAt = new Date(System.currentTimeMillis());
	
	private Date updatedAt;
	
	private Date deletedAt;
	
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
	
	//il setcreated non ha senso, dato che cambia e si imposta solo all'inizio
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setUpdatedAt() {
		this.updatedAt = new Date(System.currentTimeMillis());
	}
	
	public Date getUpdateAt() {
		return updatedAt;
	}
	
	//?
	public void setDeletedAt() {
		this.deletedAt = new Date(System.currentTimeMillis());
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
}
