package com.web.service.orderApp.Models;
import lombok.Getter;

import java.util.List;
import java.util.Vector;

@Getter
public class CompoundOrder implements IOrder {
	private List<IOrder> orders;
	String id ;
	/**
	 * 
	 * @param order
	 */
	public void addOrder(IOrder order) {
		orders.add(order);
	}

	/**
	 * 
	 * @param order
	 */
	public void cancelOrder(IOrder order) {
		orders.remove(order);
	}

	public double calculatePrice() {
		double ans = 0;
		for (IOrder order : orders) {
			ans += order.calculatePrice();
		}
		return ans ;
	}
	@Override
	public List<Product> getProducts() {
		List<Product> products = new Vector<>();
        for (IOrder order : orders) {
            products.addAll(order.getProducts());
        }
		return products;
	}
}