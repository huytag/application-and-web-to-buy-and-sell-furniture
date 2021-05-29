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
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;

import java.util.HashMap;
import java.util.Map;

public class activity_themmathang extends AppCompatActivity {
    EditText editTexttensanpham,editTextgia,editTexthinhanh,editTextmota,editTextidsanpham;
    Button btnXacnhan,btnTrove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmathang);
        Anhxa();
        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
            EvenButton();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"bạn hãy kiểm tra lại kết nối");
        }
    }

    private void EvenButton() {
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = editTexttensanpham.getText().toString().trim();
                final String gia = editTextgia.getText().toString().trim();
                final String hinhanh = editTexthinhanh.getText().toString().trim();
                final String mota = editTextmota.getText().toString().trim();
                final String idsp = editTextidsanpham.getText().toString().trim();
                if(ten.length()>0 && gia.length()>0&& hinhanh.length()>0&& mota.length()>0&& idsp.length()>0 ){
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest= new StringRequest(Request.Method.POST, Sever.Duongdanthemmathang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String response) {
                            Log.d("madonhang",response);
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn đã thêm hàng thành công");
                            Intent intent = new Intent(getApplicationContext(),Center.class);
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
                            hashMap.put("ten",ten);
                            hashMap.put("gia",gia);
                            hashMap.put("hinh",hinhanh);
                            hashMap.put("mota",mota);
                            hashMap.put("idsp",idsp);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else {
                    Checkconnecttion.showToast_Short(getApplicationContext(),"Hãy kiểm tra lại nhập dữ liệu");
                }
            }
        });
    }

    private void Anhxa() {
        editTexttensanpham = findViewById(R.id.edittensanpham);
        editTextgia = findViewById(R.id.editgiasanpham);
        editTexthinhanh = findViewById(R.id.edithinhanhsanpham);
        editTextmota = findViewById(R.id.editmotasanpham);
        editTextidsanpham = findViewById(R.id.editidsanpham);
        btnTrove = findViewById(R.id.btntrove);
        btnXacnhan = findViewById(R.id.btnxacnhanmua);
    }
}