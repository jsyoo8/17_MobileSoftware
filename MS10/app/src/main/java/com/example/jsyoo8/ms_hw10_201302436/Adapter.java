package com.example.jsyoo8.ms_hw10_201302436;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsyoo8 on 2017-11-21.
 */

public class Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Item> data;
    private int layout;

    public Adapter(Context context, int layout, ArrayList<Item> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    public ArrayList<Item> getData(){
        return data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        Item listviewitem = data.get(position);
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageview);
        icon.setImageResource(listviewitem.getIcon());
        TextView name = (TextView) convertView.findViewById(R.id.tv1);
        name.setText(listviewitem.getName());
        TextView phone = (TextView) convertView.findViewById(R.id.tv2);
        phone.setText(listviewitem.getPhone());
        TextView city = (TextView) convertView.findViewById(R.id.tv3);
        city.setText(listviewitem.getCity());
        return convertView;
    }
}