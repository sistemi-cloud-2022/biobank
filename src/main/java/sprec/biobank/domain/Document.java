package sprec.biobank.domain;

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
@Table(name = "documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@NotNull
	private Integer objectId;

	//@NotNull
	@Size(max = 255)
	private String fileName;

	// @NotNull
	private Integer size;

	// @NotNull
	@Size(max = 255)
	private String guid;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", referencedColumnName = "id")
	private DocumentType typeId;
	
	//tutti timestamp
	private String createdAt;
	
	private String updatedAt;
		
	private String deletedAt;
	
	public Integer getId() {
		return id;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getUpdateAt() {
		return updatedAt;
	}
	
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public String getDeletedAt() {
		return deletedAt;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setTypeId(DocumentType typeId) {
		this.typeId = typeId;
	}
	
	public DocumentType getTypeId() {
		return typeId;
	}

}
