package org.exampl.model;

public class CartItem {
    private String id;
    private String name;
    private Integer price;
    private Integer quantity;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public CartItem(MenuItem menuItem, Integer quantity) {
        this.id = menuItem.getCode();
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.quantity = quantity;
    }

    public Integer getCartItemPrice(){
        return price*quantity;
    }


}
