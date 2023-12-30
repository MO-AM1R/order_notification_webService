package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.Product;
import org.springframework.stereotype.Service;
import com.web.service.orderApp.Models.Cart;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map;

@Service
public class CartBsL {
	private final Map<String, Cart> carts = new HashMap<>(){{
		put("Abdo", new Cart(new Vector<>()));
		put("badr", new Cart(new Vector<>(){{
			add(new Product("fruits", "banana", "2401", "", 130, 10));
		}}));
		put("MoAmir", new Cart(new Vector<>(){{
			add(new Product("gaming", "mouse", "4410", "redragon", 580, 3));
			add(new Product("gaming", "keyboard", "5610", "redragon", 1300, 5));
		}}));
	}};
	public void add(String userName, Product product){
		carts.get(userName).getProducts().add(product);
	}
	public Cart print(String userName){
		return carts.get(userName);
	}
}