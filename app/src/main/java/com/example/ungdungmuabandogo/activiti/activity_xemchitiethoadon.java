package com.example.ungdungmuabandogo.activiti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.adapter.BangoAdeptar;
import com.example.ungdungmuabandogo.adapter.chitietAdapter;
import com.example.ungdungmuabandogo.model.ChiTietHD;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class activity_xemchitiethoadon extends AppCompatActivity {
    ListView listView;
    chitietAdapter chitiet;
    ArrayList<ChiTietHD> mangct;
    int idbg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemchitiethoadon);
        Anhxa();
        if (Checkconnecttion.haveNetworkConnection(getApplicationContext()))
        {
            ActionTooolbar();
            GetData();
//            Chitietsanpham();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"bạn hãy kiểm tra lại internet");
            finish();
        }
    }
    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.Duongdanchitiethoadon, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                int madon = 0;
                int masp = 0;
                String Tensp= "";
                int Giasp = 0;
                int slsp = 0;
                if (response !=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i ++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            madon = jsonObject.getInt("madonhang");
                            masp = jsonObject.getInt("masanpham");
                            Tensp = jsonObject.getString("tensanpham");
                            Giasp = jsonObject.getInt("giasanpham");
                            slsp = jsonObject.getInt("soluongsanpham");
                            mangct.add(new ChiTietHD(id,madon,masp,Tensp,Giasp,slsp));
                            chitiet.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        Checkconnecttion.showToast_Short(getApplicationContext(),"chưa đọc được");
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }

    private void Anhxa() {
        listView = findViewById(R.id.listviewchitiet);
        mangct = new ArrayList<>();
        chitiet = new chitietAdapter(getApplicationContext(),mangct);
        listView.setAdapter(chitiet);
    }

    private void ActionTooolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarchitiethoadon);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Chi tiết hóa đơn");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}