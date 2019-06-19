package com.it.sunny.thutuchanhchanh.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.ultil.Server;

public class DangKyKhaiSinhActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_khai_sinh);
        AnhXa();

        LoadWebView();
    }

    private void LoadWebView() {

        webView.setWebViewClient(new WebViewClient());
        String Url= Server.UrlKhaiSinh;
        webView.loadUrl(Url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }

    private void AnhXa() {
        webView = findViewById(R.id.webviewKhaiSinh);

    }
}
