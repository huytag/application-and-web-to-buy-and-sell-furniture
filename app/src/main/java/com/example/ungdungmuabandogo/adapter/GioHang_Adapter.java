package com.example.ungdungmuabandogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ungdungmuabandogo.Center;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.activiti.Center_dogo;
import com.example.ungdungmuabandogo.activiti.activiti_giohang;
import com.example.ungdungmuabandogo.model.GioHang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHang_Adapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayListgiohang;

    public GioHang_Adapter(Context context, ArrayList<GioHang> arrayListgiohang) {
        this.context = context;
        this.arrayListgiohang = arrayListgiohang;
    }

    @Override
    public int getCount() {
        return arrayListgiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListgiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imggiohang;
        public Button btngiam,btngiatri,btntang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_giohang, null);
            viewHolder.txttengiohang = convertView.findViewById(R.id.textviewtengiohang);
            viewHolder.txtgiagiohang = convertView.findViewById(R.id.textviewgiatrigiohang);
            viewHolder.imggiohang = convertView.findViewById(R.id.imageViewgiohang);
            viewHolder.btngiam = convertView.findViewById(R.id.buttongiamsl);
            viewHolder.btngiatri = convertView.findViewById(R.id.buttonggiatrisl);
            viewHolder.btntang = convertView.findViewById(R.id.buttongtangsl);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txttengiohang.setText(gioHang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(gioHang.getGiasp()) + "Đ");
        Picasso.with(context).load(gioHang.getHinhanhsp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imggiohang);
        viewHolder.btngiatri.setText(gioHang.getSoluongsp() + "");
        int sl = Integer.parseInt(viewHolder.btngiatri.getText().toString());
        if (sl >= 10){
            viewHolder.btntang.setVisibility(View.INVISIBLE);
            viewHolder.btngiam.setVisibility(View.VISIBLE);
        }else if(sl<=1){
            viewHolder.btngiam.setVisibility(View.INVISIBLE);
        }else if(sl>=1 ){
            viewHolder.btntang.setVisibility(View.VISIBLE);
            viewHolder.btngiam.setVisibility(View.VISIBLE);
        }
        ViewHolder finalViewHolder = viewHolder;
        viewHolder.btntang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btngiatri.getText().toString()) + 1;
                int slhientai = Center_dogo.manggiohang.get(position).getSoluongsp();
                long giahientai = Center_dogo.manggiohang.get(position).getGiasp();

                Center_dogo.manggiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giahientai * slmoinhat) / slhientai;
                Center_dogo.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format((giamoinhat)) + "Đ");
                activiti_giohang.EvenUltil();
                if (slmoinhat > 9){
                    finalViewHolder.btntang.setVisibility(View.INVISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolder.btngiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btngiatri.getText().toString()) - 1;
                int slhientai = Center_dogo.manggiohang.get(position).getSoluongsp();
                long giahientai = Center_dogo.manggiohang.get(position).getGiasp();

                Center_dogo.manggiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giahientai * slmoinhat) / slhientai;
                Center_dogo.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format((giamoinhat)) + "Đ");
                activiti_giohang.EvenUltil();
                if (slmoinhat < 2){
                    finalViewHolder.btngiam.setVisibility(View.INVISIBLE);
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return convertView;
    }
}
