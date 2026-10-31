package org.exampl.factory;

import org.exampl.model.*;
import org.exampl.strategy.PaymentStrategy;

import java.util.List;

 public interface OrderFactory {
     Order createOder(User user, Cart cart, Restaurant restaurant, List<CartItem>me
    , PaymentStrategy paymentStrategy, String orderType);


}
