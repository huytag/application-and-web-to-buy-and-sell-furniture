package com.example.ungdungmuabandogo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.activiti.Center_dogo;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class dangky extends AppCompatActivity {

    EditText editTexttenuser,editTextemail,editTextpass,editTextnlpass;
    Button backDN,btnDK ;
    ProgressBar loading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        BackDN();
        Anhxa();
        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
            setBackDN();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"Vui lòng kiểm tra lại kết nối");
        }
    }

    public void setBackDN(){
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDK();
            }
        });
    }

    private void EventDK() {
            loading.setVisibility(View.VISIBLE);
                final String tenuser = editTexttenuser.getText().toString().trim();
                final String email = editTextemail.getText().toString().trim();
                final String pass = editTextpass.getText().toString().trim();
                final String nlpass = editTextnlpass.getText().toString().trim();
                if (tenuser.length() > 0 && email.length() > 0 && pass.length() > 0 && nlpass.length() > 0){
                        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                        StringRequest stringRequest= new StringRequest(Request.Method.POST, Sever.Duongdanuserdk, new Response.Listener<String>() {
                            @Override
                            public void onResponse(final String response) {
                                Log.d("userkhachhang",response);
                                loading.setVisibility(View.INVISIBLE);
                                Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn đã thêm tài khoản thành công");
                                Intent intent = new Intent(getApplicationContext(),Login.class);
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
                                hashMap.put("tenuser",tenuser);
                                hashMap.put("email",email);
                                hashMap.put("pass",pass);
                                return hashMap;
                            }
                        };
                        requestQueue.add(stringRequest);
                }else{
                    Checkconnecttion.showToast_Short(getApplicationContext(),"Hãy kiểm tra lại nhập dữ liệu");
                }
            }

    private void Anhxa() {
        btnDK = findViewById(R.id.btnDangkiDK);
        editTexttenuser = findViewById(R.id.txtNameDK);
        editTextemail = findViewById(R.id.txtEmailDK);
        editTextpass = findViewById(R.id.txtPassDK);
        editTextnlpass = findViewById(R.id.txtPassnhaplaiDK);
        loading = findViewById(R.id.loading);
    }

    public void BackDN() {
        backDN = findViewById(R.id.btnDangnhapDK);
        backDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangky.this, Login.class);
                startActivity(intent);
            }
        });
    }
}

