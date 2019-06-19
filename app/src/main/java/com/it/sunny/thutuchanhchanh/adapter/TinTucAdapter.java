package com.it.sunny.thutuchanhchanh.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.activity.ActivityTinTuc;
import com.it.sunny.thutuchanhchanh.activity.activityNhomTin;
import com.it.sunny.thutuchanhchanh.activity.activityNoiDungTin;
import com.it.sunny.thutuchanhchanh.model.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ItemHolder> {
    Context context;
    ArrayList<TinTuc> arraytintuc;

    public TinTucAdapter(Context context, ArrayList<TinTuc> arraytintuc) {
        this.context = context;
        this.arraytintuc = arraytintuc;
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_tintucmoinhat,null);
        ItemHolder itemHolder = new ItemHolder(v);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder,final int i) {
        TinTuc tinTuc = arraytintuc.get(i);
        itemHolder.txttieude.setText(tinTuc.getTieuDe());
        itemHolder.txtngaydang.setText(tinTuc.getNgayDang().toString());
        Picasso.with(context).load(tinTuc.getHinhAnh())
                .placeholder(R.drawable.defaultimg)
                .error(R.drawable.erroimg)
                .into(itemHolder.imghinhtintuc);
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activityNoiDungTin.class);
                intent.putExtra("thongtinnoidung", arraytintuc.get(i));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                //Toast.makeText(context, "AAA"+ arraytintuc.get(i).getID(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arraytintuc.size();
    }

    public  class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhtintuc;
        public TextView txttieude,txtngaydang;

        public ItemHolder(View itemView) {
            super(itemView);
            imghinhtintuc =(ImageView) itemView.findViewById(R.id.imgHinhTinTuc);
            txttieude =(TextView) itemView.findViewById(R.id.txtTieuDe);
            txtngaydang =(TextView) itemView.findViewById(R.id.txtNgayDang);
        }
    }
}
