package com.it.sunny.thutuchanhchanh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.it.sunny.thutuchanhchanh.R;

import org.w3c.dom.Text;

public class ActivityRacThai extends AppCompatActivity {
    Toolbar toolbarRacThai;
    Button btHuuCo,btVoCo,btConLai,btPhanLoai;
    TextView tvKetQua;
    EditText etNhapTenRac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racthai);

        AnhXa();
        ActionToolbar();
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarRacThai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarRacThai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void AnhXa() {
        toolbarRacThai = findViewById(R.id.toolbarracthai);
        btHuuCo = (Button) findViewById(R.id.btnHuuCo);
        btVoCo = (Button) findViewById(R.id.btnVoCo);
        btConLai = (Button) findViewById(R.id.btnConLai);

        tvKetQua = findViewById(R.id.tvKetQua);
    }

    public void cmdHuuCo(View v)
    {
        String KQ ="Rác thải hữu cơ là loại rác thải dễ phân hủy và có thể đưa vào tái chế để đưa vào sử dụng cho" +
                " việc chăm bón hoặc làm thức ăn cho cho động vật \n"
                + "- Các loại rau củ quả hư thối...\n"
                + "- Cơm canh thức ăn thừa hoặc bị thiu...\n"
                + "các loại bả chè, bả cà phê"
                + "- Cỏ cây bị xén/chặt bỏ, hoa rụng...\n"+ "mica trung quốc.";
        tvKetQua.setText(KQ);
    }

    public void cmdVoCo(View v)
    {
        String KQ ="Rác thải vô cơ là loại rác không thể tái chế được. Xử lý bằng cách chôn lắp khu rác thải riêng biệt, chúng có gian phân hủy rất lâu như các loại:\n"+
                "- Gạch/ đá, đồ sành/ sứ vỡ hoặc không còn giá trị sử dụng.\n" +
                "- Ly/ cốc/ bình thủy tinh vỡ…\n" +
                "- Các loại vỏ sò/ ốc, vỏ trứng…\n" +
                "- Đồ da, đồ cao su, đồng hồ hỏng, băng đĩa nhạc, radio… không thể sử dụng.";
        tvKetQua.setText(KQ);
    }
    public void cmdConLai(View v)
    {
        String KQ ="Rác vô cơ là loại rác khó phân hủy nhưng có thể đưa vào tái chế để sử dụng nhằm mục đích phục vụ cho con người "+
                "như: \n"+
                "- Thùng carton, sách báo cũ.\n" +
                "- Hộp giấy, bì thư, bưu thiếp đã qua sử dụng\n" +
                "- Các loại vỏ lon nước ngọt/ lon bia/ vỏ hộp trà….\n" +
                "- Các loại ghế nhựa, thau/ chậu nhựa, quần áo và vải cũ…";
        tvKetQua.setText(KQ);
    }
}
