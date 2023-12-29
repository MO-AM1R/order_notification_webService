package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private String category;
	private String name;
	private String serialNumber;
	private String vendor;
	private double price;
	private int quantity;
}