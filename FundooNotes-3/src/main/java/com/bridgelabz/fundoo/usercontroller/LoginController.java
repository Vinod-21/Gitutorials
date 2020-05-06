package com.bridgelabz.fundoo.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.configuration.JasonWebToken;
import com.bridgelabz.fundoo.model.Login;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.responses.UserResponse;
import com.bridgelabz.fundoo.service.RegisterService;
import com.sun.mail.iap.Response;

@RestController
public class LoginController {
	@Autowired
	RegisterService service;

	@Autowired
	JasonWebToken jwt;
	
	@Autowired
	private Environment env;


	public LoginController() {
		
	}

		

	/*
	 * @RequestMapping("/login") public ModelMap onLogin(Login login, ModelMap map)
	 * {
	 * 
	 * System.out.println("onLogin method is working!!!!!");
	 * 
	 * User user = this.service.Login(login);
	 * 
	 * ModelMap mp = new ModelMap(); mp.addAttribute("name", user); return mp;
	 * 
	 * }
	 */

	// ResponseEntity class represents an HTTP response, including headers, body,
	// and status.
	@SuppressWarnings("unchecked")
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(Login login) {
		//fetching data from database through service layer
		User user = service.Login(login);
		String token = jwt.createJWT((long) user.getUserId());
		System.out.println("the token is" + " -->" + token);
		Long getToken = jwt.decodeJWT(token);
		System.out.println("the decode token is" + "--->" + getToken);
		if (user != null) {
			UserResponse userr = new UserResponse(token, env.getProperty("100"), user);

			return new ResponseEntity<>(userr, HttpStatus.OK);

		} 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserResponse(env.getProperty("106"), "", user));


			//return (ResponseEntity<UserResponse>) ResponseEntity.status(HttpStatus.BAD_REQUEST).header(token);
	}
}
