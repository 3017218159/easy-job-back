package cn.tju.easy_job.entity;

public class MyError {
	private String message;
	private String status;
	
	public MyError() {
		super();
	}
	public MyError(String message) {
		super();
		this.message = message;
		this.status = "error";
	}
	@Override
	public String toString() {
		return "{\"message\":\"" + message + "\", \"status\":\"" + status + "\"}";
	} 

}
