package com.web.service.orderApp.Models;
public class PlacementNotification extends NotificationTemplates {
	private String subject;

	public PlacementNotification(String content, String subject) {
		super(content, subject);
	}
}