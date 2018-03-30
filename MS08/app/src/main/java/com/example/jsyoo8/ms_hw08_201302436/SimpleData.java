package com.example.jsyoo8.ms_hw08_201302436;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    String manufact;
    String name;
    String price;
    String product;
    int resId;

    public SimpleData() {
    }

    public SimpleData(String manufact, String name, String price, String product, int resId) {
        this.manufact = manufact;
        this.name = name;
        this.price = price;
        this.product = product;
        this.resId = resId;
    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public SimpleData(Parcel src){
        manufact = src.readString();
        name = src.readString();
        price = src.readString();
        product = src.readString();
        resId = src.readInt();
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(manufact);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(product);
        dest.writeInt(resId);
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