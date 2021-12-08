package com.example.food.Model;

import java.io.Serializable;

public class Topping implements Serializable {
    private String name;
    private String price;

    public Topping() {
    }

    public Topping(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
