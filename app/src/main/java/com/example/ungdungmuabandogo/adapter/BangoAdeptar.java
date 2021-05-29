package com.example.ungdungmuabandogo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BangoAdeptar extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraybango;

    public BangoAdeptar(Context context, ArrayList<Sanpham> arraybango) {
        this.context = context;
        this.arraybango = arraybango;
    }

    @Override
    public int getCount() {
        return arraybango.size();
    }

    @Override
    public Object getItem(int position) {
        return arraybango.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
            public TextView txtten,txtgia,txtmota;
            public ImageView imgbango;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_bango, null);
            viewHolder.txtten = convertView.findViewById(R.id.textviewbango);
            viewHolder.txtgia = convertView.findViewById(R.id.textviewgiabango);
            viewHolder.txtmota = convertView.findViewById(R.id.textviewmotabango);
            viewHolder.imgbango = convertView.findViewById(R.id.imageViewbango);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txtten.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Giá : " + decimalFormat.format(sanpham.getGiasanpham()) + "Đ");
        viewHolder.txtmota.setMaxLines(2);
        viewHolder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmota.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgbango);
        return convertView;
    }
}
