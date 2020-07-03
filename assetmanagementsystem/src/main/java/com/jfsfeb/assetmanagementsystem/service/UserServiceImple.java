package com.jfsfeb.assetmanagementsystem.service;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dao.UserDAO;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.factory.Factory;
import com.jfsfeb.assetmanagementsystem.validation.Valid;

public class UserServiceImple implements UserService {

	UserDAO dao = Factory.getUserDAOImpleInstance();
	Valid validation = Factory.getValidationInstance();

	@Override
	public boolean registerUser(UserInfo userInfo) {
		if (userInfo != null) {
			return dao.registerUser(userInfo);
		}
		throw new AMSException("Enter correct details");
	}

	@Override
	public boolean userLogin(String email, String password) {
		if (email != null && password != null) {
			if (validation.validatedEmail(email)) {
				if (validation.validatedPassword(password)) {

					return dao.userLogin(email, password);
				}
			}
		}
		return false;
	}

	@Override
	public List<AssetsDetails> viewAllAsset() {
		
		return dao.viewAllAsset();
	}

	@Override
	public List<UserInfo> viewDetails() {
		
		return dao.viewDetails();
	}

	@Override
	public boolean requestAsset(int userId, String assetName, int quantity) {
		
		if ((userId > 0) && (assetName != null) && (quantity > 0)) {
			return dao.requestAsset(userId, assetName, quantity);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	@Override
	public boolean validatedId(int id) {
		// TODO Auto-generated method stub
		return validation.validatedId(id);
	}

	@Override
	public boolean validatedName(String name) {
		// TODO Auto-generated method stub
		return validation.validatedName(name);
	}

	@Override
	public boolean validatedEmail(String email) {
		// TODO Auto-generated method stub
		return validation.validatedEmail(email);
	}

	@Override
	public boolean validatedPassword(String password) {
		// TODO Auto-generated method stub
		return validation.validatedPassword(password);
	}

	@Override
	public boolean validateCategory(String name) {
		// TODO Auto-generated method stub
		return validation.validateCategory(name);
	}

	@Override
	public boolean validateQuantity(int quantity) {
		// TODO Auto-generated method stub
		return validation.validateQuantity(quantity);
	}

	@Override
	public boolean validatePrice(int price) {
		// TODO Auto-generated method stub
		return validation.validatePrice(price);
	}
}
