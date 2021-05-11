package cn.tju.easy_job.entity;

import java.util.Date;

public class StudentUserInfo {
	private int id;
	private int userId;
	private String name;
	private String sex;
	private Date birth;
	private String school;
	private String major;
	private String avatar;
	public StudentUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentUserInfo(int id, int userId, String name, String sex, Date birth, String school, String major,
			String avatar) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.school = school;
		this.major = major;
		this.avatar = avatar;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
				+ "\", \"school\":\"" + school + "\", \"major\":\"" + major + "\", \"avatar\":\"" + avatar + "\"}";
	}
	

}
