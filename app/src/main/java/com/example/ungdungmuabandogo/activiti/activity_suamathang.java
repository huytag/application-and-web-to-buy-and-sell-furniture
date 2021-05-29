package com.example.ungdungmuabandogo.activiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.Center;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class activity_suamathang extends AppCompatActivity {
    Button backxn,backtv;
    EditText id,ten,gia,hinhanh,mota;
    int Id =0;
    String Tenchitiet = "";
    int Giachitiet = 0;
    String Hinhanhchitiet = "";
    String Motachitiet = "";
    int Idsanpham = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suamathang);
        Anhxa();
        BachTV();
        GetInformattion();
        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
            setonclick();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"Vui lòng kiểm tra lại kết nối");
        }
    }

    private void BachTV() {
        backtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Center.class);
                startActivity(intent);
            }
        });
    }



    private void setonclick() {
        backxn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eventsua();
            }
        });
    }
    private void Eventsua() {
        final String Id = id.getText().toString().trim();
        final String Ten = ten.getText().toString().trim();
        final String Gia = gia.getText().toString().trim();
        final String Hinhanh = hinhanh.getText().toString().trim();
        final String Mota = mota.getText().toString().trim();
        if (Id.length() > 0 && Gia.length() > 0 && Hinhanh.length() > 0 && Mota.length() > 0){
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest= new StringRequest(Request.Method.POST, Sever.Duongdansuamathang, new Response.Listener<String>() {
                @Override
                public void onResponse(final String response) {
                    Log.d("idxoahang",response);
                    Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn đã sửa mặt hàng thành công");
                    Intent intent = new Intent(getApplicationContext(), activity_tongquansuamathang.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("id",Id);
                    hashMap.put("tensanpham",Ten);
                    hashMap.put("giasanpham",Gia);
                    hashMap.put("hinhanhsanpham",Hinhanh);
                    hashMap.put("motasanpham",Mota);
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"Hãy nhập id để sửa");
        }
    }

    private void Anhxa() {
        backtv = findViewById(R.id.Btntrove);
        backxn = findViewById(R.id.Btnxacnhanmua);
        id = findViewById(R.id.Editid);
        ten = findViewById(R.id.Editten);
        gia = findViewById(R.id.Editgia);
        hinhanh = findViewById(R.id.Edithinhanh);
        mota = findViewById(R.id.Editmota);
    }
    private void GetInformattion() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("tongquanmathangsua");
        Id = sanpham.getID();
        Tenchitiet = sanpham.getTensanpham();
        Giachitiet = sanpham.getGiasanpham();
        Hinhanhchitiet = sanpham.getHinhanhsanpham();
        Motachitiet = sanpham.getMotasanpham();
        Idsanpham = sanpham.getIDSanpham();
        id.setEnabled(false);
        id.setText(""+Id);
        ten.setText(Tenchitiet);
        gia.setText(""+Giachitiet);
        hinhanh.setText(""+Hinhanhchitiet);
        mota.setText(Motachitiet);

    }
}