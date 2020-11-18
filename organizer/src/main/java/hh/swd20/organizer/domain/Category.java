package hh.swd20.organizer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Category {
	
	// Tein suomenkieliset virheilmoitukset, toimii lisäyksessä ja muokkauksessa

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cateId;
	
	@NotEmpty(message="Nimi ei saa olla tyhjä!")
	@Size(min=2, max=20,  message="Nimen pitää olla 2-20 merkkiä pitkä!")
	private String cName;
	
	
	@Size(min=2, max=90, message="Kuvauksen pitää olla 2-90 merkkiä pitkä!")
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
