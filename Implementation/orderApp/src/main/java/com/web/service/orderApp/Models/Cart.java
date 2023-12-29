package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class Cart {
	private final List<Product> products;
}