package com.jfsfeb.assetmanagementsystem.dao;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;

public interface UserDAO {

	public boolean registerUser(UserInfo userInfo);

	public boolean userLogin(String email, String password);

	public List<AssetsDetails> viewAllAsset();

	public List<UserInfo> viewDetails();

	public boolean requestAsset(int userId, String assetName, int quantity);

}
