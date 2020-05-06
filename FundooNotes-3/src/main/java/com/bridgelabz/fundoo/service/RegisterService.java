 package com.bridgelabz.fundoo.service;

import com.bridgelabz.fundoo.model.Login;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.responses.UserResponse;

public interface RegisterService {
	public void Save(User dto);

	public User Login(Login login);

}
