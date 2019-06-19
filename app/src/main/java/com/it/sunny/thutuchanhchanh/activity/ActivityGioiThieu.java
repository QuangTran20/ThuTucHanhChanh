package com.it.sunny.thutuchanhchanh.activity;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class ActivityGioiThieu extends AppCompatActivity {
    Toolbar toolbarGioiThieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu);

        AnhXa();

        ActionToolbar();
    }

    private void AnhXa() {
        toolbarGioiThieu = findViewById(R.id.toolbarGioiThieu);
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarGioiThieu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarGioiThieu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
