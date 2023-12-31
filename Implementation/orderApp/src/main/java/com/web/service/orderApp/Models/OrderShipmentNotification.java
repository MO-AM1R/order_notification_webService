package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderShipmentNotification extends NotificationTemplates {
	private String subject;
	public OrderShipmentNotification(String content, String subject) {
		super(content, subject);
	}
	public OrderShipmentNotification() {
		super("", "");
	}
}