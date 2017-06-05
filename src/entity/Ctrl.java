package entity;

public class Ctrl {
	
	private String id;
	private String uname;
	private int cstatus;
	private String content;
	
	public String getCid() {
		return id;
	}



	public void setCid(String cid) {
		this.id = cid;
	}



	public String getCname() {
		return uname;
	}



	public void setCname(String cname) {
		this.uname = cname;
	}



	public int getCstatus() {
		return cstatus;
	}



	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}



	public String getCcontent() {
		return content;
	}



	public void setCcontent(String ccontent) {
		this.content = ccontent;
	}


}
