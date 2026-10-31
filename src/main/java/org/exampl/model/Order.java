package org.exampl.model;

import org.exampl.strategy.PaymentStrategy;

import java.util.List;

public abstract class Order {

    static Integer nextOrderId = 0;
    private Integer orderId;
    private User user;
    private Restaurant restaurant;
    private List<CartItem> itemList;
    private PaymentStrategy paymentStrategy = null;
    private double total;

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public List<CartItem> getItemList() {
        return itemList;
    }

    public static Integer getNextOrderId() {
        return nextOrderId;
    }

    public static void setNextOrderId(Integer nextOrderId) {
        Order.nextOrderId = nextOrderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private String scheduled;



    public Order() {
        this.itemList = null;
        this.orderId = ++nextOrderId;
        this.restaurant = null;
        this.scheduled = "";
        this.paymentStrategy = null;
        this.total = 0.0;
        this.user = null;
    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }else{
            System.out.println("Please choose a payment mode first ");
            return false;
        }
    }



    public Integer getOrderId(){
        return orderId;
    }

    public abstract String getType();

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setRestaurant (Restaurant restaurant){
        this.restaurant =restaurant;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }

    public void setItemList(List<CartItem> itm){
        itemList = itm;
        total = 0.0;
        for(CartItem item : itm){
            total += item.getCartItemPrice();
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

}
