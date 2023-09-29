package com.firstdecision.userregistration.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.firstdecision.userregistration.domain.model.User;

public class UserValidatorUtil {
	
	private List<String> validationErrors = new ArrayList<>();

	public List<String> validateForm(User user) {
		
		validateName(user.getName());
		validateEmail(user.getEmail());
		validatePasswords(user.getPassword(), user.getConfirmPassword());
		
		return validationErrors;
		
	}
	
	public void validateName(String name) {
		if(name == null || name.length() < 3 || name.length() > 50) {
			validationErrors.add("O nome deve possuir entre 3 e 50 caracteres.");
		}
	}
	
	public void validateEmail(String email) {
		String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if(email == null || !Pattern.compile(emailPattern).matcher(email).matches()) {
			validationErrors.add("O e-mail possui um formato inválido.");
		}
	}
	
	public void validatePasswords(String password, String confirmPassword) {
		if(password == null || password.length() < 6 || password.length() > 20) {
			validationErrors.add("A senha deve possuir entre 6 e 20 caracteres.");
		}
		
		if(confirmPassword == null || password == null || !password.equals(confirmPassword)) {
			validationErrors.add("As senhas devem ser iguais.");
		}
	}

}
