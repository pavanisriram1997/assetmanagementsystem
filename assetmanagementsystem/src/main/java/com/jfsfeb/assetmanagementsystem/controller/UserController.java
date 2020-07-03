package com.jfsfeb.assetmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jfsfeb.assetmanagementsystem.dao.AdminDAOImple;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.dto.UserInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.factory.Factory;
import com.jfsfeb.assetmanagementsystem.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserController {

	public static void userOperations() {
		
		boolean flag = false;
		int id = 0;
		String name = null;
		String email = null;
		String password = null;

		int assetId = 0;
		String assetName = null;
		int price = 0;
		int quantity = 0;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		UserService service1 = Factory.getUserServicesImpleInstance();
		UserInfo userInfo = new UserInfo();
		AssetsDetails assetsInfo = new AssetsDetails();
		do {
			try {
				log.info("<--------------------------------------------------------------------->");
				log.info("[1] USER REGISTER");
				log.info("[2] USER LOGIN");
				log.info("[3] EXIT");
				log.info("<--------------------------------------------------------------------->");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:

					do {
						try {
							log.info("Enter ID to Register as USER : ");
							id = scanner.nextInt();
							service1.validatedId(id);
							flag = true;
						} catch (InputMismatchException e) {
							log.error("ID should consist of only digits");
							flag = false;
							scanner.next();
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Name to Register : ");
							name = scanner.next();
							service1.validatedName(name);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Name should consists of only Alphabates");
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Email to Register : ");
							email = scanner.next();
							service1.validatedEmail(email);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error(
									"Enter proper email such that it should consist of numbers and alphabets");
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Password :");
							password = scanner.next();
							service1.validatedPassword(password);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Password doesnt accept spaces ");
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					UserInfo bean1 = new UserInfo();
					bean1.setUserid(id);
					bean1.setUsername(name);
					bean1.setEmail(email);
					bean1.setPassword(password);

					boolean check = service1.registerUser(bean1);
					if (check) {
						log.info("Registered Successfully");
					} else {
						log.info("Already registered");
					}
					break;

				case 2:
					log.info("Enter registered email to login : ");
					String userEmail = scanner.next();
					log.info("Enter registered Password to login : ");
					String UserPassword = scanner.next();
					try {
						@SuppressWarnings("unused")
						boolean UserBean = service1.userLogin(userEmail, UserPassword);
						log.info("Logged in Successfully");
						do {
							try {
								log.info(
										"<--------------------------------------------------------------------->");
								log.info("[1] VIEW ALL ASSETS");
								log.info("[2] VIEW DETAILS");
								log.info("[3] REQUEST ASSET");
								log.info("[4] LOGOUT");
								log.info(
										"<--------------------------------------------------------------------->");
								int choice2 = scanner.nextInt();
								switch (choice2) {
								case 1:

									List<AssetsDetails> asset = service1.viewAllAsset();
									log.info(
											"<---------------------------------------------------------------->");
									for (AssetsDetails details : asset) {
										if (details != null) {
											log.info("asset id=====>" + details.getAssetId());
											log.info("asset name====>" + details.getAssetName());
											log.info("asset price====>" + details.getPrice());
											log.info("asset quantity====>" + details.getQuantity());
											log.info("---------------------------------------------");
										} else {
											log.info("No Assets are available in the Asset Details");
										}
									}

									break;
								case 2:
									
									List<UserInfo> user=service1.viewDetails();
									log.info("<------------------------------------------------------------------->");
									for (UserInfo details:user) {
										if(details!=null) {
											log.info("user id=====>"+details.getUserid());
											log.info("user name=====>"+details.getUsername());
											log.info("user email=====>"+details.getEmail());
										}else {
											log.info("No User Found");
										}
									}
									break;
								case 3:
		
									log.info("Add your required assets");

									log.info("Enter user id");
									int Userid = scanner.nextInt();
//									int userid = userInfo.getUserid();
									userInfo.setUserid(Userid);

									log.info("Enter user name");
									String username=scanner.next();
									userInfo.setUsername(username);
									
									log.info("Enter asset name");
									String assetName1 = scanner.next();
									assetsInfo.setAssetName(assetName1.trim());

									log.info("Enter asset quantity");
									int quantity1 = scanner.nextInt();
									assetsInfo.setQuantity(quantity1);

									log.info("Enter asset price");
									int price1 = scanner.nextInt();
									assetsInfo.setPrice(price1);

									try {

										boolean status = service1.requestAsset(Userid, assetName1, quantity1);

										if(status) {
											
											AdminDAO service= new AdminDAOImple();
											service.acceptRequest(id, name);

											log.info("request accepted");
										}

									} catch (AMSException e) {

										log.error(e.getMessage());

									}
									break;
								case 4:
									userOperations();
									break;
								default:
									break;
								}
							} catch (InputMismatchException e) {
								log.error("Invalid entry please provide only positive integer");
								scanner.nextLine();
							}
						} while (true);
					} catch (Exception e) {
						log.error("Invalid Credentials");
					}
					break;
				case 3:
					SubAsset.assetOperation();
					break;

				default:
					log.info("Invalid Choice");
					log.error("Choice must be 1 or 2");
					break;
				}
			} catch (InputMismatchException e) { // if we give string in 1 n 2 n 3
				log.error("Invalid entry please provide only positive integer");
				scanner.nextLine();
			}
		} while (true);

}// end of method
}// end of class
