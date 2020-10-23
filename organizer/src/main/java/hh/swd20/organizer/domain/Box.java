package hh.swd20.organizer.domain;

public class Box {
	
	private Long boxId;
	private String bName;
	private String bDesc;
	private String bPrivate;
	private String bPublic;
	private String bLocation;
	
	public Box(Long boxId, String bName, String bDesc, String bPrivate, String bPublic, String bLocation) {
		super();
		this.boxId = boxId;
		this.bName = bName;
		this.bDesc = bDesc;
		this.bPrivate = bPrivate;
		this.bPublic = bPublic;
		this.bLocation = bLocation;
	}

	public Box(String bName, String bDesc, String bPrivate, String bPublic, String bLocation) {
		super();
		this.bName = bName;
		this.bDesc = bDesc;
		this.bPrivate = bPrivate;
		this.bPublic = bPublic;
		this.bLocation = bLocation;
	}
	
	public Box() {
		super();
		this.boxId = null;
		this.bName = null;
		this.bDesc = null;
		this.bPrivate = null;
		this.bPublic = null;
		this.bLocation = null;
	}

	public Long getboxId() {
		return boxId;
	}

	public void setbId(Long bId) {
		this.boxId = bId;
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

	public String getbPrivate() {
		return bPrivate;
	}

	public void setbPrivate(String bPrivate) {
		this.bPrivate = bPrivate;
	}

	public String getbPublic() {
		return bPublic;
	}

	public void setbPublic(String bPublic) {
		this.bPublic = bPublic;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}

	@Override
	public String toString() {
		return "Box [boxId=" + boxId + ", bName=" + bName + ", bDesc=" + bDesc + ", bPrivate=" + bPrivate + ", bPublic="
				+ bPublic + ", bLocation=" + bLocation + "]";
	}
	
	

}
