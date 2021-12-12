package com.example.food.Model;

public class Order_item {
    private String quantity;
    private String name;
    private String size;
    private String price;

    public Order_item(String quantity, String name, String size, String price) {
        this.quantity = quantity;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
