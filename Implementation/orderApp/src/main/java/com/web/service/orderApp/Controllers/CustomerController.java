package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.Models.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
	private final CustomerBsl customerBsl;

	public CustomerController() {
		this.customerBsl = new CustomerBsl();
	}
	@GetMapping(value = "/users/login")
	String login(@RequestParam String email, @RequestParam String password){
		return customerBsl.login(email, password);
	}
	@PostMapping(value = "/users/register")
	String register(@RequestBody Customer customer){
		return customerBsl.register(customer);
	}

	@GetMapping(value = "/users/showCustomers")
	List<Customer> showCustomers(){
		return customerBsl.showCustomers();
	}
}