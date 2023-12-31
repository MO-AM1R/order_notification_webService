package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.BusinessLogic.SingletonHelper;
import com.web.service.orderApp.Models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

	public CustomerController() {}
	@GetMapping(value = "/users/login")
	String login(@RequestParam String email, @RequestParam String password){
		CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
		return customerBsl.login(email, password);
	}
	@PostMapping(value = "/users/register")
	String register(@RequestBody Customer customer){
		CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
		return customerBsl.register(customer);
	}

	@GetMapping(value = "/users/showCustomers")
	String showCustomers(){
		CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
		return customerBsl.showCustomers();
	}
}