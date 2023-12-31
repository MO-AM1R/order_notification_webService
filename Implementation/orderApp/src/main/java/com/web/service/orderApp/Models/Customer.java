package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Customer {
	private String email;
	private String password;
	private String userName;
	private double balance;
	private String phoneNumber;
	private List<IOrder> orders;
	private IChannel iChannel;
	private String language;

	public Customer(String email, String password, String userName, double balance, String phoneNumber, List<IOrder> orders,
					IChannel iChannel, String language) {
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
		this.orders = orders;
		this.language = language;

		this.iChannel = iChannel ;
		if (iChannel != null){
			return;
		}
		IChannel[] channels = new IChannel[]{new Email(new Channel()), new SMS(new Channel()), new Email(new SMS(new Channel()))};
		Random rand = new Random();
		int randOption = rand.nextInt(3);
		this.iChannel = channels[randOption];
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
				", iChannel=" + iChannel.toString() +
				", language='" + language + '\'' +
				'}';
	}
}