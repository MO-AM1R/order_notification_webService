package com.web.service.orderApp.Models;

public class NotificationsManagement {

	private final IChannel channel;
	private final NotificationsManagement notificationTemplate;

	/**
	 * 
	 * @param channel
	 * @param notificationTemplate
	 */
	public NotificationsManagement(IChannel channel, NotificationsManagement notificationTemplate) {
		this.channel = channel ;
		this.notificationTemplate = notificationTemplate;
	}

}