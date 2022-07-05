package sprec.biobank.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="freezers")
public class Freezer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull 
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room roomId;
	

	@NotNull
	@Size(max=255)
	private String name;
	
	private Integer parentId;
	
	/*
	 * json_details
	 * json_samples
	*/ 
	
	private Date createdAt = new Date(System.currentTimeMillis());
		
	private Date updatedAt;
		
	private Date deletedAt;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setUpdatedAt() {
		this.updatedAt = new Date(System.currentTimeMillis());
	}
	
	public Date getUpdateAt() {
		return updatedAt;
	}
	
	public void setDeletedAt() {
		this.deletedAt =  new Date(System.currentTimeMillis());
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}
	
	public Room getRoomId() {
		return roomId;
	}

}
