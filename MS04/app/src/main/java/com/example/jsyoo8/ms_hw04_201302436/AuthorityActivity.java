package com.example.jsyoo8.ms_hw04_201302436;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jsyoo8 on 2017-10-12.
 */

public class AuthorityActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    TextView tv;
    String auth;
    String result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        tv = (TextView) findViewById(R.id.authTV);

        Intent intent = getIntent();

        processIntent(intent);
        if ("0".equals(result)) {
            tv.setText(auth + " 권한 인증 실패");
        } else {
            tv.setText(auth + " 권한 인증");
        }
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
            auth = data.getName();
            result = data.getResult();
            if ("0".equals(result)) {
                Toast.makeText(this, "titleMsg: " + auth + " 권한 인증 실패", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "titleMsg: " + auth + " 권한 인증", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onButtonClickedMenu(View v) {
        if ("0".equals(result)) {
            Toast.makeText(this, auth + " 권한 응답, result code: " + result + ", message : result message is OK!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, auth + " 권한 응답, result code: " + result + ", message : result message is OK!", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
