package com.it.sunny.thutuchanhchanh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.ultil.Server;

public class DangKyKhaiTuActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_khai_tu);
        AnhXa();
        LoadWebView();
    }

    private void AnhXa() {
        webView =findViewById(R.id.webviewKhaiTu);
    }

    private void LoadWebView() {

        webView.setWebViewClient(new WebViewClient());
        String Url= Server.UrlKhaiTu;
        webView.loadUrl(Url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }
}
