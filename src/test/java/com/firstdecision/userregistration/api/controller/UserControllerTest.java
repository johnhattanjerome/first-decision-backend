package com.firstdecision.userregistration.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.firstdecision.userregistration.api.util.UserValidatorUtil;
import com.firstdecision.userregistration.domain.model.User;

@SpringBootTest
class UserControllerTest {
	
	@Mock
	UserValidatorUtil userValidator;
	
	@Autowired
	UserController userController;
	
	@Test
    public void testInsertValidUser() throws Exception {
		User user = new User();
		user.setName("Joao");
		user.setEmail("joao@firstdecision.com");
		user.setPassword("123456");
		user.setConfirmPassword("123456");
		
		List<String> validationErrors = userValidator.validateForm(user); 
		
		assertThat(validationErrors.isEmpty());
		
		ResponseEntity<List<String>> response = userController.insert(user);
		
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);		 
		
	}
	
	@Test
    public void testInsertInvalidUser() throws Exception {
		User user = new User();
		user.setName("Jo");
		user.setEmail("joao@fd");
		user.setPassword("12345");
		user.setConfirmPassword("1234");
		
		List<String> validationErrors = userValidator.validateForm(user); 
		
		assertThat(!validationErrors.isEmpty());
		
	}

}
