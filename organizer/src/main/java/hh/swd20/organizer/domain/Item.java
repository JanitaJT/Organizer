package hh.swd20.organizer.domain;




public class Item {


	private Long itemId;
	private String iName;
	private String iOwner;
	private Boolean iPrivate;
	
	public Item(Long itemId, String iName, String iOwner, Boolean iPrivate) {
		super();
		this.itemId = itemId;
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
	}

	public Item(String iName, String iOwner, Boolean iPrivate) {
		super();
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
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

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", iName=" + iName + ", iOwner=" + iOwner + ", iPrivate=" + iPrivate + "]";
	}
	
	

}
	
