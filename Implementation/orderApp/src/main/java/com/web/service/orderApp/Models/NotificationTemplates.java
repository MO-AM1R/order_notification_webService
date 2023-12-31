package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NotificationTemplates {
	protected final String content;
	protected final String subject;
}