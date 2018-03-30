package com.example.jsyoo8.ms_hw04_201302436;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    String auth = "";

    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        processIntent(intent);
    }

    public void onButtonClickedMain(View v) {
        finish();
    }

    public void onButtonClicked1(View v) {
        auth = "위치";
        checkAuth(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public void onButtonClicked2(View v) {
        auth = "카메라";
        checkAuth(Manifest.permission.CAMERA);
    }

    public void onButtonClicked3(View v) {
        auth = "달력";
        checkAuth(Manifest.permission.READ_CALENDAR);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
            Toast.makeText(this, "username: " + data.getId() + "\npassword: " + data.getPwd(), Toast.LENGTH_SHORT).show();
        }
    }

    private void checkAuth(String permission) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(getApplicationContext(), AuthorityActivity.class);

            SimpleData data = new SimpleData(auth, -1);
            intent.putExtra(KEY_SIMPLE_DATA, data);
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, 1);
        }
        return;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case 1:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(getApplicationContext(), AuthorityActivity.class);

                    SimpleData data = new SimpleData(auth, -1);
                    intent.putExtra(KEY_SIMPLE_DATA, data);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), AuthorityActivity.class);

                    SimpleData data = new SimpleData(auth, 0);
                    intent.putExtra(KEY_SIMPLE_DATA, data);
                    startActivity(intent);
                }
                return;
            }
        }
    }
}