package cn.tju.easy_job.entity;

import java.util.Date;

public class RecruitInfo {
	private int id;
	private int userId;
	private int userInfoId;
	private String company;
	private String position;
	private String discribe;
	private String requirement;
	private Date datetime;
	private String categary;
	private String salary;
	
	public RecruitInfo(int id, int userId, int userInfoId, String company, String position, String discribe,
			String requirement, Date datetime, String categary) {
		super();
		this.id = id;
		this.userId = userId;
		this.userInfoId = userInfoId;
		this.company = company;
		this.position = position;
		this.discribe = discribe;
		this.requirement = requirement;
		this.datetime = datetime;
		this.categary = categary;
	}
	public RecruitInfo(int id, int userId, int userInfoId, String company, String position, String discribe,
			String requirement, String categary) {
		super();
		this.id = id;
		this.userId = userId;
		this.userInfoId = userInfoId;
		this.company = company;
		this.position = position;
		this.discribe = discribe;
		this.requirement = requirement;
		this.categary = categary;
	}
	public RecruitInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getCategary() {
		return categary;
	}
	public void setCategary(String categary) {
		this.categary = categary;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"userId\":\"" + userId + "\", \"userInfoId\":\"" + userInfoId + "\", \"company\":\"" + company
				+ "\", \"position\":\"" + position + "\", \"discribe\":\"" + discribe + "\", \"requirement\":\"" + requirement + "\", \"datetime\":\""
				+ datetime + "\", \"categary\":\"" + categary + "\", \"salary\":\"" + salary + "\"}";
	}
	

}
