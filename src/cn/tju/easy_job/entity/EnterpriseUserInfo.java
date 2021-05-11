package cn.tju.easy_job.entity;

import java.util.Date;

public class EnterpriseUserInfo {
	private int id;
	private int userId;
	private String name;
	private String sex;
	private Date birth;
	private String company;
	private String position;
	private String avatar;
	public EnterpriseUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnterpriseUserInfo(int id, int userId, String name, String sex, Date birth, String company, String position,
			String avatar) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.company = company;
		this.position = position;
		this.avatar = avatar;
	}
	public EnterpriseUserInfo(int id, int userId, String name, String sex, String company, String position) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.sex = sex;
		this.company = company;
		this.position = position;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"userId\":\"" + userId + "\", \"name\":\"" + name + "\", \"sex\":\"" + sex + "\", \"birth\":\"" + birth
				+ "\", \"company\":\"" + company + "\", \"position\":\"" + position + "\", \"avatar\":\"" + avatar + "\"}";
	}
	

}
