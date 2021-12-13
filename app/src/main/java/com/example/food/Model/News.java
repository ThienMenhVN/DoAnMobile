package com.example.food.Model;

import java.io.Serializable;

public class News implements Serializable {
    private int image;
    private String title;
    private String description;
    private String action;

    public News() {
    }

    public News(int image, String title, String description, String action) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.action = action;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
