package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.it.sunny.thutuchanhchanh.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void cmdTinTuc(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityTinTuc.class);
        startActivity(intent);
    }

    public void cmdRacThai(View v){
        Intent intent = new Intent(MainActivity.this, ActivityRacThai.class);
        startActivity(intent);
    }

    public void  cmdDichVu(View v)
    {
        Intent intent = new Intent(MainActivity.this, ActivityDichVuCong.class);
        startActivity(intent);
    }

    public  void  cmdDongGopYKien(View v)
    {
        Intent intent = new Intent(MainActivity.this, ActivityDongGopYKien.class);
        startActivity(intent);
    }

    public void cmdGioiThieu(View v)
    {
        Intent intent = new Intent(MainActivity.this, ActivityGioiThieu.class);
        startActivity(intent);
    }
}
