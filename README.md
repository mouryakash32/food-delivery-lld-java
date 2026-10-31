🍔 Foodyfy - Food Delivery App (Low Level Design in Java)

A Low Level Design (LLD) implementation of a food delivery application in Java. It covers the complete flow: browsing restaurants, adding items to a cart, placing an order (immediate or scheduled, delivery or pickup), paying, and getting notified.

The design uses Factory and Strategy design patterns to keep the code clean, extensible, and easy to maintain.

✨ Features
Add restaurants and menu items
Add items to a cart and place an order
Two order types: Delivery and Pickup
Two order timings: Now and Scheduled
Multiple payment methods: UPI and Credit Card
Notifications to the user on order updates

Foodyfy/
└── src/main/java/org/exampl/
    ├── factory/
    │   ├── OrderFactory.java              (interface)
    │   ├── NowOrderFactory.java
    │   └── ScheduledOrderFactory.java
    ├── managers/
    │   ├── Ordermanager.java              (order lifecycle)
    │   └── RestaurentManager.java         (restaurants and menus)
    ├── model/
    │   ├── Cart.java
    │   ├── CartItem.java
    │   ├── DeliveryOrder.java
    │   ├── PickupOrder.java
    │   ├── Order.java
    │   ├── MenuItem.java
    │   ├── Restaurant.java
    │   └── User.java
    ├── service/
    │   └── NotificationService.java
    ├── strategy/
    │   ├── PaymentStrategy.java           (interface)
    │   ├── UpiPaymentStrategy.java
    │   └── CreditCartPaymentStrategy.java
    ├── util/
    │   └── TimeUtils.java
    ├── Foodify.java                       (app facade / setup)
    └── Main.java                          (entry point)
