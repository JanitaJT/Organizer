package hh.swd20.organizer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cateId;
	private String cName;
	private String cDesc;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Item> items;

	public Category(Long cateId, String cName, String cDesc) {
		super();
		this.cateId = cateId;
		this.cName = cName;
		this.cDesc = cDesc;
	}

	public Category(String cName, String cDesc) {
		super();
		this.cName = cName;
		this.cDesc = cDesc;
	}

	public Category() {
		super();
		this.cateId = null;
		this.cName = null;
		this.cDesc = null;
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Category [cateId=" + cateId + ", cName=" + cName + ", cDesc=" + cDesc + "]";
	}

}
