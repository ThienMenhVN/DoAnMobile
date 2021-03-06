package com.example.food.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private String name;
    private String description;
    private String price;
    private ArrayList<Size> size;
    private String category;
    private int img;

    public Product() {
        this.setSize(new ArrayList<Size>());}

    public Product(String name, String description, String price, ArrayList<Size> size) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<Size> getSize() {
        return size;
    }

    public void setSize(ArrayList<Size> size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
