package org.exampl.model;

public class User {

    public static Integer referenceId = 0;
    public Integer Id;
    public String Name;
    public String Address;
    public Cart cart;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Cart getCart() {
        return cart;
    }



    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static Integer getReferenceId() {
        return referenceId;
    }

    public static void setReferenceId(Integer referenceId) {
        User.referenceId = referenceId;
    }

    public User( Integer id, String name, String address) {
        Address = address;
        Id = id;
        Name = name;
        cart = new Cart();
    }



}
