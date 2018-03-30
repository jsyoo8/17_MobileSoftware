package com.example.jsyoo8.ms_hw07_201302436;

public class InfoItem {
    String name, date, phone;
    int img;


    public InfoItem(String name, String date, String phone, int img) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setImg(int img) {
        this.img = img;
    }
}
