package org.exampl.factory;

import org.exampl.model.*;
import org.exampl.strategy.PaymentStrategy;
import org.exampl.util.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory{
    private final String ORDER_TYPE="DELIVERY";


    @Override
    public Order createOder(User user, Cart cart, Restaurant restaurant, List<CartItem> cartItemList, PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if(orderType.equalsIgnoreCase(ORDER_TYPE)){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.Address);
            order = deliveryOrder;
        }else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItemList(cartItemList);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(cart.getTotalCartPrice());
        order.setPaymentStrategy(paymentStrategy);
        return order;
    }
}
