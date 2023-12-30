package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
	private String category;
	private String name;
	private String serialNumber;
	private String vendor;
	private double price;
	private int quantity;

	@Override
	public String toString() {
		return "Product{" +
				"category='" + category + '\'' +
				", name='" + name + '\'' +
				", serialNumber='" + serialNumber + '\'' +
				", vendor='" + vendor + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				'}';
	}
}