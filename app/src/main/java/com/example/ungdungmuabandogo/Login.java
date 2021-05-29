package com.example.ungdungmuabandogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btDK;
    Button btDN;
    TextView tk,mk,chimuahang;
    private static final String KEY_TK = "admin";
    private static final String KEY_MK = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        dangnhap();
        dangky();
        chimuahang();
    }

    private void chimuahang() {
        chimuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Center_dogo.class);
                startActivity(intent);
            }
        });
    }

    public void anhxa()
    {
        btDK = findViewById(R.id.btnDangki);
        btDN = findViewById(R.id.btnDangnhap);
        tk = findViewById(R.id.txtEmail);
        mk = findViewById(R.id.txtPass);
        chimuahang = findViewById(R.id.chimuonmuahang);
    }
    public void dangnhap()
    {
        btDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tk.getText().length() != 0 && mk.getText().length() != 0 )
                {
                    String mEmail = tk.getText().toString().trim();
                    String mPass = mk.getText().toString().trim();
                    login(mEmail,mPass);
                    if(tk.getText().toString().equals(KEY_TK) && mk.getText().toString().equals(KEY_MK)) {
                        Toast.makeText(Login.this, "Bạn đang đăng nhập thành công", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(Login.this, Center.class);
                        startActivity(intent2);
                        finish();

                    }
                    else {
                        Toast.makeText(Login.this, "Bạn đang đăng nhập thất bại", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Login.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_LONG).show();

                }

            }

        });
    }
    private void login(String email,String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.Duongdanlogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if(success.equals("1")){
                        for(int i =0; i< jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String name = object.getString("name").trim();
                            String email = object.getString("name").trim();
                            Toast.makeText(Login.this, "Bạn đang đăng nhập thành công" + "\nyour name"+name+"\nYour email"+email, Toast.LENGTH_LONG).show();
                            Intent intent2 = new Intent(Login.this, Center.class);
                            startActivity(intent2);
                            finish();
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Đăng nhập thành công.");
                        }

                    }                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String success;
            }
        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("email", email);
                param.put("password", password);
                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void dangky()
    {
        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,dangky.class);
                startActivity(intent);
            }
        });
    }
}