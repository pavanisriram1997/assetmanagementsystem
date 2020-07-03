package com.jfsfeb.assetmanagementsystem.dao;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;

public interface AdminDAO {

	public boolean registerAdmin(AdminInfo admin);

	public AdminInfo adminLogin(String email, String password);

	public List<AssetsDetails> searchAssetByName(String assetName);

	public List<AssetsDetails> getAllAssetsInfo();

	public boolean addAssets(AssetsDetails assetInfo);

	public boolean removeAssets(int assetId);

	public List<RequestInfo> requestDetails();

	public boolean acceptRequest(int id, String name);
}
