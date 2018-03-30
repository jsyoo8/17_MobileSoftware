package com.example.jsyoo8.ms_hw0302_201302436;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable{
    String sid;
    String spwd;
    String name;

    public SimpleData(String id, String pwd){
        sid = id;
        spwd = pwd;
    }

    public SimpleData(String _name){
        name = _name;
    }

    public SimpleData(Parcel src){
        sid = src.readString();
        spwd = src.readString();
        name = src.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Creator(){
        public SimpleData createFromParcel(Parcel in) {return new SimpleData(in);}
        public SimpleData[] newArray(int size) {return new SimpleData[size];}
    };

    public int describeContents() { return 0;}

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(sid);
        dest.writeString(spwd);
        dest.writeString(name);
    }

    public String getId(){return sid;}
    public void setId(String id){sid=id;}
    public String getPwd(){return spwd;}
    public void setPwd(String pwd){spwd=pwd;}
    public String getName(){return name;}
    public void setName(String _name){name=_name;}
}