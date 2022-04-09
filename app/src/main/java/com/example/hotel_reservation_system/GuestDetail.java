package com.example.hotel_reservation_system;

public class GuestDetail {
    String name;
    String gender;
    String email;
    String mobile;

    public GuestDetail(String name, String gender, String email, String mobile) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
    }

    public GuestDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
