package com.it.sunny.thutuchanhchanh.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.model.TinTuc;
import com.squareup.picasso.Picasso;

public class activityNoiDungTin extends AppCompatActivity {

    ImageView imgHinhChiTiet;
    TextView textViewNgay;
    TextView textViewNoiDungChiTiet;
    Toolbar toolbarnoidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_tin);

        AnhXa();
        ActionToolBar();
        GetDataNoiDung();
    }

    private void GetDataNoiDung() {
        //khai bao biến hứng dữ liệu truyền qua
        int id =0;
        String tieude="";
        String hinhanh="";
        String noidungchitiet="";
        String tacgia="";
        String ngaydang="";

        //khởi tạo phương thức nhận dữ liệu tryển qua
        TinTuc tinTuc = (TinTuc) getIntent().getSerializableExtra("thongtinnoidung");
        //lấy dữ liệu truyển qua gán giá trị vào biến
        id =tinTuc.getID();
        tieude = tinTuc.getTieuDe();
        hinhanh = tinTuc.getHinhAnh();
        noidungchitiet = tinTuc.getNoiDung();
        tacgia = tinTuc.getTacGia();
        ngaydang = tinTuc.getNgayDang();

        String NoiDung =tieude + "\n" + noidungchitiet;
        String xuatban ="Ngày: " + ngaydang + " - " + tacgia;

        //gán dữ liệu lên layout
        textViewNoiDungChiTiet.setText(NoiDung);
        textViewNgay.setText(xuatban);
        Picasso.with(getApplicationContext()).load(hinhanh)
                .placeholder(R.drawable.defaultimg)
                .error(R.drawable.erroimg)
                .into(imgHinhChiTiet);

    }

    private void ActionToolBar() {
        //kích hoat toolbar
        setSupportActionBar(toolbarnoidung);
        //hiển thị nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //khởi tạo kiện click
        toolbarnoidung.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbarnoidung = (Toolbar) findViewById(R.id.toolbarnoidungtintuc);
        imgHinhChiTiet = (ImageView) findViewById(R.id.imgnoidungtintuc);
        textViewNgay =(TextView) findViewById(R.id.txtngaydangnoidung);
        textViewNoiDungChiTiet =(TextView) findViewById(R.id.txtnoidungchitiet);
    }


}
