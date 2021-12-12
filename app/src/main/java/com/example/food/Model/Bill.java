package com.example.food.Model;

public class Bill {
    private String name;
    private String nameSize;
    private String money;
    private String SoLuong;

    public Bill() {
    }

    public Bill(String name, String nameSize, String money, String soLuong) {
        this.name = name;
        this.nameSize = nameSize;
        this.money = money;
        SoLuong = soLuong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSize() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize = nameSize;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }
}
