package com.jfsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.repository.AssetManagementDB;

public class AdminDAOImple implements AdminDAO {

	@Override
	public boolean registerAdmin(AdminInfo admin) {

		for (AdminInfo a1 : AssetManagementDB.adminInfos) {
			if ((a1.getEmailId()).equals(admin.getEmailId())) {
				return false;
			}
		}
		AssetManagementDB.adminInfos.add(admin);
		return true;
	}

	@Override
	public AdminInfo adminLogin(String email, String password) {

		for (AdminInfo a2 : AssetManagementDB.adminInfos) {
			if ((a2.getEmailId().equalsIgnoreCase(email)) && (a2.getPassword().equals(password))) {
				return a2;
			}
		}
		throw new AMSException("Enter correct Email and Password");
	}

	@Override
	public List<AssetsDetails> searchAssetByName(String assetName) {

		List<AssetsDetails> searchList = new ArrayList<AssetsDetails>();
		for (int i = 0; i <= AssetManagementDB.assetDetails.size() - 1; i++) {
			AssetsDetails retrievedData = AssetManagementDB.assetDetails.get(i);
			String retrievedName = retrievedData.getAssetName();
			if (assetName.equals(retrievedName)) {
				searchList.add(retrievedData);
				return searchList;
			}
		}
		if (searchList.size() == 0) {
			throw new AMSException("Searched item not found");
		} else {
			return searchList;
		}
	}

	@Override
	public List<AssetsDetails> getAllAssetsInfo() {

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
	public boolean addAssets(AssetsDetails assetInfo) {

		for (AssetsDetails assetbean : AssetManagementDB.assetDetails) {
			if (assetbean.getAssetName() == assetInfo.getAssetName()) {
				throw new AMSException("can't add asset....already exits");
			}
		}
		AssetManagementDB.assetDetails.add(assetInfo);
		return true;
	}

	@Override
	public boolean removeAssets(int assetId) {

		for (AssetsDetails assetinf : AssetManagementDB.assetDetails) {
			if (assetinf.getAssetId() == assetId) {
				AssetManagementDB.assetDetails.remove(assetId);
				return true;
			}
		}
		throw new AMSException("Can't remove , No asset found");
	}

	@Override
	public List<RequestInfo> requestDetails() {

		List<RequestInfo> requests = new ArrayList<RequestInfo>();

		for (RequestInfo requestBeans : AssetManagementDB.requestDetails) {

			requestBeans.getUserId();
			requestBeans.getUserName();
			requestBeans.getAssetId();
			requestBeans.getAssetName();
			requestBeans.getStatus();

			requests.add(requestBeans);

		}

		return requests;
	}

	@Override
	public boolean acceptRequest(int id, String name) {
		
		RequestInfo requestInfo = new RequestInfo();

		for (RequestInfo accept : AssetManagementDB.requestDetails) {

			if (id == accept.getUserId()) {

				for (AssetsDetails assetBean : AssetManagementDB.assetDetails) {

					if (assetBean.getAssetName().contentEquals(name)) {

						requestInfo.setUserId(id);
						requestInfo.setAssetName(name);
						String status = "true";
						requestInfo.setStatus(status);
						AssetManagementDB.requestDetails.add(requestInfo);
						return true;

					}

				}

			}

		}

		throw new AMSException("Accept is not valid");
	}

}
