package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.NotificationBsl;
import com.web.service.orderApp.BusinessLogic.SingletonHelper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.BusinessLogic.OrderBsl;
import com.web.service.orderApp.Models.*;

import java.util.*;

@RestController
public class OrderController {
	private final OrderBsl orderBsl;
	public OrderController() {
		this.orderBsl = new OrderBsl();
	}

	public void createNotification(String userName, IOrder order){
		NotificationBsl notificationBsl = SingletonHelper.getNotificationBsl();

		NotificationFactory factory = new OrderPlacementFactory();
		NotificationTemplates template = factory.createNotification(userName, order);
		notificationBsl.addNotification(template, userName) ;

		factory = new OrderShipmentFactory();
		template = factory.createNotification(userName, order);
		notificationBsl.addNotification(template, userName) ;
	}

	@GetMapping("orders/makeOrder")
	public String makeSimpleOrder(@RequestParam String userName){
		CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
		Customer customer = customerBsl.search(userName) ;

		Order order = new Order(customer.getCart().getProducts(),
				OrderStatus.PLACED,
				new Date(),
				Integer.toString(orderBsl.getLatId(userName) + 1));

		if (customer.getBalance() < order.calculatePrice()){
			return "No sufficient funds" ;
		}
		customerBsl.decreaseBalance(userName, order.calculatePrice() + 30);
		orderBsl.addOrder(userName, order);
		createNotification(userName, order);
		customerBsl.clearCart(userName);

		return "Your Order placed successfully and the notification " +
				"has been sent in " + customer.getIChannel().toString() +
				" and the language is " + customer.getLanguage();
	}
	@GetMapping("orders/makeCompoundOrder")
	public String makeCompoundOrder(@RequestBody Map<String, String> map){
		CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
		boolean firstOrder = false ;

		for (Map.Entry<String, String> entry: map.entrySet()){
			Customer customer = customerBsl.search(entry.getKey()) ;
			Order userOrder = orderBsl.getOrder(entry.getKey(), entry.getValue()) ;

			if (!firstOrder) {
				userOrder = new Order(customer.getCart().getProducts(),
						OrderStatus.PLACED,
						new Date(),
						Integer.toString(orderBsl.getLatId(entry.getKey()) + 1));

				customerBsl.clearCart(entry.getKey());
				firstOrder = true;
			}

			if (customer == null){
				return "There is incorrect userName" ;
			}
			if (userOrder == null){
				return "There is incorrect order id" ;
			}
			if (customer.getBalance() < userOrder.calculatePrice()) {
				return "No sufficient funds";
			}
			customerBsl.decreaseBalance(customer.getUserName(), (userOrder.calculatePrice() + 10));
			createNotification(customer.getUserName(), userOrder);
		}

		return "Your Compound Order placed successfully and the notification " +
				"has been sent for your friend channels";
	}
}