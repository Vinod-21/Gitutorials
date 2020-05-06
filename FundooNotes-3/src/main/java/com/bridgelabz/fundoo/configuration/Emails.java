package com.bridgelabz.fundoo.configuration;

public class Emails {
	
	private String from;
	private String to;
	private String subject;
	private String body;
	
	
	public Emails() {
		
	}
	public Emails(String from, String to, String subject, String body) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Email [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
	
}
