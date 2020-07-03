package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@SuppressWarnings("serial")
public class UserInfo implements Serializable{

	private int userid;
	private String username;
	private String email;
	@ToString.Exclude
	private String password;
	

}
