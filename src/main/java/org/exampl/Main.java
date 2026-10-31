package org.exampl;

import org.exampl.model.Order;
import org.exampl.model.Restaurant;
import org.exampl.model.User;
import org.exampl.strategy.CreditCartPaymentStrategy;
import org.exampl.strategy.UpiPaymentStrategy;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Create Foodify facade
        Foodify foodify  = new Foodify();
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: "+ user.getName()+ " is active.");
        List<Restaurant> restaurants = foodify.searchRestaurents("Delhi");
        if(restaurants.isEmpty()){
            System.out.println("No restaurants found!");
            return;
        }
        System.out.println("Found Restaurants: ");
        for(Restaurant restaurant : restaurants){
            System.out.println(" - "+ restaurant.getName());
        }

        //User selects a restaurant
        foodify.selectRestaurent(user, restaurants.get(0));
        System.out.println("Selected Restaurant : "+ restaurants.get(0).getName());
        foodify.addToCart(user, "P1", 1);
        foodify.addToCart(user, "P2", 2);
        foodify.printUserCart(user);

        Order order = foodify.checkOutNow(user, "DELIVERY", new CreditCartPaymentStrategy("32983498329812"));
        foodify.payForOrder(user, order);

    }
}