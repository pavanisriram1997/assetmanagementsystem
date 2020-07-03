package com.jfsfeb.assetmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.repository.AssetManagementDB;
import com.jfsfeb.assetmanagementsystem.service.AdminService;
import com.jfsfeb.assetmanagementsystem.service.AdminServiceImple;
import com.jfsfeb.assetmanagementsystem.service.UserService;
import com.jfsfeb.assetmanagementsystem.service.UserServiceImple;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAsset {

	public static void assetOperation() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info("<----------------------<<< ASSET MANAGEMENT SYSTEM >>>--------------------->");
				log.info("[1] ADMIN PAGE");
				log.info("[2] USER PAGE");
				log.info("<--------------------------------------------------------------------->");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminController.adminOperations();
					
				case 2:
					UserController.userOperations();
					
				default:
					log.error("Invalid Choice....Choice must be 1 or 2 ");
					break;
				}
			} catch (InputMismatchException e) { //// if we give string in 1 n 2
				log.error("Invalid entry please provide 1 or 2");
				scanner.nextLine();
			} catch (Exception e) {
				log.error("Enter Correct ");
			}
		} while (true);

	}// End of Method
}// End of class
