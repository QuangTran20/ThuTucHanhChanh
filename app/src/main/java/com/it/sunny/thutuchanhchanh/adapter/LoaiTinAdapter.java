package com.it.sunny.thutuchanhchanh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.model.LoaiTin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaiTinAdapter extends BaseAdapter {

    ArrayList<LoaiTin> arrayListloaitin;
    Context context;

    public LoaiTinAdapter(ArrayList<LoaiTin> arrayListloaitin, Context context) {
        this.arrayListloaitin = arrayListloaitin;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaitin.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListloaitin.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txttenloaitin;
        ImageView imghinhloaitin;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if( view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaitin,null);
            viewHolder.txttenloaitin=view.findViewById(R.id.textviewLoaiTin);
            viewHolder.imghinhloaitin = view.findViewById(R.id.imgLoaiTin);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();

        }
        LoaiTin loaiTin = (LoaiTin) getItem(position);
        viewHolder.txttenloaitin.setText(loaiTin.getLoaitin());
        Picasso.with(context).load(loaiTin.getHinh())
                .placeholder(R.drawable.defaultimg)
                .error(R.drawable.erroimg)
                .into(viewHolder.imghinhloaitin);

        return view;
    }
}
