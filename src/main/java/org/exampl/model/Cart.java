package org.exampl.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> cartItemList = new ArrayList<>();

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void clearCartItem(){
        cartItemList.clear();

    }

    public boolean isEmptyCart(){
        return cartItemList.isEmpty();
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    Restaurant restaurant;
    public Cart(){
        restaurant = null;
    }
    public void addCartItem(CartItem cartItem){
        if(restaurant == null){
            System.out.println("Add restaurent before adding items into the cart");
            return;
        }
        cartItemList.add(cartItem);
    }

    public void remvoeCartItem(Integer id){
        cartItemList = cartItemList
                .stream()
                .filter(cartItem -> !cartItem.getId().equals(id))
                .toList();
    }

    public Integer getTotalCartPrice(){
        Integer totalPrice = 0;
        for(CartItem cartItem : cartItemList){
            totalPrice += cartItem.getCartItemPrice();
        }
        return totalPrice;
    }

    public void clearCart(){
        cartItemList.clear();
        restaurant = null;
    }

    public List<CartItem> getCartItems(){
        return cartItemList;
    }
}
