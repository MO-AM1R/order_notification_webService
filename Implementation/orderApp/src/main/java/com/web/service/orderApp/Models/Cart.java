package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Cart {
	private final List<Product> products;

	@Override
	public String toString() {
		return "Cart{" +
				"products=" + products +
				'}';
	}
}