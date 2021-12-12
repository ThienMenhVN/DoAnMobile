package com.example.food.Model;

public class Store {
    private String location;
    private int img;

    public Store(String location, int img) {
        this.location = location;
        this.img = img;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
