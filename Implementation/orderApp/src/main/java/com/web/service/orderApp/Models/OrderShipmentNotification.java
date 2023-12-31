package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderShipmentNotification extends NotificationTemplates {
	public OrderShipmentNotification(String content, String subject) {
		super(content, subject);
	}
}