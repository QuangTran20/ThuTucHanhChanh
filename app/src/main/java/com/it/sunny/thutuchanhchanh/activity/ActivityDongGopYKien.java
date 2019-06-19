package com.it.sunny.thutuchanhchanh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class ActivityDongGopYKien extends AppCompatActivity {
    Toolbar toolbarDongGopYKien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_gop_ykien);

        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbarDongGopYKien = findViewById(R.id.toolbarDongGopYKien);
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarDongGopYKien);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarDongGopYKien.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
