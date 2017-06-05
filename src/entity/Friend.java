package entity;

public class Friend {
	
	private String id;
	private String firstid;
	private String secondid;
	private int fstatus;
	
	public String getFid() {
		return id;
	}



	public void setFid(String fid) {
		this.id = fid;
	}



	public String getFfirstid() {
		return firstid;
	}



	public void setFfirstid(String ffirstid) {
		this.firstid = ffirstid;
	}



	public String getFsecondid() {
		return secondid;
	}



	public void setFsecondid(String fsecondid) {
		this.secondid = fsecondid;
	}



	public int getFstatus() {
		return fstatus;
	}



	public void setFstatus(int fstatus) {
		this.fstatus = fstatus;
	}


}
