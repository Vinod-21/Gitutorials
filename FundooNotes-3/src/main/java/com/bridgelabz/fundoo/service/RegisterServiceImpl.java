package com.bridgelabz.fundoo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;

import com.bridgelabz.fundoo.configuration.Emails;
import com.bridgelabz.fundoo.configuration.JasonWebToken;
import com.bridgelabz.fundoo.configuration.JavaMailService;
import com.bridgelabz.fundoo.dao.RegisterDaoImpl;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.responses.Response;
import com.bridgelabz.fundoo.responses.ResponseHelper;
import com.bridgelabz.fundoo.responses.UserResponse;
import com.bridgelabz.fundoo.utility.RedisTemp;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDaoImpl RegisterDAO;

	@Autowired
	private JavaMailService jms;

	@Autowired
	JasonWebToken jwt;

	@Autowired
	private Environment environment;

	@Autowired
	RedisTemp<Object> redis;

	private String redisKey = "Key";

	public RegisterServiceImpl() {
		System.out.println("constructor of  RegisterServiceImpl is working");
	}

	@Override
	@Transactional
	public void Save(User dto) {
		System.out.println("printing user");
		System.out.println(dto);
		System.out.println("Springboot save");
		RegisterDAO.saves(dto);
		jms.sendMail(dto.getEmail());
		System.out.println("validatAndSave method Success");

	}

	@Transactional
	public List<User> getAllUser() {

		return RegisterDAO.getAllUser();
	}

	@Override
	@Transactional
	public User Login(com.bridgelabz.fundoo.model.Login login) {
		boolean result = false;

		System.out.println("login service method invoked");

		// fetching data from database
		User user = RegisterDAO.login(login);
		String token = jwt.createJWT(user.getUserId());
		redis.putMap(redisKey, user.getEmail(), token);

		if (user != null) {
			// validating and comparing
			if (login.getEmail().equalsIgnoreCase(user.getEmail()) && login.getPassword().equals(user.getPassword())) {

				System.out.println("validation is done!!!");
				return user;
			}

		} else {
			System.out.println("user not found!!!!");
		}
		return user;

		/*
		 * if (result == true) { return new
		 * UserResponse(environment.getProperty("LOGIN_SUCCESS"),
		 * environment.getProperty("SERVER_CODE_SUCCESS")); } else return new
		 * UserResponse(environment.getProperty("INVALID_CREDENTIALS"),
		 * environment.getProperty("SERVER_CODE_ERROR"));
		 */

		/*
		 * System.out.println("service Login executed");
		 * 
		 * String token=jwt.createJWT(user.getEmail());
		 * System.out.println("the token is"+" -->"+token); String
		 * getToken=jwt.getUserToken(token);
		 * System.out.println("the decode token is"+"--->"+getToken);
		 * 
		 * return user ;
		 */
	}

	@Transactional
	public User forgotPassword(String email) {
		System.out.println("forgot password method provoked in register controller");
		User user = RegisterDAO.getByEmail(email);
		System.out.println("printing user object in forgot password");
		System.out.println(user);
		if (user != null) {
			long id = user.getUserId();
			// JavaMailService jms1=new JavaMailService();
			Emails mail = new Emails();
			mail.setTo(email);
			mail.setSubject("FORGOT PASSWORD & RESET PASSWORD");
			try {
				mail.setBody(jms.getLink("http://localhost:8081/user/resetPassword/", id));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			jms.forgetSendMail(mail);

		}
		return user;
	}

	@Transactional
	public Response resetPassword(String token, String password) {
		Long id = jwt.decodeJWT(token);
		User user = (User) RegisterDAO.findById(id);
		// String encodedpassword = passwordEncoder.encode(password);
		// user.setPassword(encodedpassword);
		user.setPassword(password);
		RegisterDAO.saves(user);
		return ResponseHelper.statusResponse("password successfully reset", 200);

	}
}
