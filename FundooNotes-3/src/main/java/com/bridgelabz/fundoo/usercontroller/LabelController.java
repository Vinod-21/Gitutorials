package com.bridgelabz.fundoo.usercontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.responses.Response;
import com.bridgelabz.fundoo.responses.UserResponse;
import com.bridgelabz.fundoo.service.LabelServiceImpl;

@RestController
//@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LabelController {

	@Autowired
	LabelServiceImpl service;
	
	@PostMapping("/createLabel/{token}") 
	//consumes = "application/json";
	public  ResponseEntity<Response> createLabel(LabelDTO labelDTO, @RequestHeader String token){

		System.out.println("Dto values are");
		System.out.println("token values is"+" "+token);
		System.out.println(labelDTO.getLabelName());
		System.out.println("atlest create label endpoint working");
		
		Response response = service.createLabel(labelDTO, token);
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateLabel")
	public ResponseEntity<Response> updateLabel(@RequestBody LabelDTO labelDto,@RequestHeader String token,@RequestParam long labelId){
		Response response = service.updateLabel(labelDto, token, labelId);
		
		return new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/deleteLabel")
	public ResponseEntity<Response> deleteLabel(@RequestHeader String token, @RequestParam long labelId){
		Response response = service.deleteLabel(token, labelId);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}

	@GetMapping("/getLabel")
	List<Label>getLabel(@RequestHeader String token){
		System.out.println("getlabel controller method started");
		List<Label> listLabel = service.getAllLabelFromUser(token);
		System.out.println("pring getlabel ccontroller method");
		System.out.println(listLabel);
		return listLabel;
	}
}
