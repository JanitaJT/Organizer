package hh.swd20.organizer.domain;

public class Item {

	private Long itemId;
	private String iName;
	private String iOwner;
	private String iPrivate;
	private String iPublic;
	
	public Item(Long itemId, String iName, String iOwner, String iPrivate, String iPublic) {
		super();
		this.itemId = itemId;
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
		this.iPublic = iPublic;
	}

	public Item(String iName, String iOwner, String iPrivate, String iPublic) {
		super();
		this.iName = iName;
		this.iOwner = iOwner;
		this.iPrivate = iPrivate;
		this.iPublic = iPublic;
	}
	
	public Item() {
		super();
		this.itemId = null;
		this.iName = null;
		this.iOwner = null;
		this.iPrivate = null;
		this.iPublic = null;
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

	public String getiPrivate() {
		return iPrivate;
	}

	public void setiPrivate(String iPrivate) {
		this.iPrivate = iPrivate;
	}

	public String getiPublic() {
		return iPublic;
	}

	public void setiPublic(String iPublic) {
		this.iPublic = iPublic;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", iName=" + iName + ", iOwner=" + iOwner + ", iPrivate=" + iPrivate
				+ ", iPublic=" + iPublic + "]";
	}
	
}
