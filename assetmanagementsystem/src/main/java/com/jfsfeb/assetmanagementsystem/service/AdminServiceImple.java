package com.jfsfeb.assetmanagementsystem.service;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.factory.Factory;
import com.jfsfeb.assetmanagementsystem.validation.Valid;

public class AdminServiceImple implements AdminService {

	AdminDAO dao = Factory.getAdminDAOImpleInstance();
	Valid validation = Factory.getValidationInstance();

	@Override
	public boolean registerAdmin(AdminInfo admin) {
		if (admin != null) {
			return dao.registerAdmin(admin);
		}
		throw new AMSException("Enter correct details");
	}

	@Override
	public AdminInfo adminLogin(String email, String password) {
		if (email != null && password != null) {
			if (validation.validatedEmail(email)) {
				if (validation.validatedPassword(password)) {

					return dao.adminLogin(email, password);
				}
			}
		}
		return null;

	}

	@Override
	public List<AssetsDetails> searchAssetByName(String assetName) {
		if (assetName != null) {
			return dao.searchAssetByName(assetName);
		}
		throw new AMSException("Enter correct details");
	}

	@Override
	public List<AssetsDetails> getAllAssetsInfo() {

		return dao.getAllAssetsInfo();
	}

	@Override
	public boolean addAssets(AssetsDetails assetInfo) {
		if (assetInfo != null) {
			return dao.addAssets(assetInfo);
		}
		throw new AMSException("Enter correct details");
	}

	@Override
	public boolean removeAssets(int assetId) {

		if (assetId != 0) {
			return dao.removeAssets(assetId);
		}
		throw new AMSException("Enter correct details");

	}

	@Override
	public List<RequestInfo> requestDetails() {

		return dao.requestDetails();
	}

	@Override
	public boolean acceptRequest(int id, String name) {
		if (id != 0 && name != null) {
			return dao.acceptRequest(id, name);
		}
		throw new AMSException("Enter correct details");
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
