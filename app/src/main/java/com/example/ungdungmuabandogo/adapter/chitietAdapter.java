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
import com.example.ungdungmuabandogo.model.ChiTietHD;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class chitietAdapter extends BaseAdapter {
    Context context;
    ArrayList<ChiTietHD> arraychitiet;

    public chitietAdapter(Context context, ArrayList<ChiTietHD> arraychitiet) {
        this.context = context;
        this.arraychitiet = arraychitiet;
    }

    @Override
    public int getCount() {
        return arraychitiet.size();
    }

    @Override
    public Object getItem(int position) {
        return arraychitiet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txtmadon,txtmasp,txtten,txtgia,txtsl;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_cthoadon, null);
            viewHolder.txtmadon = convertView.findViewById(R.id.textviewmadon);
            viewHolder.txtmasp = convertView.findViewById(R.id.textviewmasanpham);
            viewHolder.txtten = convertView.findViewById(R.id.textviewtensanpham);
            viewHolder.txtgia = convertView.findViewById(R.id.textviewgiasanpham);
            viewHolder.txtsl = convertView.findViewById(R.id.textviewsoluongsanpham);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ChiTietHD chiTietHD = (ChiTietHD) getItem(position);
        viewHolder.txtmadon.setText("Mã đơn: "+chiTietHD.getMadonhang());
        viewHolder.txtmasp.setText("Mã sản phẩm: "+chiTietHD.getMasanpham());
        viewHolder.txtten.setText("Tên sản phẩm: "+chiTietHD.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Giá : " + decimalFormat.format(chiTietHD.getGiasanpham()) + "Đ");
        viewHolder.txtsl.setText("Số lượng: "+chiTietHD.getSLsanpham());
        return convertView;
    }
}

