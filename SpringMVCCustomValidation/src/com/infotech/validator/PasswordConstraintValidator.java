package com.infotech.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<IsValidPassword, String> {
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	private Matcher matcher;
	
	public PasswordConstraintValidator() {
		 pattern = Pattern.compile(PASSWORD_PATTERN);
	}
    @Override
    public void initialize(IsValidPassword isValidPassword) {
    	 isValidPassword.message();
    }
 
    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        if(password == null) {
            return false;
        }
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}