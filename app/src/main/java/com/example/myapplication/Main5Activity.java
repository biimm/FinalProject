package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.showlist.Listclothes;
import com.example.myapplication.showlist.LundryStatus;
import com.example.myapplication.showlist.MatchCloth;
import com.example.myapplication.showlist.UseStatus;
import com.example.myapplication.showlist.WashStatus;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Main5Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,cardView9,cardView10;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /// toolbar
        setSupportActionBar(toolbar);


        //////// nevigation Drawer Menu /////////



        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);


        cardView1 = (CardView)findViewById(R.id.card1);
        cardView2 = (CardView)findViewById(R.id.card2);
        cardView3 = (CardView)findViewById(R.id.card3);
        cardView4 = (CardView)findViewById(R.id.card4);
        cardView5 = (CardView)findViewById(R.id.card5);
        cardView6 = (CardView)findViewById(R.id.card6);
        cardView7 = (CardView)findViewById(R.id.card7);
        cardView8 = (CardView)findViewById(R.id.card8);
        cardView9 = (CardView)findViewById(R.id.card9);
        cardView10 = (CardView)findViewById(R.id.card10);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Main5Activity.this, Listclothes.class);
               intent.putExtra("name_type","เสื้อยืดแขนสั้น");
               startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card1",Toast.LENGTH_SHORT).show();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","เสื้อยืดแขนยาว");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card2",Toast.LENGTH_SHORT).show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","เสื้อเชิ้ตแขนสั้น");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card3",Toast.LENGTH_SHORT).show();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","เสื้อเชิ้ตแขนยาว");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card4",Toast.LENGTH_SHORT).show();
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","เสื้อไหมพรม");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card5",Toast.LENGTH_SHORT).show();
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","ชุดเดรส");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card6",Toast.LENGTH_SHORT).show();
            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","กางเกงขายาว");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card7",Toast.LENGTH_SHORT).show();
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","กางเกงขาสั้น");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card8",Toast.LENGTH_SHORT).show();
            }
        });

        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","กระโปรง");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card9",Toast.LENGTH_SHORT).show();
            }
        });

        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Listclothes.class);
                intent.putExtra("name_type","แจ็คเก็ต");
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"select card10",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(Main5Activity.this , Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.nav_add:
                Intent intent1 = new Intent(Main5Activity.this , Main3Activity.class);
                startActivity(intent1);
                break;
            case R.id.nav_show:
                Intent intent2 = new Intent(Main5Activity.this , Main5Activity.class);
                startActivity(intent2);
                break;
            case R.id.nav_use:
                Intent intent3 = new Intent(Main5Activity.this , UseStatus.class);
                startActivity(intent3);
                break;
            case R.id.nav_basket:
                Intent intent4 = new Intent(Main5Activity.this, LundryStatus.class);
                startActivity(intent4);
                break;
            case R.id.nav_wash:
                Intent intent5 = new Intent(Main5Activity.this , WashStatus.class);
                startActivity(intent5);
            case R.id.nav_search:
                Intent intent6 = new Intent(Main5Activity.this , SearchClothesfromcam.class);
                startActivity(intent6);
            case R.id.nav_match:
                Intent intent7 = new Intent(Main5Activity.this , MatchCloth.class);
                startActivity(intent7);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
