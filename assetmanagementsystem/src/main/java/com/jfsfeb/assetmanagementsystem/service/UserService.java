package com.jfsfeb.assetmanagementsystem.service;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;

public interface UserService {

	public boolean registerUser(UserInfo userInfo);

	public boolean userLogin(String email, String password);

	public List<AssetsDetails> viewAllAsset();

	public List<UserInfo> viewDetails();

	public boolean requestAsset(int userId, String assetName, int quantity);

	public boolean validatedId(int id);

	public boolean validatedName(String name);

	public boolean validatedEmail(String email);

	public boolean validatedPassword(String password);

	public boolean validateCategory(String name);

	public boolean validateQuantity(int quantity);

	public boolean validatePrice(int price);

}
