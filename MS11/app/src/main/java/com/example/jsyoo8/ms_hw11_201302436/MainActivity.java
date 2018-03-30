package com.example.jsyoo8.ms_hw11_201302436;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText url;
    TextView msg;
    WebView webview;

    public static String defaultUrl = "https://m.naver.com";

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        url = (EditText) findViewById(R.id.URL);
        msg = (TextView) findViewById(R.id.msg);

        webview.getSettings().setJavaScriptEnabled(true);
        url.setText(defaultUrl);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webview.loadUrl(url);
                return true;
            }
        });
    }

    public void onBtnRequest(View view) {
        String urlStr = url.getText().toString();
        ConnectThread thread = new ConnectThread(urlStr);
        thread.start();
    }


    class ConnectThread extends Thread {
        String urlStr;

        public ConnectThread(String inStr) {
            urlStr = inStr;
        }

        public void run() {

            try {
                final String output = request(urlStr);
                handler.post(new Runnable() {
                    public void run() {
                        msg.setText(output);
                        webview.loadData(msg.getText().toString(), "text/html; charset=UTF-8",null);
                    }
                });

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        private String request(String urlStr) {
            StringBuilder output = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    int resCode = conn.getResponseCode();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;
                    while (true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        output.append(line + "\n");
                    }

                    reader.close();
                    conn.disconnect();
                }
            } catch (Exception ex) {
                Log.e("SampleHTTP", "Exception in processing response.", ex);
                ex.printStackTrace();
            }

            return output.toString();
        }

    }


}