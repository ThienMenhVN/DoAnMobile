package com.example.food.Model;

import java.util.ArrayList;

public class Product_order {
    private int quantity;
    private int price;
    private int priceSize;
    private ArrayList<Topping> toppingArrayList;


    public Product_order() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceSize() {
        return priceSize;
    }

    public void setPriceSize(int priceSize) {
        this.priceSize = priceSize;
    }

    public ArrayList<Topping> getToppingArrayList() {
        return toppingArrayList;
    }

    public void setToppingArrayList(ArrayList<Topping> toppingArrayList) {
        this.toppingArrayList = toppingArrayList;
    }

    public int getTotalMoney(){
        int totalmoneyoftopping = 0;
        if (toppingArrayList != null ){
            for (Topping topping : toppingArrayList) {
                totalmoneyoftopping += Integer.parseInt(topping.getPrice());
            }
        }
        return (price+priceSize+totalmoneyoftopping)*quantity;
    }
}
