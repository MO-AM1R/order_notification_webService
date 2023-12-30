package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.Models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
	private final CustomerBsl customerBsl;

	public CustomerController() {
		this.customerBsl = new CustomerBsl();
	}
	@PostMapping(value = "/users/login")
	Customer login(@RequestBody String email, @RequestBody String password){
		return customerBsl.login(email, password);
	}
}