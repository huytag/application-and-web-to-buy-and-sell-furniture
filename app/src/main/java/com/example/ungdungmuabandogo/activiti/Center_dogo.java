package com.example.ungdungmuabandogo.activiti;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.Toolbar;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ungdungmuabandogo.Login;
import com.example.ungdungmuabandogo.R;
import com.example.ungdungmuabandogo.adapter.LoaispAdapter;
import com.example.ungdungmuabandogo.adapter.SanphamAdapter;
import com.example.ungdungmuabandogo.model.GioHang;
import com.example.ungdungmuabandogo.model.Loaisp;
import com.example.ungdungmuabandogo.model.Sanpham;
import com.example.ungdungmuabandogo.ultil.Checkconnecttion;
import com.example.ungdungmuabandogo.ultil.Sever;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Center_dogo extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanghinhchinh;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    public static ArrayList<GioHang> manggiohang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_center_dogo);
       if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
           Anhxa();
           toolbar();
           ActionViewFliper();
           GetDulieuloaisp();
           GetDulieuSPMoiNhat();
           CatchOnItemListView();
       }else
       {
           Checkconnecttion.showToast_Short(getApplicationContext(),"ban hay kiem tra lai ket noi");
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

    private void CatchOnItemListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, Center_dogo.class);
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, activity_bango.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, acticity_ghego.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, activity_tugo.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, activity_moctreo.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, activity_banthogo.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, activiti_giohang.class);
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 7:
                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(Center_dogo.this, Login.class);
                            startActivity(intent);
                        }else
                        {
                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
//                    case 8:
//                        if(Checkconnecttion.haveNetworkConnection(getApplicationContext())){
//                            Intent intent = new Intent(Center_dogo.this, Center_dogo.class);
//                            startActivity(intent);
//                        }else
//                        {
//                            Checkconnecttion.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
//                        }
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
                }
            }
        });
    }

    private void GetDulieuSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.Duongdanspmoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for(int i = 0 ; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("tensanpham");
                            Giasanpham = jsonObject.getInt("giasanpham");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                            Motasanpham = jsonObject.getString("motasanpham");
                            IDsanpham = jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Checkconnecttion.showToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDulieuloaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.DuongdanLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for(int i = 0 ; i < response.length(); i ++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenloaisanpham");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisanpham");
                            mangloaisp.add(new Loaisp(id,tenloaisp,hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaisp.add(6, new Loaisp(0,"Giỏ Hàng","http://pngimg.com/uploads/shopping_cart/shopping_cart_PNG42.png"));
                    mangloaisp.add(7, new Loaisp(0,"Login","https://marketplace.magento.com/media/catalog/product/cache/603f9e977a3dc35468ba3ae89ddfbb29/l/o/login-as-customer-kiwicommerce_1_5_12.png"));
//                    mangloaisp.add(8, new Loaisp(0,"Thông Tin","https://png.pngtree.com/png-clipart/20190520/original/pngtree-info-icon-png-image_3550246.jpg"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Checkconnecttion.showToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFliper() {
            ArrayList<String> mangquangcao = new ArrayList<>();
            mangquangcao.add("https://dogoquanthong.files.wordpress.com/2014/09/tat1392435154.jpg");
            mangquangcao.add("https://xuongdogogiagoc.com/wp-content/uploads/2020/04/ban-an-hinh-chu-nhat-8-375x281.jpg");
            mangquangcao.add("https://thumuaphelieusatvun.com/wp-content/uploads/2017/05/do-go-cu.jpg");
            mangquangcao.add("https://dogoquoccuong.com/wp-content/uploads/2020/11/Ban-ghe-minh-nghe-go-huong-tay-17-6.jpg");
            for(int i = 0; i < mangquangcao.size() ;i++ )
            {
                ImageView imageView = new ImageView(getApplicationContext());
                Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(5000);
            viewFlipper.setAutoStart(true);
            Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.silde_in_right);
            Animation  animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
            viewFlipper.setInAnimation(animation_slide_in);
            viewFlipper.setOutAnimation(animation_slide_out);
        }

    public void toolbar()
    {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarmanghinhchinh);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.dong,R.string.mo);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

        public void Anhxa() {
            viewFlipper = findViewById(R.id.viewfliper);
            recyclerViewmanghinhchinh = findViewById(R.id.recyclerview);
            navigationView = findViewById(R.id.navigationview);
            listView = findViewById(R.id.listviewmanghinhchinh);
            drawerLayout = findViewById(R.id.drawerlayout);
            mangloaisp = new ArrayList<>();
            mangloaisp.add(0, new Loaisp(0,"Trang Chính","https://edemy.edu.vn/wp-content/uploads/2017/08/home-icon.png"));
            loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
            listView.setAdapter(loaispAdapter);
            mangsanpham = new ArrayList<>();
            sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangsanpham);
            recyclerViewmanghinhchinh.setHasFixedSize(true);
            recyclerViewmanghinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            recyclerViewmanghinhchinh.setAdapter(sanphamAdapter);
            if(manggiohang !=null ){

            }else{
                manggiohang = new ArrayList<>();
            }
        }
}




