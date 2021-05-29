package com.example.ungdungmuabandogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ungdungmuabandogo.activiti.activiti_xoa1sanpham;
import com.example.ungdungmuabandogo.activiti.activity_chitietKH;
import com.example.ungdungmuabandogo.activiti.activity_suamathang;
import com.example.ungdungmuabandogo.activiti.activity_themmathang;
import com.example.ungdungmuabandogo.activiti.activity_tongquansuamathang;
import com.example.ungdungmuabandogo.activiti.activity_tongquanxoa;
import com.example.ungdungmuabandogo.activiti.activity_xemchitiethoadon;
import com.example.ungdungmuabandogo.activiti.activity_tongquanmh;

public class Center extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnthemmh,btnxemchitiethd,btnlogout,btnctKH,btnXoaHang,btnxoadung,btnsuamathang,btnquanlytk;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        drawerLayout = findViewById(R.id.drawer);
//        xulynav();
//        toolbar();
        Anhxa();
        EventButton();
    }

    private void EventButton() {
        btnthemmh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_themmathang.class);
                startActivity(intent);
            }
        });
        btnxemchitiethd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_xemchitiethoadon.class);
                startActivity(intent);
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        btnctKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_chitietKH.class);
                startActivity(intent);
            }
        });
        btnXoaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tongquanmh.class);
                startActivity(intent);
            }
        });
        btnxoadung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tongquanxoa.class);
                startActivity(intent);
            }
        });
        btnsuamathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_tongquansuamathang.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btnthemmh = findViewById(R.id.btnTHEMMATHANG);
        btnxemchitiethd = findViewById(R.id.btnXEMCHITIETHOADON);
        btnlogout = findViewById(R.id.btnLOGOUT);
        btnctKH = findViewById(R.id.btnCTKHACHHANG);
        btnXoaHang = findViewById(R.id.btnXOAMATHANG);
        btnxoadung = findViewById(R.id.btnXOAMATHANGxoa);
        btnsuamathang = findViewById(R.id.btnSUAMATHANG);
    }

//    public void xulynav()
//    {
//        NavigationView navigationView = findViewById(R.id.nav);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.logout:
//                        Intent intent = new Intent(Center.this, Login.class);
//                        startActivity(intent);
//                }
//                return true;
//            }
//        });
//    }
//    public void toolbar()
//    {
//        Toolbar toolbar = findViewById(R.id.toolbar2);
//
//        ActionBarDrawerToggle actionBarDrawerToggle =
//                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.dong,R.string.mo);
//
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//
//        actionBarDrawerToggle.syncState();
//    }


}
