package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class KhaiTuActivity extends AppCompatActivity {
    Toolbar toolbarKhaiTu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khai_tu);
        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbarKhaiTu = findViewById(R.id.toolbarKhaiTu);
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarKhaiTu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarKhaiTu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void cmdKhaiTu(View v)
    {
        Intent intent = new Intent(KhaiTuActivity.this,DangKyKhaiTuActivity.class);
        startActivity(intent);
    }
}
