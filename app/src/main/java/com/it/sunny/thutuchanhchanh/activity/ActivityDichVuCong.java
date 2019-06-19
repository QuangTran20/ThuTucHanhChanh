package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class ActivityDichVuCong extends AppCompatActivity {

    Toolbar toolbarDichVuCong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vu_cong);

        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbarDichVuCong = findViewById(R.id.toolbarDichVuCong);
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarDichVuCong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarDichVuCong.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void cmdKhaiSinh(View v)
    {
        Intent intent = new Intent(ActivityDichVuCong.this,KhaiSinhActivity.class);
        startActivity(intent);
    }

    public  void  cmdKetHon(View v)
    {
        Intent intent = new Intent(ActivityDichVuCong.this,KetHonActivity.class);
        startActivity(intent);
    }

    public void cmdKhaiTu(View v)
    {
        Intent intent = new Intent(ActivityDichVuCong.this,KhaiTuActivity.class);
        startActivity(intent);
    }
}
