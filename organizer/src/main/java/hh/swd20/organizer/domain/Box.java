package hh.swd20.organizer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boxId;
	private String bName;
	private String bDesc;
	private Boolean bPrivate;
	private String bLocation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
	private List<Item> items;
	
	public Box(Long boxId, String bName, String bDesc, Boolean bPrivate, String bLocation) {
		super();
		this.boxId = boxId;
		this.bName = bName;
		this.bDesc = bDesc;
		this.bPrivate = bPrivate;
		this.bLocation = bLocation;
	}

	public Box(String bName, String bDesc, Boolean bPrivate, String bLocation) {
		super();
		this.bName = bName;
		this.bDesc = bDesc;
		this.bPrivate = bPrivate;
		this.bLocation = bLocation;
	}

	public Box() {
		super();
		this.boxId = null;
		this.bName = null;
		this.bDesc = null;
		this.bPrivate = null;
		this.bLocation = null;
	}

	public Long getBoxId() {
		return boxId;
	}

	public void setBoxId(Long boxId) {
		this.boxId = boxId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbDesc() {
		return bDesc;
	}

	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}

	public Boolean getbPrivate() {
		return bPrivate;
	}

	public void setbPrivate(Boolean bPrivate) {
		this.bPrivate = bPrivate;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}
	

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Box [boxId=" + boxId + ", bName=" + bName + ", bDesc=" + bDesc + ", bPrivate=" + bPrivate
				+ ", bLocation=" + bLocation + "]";
	}

}
