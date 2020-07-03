package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class AssetsDetails implements Serializable {

	private int assetId;
	private String assetName;
	private String companyName;
	private String category;
	private int price;
	private int quantity;
	private String status;
}
