package com.web.service.orderApp.Models;

public class OrderShipmentNotification extends NotificationTemplates {
	private String subject;
	public OrderShipmentNotification(String content, String subject) {
		super(content, subject);
	}
}