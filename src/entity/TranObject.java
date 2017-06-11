package entity;

import java.io.Serializable;

import util.TranObjectType;

public class TranObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TranObject() {

	}

	public TranObject(Object object, TranObjectType tranType) {

		this.object = object;
		this.tranType = tranType;
	}

	private Object object;
	private TranObjectType tranType;
	
	//1111~1119 resultcode
	private String result;
	private String sendTime;
	private int sendId;
	private int receiveId;
	private String sendName;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public TranObjectType getTranType() {
		return tranType;
	}

	public void setTranType(TranObjectType tranType) {
		this.tranType = tranType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

}
