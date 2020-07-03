package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestInfo implements Serializable {

	private int userId;
	private String userName;
	private int assetId;
	private String assetName;
	private int quantity;
	private String status;
	
}
