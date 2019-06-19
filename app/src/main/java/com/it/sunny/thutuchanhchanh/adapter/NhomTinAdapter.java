package com.it.sunny.thutuchanhchanh.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.sunny.thutuchanhchanh.R;
import com.it.sunny.thutuchanhchanh.model.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NhomTinAdapter extends BaseAdapter {
    Context context;
    ArrayList<TinTuc> arraynhomtin;

    public NhomTinAdapter(Context context, ArrayList<TinTuc> arraynhomtin) {
        this.context = context;
        this.arraynhomtin = arraynhomtin;
    }

    @Override
    public int getCount() {
        return arraynhomtin.size();
    }

    @Override
    public Object getItem(int position) {
        return arraynhomtin.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        public TextView txttieude,txtngadang;
        public ImageView imghinhnhomtin;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (viewHolder==null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_nhomtin,null);
            viewHolder.txttieude =(TextView) view.findViewById(R.id.txtTieuDe);
            viewHolder.imghinhnhomtin =(ImageView) view.findViewById(R.id.imgageviewhinhnhomtin);
            viewHolder.txtngadang =(TextView) view.findViewById(R.id.txtNgayDang);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        TinTuc tinTuc = (TinTuc) getItem(position);
        viewHolder.txttieude.setText(tinTuc.getTieuDe());
        viewHolder.txttieude.setLines(3);
        viewHolder.txttieude.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtngadang.setText(tinTuc.getNgayDang());

        Picasso.with(context).load(tinTuc.getHinhAnh())
                .placeholder(R.drawable.defaultimg)
                .error(R.drawable.erroimg)
                .into(viewHolder.imghinhnhomtin);
        return view;
    }
}
