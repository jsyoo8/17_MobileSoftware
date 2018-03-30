package com.example.jsyoo8.ms_hw10_201302436;

/**
 * Created by jsyoo8 on 2017-11-21.
 */

public class Item {
    private int icon;
    private String name;
    private String phone;
    private String city;
    private int index;

    public Item(int icon, String name, String phone, String city, int index) {
        this.icon = icon;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.index = index;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public int getIndex() {
        return index;
    }
}