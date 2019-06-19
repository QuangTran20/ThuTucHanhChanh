package com.it.sunny.thutuchanhchanh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class chatthai_huuco_activity extends AppCompatActivity {
    Toolbar toolbarhuuco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatthai_huuco);

        AnhXa();
        ActionToolbar();
    }

    private void ActionToolbar() {
        //setActionBar(toolbarnt);
        setSupportActionBar(toolbarhuuco);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarhuuco.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void AnhXa() {
        toolbarhuuco =(Toolbar) findViewById(R.id.toolbarhuuco);
    }
}
