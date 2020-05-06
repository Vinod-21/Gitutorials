package com.bridgelabz.fundoo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoo.configuration.JasonWebToken;
import com.bridgelabz.fundoo.dao.ILabelRepository;
import com.bridgelabz.fundoo.dao.NoteDaoImpl;
import com.bridgelabz.fundoo.dao.RegisterDaoImpl;
import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.responses.Response;
import com.bridgelabz.fundoo.responses.ResponseHelper;
import com.bridgelabz.fundoo.responses.UserResponse;

@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	JasonWebToken jwt;

	@Autowired
	private
	Environment environment;

	@Autowired
	private 
	ILabelRepository labelRepository;

	Label label;

	@Autowired
	NoteDaoImpl noteDAO;

	@Autowired
	RegisterDaoImpl registerDAO;

	@Override
	public Response createLabel(LabelDTO labelDto, String token) {
		long userId = jwt.decodeJWT(token);
		User user=registerDAO.findById(userId);
		System.out.println("printing user object in label service");
		System.out.println(user);
		Label label = new Label();
		BeanUtils.copyProperties(labelDto, label);
		label.setLabelName(label.getLabelName());
		label.setCreated(LocalDateTime.now());
		label.setModified(LocalDateTime.now());
		labelRepository.save(label);
		registerDAO.save(user.getLabel());
		Response response = ResponseHelper.statusResponse(environment.getProperty("status.label.created"), 200);
		return response;
	}

	@Override
	public Response updateLabel(LabelDTO labelDto, String token, long labelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteLabel(String token, long labelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Label> getAllLabelFromUser(String token) {
		System.out.println("getAllLabelFromUser starts!!!!!!!!!!!!!!!!!!!!!!!1");

		long userId = jwt.decodeJWT(token);

		return labelRepository.findByUserId(userId);

		// return listLabel1;

	}

}
