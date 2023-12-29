package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NotificationTemplates {
	private final String content;
	protected final String subject;
}