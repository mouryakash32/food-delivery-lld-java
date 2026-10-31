package org.exampl.managers;

import org.exampl.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Ordermanager {
    private List<Order>orders = new ArrayList<>();
     static Ordermanager ordermanager = null;

    private Ordermanager(){
        //private Constructor
    }

    public static Ordermanager getOrdermanager(){
        if(ordermanager == null){
            ordermanager = new Ordermanager();
        }
        return ordermanager;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void listOrders(){
        System.out.println("*******************    All orders   ********************");
        for(Order order : orders){
            System.out.println(order.getType() + " order for "+ order.getUser().getName()+ " | Total Rs : "+ order.getScheduled());
        }
    }
}
