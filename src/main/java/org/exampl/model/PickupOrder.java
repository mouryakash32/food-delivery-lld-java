package org.exampl.model;

public class PickupOrder extends Order{
    private final String PICK_UP= "PICKUP";
    private String restaurantAddress;


    public PickupOrder() {
        this.restaurantAddress = "";
    }


    @Override
    public String getType() {
        return PICK_UP;
    }

    public void setRestaurantAddress(String restaurantAddress){
        this.restaurantAddress = restaurantAddress;
    }
    public String getRestaurantAddress(){
        return restaurantAddress;
    }

}
