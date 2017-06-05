package entity;

public class Message {
	
	private String id;
	private String content;
	private String picture;
	private String address;
	private int mstatus;
	private int permission;
	private int likenumber;
	private String uname;
	private String uid;
	private int mtype;

	public String getMid() {
		return id;
	}



	public void setMid(String mid) {
		this.id = mid;
	}



	public String getMcontent() {
		return content;
	}



	public void setMcontent(String mcontent) {
		this.content = mcontent;
	}



	public String getMpicture() {
		return picture;
	}



	public void setMpicture(String mpicture) {
		this.picture = mpicture;
	}



	public String getMaddress() {
		return address;
	}



	public void setMaddress(String maddress) {
		this.address = maddress;
	}



	public int getMstatus() {
		return mstatus;
	}



	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}



	public int getMpermission() {
		return permission;
	}



	public void setMpermission(int mpermission) {
		this.permission = mpermission;
	}




	public int getMlikenumber() {
		return likenumber;
	}



	public void setMlikenumber(int mlikenumber) {
		this.likenumber = mlikenumber;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public int getMtype() {
		return mtype;
	}



	public void setMtype(int mtype) {
		this.mtype = mtype;
	}


}
