package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Customer {
	private String email;
	private String password;
	private String userName;
	private double balance;
	private String phoneNumber;
	private List<IOrder> orders;
}