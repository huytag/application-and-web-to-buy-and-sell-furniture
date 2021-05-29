package com.example.ungdungmuabandogo.activiti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.ungdungmuabandogo.Center;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.model.GioHang;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public class activity_chitietsanpham extends AppCompatActivity {
    ImageView imageViewchitiet;
    TextView textViewten,textViewgia,textViewmota;
    Spinner spinner;
    Button btndatmua;
    int id =0;
    String Tenchitiet = "";
    int Giachitiet = 0;
    String Hinhanhchitiet = "";
    String Motachitiet = "";
    int Idsanpham = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        Anhxa();
        ActionTooolbar();
        GetInformattion();
        CatchEvenSpinner();
        EventBtn();
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

    private void EventBtn() {
        btndatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Center_dogo.manggiohang.size() >0){
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists = false;
                    for (int i = 0; i < Center_dogo.manggiohang.size(); i ++){
                        if(Center_dogo.manggiohang.get(i).getIdsp() == id){
                            Center_dogo.manggiohang.get(i).setSoluongsp(Center_dogo.manggiohang.get(i).getSoluongsp() + sl);
                            //Nếu số lượng san phẩm quá 10 thì chỉ lấy 10 sản phẩm
                            if (Center_dogo.manggiohang.get(i).getSoluongsp() >= 10){
                                Center_dogo.manggiohang.get(i).setSoluongsp(10);
                            }
                            Center_dogo.manggiohang.get(i).setGiasp(Giachitiet * Center_dogo.manggiohang.get(i).getSoluongsp());
                            exists = true;
                        }
                    }
                    if(exists == false){
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        long Giamoi = soluong * Giachitiet;
                        Center_dogo.manggiohang.add(new GioHang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));
                    }
                }else {
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi = soluong * Giachitiet;
                    Center_dogo.manggiohang.add(new GioHang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));
                }
                Intent intent = new Intent(getApplicationContext(),activiti_giohang.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEvenSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformattion() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getID();
        Tenchitiet = sanpham.getTensanpham();
        Giachitiet = sanpham.getGiasanpham();
        Hinhanhchitiet = sanpham.getHinhanhsanpham();
        Motachitiet = sanpham.getMotasanpham();
        Idsanpham = sanpham.getIDSanpham();

        textViewten.setText(Tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        textViewgia.setText("Giá: " + decimalFormat.format(Giachitiet) + "Đ");
        textViewmota.setText(Motachitiet);
        Picasso.with(getApplicationContext()).load(Hinhanhchitiet)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imageViewchitiet);
    }

    private void ActionTooolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarchitietsanpham);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private void Anhxa() {
        imageViewchitiet = findViewById(R.id.imgchitietsanpham);
        textViewten = findViewById(R.id.textviewtenchitietsanpham);
        textViewgia = findViewById(R.id.textviewgiachitietsanpham);
        textViewmota = findViewById(R.id.textviewmotachitietsanpham);
        spinner = findViewById(R.id.spinner);
        btndatmua = findViewById(R.id.buttondatmua);
    }
}