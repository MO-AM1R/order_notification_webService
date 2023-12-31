package com.web.service.orderApp.Models;

public interface NotificationFactory {
    NotificationTemplates createNotification(String userName, IOrder order);
}