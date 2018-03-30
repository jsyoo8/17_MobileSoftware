package com.example.jsyoo8.ms_hw0302_201302436;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
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


    public void onButtonClicked(View v) {
        saveState();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        String mid = pref.getString("mid", "");
        String mpwd = pref.getString("mpwd", "");
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        SimpleData data = new SimpleData(mid, mpwd);
        intent.putExtra(KEY_SIMPLE_DATA, data);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_MENU && data != null) {
            Bundle bundle = data.getExtras();
            String name = bundle.getString("name");
            Toast.makeText(getApplicationContext(), "메뉴 : " + name, Toast.LENGTH_SHORT).show();
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