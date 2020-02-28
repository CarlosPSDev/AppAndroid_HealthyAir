package com.riluca.healthyair.chatBOTWebView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.riluca.healthyair.R;

public class ChatBOTActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat_bot);

        wv = (WebView) findViewById(R.id.chat_w_v);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl("https://console.dialogflow.com/api-client/demo/embedded/8eebcfbf-4428-4f69-93e2-d352a452efca");

    }
}
