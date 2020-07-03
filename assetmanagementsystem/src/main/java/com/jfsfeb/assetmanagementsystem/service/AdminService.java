package com.jfsfeb.assetmanagementsystem.service;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;

public interface AdminService {
	
	public boolean registerAdmin(AdminInfo admin);

	public AdminInfo adminLogin(String email, String password);

	public List<AssetsDetails> searchAssetByName(String assetName);

	public List<AssetsDetails> getAllAssetsInfo();

	public boolean addAssets(AssetsDetails assetInfo);

	public boolean removeAssets(int assetId);

	public List<RequestInfo> requestDetails();

	public boolean acceptRequest(int id, String name);
	
	public boolean validatedId(int id);

	public boolean validatedName(String name);

	public boolean validatedEmail(String email);

	public boolean validatedPassword(String password);

	public boolean validateCategory(String name);

	public boolean validateQuantity(int quantity);

	public boolean validatePrice(int price);
}
