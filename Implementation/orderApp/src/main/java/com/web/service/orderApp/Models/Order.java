package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class Order implements IOrder {
	private final List<Product> products;
	private final OrderStatus orderStatus;
	private final Date date;
	private final double totalPrice;

	public double calculatePrice() {
		double ans = 0;
        for (Product product : products) {
            ans += product.getPrice();
        }
		return ans ;
	}
}