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
import com.example.ungdungmuabandogo.model.QuanlyTk;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Quanlytk_Adapter {
    Context context;
    ArrayList<QuanlyTk> arraychitiet;

    public Quanlytk_Adapter(Context context, ArrayList<QuanlyTk> arraychitiet) {
        this.context = context;
        this.arraychitiet = arraychitiet;

    }


    public int getCount() {
        return arraychitiet.size();
    }

    public Object getItem(int position) {
        return arraychitiet.get(position);
    }


    public long getItemId(int position) {
        return position;
    }

    public void notifyDataSetChanged() {

    }

    public class ViewHolder{
        public TextView txtid,txtten,txtsdt,txtemail;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Quanlytk_Adapter.ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new Quanlytk_Adapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_chitiet_kh, null);
            viewHolder.txtid = convertView.findViewById(R.id.textviewid);
            viewHolder.txtten = convertView.findViewById(R.id.textviewtenkh);
            viewHolder.txtsdt = convertView.findViewById(R.id.textviewsdt);
            viewHolder.txtemail = convertView.findViewById(R.id.textviewEmail);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (Quanlytk_Adapter.ViewHolder) convertView.getTag();
        }
        ChitietKH chiTietKH = (ChitietKH) getItem(position);
        viewHolder.txtid.setText("ID Mã đơn hàng: "+chiTietKH.getID());
        viewHolder.txtten.setText("Tên Khách Hàng: "+chiTietKH.getTenkhachhang());
        viewHolder.txtsdt.setText("Số điện thoại: "+chiTietKH.getSdt());
        viewHolder.txtemail.setText("Email: "+chiTietKH.getEmail());
        return convertView;
    }
}
