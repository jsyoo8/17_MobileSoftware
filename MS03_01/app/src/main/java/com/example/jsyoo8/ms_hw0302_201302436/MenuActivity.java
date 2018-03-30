package com.example.jsyoo8.ms_hw0302_201302436;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        Intent intent = getIntent();
        processIntent(intent);


    }



    public void onButtonClicked1(View v) {
        String name = "고객 관리";
        Intent intent = new Intent();
        intent.putExtra("name",name);

        setResult(RESULT_OK, intent);
        finish();
    }


    public void onButtonClicked2(View v) {
        String name = "배송 관리";
        Intent intent = new Intent();
        intent.putExtra("name",name);

        setResult(RESULT_OK, intent);
        finish();
    }


    public void onButtonClicked3(View v) {
        String name = "상품 관리";
        Intent intent = new Intent();
        intent.putExtra("name",name);

        setResult(RESULT_OK, intent);
        finish();
    }

    private void processIntent(Intent intent){
        if (intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
            Toast.makeText(this, "id: "+data.getId()+"\npassword: "+data.getPwd(), Toast.LENGTH_SHORT).show();
        }
    }
}