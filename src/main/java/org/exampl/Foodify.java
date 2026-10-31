package org.exampl;

import org.exampl.factory.NowOrderFactory;
import org.exampl.factory.OrderFactory;
import org.exampl.factory.ScheduledOrderFactory;
import org.exampl.managers.Ordermanager;
import org.exampl.managers.RestaurentManager;
import org.exampl.model.*;
import org.exampl.service.NotificationService;
import org.exampl.strategy.PaymentStrategy;

import java.util.List;

public class Foodify {
    public Foodify() {
        initializeRestaurants();
    }
    public void initializeRestaurants(){
        Restaurant restaurant = new Restaurant("Bikaner", "Delhi");
        MenuItem menuItem = new MenuItem("P1", "Chole Bhature", 120);
        restaurant.addmenue(menuItem);
        restaurant.addmenue(new MenuItem("P2", "Samosa", 15));


        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.addmenue(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addmenue(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addmenue(new MenuItem("P3", "Dhokla", 50));


        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.addmenue(new MenuItem("P1", "Masala Dosa", 50));
        restaurant3.addmenue(new MenuItem("P2", "Idli Vada", 90));
        restaurant3.addmenue(new MenuItem("P3", "Rasam", 50));

        RestaurentManager restaurentManager = RestaurentManager.getInstance();
        restaurentManager.addRestaurent(restaurant);
        restaurentManager.addRestaurent(restaurant2);
        restaurentManager.addRestaurent(restaurant3);

    }

    public List<Restaurant>searchRestaurents(String location){
        return RestaurentManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurent(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode, Integer quantity){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null){
            System.out.println("Please select a restaurant first.");
            return;
        }
        for(MenuItem menuItem : restaurant.getMenu()){
            if(menuItem.getCode().equalsIgnoreCase(itemCode)){
                user.getCart().addCartItem(new CartItem(menuItem, quantity));
                break;
            }
        }
    }

    Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());

    }
    Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime){
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduleTime));
    }

    Order checkout(User user, String orderType, PaymentStrategy paymentStrategy,  OrderFactory orderFactory){
        if(user.getCart().isEmptyCart()){
            return null;
        }
        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<CartItem> items = userCart.getCartItems();
        double totalCost = userCart.getTotalCartPrice();

        Order order = orderFactory.createOder(user, userCart, orderedRestaurant, items, paymentStrategy, orderType);
        Ordermanager.getOrdermanager().addOrder(order);
        return order;

    }

    void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();
        if(isPaymentSuccess){
            NotificationService notificationService = new NotificationService();
            notificationService.notify(order);
            //Clear use cart if payment is successful.
            user.getCart().clearCart();
        }
    }

    void printUserCart(User user){
        System.out.println("Items in cart: ");
        System.out.println("----------------------------------------------");
        for(CartItem cartItem: user.getCart().getCartItems()){
            System.out.println(cartItem.getId()+ " : "+ cartItem.getName()+ " : "+ cartItem.getPrice());

        }
        System.out.println("------------------------------------------------");
        System.out.println("Grand Total Rs: "+ user.getCart().getTotalCartPrice());
    }


}
