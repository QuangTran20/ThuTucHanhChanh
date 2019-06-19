package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.it.sunny.thutuchanhchanh.R;

public class KhaiSinhActivity extends AppCompatActivity {

    Toolbar toolbarKhaiSinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khai_sinh);

        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbarKhaiSinh = findViewById(R.id.toolbarKhaiSinh);

    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarKhaiSinh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarKhaiSinh.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void cmdDangKyKhaiSinh(View v)
    {
        Intent intent = new Intent(KhaiSinhActivity.this,DangKyKhaiSinhActivity.class);
        startActivity(intent);
    }
}
