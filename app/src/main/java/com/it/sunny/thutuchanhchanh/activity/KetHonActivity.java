package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class KetHonActivity extends AppCompatActivity {
    Toolbar toolbarKetHon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_hon);
        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbarKetHon = findViewById(R.id.toolbarKetHon);
    }
    private void ActionToolbar() {

        setSupportActionBar(toolbarKetHon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarKetHon.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void cmdDangKyKetHon(View v)
    {
        Intent intent = new Intent(KetHonActivity.this,DangKyKetHonActivity.class);
        startActivity(intent);
    }
}
