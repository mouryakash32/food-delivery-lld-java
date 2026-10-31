package org.exampl.service;

import org.exampl.model.CartItem;
import org.exampl.model.Order;

import java.util.List;

public class NotificationService {
    public void notify(Order order){
        System.out.println("Notification : Now "+ order.getType()+ " order placed: ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Order ID: "+ order.getOrderId());
        System.out.println("Customer: "+ order.getUser().getName());
        System.out.println("Restaurant: "+ order.getRestaurant().getName());
        System.out.println("Items Ordered: ");
        List<CartItem> cartItemList = order.getItemList();
        for (CartItem cartItem: cartItemList){
            System.out.println("   - "+ cartItem.getName()+ " (Rs: "+ cartItem.getPrice()+ " Quantity: "+  cartItem.getQuantity()+ ")");

        }
        System.out.println("Total Rs: "+ order.getTotal());
        System.out.println("Scheduled For: "+ order.getScheduled());
        System.out.println("Payment : Done");
        System.out.println("------------------------------------------");
    }
}
