package hh.swd20.organizer.domain;

public class Category {

	private Long cateId;
	private String cName;
	private String cDesc;

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

	@Override
	public String toString() {
		return "Category [cateId=" + cateId + ", cName=" + cName + ", cDesc=" + cDesc + "]";
	}

}
