package com.web.service.orderApp.Models;
import java.util.List;

public class OrderPlacementFactory implements NotificationFactory{
    @Override
    public NotificationTemplates createNotification(String userName, IOrder order) {
        String message = "Dear {x}, your booking of the {y}. thanks for using our store :)" ;
        message = message.replace("{x}", userName);

        List<Product> products = order.getProducts();
        StringBuilder str = new StringBuilder();
        for(Product product: products){
            str.append(product.getName()).append(" is confirmed\n");
        }

        message = message.replace("{y}", str.toString());
        return new PlacementNotification(message, "OrderPlacement") ;
    }
}