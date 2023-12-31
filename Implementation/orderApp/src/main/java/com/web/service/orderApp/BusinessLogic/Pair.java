package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.NotificationTemplates;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Pair{
	private NotificationTemplates template;
	private String userName;

	@Override
	public String toString() {
		return "Pair{" +
				"template=" + template +
				", userName='" + userName + '\'' +
				"}\n";
	}
}
