package com.example.ungdungmuabandogo.activiti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.adapter.BangoAdeptar;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class activity_moctreo extends AppCompatActivity {
    ListView listView;
    BangoAdeptar   bangoAdeptar;
    ArrayList<Sanpham> mangbg;
    int idbg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bango);
        Anhxa();
        if (Checkconnecttion.haveNetworkConnection(getApplicationContext()))
        {
            GetIdLoaiSP();
            ActionTooolbar();
            GetData();
            Chitietsanpham();
        }else{
            Checkconnecttion.showToast_Short(getApplicationContext(),"bạn hãy kiểm tra lại internet");
            finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_giohang,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(),activiti_giohang.class);
                startActivity(intent);
        }        return super.onOptionsItemSelected(item);
    }
    private void Chitietsanpham() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), activity_chitietsanpham.class);
                intent.putExtra("thongtinsanpham", mangbg.get(position));
                startActivity(intent);
            }
        });
    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.Duongdanmoctreo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tengb= "";
                int Giagb = 0;
                String Hinhanhbg = "";
                String Motabg = "";
                int idsp = 0;
                if (response !=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i ++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tengb = jsonObject.getString("tensanpham");
                            Giagb = jsonObject.getInt("giasanpham");
                            Hinhanhbg = jsonObject.getString("hinhanhsanpham");
                            Motabg = jsonObject.getString("motasanpham");
                            idsp = jsonObject.getInt("idsanpham");
                            mangbg.add(new Sanpham(id,Tengb,Giagb,Hinhanhbg,Motabg,idsp));
                            bangoAdeptar.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String, String>();
                param.put("idsanpham",String.valueOf(idbg));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionTooolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarbango);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Móc treo, Cây treo gỗ");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private void GetIdLoaiSP() {
        idbg = getIntent().getIntExtra("idloaisanpham", -1);
        Log.d("giatriloaisanpham",idbg+"");

    }

    private void Anhxa() {
        listView = findViewById(R.id.listviewbango);
        mangbg = new ArrayList<>();
        bangoAdeptar = new BangoAdeptar(getApplicationContext(),mangbg);
        listView.setAdapter(bangoAdeptar);
    }
}