package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.NotificationTemplates;
import com.web.service.orderApp.Models.PlacementNotification;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationBsl {
	private final Queue<Pair> notifications = new LinkedList<>(){{
		push(new Pair(new PlacementNotification
				("Dear Yasser, your booking of the item mobile charger is confirmed, thanks for using our store :)", "OrderPlacement")
				, "Yasser"));
		push(new Pair(new PlacementNotification
				("Dear Yasser, your order 1 shipped successfully :)", "OrderShipment")
				, "Yasser"));
	}};

	public void addNotification(NotificationTemplates template, String userName) {
		Pair pair = new Pair(template, userName) ;
		notifications.add(pair);
	}
}