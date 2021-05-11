package cn.tju.easy_job.entity;

import java.util.Date;

public class MySession {
	private int id;
	private int user1Id;
	private int user2Id;
	private String message;
	private Date datetime;
	public MySession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MySession(int id, int user1Id, int user2Id, String message, Date datetime) {
		super();
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.message = message;
		this.datetime = datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser1Id() {
		return user1Id;
	}
	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}
	public int getUser2Id() {
		return user2Id;
	}
	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
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
		return "{\"id\":\"" + id + "\", \"user1Id\":\"" + user1Id + "\", \"user2Id\":\"" + user2Id + "\", \"message\":\"" + message
				+ "\", \"datetime\":\"" + datetime + "\"}";
	}
	

}
