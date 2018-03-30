package com.example.jsyoo8.ms_hw06_201302436;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        url = (EditText) findViewById(R.id.URL);
        url.setText("http://www.naver.com");
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "에러가 발생하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        webview.loadUrl(url.getText().toString());
    }

    public void onBtnNaver(View view){
        url.setText("http://www.naver.com");
        webview.loadUrl(url.getText().toString());
    }

    public void onBtnMove(View view){
        webview.loadUrl(url.getText().toString());
    }

}
