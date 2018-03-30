package com.example.jsyoo8.ms_hw08_201302436;

public class SimpleItem {

    String manufact;
    String name;
    String price;
    String product;
    int resId;

    public SimpleItem(String manufact, String name, String price, String product, int resId) {
        this.manufact = manufact;
        this.name = name;
        this.price = price;
        this.product = product;
        this.resId = resId;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}

