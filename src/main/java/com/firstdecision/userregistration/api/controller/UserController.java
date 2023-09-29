package com.firstdecision.userregistration.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstdecision.userregistration.api.util.UserValidatorUtil;
import com.firstdecision.userregistration.domain.model.User;
import com.firstdecision.userregistration.domain.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<List<String>> insert(@RequestBody User user) throws SQLException {
		UserValidatorUtil userValidator = new UserValidatorUtil();
		List<String> validationErrors = userValidator.validateForm(user);
		if (validationErrors.isEmpty()) {
			userService.insert(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
	}

}
