package com.example.jsyoo8.ms_hw08_201302436;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class AddActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    TextView iet1;
    TextView iet2;
    TextView iet3;
    TextView iet4;
    ImageView iiv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        iet1 = (TextView) findViewById(R.id.iet1);
        iet2 = (TextView) findViewById(R.id.iet2);
        iet3 = (TextView) findViewById(R.id.iet3);
        iet4 = (TextView) findViewById(R.id.iet4);
        iiv1 = (ImageView) findViewById(R.id.iiv1);
    }

    public void onClickedSubmit(View v) {
        String manufact = iet1.getText().toString();
        String name = iet2.getText().toString();
        String price = iet3.getText().toString();
        String product = iet4.getText().toString();
        int resId = R.drawable.clothes5;
        if (manufact.equals("") || name.equals("") || price.equals("") || product.equals("")) {
            Toast.makeText(getApplicationContext(), "입력하지 않은 곳이 있습니다.", Toast.LENGTH_SHORT).show();
        } else {
            int priceNum = Integer.parseInt(price);
            String result = "";
            NumberFormat nf = NumberFormat.getInstance();
            result = nf.format(priceNum);
            SimpleData simpleData = new SimpleData(manufact, name, result, product, resId);
            Intent intent = new Intent();
            intent.putExtra(KEY_SIMPLE_DATA, simpleData);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
}