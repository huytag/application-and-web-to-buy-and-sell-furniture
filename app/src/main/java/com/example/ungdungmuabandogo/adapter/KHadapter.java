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
import com.example.ungdungmuabandogo.model.ChitietKH;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class KHadapter extends BaseAdapter {
    Context context;
    ArrayList<ChitietKH> arraychitiet;

    public KHadapter(Context context, ArrayList<ChitietKH> arraychitiet) {
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
        public TextView txtid,txtten,txtsdt,txtemail;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_chitiet_kh, null);
            viewHolder.txtid = convertView.findViewById(R.id.textviewid);
            viewHolder.txtten = convertView.findViewById(R.id.textviewtenkh);
            viewHolder.txtsdt = convertView.findViewById(R.id.textviewsdt);
            viewHolder.txtemail = convertView.findViewById(R.id.textviewEmail);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ChitietKH chiTietKH = (ChitietKH) getItem(position);
        viewHolder.txtid.setText("ID Mã đơn hàng: "+chiTietKH.getID());
        viewHolder.txtten.setText("Tên Khách Hàng: "+chiTietKH.getTenkhachhang());
        viewHolder.txtsdt.setText("Số điện thoại: "+chiTietKH.getSdt());
        viewHolder.txtemail.setText("Email: "+chiTietKH.getEmail());
        return convertView;
    }
}

