package com.example.food;

public class User {

    private String passwork;
    private String name;
    private String address;
    private String phone;

    public User() {
    }

    public User(String passwork, String name, String address, String phone) {
        this.passwork = passwork;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
