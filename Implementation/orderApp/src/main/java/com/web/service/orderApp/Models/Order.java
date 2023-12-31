package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Order implements IOrder {
	private final List<Product> products;
	private final OrderStatus orderStatus;
	private final Date date;
	private final double totalPrice;
	private final String id ;

	public double calculatePrice() {
		double ans = 0;
        for (Product product : products) {
            ans += product.getPrice();
        }
		return ans ;
	}
}