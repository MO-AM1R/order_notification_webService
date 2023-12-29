package com.web.service.orderApp.Models;
import java.util.List;

public class CompoundOrder implements IOrder {
	private List<IOrder> orders;

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
}