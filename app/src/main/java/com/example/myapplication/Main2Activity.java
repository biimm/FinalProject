package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.showlist.LundryStatus;
import com.example.myapplication.showlist.MatchCloth;
import com.example.myapplication.showlist.UseStatus;
import com.example.myapplication.showlist.WashStatus;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CardView cardView1,cardView2,cardView3,cardView4;



    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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



        cardView1 = (CardView) findViewById(R.id.card_cloth);
        cardView2 = (CardView) findViewById(R.id.card_list);
        cardView3 = (CardView) findViewById(R.id.card_status);
        cardView4 = (CardView) findViewById(R.id.card_match);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,function_status.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, FindClothes.class);
                startActivity(intent);

            }
        });
    }



    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }


//        this.finish();
//        Intent in = new Intent(this,MainActivity.class);
//        startActivity(in);
//        overridePendingTransition(0,0);
//        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        // moveTaskToBack(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(Main2Activity.this , Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.nav_add:
                Intent intent1 = new Intent(Main2Activity.this , Main3Activity.class);
                startActivity(intent1);
                break;
            case R.id.nav_show:
                Intent intent2 = new Intent(Main2Activity.this , Main5Activity.class);
                startActivity(intent2);
                break;
            case R.id.nav_use:
                Intent intent3 = new Intent(Main2Activity.this , UseStatus.class);
                startActivity(intent3);
                break;
            case R.id.nav_basket:
                Intent intent4 = new Intent(Main2Activity.this, LundryStatus.class);
                startActivity(intent4);
                break;
            case R.id.nav_wash:
                Intent intent5 = new Intent(Main2Activity.this , WashStatus.class);
                startActivity(intent5);
            case R.id.nav_search:
                Intent intent6 = new Intent(Main2Activity.this , SearchClothesfromcam.class);
                startActivity(intent6);
            case R.id.nav_match:
                Intent intent7 = new Intent(Main2Activity.this , MatchCloth.class);
                startActivity(intent7);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
