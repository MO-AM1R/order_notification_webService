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
import java.util.Date;
import java.util.Map;

@RestController
public class OrderController {
	private final OrderBsl orderBsl;
	public OrderController() {
		this.orderBsl = new OrderBsl();
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
		customerBsl.decreaseBalance(userName, order.calculatePrice());
		orderBsl.addOrder(userName, order);

		NotificationBsl notificationBsl = new NotificationBsl();

		NotificationFactory factory = new OrderPlacementFactory();
		NotificationTemplates template = factory.createNotification(userName, order);
		notificationBsl.addNotification(template, userName) ;

		factory = new OrderShipmentFactory();
		template = factory.createNotification(userName, order);
		notificationBsl.addNotification(template, userName) ;

		customerBsl.clearCart(userName);

		return "You Order placed successfully and the notification " +
				"has been sent in " + customer.getIChannel().toString() +
				" and the language is " + customer.getLanguage();
	}
	@GetMapping("orders/makeCompoundOrder")
	public String makeCompoundOrder(@RequestBody Map<String, String> map){
		return "";
	}
}