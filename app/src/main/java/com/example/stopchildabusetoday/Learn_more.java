package com.example.stopchildabusetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Learn_more extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        getSupportActionBar().setTitle("Learn more");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView =(WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.childhelp.org/child-abuse/");
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }
}