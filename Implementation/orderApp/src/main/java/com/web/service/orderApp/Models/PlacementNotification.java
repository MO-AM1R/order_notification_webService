package com.web.service.orderApp.Models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlacementNotification extends NotificationTemplates {
	public PlacementNotification(String content, String subject) {
		super(content, subject);
	}
}