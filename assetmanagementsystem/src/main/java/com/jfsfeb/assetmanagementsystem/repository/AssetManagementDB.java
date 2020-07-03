package com.jfsfeb.assetmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;

public class AssetManagementDB {

	public static final List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
	public static final List<UserInfo> userInfos = new ArrayList<UserInfo>();
	public static final List<AssetsDetails> assetDetails = new ArrayList<AssetsDetails>();
	public static final List<RequestInfo> requestDetails = new ArrayList<RequestInfo>();

	private static void addDefaults() {

		AdminInfo admin = new AdminInfo();
		admin.setId(11);
		admin.setName("pavani");
		admin.setEmailId("pavani@gmail.com");
		admin.setPassword("Pavani@123");
		adminInfos.add(admin);

		UserInfo user = new UserInfo();
		user.setUserid(123);
		user.setUsername("varunavi");
		user.setEmail("varunavi@gmail.com");
		user.setPassword("Sweety@12");
		userInfos.add(user);

		AssetsDetails asset = new AssetsDetails();
		asset.setAssetId(10);
		asset.setAssetName("Chair");
		asset.setCompanyName("RoyalOak");
		asset.setCategory("OfficeChairs");
		asset.setPrice(3000);
		assetDetails.add(asset);

		AssetsDetails asset1 = new AssetsDetails();
		asset1.setAssetId(20);
		asset1.setAssetName("Table");
		asset1.setCompanyName("Aprodz");
		asset1.setCategory("OfficeTable");
		asset1.setPrice(25000);
		assetDetails.add(asset1);

		AssetsDetails asset2 = new AssetsDetails();
		asset2.setAssetId(30);
		asset2.setAssetName("File");
		asset2.setCompanyName("Banggood");
		asset2.setPrice(900);
		assetDetails.add(asset2);
		
		RequestInfo request=new RequestInfo();
		request.setUserId(21);
		request.setUserName("Pavani");
		request.setAssetId(30);
		request.setAssetName("File");
		request.setQuantity(40);
		requestDetails.add(request);

		RequestInfo request1 = new RequestInfo();
		request1.setUserId(13);
		request1.setUserName("Kusuma");
		request1.setAssetId(11);
		request1.setAssetName("Chair");
		request1.setQuantity(50);
		requestDetails.add(request1);
		
		RequestInfo request2 = new RequestInfo();
		request2.setUserId(12);
		request2.setAssetName("Chair");
		request2.setQuantity(40);
		request2.setStatus("sent");
		requestDetails.add(request2); 
	}
	
	static {
		addDefaults();
	}
}
