package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
//@SuppressWarnings("serial")
public class AdminInfo implements Serializable{

	private int id;
	private String name;
	private String emailId;
	@ToString.Exclude
	private String password;

}
