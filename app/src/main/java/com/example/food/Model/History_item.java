package com.example.food.Model;

public class History_item {
    private String quantity;
    private String price;
    private String date;

    public History_item(String quantity, String price, String date) {
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public History_item() {
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
