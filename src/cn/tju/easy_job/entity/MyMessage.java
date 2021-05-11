package cn.tju.easy_job.entity;

import java.util.Date;

public class MyMessage {
	private int id;
	private int sessionId;
	private int fromId;
	private int toId;
	private String message;
	private Date datetime;
	public MyMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sessionId=" + sessionId + ", fromId=" + fromId + ", toId=" + toId + ", message="
				+ message + ", datetime=" + datetime + "]";
	}
	
}
