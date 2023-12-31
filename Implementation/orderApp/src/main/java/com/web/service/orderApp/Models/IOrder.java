package com.web.service.orderApp.Models;
import java.util.List;

public interface IOrder {
	double calculatePrice();
	List<Product> getProducts() ;
	String getId();
}