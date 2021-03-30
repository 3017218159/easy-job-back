package cn.tju.easy_job.entity;

public class MyCallback {
	private String message;
	private String status;
	
	public MyCallback() {
		super();
	}
	public MyCallback(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	@Override
	public String toString() {
		if (message.length() > 0) {
			char start = message.charAt(0);
			char end =  message.charAt(message.length() - 1);
			if ((start == '{' || start =='[') && (end == '}' || end == ']')) {
				return "{\"message\":" + message + ", \"status\":\"" + status + "\"}";
			}
		}
		return "{\"message\":\"" + message + "\", \"status\":\"" + status + "\"}";
	} 

}
