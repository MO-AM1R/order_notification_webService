package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Vector;

@Getter
@Setter
public class Customer {
	private String email;
	private String password;
	private String userName;
	private double balance;
	private String phoneNumber;
	private List<IOrder> orders;
	private Cart cart;
	private IChannel iChannel;
	private String language;

	public Customer(String email, String password, String userName, double balance, String phoneNumber, List<IOrder> orders,
					Cart cart, IChannel iChannel, String language) {
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
		this.orders = orders;
		this.language = language;

		this.iChannel = iChannel ;
		if (this.iChannel == null){
			IChannel[] channels = new IChannel[]{new Email(new Channel()), new SMS(new Channel()), new Email(new SMS(new Channel()))};
			Random rand = new Random();
			int randOption = rand.nextInt(3);
			this.iChannel = channels[randOption];
		}

		this.cart = cart ;
		if (this.cart != null){
			return;
		}
		this.cart = new Cart(new Vector<>());
	}

	@Override
	public String toString() {
		return "Customer{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", balance=" + balance +
				", phoneNumber='" + phoneNumber + '\'' +
				", orders=" + orders +
				", cart=" + cart +
				", iChannel=" + iChannel.toString() +
				", language='" + language + '\'' +
				'}';
	}
}