package hh.swd20.organizer.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import hh.swd20.organizer.domain.User;

@Entity
@Table(name = "Box")
public class Box {
	
	// Tein suomenkieliset virheilmoitukset, toimii lisäyksessä ja muokkauksessa

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boxId;
	
	@NotEmpty(message="Nimi ei saa olla tyhjä!")
	@Size(min=2, max=20, message="Nimen pitää olla 2-20 merkkiä pitkä!")
	private String bName;
	
	@Size(min=2, max=90, message="Kuvauksen pitää olla 2-90 merkkiä pitkä!")
	private String bDesc;
	
	@NotNull(message="Vaihtoehto ei voi olla tyhjä!")
	private Boolean bPrivate;
	
	@Size(min=2, max=50,  message="Paikan pitää olla 2-50 merkkiä pitkä!")
	private String bLocation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
	private List<Item> items;
	
	
// Many to many yhteys, jotta laatikoilla voi olla monta samaa käyttäjää
	@ManyToMany(mappedBy = "boxes")
	private Set<User> users = new HashSet<>();

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Box [boxId=" + boxId + ", bName=" + this.getbName() + ", bDesc=" + this.getbDesc() + ", bPrivate=" + this.getbPrivate()
				+ ", bLocation=" + this.getbLocation() + "]";
	}

}
