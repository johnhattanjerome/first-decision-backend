package com.firstdecision.userregistration.domain.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdecision.userregistration.domain.model.User;
import com.firstdecision.userregistration.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insert(User user) throws SQLException{
			userRepository.save(user);	
	}

}
