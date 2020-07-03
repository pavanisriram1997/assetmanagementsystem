package com.jfsfeb.assetmanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;

public class Validation implements Valid {

	@Override
	public boolean validatedId(int id) throws AMSException {
		String idRegEx = "[0-9]{2}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new AMSException("Invalid Id...Id should contain exactly 2 digits");
		}
		return result;
	}

	@Override
	public boolean validatedName(String name) throws AMSException {
		String nameRegEx = "^[A-Za-z\\s]+$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Invalid Name....Name should have atleast 4 characters");
		}
		return result;
	}

	@Override
	public boolean validatedEmail(String email) throws AMSException {
		String emailRegEx = "^(.+)@(.+)$";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Invalid Email....Enter the proper email Id");
		}
		return result;
	}

	@Override
	public boolean validatedPassword(String password) throws AMSException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{6,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} else {
			throw new AMSException(
					"Enter Valid Passsword with min 6 Characters, One Uppercase and Lowercase and a Symbol ");
		}
		return result;
	}

	@Override
	public boolean validateCategory(String name) throws AMSException {
		String nameRegEx = "^[A-Za-z\\s]+$";
		boolean result = false;

		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Category Should Contains only Alphabets");
		}
		return result;
	}

	@Override
	public boolean validateQuantity(int quantity) throws AMSException {

		String idRegEx = "^[0-9]+$";
		boolean result = false;

		if (Pattern.matches(idRegEx, String.valueOf(quantity))) {
			result = true;
		} else {
			throw new AMSException("Quantity should contain only number");
		}
		return result;
	}

	@Override
	public boolean validatePrice(int price) throws AMSException {

		String isRegEx = "[0-9]+([,.][0-9]{1,2})?";
		boolean result = false;
		if (Pattern.matches(isRegEx, String.valueOf(price))) {
			result = true;
		} else {
			throw new AMSException("price should contain valid number");
		}
		return false;
	}

}
