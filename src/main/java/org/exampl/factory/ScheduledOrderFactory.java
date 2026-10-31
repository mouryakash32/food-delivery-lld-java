package org.exampl.factory;

import org.exampl.model.*;
import org.exampl.strategy.PaymentStrategy;

import java.util.List;

public class ScheduledOrderFactory implements OrderFactory{
    private final String DELIVERY = "DELIVERY";
    String scheduleTime;
    public ScheduledOrderFactory(String scheduleTime){
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOder(User user, Cart cart, Restaurant restaurant, List<CartItem> cartItemList, PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if(order.equals(DELIVERY)){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItemList(cartItemList);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduleTime);
        order.setTotal(cart.getTotalCartPrice());
        return order;
    }
}
