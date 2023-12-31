package com.web.service.orderApp.Models;

public class OrderShipmentFactory implements NotificationFactory{
    @Override
    public NotificationTemplates createNotification(String userName, IOrder order) {
        String message = "Dear {x}, your order {y} shipped successfully :)" ;
        message = message.replace("{x}", userName);
        message = message.replace("{y}", order.getId());
        return new OrderShipmentNotification(message, "OrderShipment") ;
    }
}