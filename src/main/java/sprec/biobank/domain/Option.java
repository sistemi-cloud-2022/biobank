package sprec.biobank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="opts")
public class Option {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	@NotNull
	private long value;
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(long value) {
		this.value = value;
	}
	
	public long getValue() {
		return value;
	}

}
