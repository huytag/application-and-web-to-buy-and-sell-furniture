package com.example.ungdungmuabandogo.activiti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.adapter.GioHang_Adapter;
import com.example.ungdungmuabandogo.model.GioHang;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;

import java.text.DecimalFormat;

public class activiti_giohang extends AppCompatActivity {
    ListView listViewgh;
    TextView txtthongbao;
    static TextView txttongtien;
    Button  btnthanhtoan,btntieptucmua;
    GioHang_Adapter gioHang_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_giohang);
        ActionTooolbar();
//        CheckData();
        Anhxa();
        EvenUltil();
        EvenMUAHANGTIEPTUC();
        CatchOnItemListView();
    }

    private void CatchOnItemListView() {
        listViewgh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activiti_giohang.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Center_dogo.manggiohang.remove(position);
                            gioHang_adapter.notifyDataSetChanged();
                            EvenUltil();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            gioHang_adapter.notifyDataSetChanged();
                            EvenUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    private void EvenMUAHANGTIEPTUC() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Center_dogo.class);
                startActivity(intent);
            }
        });
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Center_dogo.manggiohang.size() > 0){
                    Intent intent = new Intent(getApplicationContext(),activity_thongtinkhachhang.class);
                    startActivity(intent);
                }else {
                    Checkconnecttion.showToast_Short(getApplicationContext(),"Giỏ hàng của bạn đang trống");
                }
            }
        });
    }

    public static void EvenUltil() {
        long tongtien = 0;
        for(int i = 0 ; i <Center_dogo.manggiohang.size(); i++){
            tongtien +=Center_dogo.manggiohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien) + "Đ");
    }

//    private void CheckData() {
//        if(Center_dogo.manggiohang.size() >= 1 ){
//            txtthongbao.setVisibility(View.VISIBLE);
//            listViewgh.setVisibility(View.INVISIBLE);
//        }else{
//            txtthongbao.setVisibility(View.INVISIBLE);
//            listViewgh.setVisibility(View.VISIBLE);
//        }
//    }


    private void Anhxa() {
        listViewgh = findViewById(R.id.lstGioHang);
//        txtthongbao = findViewById(R.id.texviewthongbaogiohang);
        txttongtien = findViewById(R.id.txttongtiengiohang);
        btnthanhtoan = findViewById(R.id.btnThanhtoangiohang);
        btntieptucmua = findViewById(R.id.btnTieptucmuahang);
        gioHang_adapter = new GioHang_Adapter(activiti_giohang.this,Center_dogo.manggiohang);
        listViewgh.setAdapter(gioHang_adapter);

    }

    private void ActionTooolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toobargiohang);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Giỏ hàng");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}