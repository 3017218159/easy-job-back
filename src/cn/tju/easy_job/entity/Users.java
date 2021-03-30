package cn.tju.easy_job.entity;

public class Users {
	private int id;
	private String email;
	private String status;
	private String password;
	private String username;
	
	public Users() {
		super();
	}
	public Users(int id, String email, String status, String password, String username) {
		super();
		this.id = id;
		this.email = email;
		this.status = status;
		this.password = password;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\", \"password\":\"" + password
				+ "\", \"username\":\"" + username + "\"}";
	}
}
