package com.bridgelabz.fundoo.configuration;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class JavaMailService {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	JasonWebToken jwt;

	// function for sending mail
	public void sendMail(String email ,String token) {
		
		
		
	}

	public void sendMail(String email) {
		SimpleMailMessage m2 = new SimpleMailMessage();
		m2.setFrom("vinodtitu1@gmail.com");
		m2.setTo(email);
		m2.setText("succesful registration of fundoo ");
		mailSender.send(m2);
	}
	

	public void forgetSendMail(Emails mail) {
		
		SimpleMailMessage messagess = new SimpleMailMessage();
		
		messagess.setTo(mail.getTo());
		messagess.setSubject(mail.getSubject());
		messagess.setText(mail.getBody());

		System.out.println("Sending Email ");

		mailSender.send(messagess);
	}

	public String getLink(String link, long id) throws IllegalArgumentException, UnsupportedEncodingException {
		return link + jwt.createJWT(id);
	}

}
