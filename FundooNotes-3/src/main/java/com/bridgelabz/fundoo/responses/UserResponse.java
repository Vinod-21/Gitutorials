package com.bridgelabz.fundoo.responses;

public class UserResponse {

	private String token;
	private String Message;
	private Object obj;
	public UserResponse(String token, String message, Object obj) {
		super();
		this.token = token;
		Message = message;
		this.obj = obj;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	}	
	

