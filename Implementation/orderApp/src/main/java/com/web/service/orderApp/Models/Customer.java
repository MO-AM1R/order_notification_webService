package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	private String email;
	private String password;
	private String userName;
	private double balance;
	private String phoneNumber;
	private List<IOrder> orders;

	@Override
	public String toString() {
		return "Customer{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", balance=" + balance +
				", phoneNumber='" + phoneNumber + '\'' +
				", orders=" + orders +
				'}';
	}
}