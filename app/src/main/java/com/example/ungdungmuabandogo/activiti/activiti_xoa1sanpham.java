package com.example.ungdungmuabandogo.activiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.Center;
import com.example.ungdungmuabandogo.Login;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class activiti_xoa1sanpham extends AppCompatActivity {
    EditText editTextxoa;
    Button backXOA,backTV ;
    TextView test;
    int id =0;
    String Tenchitiet = "";
    int Giachitiet = 0;
    String Hinhanhchitiet = "";
    String Motachitiet = "";
    int Idsanpham = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_xoa1sanpham);
        Anhxa();
        btnback();
        GetInformattion();


        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
            setonclick();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"Vui lòng kiểm tra lại kết nối");
        }
    }

    private void GetInformattion() {
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("xoamotsanpham");
        id = sanpham.getID();
        Tenchitiet = sanpham.getTensanpham();
        Giachitiet = sanpham.getGiasanpham();
        Hinhanhchitiet = sanpham.getHinhanhsanpham();
        Motachitiet = sanpham.getMotasanpham();
        Idsanpham = sanpham.getIDSanpham();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        editTextxoa.setEnabled(false);
        editTextxoa.setText(""+id);
    }

    private void btnback() {
        backTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Center.class);
                startActivity(intent);
            }
        });
    }

    private void setonclick() {
        backXOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDK();
            }
        });
    }

    private void EventDK() {
        final String id = editTextxoa.getText().toString().trim();
        if (id.length() > 0 ){
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest= new StringRequest(Request.Method.POST, Sever.Duongdanxoamh1, new Response.Listener<String>() {
                @Override
                public void onResponse(final String response) {
                    Log.d("idxoahang",response);
                    Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn đã xóa mặt hàng thành công");
                    Intent intent = new Intent(getApplicationContext(), activity_tongquanxoa.class);
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
                    hashMap.put("id",id);
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"Hãy nhập id để xóa");
        }
    }



    private void Anhxa() {
        backXOA = findViewById(R.id.btnxacnhanxoa);
        backTV = findViewById(R.id.btntrove);
        editTextxoa = findViewById(R.id.edittextxoamh);
        test = findViewById(R.id.testhihi);
    }
}