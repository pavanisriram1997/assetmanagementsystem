package com.jfsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.repository.AssetManagementDB;

public class UserDAOImple implements UserDAO {

	@Override
	public boolean registerUser(UserInfo userInfo) {

		for (UserInfo a1 : AssetManagementDB.userInfos) {
			if ((a1.getEmail()).equals(userInfo.getEmail())) {
				return false;
			}
		}
		AssetManagementDB.userInfos.add(userInfo);
		return true;
	}

	@Override
	public boolean userLogin(String email, String password) {

		for (UserInfo a2 : AssetManagementDB.userInfos) {
			if ((a2.getEmail().equals(email)) && (a2.getPassword().equals(password))) {
				return true;
			}
		}
		throw new AMSException("Invalid Credentials");
	}

	@Override
	public List<AssetsDetails> viewAllAsset() {

		List<AssetsDetails> allAssets = new ArrayList<AssetsDetails>();

		for (AssetsDetails assetBean : AssetManagementDB.assetDetails) {

			assetBean.getAssetId();
			assetBean.getAssetName();
			assetBean.getCategory();
			assetBean.getCompanyName();
			assetBean.getPrice();

			allAssets.add(assetBean);

		}

		return allAssets;
	}

	@Override
	public List<UserInfo> viewDetails() {

		List<UserInfo> allAssets = new ArrayList<UserInfo>();

		for (UserInfo userBean : AssetManagementDB.userInfos) {

			userBean.getUserid();
			userBean.getUsername();
			userBean.getEmail();
			userBean.getPassword();

			allAssets.add(userBean);

		}

		return allAssets;

	}

	@Override
	public boolean requestAsset(int userId, String assetName, int quantity) {

		RequestInfo requestInfo = new RequestInfo();
		for (UserInfo userBean : AssetManagementDB.userInfos) {
			if (userId == userBean.getUserid()) {
				for (AssetsDetails assetBean : AssetManagementDB.assetDetails) {
					if (assetBean.getAssetName().equals(assetName)) {
						requestInfo.setUserId(userId);
						requestInfo.setAssetName(assetName);
						requestInfo.setQuantity(quantity);
						AssetManagementDB.requestDetails.add(requestInfo);
						return true;
					}
				}
			}
		}
		throw new AMSException("Request is not sent");
	}

}
