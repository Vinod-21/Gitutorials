package com.bridgelabz.fundoo.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.responses.Response;
import com.bridgelabz.fundoo.responses.UserResponse;
import com.bridgelabz.fundoo.service.RegisterService;
import com.bridgelabz.fundoo.service.RegisterServiceImpl;

@RestController
//@RequestMapping("/api")
public class RegisterController {
	
	
	@Autowired
	 RegisterServiceImpl service;
	
	@Autowired
	private Environment env;

	public RegisterController() {
		System.out.println("RegisterController working");
	}
	

	@PostMapping("/save")
	public ResponseEntity<UserResponse> save(User dto){
	//public ModelMap ModelAndView (User dto) {
		System.out.println("onRegister method is working!!!!!");
		 this.service.Save(dto);
		 System.out.println("service.save executed");
		
		 
		 UserResponse userr = new UserResponse("",env.getProperty("100"),"");

			return new ResponseEntity<>(userr, HttpStatus.OK);

	}
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	
	@GetMapping("/forgotPassword")
	public ResponseEntity<UserResponse> forgotPassword(@RequestParam String emailId){
		System.out.println("forgotPaswword proveoked");
		System.out.println(emailId);
		String token="";
		User user = service.forgotPassword(emailId);
		
		UserResponse userr = new UserResponse( token,env.getProperty("100"), user);

		return new ResponseEntity<>(userr, HttpStatus.OK);

 

	}
	
	@PutMapping(value = "/resetPassword/{token}")
	public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam("password") String password) {
		Response response = service.resetPassword(token, password);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		/*
		 * Response response = userService.resetPaswords(token, password); return new
		 * ResponseEntity<Response>(response, HttpStatus.OK);
		 */
	}
	
}
