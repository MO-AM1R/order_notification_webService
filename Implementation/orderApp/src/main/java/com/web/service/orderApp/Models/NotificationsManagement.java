package com.web.service.orderApp.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@AllArgsConstructor
@Getter
public class NotificationsManagement {

	private IChannel channel;
	private NotificationsManagement notificationTemplate;
	Language language;

	/**
	 *
	 * @param channel
	 * @param notificationTemplate
	 */


}