package com.example.jsyoo8.ms_hw04_201302436;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    EditText id;
    EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        pwd = (EditText) findViewById(R.id.pwd);
    }


    public void onButtonClickedLogin(View v) {
        saveState();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        String mid = pref.getString("mid", "");
        String mpwd = pref.getString("mpwd", "");
        if ("".equals(mid) || "".equals(mpwd)) {
            Toast.makeText(this, "사용자명이나 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

            SimpleData data = new SimpleData(mid, mpwd);
            intent.putExtra(KEY_SIMPLE_DATA, data);
            startActivity(intent);
        }
    }


    protected void onPause() {
        super.onPause();

        saveState();
    }

    protected void onResume() {
        super.onResume();

        restoreState();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("mid"))) {
            String mid = pref.getString("mid", "");
            id.setText(mid);
        }
        if ((pref != null) && (pref.contains("mpwd"))) {
            String mpwd = pref.getString("mpwd", "");
            pwd.setText(mpwd);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("mid", id.getText().toString());
        editor.commit();
        editor.putString("mpwd", pwd.getText().toString());
        editor.commit();
    }
}