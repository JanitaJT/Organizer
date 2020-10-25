package hh.swd20.organizer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private String iName;
	private String iOwner;
	private Boolean iPrivate;
	
	@ManyToOne
	@JoinColumn(name = "boxId")
	private Box box;
	
	@ManyToOne
	@JoinColumn(name = "cateId")
	private Category category;
	
	
	public Item(Long itemId, String iName, String iOwner, Boolean iPrivate, Box box, Category category) {
		super();
		this.itemId = itemId;
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
		this.box = box;
		this.category = category;
	}

	public Item(String iName, String iOwner, Boolean iPrivate, Box box, Category category) {
		super();
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
		this.box = box;
		this.category = category;
	}

	public Item() {
		super();
		this.itemId = null;
		this.iName = null;
		this.iOwner = null;
		this.iPrivate = null;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiOwner() {
		return iOwner;
	}

	public void setiOwner(String iOwner) {
		this.iOwner = iOwner;
	}

	public Boolean getiPrivate() {
		return iPrivate;
	}

	public void setiPrivate(Boolean iPrivate) {
		this.iPrivate = iPrivate;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		
		return "Item [itemId=" + itemId + ", iName=" + iName + ", iOwner=" + iOwner + ", iPrivate=" + iPrivate + "box=" + this.getBox() + "category=" + this.getCategory() + "]";
	}
	
	

}
	
