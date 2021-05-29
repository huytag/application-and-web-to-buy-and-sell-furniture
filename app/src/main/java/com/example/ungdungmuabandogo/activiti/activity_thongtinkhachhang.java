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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class activity_thongtinkhachhang extends AppCompatActivity {
    EditText editTexttenkhachhang,editTextsdt,editTextemail;
    Button btnXacnhan,btnTrove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
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
                final String ten = editTexttenkhachhang.getText().toString().trim();
                final String sdt = editTextsdt.getText().toString().trim();
                final String email = editTextemail.getText().toString().trim();
                if(ten.length()>0 && sdt.length()>0&& email.length()>0)
                {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest= new StringRequest(Request.Method.POST, Sever.Duongdandonhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String madonhang) {
                            Log.d("madonhang",madonhang);
                            if(Integer.parseInt(madonhang) > 0 ){
                                RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                                StringRequest  stringRequest1 = new StringRequest(Request.Method.POST, Sever.Duongdanchitietdonhang, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response1) {
                                            Center_dogo.manggiohang.clear();
                                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn đã đặt hàng thành công");
                                            Intent intent = new Intent(getApplicationContext(),Center_dogo.class);
                                            startActivity(intent);
                                            Checkconnecttion.showToast_Short(getApplicationContext(),"Mời bạn tiếp tục mua hàng");
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }){
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        JSONArray jsonArray = new JSONArray();
                                        for(int i =0; i < Center_dogo.manggiohang.size();i++){
                                            JSONObject jsonObject = new JSONObject();
                                            try {
                                                jsonObject.put("madonhang", madonhang);
                                                jsonObject.put("masanpham", Center_dogo.manggiohang.get(i).getIdsp());
                                                jsonObject.put("tensanpham",Center_dogo.manggiohang.get(i).getTensp());
                                                jsonObject.put("giasanpham", Center_dogo.manggiohang.get(i).getGiasp());
                                                jsonObject.put("soluongsanpham", Center_dogo.manggiohang.get(i).getSoluongsp());
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            jsonArray.put(jsonObject);
                                        }
                                        HashMap<String,String> hashMap = new HashMap<String, String>();
                                        hashMap.put("json",jsonArray.toString());
                                        return hashMap;
                                    }
                                };
                                requestQueue.add(stringRequest1);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("tenkhachhang",ten);
                            hashMap.put("sodienthoai",sdt);
                            hashMap.put("email",email);
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
        editTexttenkhachhang = findViewById(R.id.edittenkhachhang);
        editTextemail = findViewById(R.id.editemail);
        editTextsdt = findViewById(R.id.editsodienthoai);
        btnXacnhan = findViewById(R.id.btnxacnhanmua);
        btnTrove = findViewById(R.id.btntrove);
    }
}