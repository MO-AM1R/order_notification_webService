package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

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
	private IChannel iChannel;
	private String language;

	@Override
	public String toString() {
		return "Customer{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", balance=" + balance +
				", phoneNumber='" + phoneNumber + '\'' +
				", orders=" + orders +
				", iChannel=" + iChannel +
				", language='" + language + '\'' +
				'}';
	}
}