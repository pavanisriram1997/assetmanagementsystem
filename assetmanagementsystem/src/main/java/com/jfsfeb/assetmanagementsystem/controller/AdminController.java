package com.jfsfeb.assetmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfo;
import com.jfsfeb.assetmanagementsystem.dto.AssetsDetails;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfo;
import com.jfsfeb.assetmanagementsystem.exceptions.AMSException;
import com.jfsfeb.assetmanagementsystem.factory.Factory;
import com.jfsfeb.assetmanagementsystem.service.AdminService;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminController {

	public static void adminOperations() {
	
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
		AdminService service = Factory.getAdminServicesImpleInstance();
		do {
			try {
				log.info("<--------------------------------------------------------------------->");
				log.info("[1] ADMINISTRATION REGISTER");
				log.info("[2] ADMINISTRATION LOGIN");
				log.info("[3] EXIT");
				log.info("<--------------------------------------------------------------------->");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					do {
						try {
							log.info("Enter ID to Register as ADMIN : ");
							id = scanner.nextInt();
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
							service.validatedName(name);
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
							service.validatedEmail(email);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Invalid email.....it should consist of numbers and alphabets");
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);
					do {
						try {
							log.info("Enter Password :");
							password = scanner.next();
							service.validatedPassword(password);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							log.error("Password doesnt accept spaces ");
						} catch (AMSException e) {
							flag = false;
							log.error(e.getMessage());
						}
					} while (!flag);

					AdminInfo bean = new AdminInfo();
					bean.setId(id);
					bean.setName(name);
					bean.setEmailId(email);
					bean.setPassword(password);

					boolean check = service.registerAdmin(bean);
					if (check) {
						log.info("You have registered Successfully");
					} else {
						log.info("Already registered");
					}
					break;

				case 2:
					log.info("Enter registered email to login : ");
					String adminEmail = scanner.next();
					log.info("Enter registered Password to login : ");
					String adminPassword = scanner.next();
					try {

						AdminInfo login = service.adminLogin(adminEmail, adminPassword);
						if (login != null) {
							log.info("You have logged in successfully");
							log.info("Now you can perform the following operations:-");
						}
						do {
							try {
								log.info(
										"<--------------------------------------------------------------------->");
								log.info("[1]  ADD ASSETS");
								log.info("[2]  SEARCH ASSET BY NAME");
								log.info("[3]  REMOVE ASSET");
								log.info("[4]  VIEW ALL ASSETDETAILS");
								log.info("[5]  Getting Request Details of User");
								log.info("[6]  LOGOUT");
								log.info(
										"<--------------------------------------------------------------------->");
								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:

									do {
										log.info("Enter AssetID to add : ");
										assetId = scanner.nextInt();
										try {
											service.validatedId(assetId);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("Id should contains only digits");
										} catch (AMSException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {
										log.info("Enter AssetName : ");
										assetName = scanner.next();
										try {
											service.validatedName(assetName);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("AssettName should contains only Alphabets");
										} catch (AMSException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {
										log.info("Enter Price : ");
										price = scanner.nextInt();
										try {
											service.validatePrice(price);

										} catch (InputMismatchException e) {
											flag = false;
											log.error("AssettName should contains only Alphabets");
										} catch (AMSException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {
										log.info("Enter Quantity : ");
										quantity = scanner.nextInt();
										try {
											service.validateQuantity(quantity);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("Asset Quantity should contains only numbers");
										} catch (AMSException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									AssetsDetails bean1 = new AssetsDetails();
									bean1.setAssetId(assetId);
									bean1.setAssetName(assetName);
									bean1.setPrice(price);
									bean1.setQuantity(quantity);
									boolean check2 = service.addAssets(bean1);
									if (check2) {
										log.info("Asset added successfully");
										log.info("Asset added of id = " + assetId);
									} else {
										log.info("Asset already exist of id = " + assetId);
									}
									break;
								case 2:
									log.info(" SEARCH ASSET BY NAME : ");
									String name1 = scanner.next();

									AssetsDetails bean2 = new AssetsDetails();
									bean2.setAssetName(name1);
									List<AssetsDetails> Aname = service.searchAssetByName(name1);
									log.info(
											"<--------------------------------------------------------------------->");
									for (AssetsDetails assets : Aname) {
										if (Aname != null) {
											log.info("asset id=====>" + assets.getAssetId());
											log.info("asset name====>" + assets.getAssetName());
											log.info("asset price====>" + assets.getPrice());
											log.info("asset quantity====>" + assets.getQuantity());
										} else {
											log.info("No Assets are available with this Asset Name");
										}
									}
									break;
								case 3:
									log.info("REMOVE ASSET ");
									int assetId1 = scanner.nextInt();
									if (assetId1 == 0) {
										log.info("Please Enter the Valid AssetId");
									} else {
										AssetsDetails bean3 = new AssetsDetails();
										bean3.setAssetId(assetId1);
										boolean remove = service.removeAssets(assetId1);
										if (remove) {
											log.info("The Asset is removed of Id = " + assetId1);
										} else {
											log.info("The Asset is not removed of Id = " + assetId1);
										}
									}
									break;
								case 4:
									List<AssetsDetails> info = service.getAllAssetsInfo();
									log.info(
											"<--------------------------------------------------------------------->");
									for (AssetsDetails assetBean : info) {
										if (assetBean != null) {
											log.info("asset id=====>" + assetBean.getAssetId());
											log.info("asset name====>" + assetBean.getAssetName());
											log.info("asset price====>" + assetBean.getPrice());
											log.info("asset quantity====>" + assetBean.getQuantity());
											log.info("-------------------------------------");
										} else {
											log.info("No Assets are available in the Asset Details");
										}
									}
									break;
								case 5:

									System.out.println("Requested User details are:");

									List<RequestInfo> requests = service.requestDetails();

									for (RequestInfo details : requests) {
										System.out.println("User id = " + details.getUserId());
										System.out.println("User name = " + details.getUserName());
										System.out.println("Asset id = " + details.getAssetId());
										System.out.println("Asset name = " + details.getAssetName());
										System.out.println("Asset quantity = " + details.getQuantity());

									}
									break;
								case 6:
									adminOperations();

								default:
									log.info("Invalid Choice");
									break;
								}
							} catch (InputMismatchException e) {
								log.error("Invalid entry please provide only positive integer");
								scanner.nextLine();
							}
						} while (true);
					} catch (Exception e) {
						log.info("Invalid Credentials");
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
			} catch (InputMismatchException e) {
				log.error("Invalid entry please provide only positive integer");
				scanner.nextLine();
			}
		} while (true);
		
	}//end of method

}//end of class
