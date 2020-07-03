package com.jfsfeb.assetmanagementsystem.factory;

import com.jfsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jfsfeb.assetmanagementsystem.dao.AdminDAOImple;
import com.jfsfeb.assetmanagementsystem.dao.UserDAO;
import com.jfsfeb.assetmanagementsystem.dao.UserDAOImple;
import com.jfsfeb.assetmanagementsystem.service.AdminService;
import com.jfsfeb.assetmanagementsystem.service.AdminServiceImple;
import com.jfsfeb.assetmanagementsystem.service.UserService;
import com.jfsfeb.assetmanagementsystem.service.UserServiceImple;
import com.jfsfeb.assetmanagementsystem.validation.Valid;
import com.jfsfeb.assetmanagementsystem.validation.Validation;

public class Factory {

	private Factory() {
	}

	public static AdminDAO getAdminDAOImpleInstance() {
		AdminDAO dao = new AdminDAOImple();
		return dao;
	}

	public static UserDAO getUserDAOImpleInstance() {
		UserDAO userdao = new UserDAOImple();
		return userdao;
	}

	public static AdminService getAdminServicesImpleInstance() {
		AdminService adminService = new AdminServiceImple();
		return adminService;
	}

	public static UserService getUserServicesImpleInstance() {
		UserService userService = new UserServiceImple();
		return userService;
	}

	public static Valid getValidationInstance() {
		Valid validation = new Validation();
		return validation;
	}
}
