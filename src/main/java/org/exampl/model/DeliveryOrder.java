package org.exampl.model;

public class DeliveryOrder extends Order{
    public DeliveryOrder() {
        this.userAddress = "";
    }

    private String userAddress;

    @Override
    public String getType() {
        return "Delivery";
    }

    public void setUserAddress(String addr){
        userAddress = addr;
    }

    public String getUserAddress(){
        return userAddress;
    }
}
