package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.Customer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

@Service
public class CustomerBsl {
	private List<Customer> customers = new Vector<>()
	{{
		add(new Customer("3abdo@gmail.com", "Paswword1", "Abdo", 1500, "011100011", new Vector<>())) ;
		add(new Customer("badr@gmail.com", "Paswword1", "badr", 1500, "011100011", new Vector<>())) ;
		add(new Customer("mohamed@gmail.com", "Paswword1", "MoAmir", 1500, "011100011", new Vector<>())) ;
	}};

	public Customer login(String email, String password) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)
                    && customer.getPassword().equals(password)) {
                return customer;
            }
        }
		return null;
	}
}