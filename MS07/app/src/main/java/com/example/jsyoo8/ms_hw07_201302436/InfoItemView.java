package com.example.jsyoo8.ms_hw07_201302436;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoItemView extends LinearLayout {
    TextView name, date, phone;
    ImageView image;


    public InfoItemView(Context context) {
        super(context);
        init(context);
    }

    public InfoItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.info_item, this, true);

        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        phone = (TextView) findViewById(R.id.phone);
        image = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String _name) {
        name.setText(_name);
    }

    public void setDate(String _date) {
        date.setText(_date);
    }

    public void setPhone(String _phone) {
        phone.setText(_phone);
    }

    public void setImage(int img) {
        image.setImageResource(img);
    }

}
