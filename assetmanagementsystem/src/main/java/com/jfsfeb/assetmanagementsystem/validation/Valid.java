package com.jfsfeb.assetmanagementsystem.validation;

public interface Valid {

	public boolean validatedId(int id);

	public boolean validatedName(String name);

	public boolean validatedEmail(String email);

	public boolean validatedPassword(String password);

	public boolean validateCategory(String name);

	public boolean validateQuantity(int quantity);

	boolean validatePrice(int price);
}
