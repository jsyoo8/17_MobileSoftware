package com.example.jsyoo8.ms_hw08_201302436;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleItemView extends LinearLayout {
    TextView tv1;
    TextView tv22;
    TextView tv3;
    ImageView imageView;

    public SimpleItemView(Context context) {
        super(context);
        init(context);
    }

    public SimpleItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.shopping_item, this, true);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv22 = (TextView) findViewById(R.id.tv22);
        tv3 = (TextView) findViewById(R.id.tv3);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name) {
        tv1.setText(name);
    }

    public void setPrice(String price) {
        tv22.setText(price);
    }

    public void setProduct(String product) {
        tv3.setText(product);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
