package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.SingletonHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
	@GetMapping("/Notifications/showNotifications")
	public String showNotifications(){
		return SingletonHelper.getNotificationBsl().showNotifications() ;
	}
}