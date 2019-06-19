package com.it.sunny.thutuchanhchanh.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.adapter.NhomTinAdapter;
import com.it.sunny.thutuchanhchanh.model.TinTuc;
import com.it.sunny.thutuchanhchanh.ultil.Checkconnection_internet;
import com.it.sunny.thutuchanhchanh.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class activityNhomTin extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarnt;
    ListView listViewNhomtin;
    NhomTinAdapter nhomTinAdapter;
    ArrayList<TinTuc> mangnhomtin;
    int idTinTuc=1;
    int _page =1;
    View footerView;
    boolean isLoading = false;
    boolean endofData =false;
    myHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhom_tin);

        AnhXa();
        if (Checkconnection_internet.haveNetworkConnection(getApplicationContext()))
        {
            GetIdNhomTin();
            ActionToolbar();
            GetData(_page);
            LoadMoreData();
        }
        else
        {
            Toast.makeText(this, "Kiểm tra kết nối internet!", Toast.LENGTH_SHORT).show();
        }

    }

    private void LoadMoreData() {
        listViewNhomtin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(activityNhomTin.this,activityNoiDungTin.class);
                intent.putExtra("thongtinnoidung",mangnhomtin.get(i));
                //Toast.makeText(activityNhomTin.this, "BBB: "+mangnhomtin.get(i), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        listViewNhomtin.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstItem, int visibleItem, int totalItem) {
                if (firstItem + visibleItem == totalItem && totalItem!=0 && isLoading==false && endofData==false){
                    isLoading=true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = Server.DuongDanNhomTin + String.valueOf(page);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id=0;
                int idLoaitin;
                String Tieude="";
                String Hinhanhnhom="";
                String MotaNhom="";
                String Noidungnhom="";
                String Tacgianhom ="";
                String NgayDang="";

                if (response!=null && response.length()!=2){
                    listViewNhomtin.removeFooterView(footerView);
                    try {

                        JSONArray jsonArray= new JSONArray(response);
                        for (int i =0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            idLoaitin =jsonObject.getInt("idloaitin");
                            Tieude =jsonObject.getString("tieude");
                            Hinhanhnhom =jsonObject.getString("hinhanh");
                            MotaNhom =jsonObject.getString("mota");
                            Noidungnhom=jsonObject.getString("noidung");
                            Tacgianhom =jsonObject.getString("tacgia");
                            NgayDang =jsonObject.getString("ngaydang");
                            mangnhomtin.add(new TinTuc(id,idLoaitin,Tieude,Hinhanhnhom,MotaNhom,Noidungnhom,Tacgianhom,NgayDang));
                            nhomTinAdapter.notifyDataSetChanged();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(activityNhomTin.this, "Lổi gán biến activityNhomTin.java xem lai đi!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    endofData=true;
                    listViewNhomtin.removeFooterView(footerView);
                    //Toast.makeText(activityNhomTin.this, "Đã hết dữ liệu để load!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activityNhomTin.this, "Lổi truy xuất dữ liệu!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String,String>();
                param.put("idloaitin",String.valueOf(idTinTuc));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolbar() {

        setSupportActionBar(toolbarnt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //bật nút home
        toolbarnt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void GetIdNhomTin() {
        idTinTuc = getIntent().getIntExtra("idloaiTin",-1);
        Log.d("Gia tri nhom tin :",+ idTinTuc + "");
    }

    private void AnhXa() {
        toolbarnt = (Toolbar) findViewById(R.id.toolbarnhomTin);
        listViewNhomtin =(ListView) findViewById(R.id.listviewNhomTin);
        mangnhomtin = new ArrayList<>();
        nhomTinAdapter = new NhomTinAdapter(getApplicationContext(),mangnhomtin);
        listViewNhomtin.setAdapter(nhomTinAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.progressbar,null);
        mHandler = new myHandler();

    }

    public class myHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0: listViewNhomtin.addFooterView(footerView);
                    break;
                case 1:
                    GetData(++_page);
                    isLoading=false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.run();
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
        }
    }
}
