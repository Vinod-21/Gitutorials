package com.bridgelabz.fundoo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.responses.Response;
import com.bridgelabz.fundoo.responses.UserResponse;

@Service
public interface LabelService {
	
	public Response updateLabel(LabelDTO labelDto,String token, long labelId);
	
	public  Response deleteLabel(String token, long labelId);
	
	public List<Label> getAllLabelFromUser(String token);

	Response createLabel(LabelDTO labelDto, String token);
	
}
