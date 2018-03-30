package com.example.jsyoo8.ms_hw03_201302436;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    TextView rv;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.edittext);
        rv = (TextView) findViewById(R.id.result);
        calculator = new Calculator(tv, rv, getApplicationContext());

        Button b0 = (Button) findViewById(R.id.b0);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);

        Button bp = (Button) findViewById(R.id.bp);
        Button bs = (Button) findViewById(R.id.bs);
        Button bm = (Button) findViewById(R.id.bm);
        Button bd = (Button) findViewById(R.id.bd);

        Button bc = (Button) findViewById(R.id.bc);
        Button br = (Button) findViewById(R.id.br);


        bc.setOnClickListener(this);

        bp.setOnClickListener(this);
        bs.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);

        br.setOnClickListener(this);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    public void onClick(View v) {
        calculator.btnOnClick(v);
    }
}
