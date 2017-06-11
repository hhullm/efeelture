package entity;

import java.io.Serializable;

public class Talk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstid;
	private String secondid;
	private String ttype;
	private String content;
	private String ttime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstid() {
		return firstid;
	}
	public void setFirstid(String firstid) {
		this.firstid = firstid;
	}
	public String getSecondid() {
		return secondid;
	}
	public void setSecondid(String secondid) {
		this.secondid = secondid;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	
	
	
	
	
	
	
	



}
