package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NotificationTemplates {
	protected final String content;
	protected final String subject;

	@Override
	public String toString() {
		return "NotificationTemplates{" +
				"content='" + content + '\'' +
				", subject='" + subject + '\'' +
				'}';
	}
}