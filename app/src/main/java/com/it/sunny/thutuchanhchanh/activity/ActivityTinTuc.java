package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.adapter.LoaiTinAdapter;
import com.it.sunny.thutuchanhchanh.adapter.TinTucAdapter;
import com.it.sunny.thutuchanhchanh.model.LoaiTin;
import com.it.sunny.thutuchanhchanh.model.TinTuc;
import com.it.sunny.thutuchanhchanh.ultil.Checkconnection_internet;
import com.it.sunny.thutuchanhchanh.ultil.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityTinTuc extends AppCompatActivity{
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewTinTuc;
    DrawerLayout drawerLayout;
    ArrayList<LoaiTin> mangloaitin;
    LoaiTinAdapter loaiTinAdapter;

    int id = 0;
    String TenLoaiTin = "";
    String HinhLoai = "";
    String urlGetData = "";

    ArrayList<TinTuc> mangtintucmoinhat;
    TinTucAdapter tinTucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc);
        Anhxa();
        urlGetData = Server.DuongDanLoaiTin;

        if (Checkconnection_internet.haveNetworkConnection(getApplicationContext())) {
            ActionBar();
            ActionViewFlipper();
            GetDulieuLoaiTin(urlGetData);
            GetDuLieuTinMoiNhat();
            CatchOnItemListView();

        } else {
            Checkconnection_internet.ShowToast_Short(getApplicationContext(), "Xin kiểm tra kết nối internet");
            finish();
        }

    }


    private void CatchOnItemListView() {
        listViewTinTuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (Checkconnection_internet.haveNetworkConnection(getApplicationContext())) {
                    Intent intent = new Intent(ActivityTinTuc.this, activityNhomTin.class);
                    intent.putExtra("idloaiTin", mangloaitin.get(position).getId());
                    startActivity(intent);
                } else {
                    Toast.makeText(ActivityTinTuc.this, "Kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

    }

    private void CatchTinMoiNhatOnItemClick()
    {
        recyclerView.setClickable(true);

    }

    private void GetDuLieuTinMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server.DuongDanTinMoiNhat, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    int IDLoaiTin = 0;
                    String Tieude = "";
                    String Hinhanh = "";
                    String Mota = "";
                    String Noidung = "";
                    String Tacgia = "";
                    String Ngaydang = "";

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            IDLoaiTin = jsonObject.getInt("idloaitin");
                            Tieude = jsonObject.getString("tieude");
                            Hinhanh = jsonObject.getString("hinhanh");

                            Mota = jsonObject.getString("mota");
                            Noidung = jsonObject.getString("noidung");
                            Tacgia = jsonObject.getString("tacgia");

                            Ngaydang = jsonObject.getString("ngaydang");


                            mangtintucmoinhat.add(new TinTuc(ID, IDLoaiTin, Tieude, Hinhanh, Mota, Noidung, Tacgia, Ngaydang));
                            tinTucAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ActivityTinTuc.this, "Lổi gán biến", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityTinTuc.this, "Lổi truy xuất dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDulieuLoaiTin(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(ActivityTinTuc.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response != null) {
                            for (int i = 0; i < response.length(); i++) {
                                try {

                                    JSONObject jsonObject = response.getJSONObject(i);
                                    id = jsonObject.getInt("id");
                                    TenLoaiTin = jsonObject.getString("theloai");
                                    HinhLoai = Server.DuongDanHinhLoaiTin + jsonObject.getString("hinh");

                                    mangloaitin.add(new LoaiTin(id, TenLoaiTin, HinhLoai));
                                    loaiTinAdapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(ActivityTinTuc.this, "Loi gan bien Loai Tin", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(ActivityTinTuc.this, "Loi doc du lieu:"+ error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("AAAA",error.getMessage());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        String urlHinhQC = Server.DuongDanHinhQuangCao;
        mangquangcao.add(urlHinhQC + "h1.jpg");
        mangquangcao.add(urlHinhQC + "h2.jpg");
        mangquangcao.add(urlHinhQC + "h3.jpg");
        mangquangcao.add(urlHinhQC + "h4.jpg");
        mangquangcao.add(urlHinhQC + "h5.jpg");
        mangquangcao.add(urlHinhQC + "h6.jpg");
        mangquangcao.add(urlHinhQC + "h7.jpg");

        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext())
                    .load(mangquangcao.get(i))
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarTinTuc);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewlipperTinTuc);
        recyclerView = (RecyclerView) findViewById(R.id.recyleviewTinTuc);
        navigationView = (NavigationView) findViewById(R.id.navigationTinTuc);
        listViewTinTuc = (ListView) findViewById(R.id.listviewTinTuc);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayoutTinTuc);
        mangloaitin = new ArrayList<>();

        loaiTinAdapter = new LoaiTinAdapter(mangloaitin, getApplicationContext());
        listViewTinTuc.setAdapter(loaiTinAdapter);

        mangtintucmoinhat = new ArrayList<>();
        tinTucAdapter = new TinTucAdapter(getApplicationContext(), mangtintucmoinhat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(tinTucAdapter);
        recyclerView.setClickable(true);
    }


}
