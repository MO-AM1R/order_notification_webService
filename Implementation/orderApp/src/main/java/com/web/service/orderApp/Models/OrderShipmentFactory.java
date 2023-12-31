package com.web.service.orderApp.Models;

public class OrderShipmentFactory implements NotificationFactory{
    @Override
    public NotificationTemplates createNotification() {
        return new OrderShipmentNotification();
    }
}