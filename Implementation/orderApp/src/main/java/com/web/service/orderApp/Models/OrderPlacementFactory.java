package com.web.service.orderApp.Models;

public class OrderPlacementFactory implements NotificationFactory{
    @Override
    public NotificationTemplates createNotification() {
        return new PlacementNotification();
    }
}