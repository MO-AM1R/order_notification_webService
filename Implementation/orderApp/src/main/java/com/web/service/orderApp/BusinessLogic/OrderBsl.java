package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.Order;
import com.web.service.orderApp.Models.OrderStatus;
import com.web.service.orderApp.Models.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderBsl {
	private final Map<String, List<Order>> orders = new HashMap<>(){{
		put("Abdo", new Vector<>(){{
			add(
					new Order(new Vector<>(){{
						add(new Product("Cars", "Corolla", "CC00", "Toyouta", 1400000, 9));
					}},
							OrderStatus.SHIPPED,
							new Date(),
							"1")
			);
		}});
		put("badr", new Vector<>(){{
			add(
				new Order(new Vector<>(){{
					add(new Product("Electronics", "HeadPhone", "EH00", "Aula", 650, 50));
				}},
						OrderStatus.SHIPPED,
						new Date(),
						"1")
			);
		}});
	}};

	public Order getOrder(String userName, String orderId) {
		List<Order> temp = orders.get(userName);
		for(Order order: temp){
			if (order.getId().equals(orderId)){
				return order;
			}
		}
		return null;
	}
	public int getLatId(String userName) {
		return Integer.parseInt(orders.get(userName).getLast().getId());
	}
	public void addOrder(String userName, Order order){
		orders.get(userName).add(order);
	}
}