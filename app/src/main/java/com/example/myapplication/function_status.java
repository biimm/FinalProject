package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.showlist.LundryStatus;
import com.example.myapplication.showlist.MatchCloth;
import com.example.myapplication.showlist.UseStatus;
import com.example.myapplication.showlist.WashStatus;
import com.example.myapplication.showlist.showall;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class function_status extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CardView cardView1,cardView2,cardView3,cardView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_status);

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

        cardView = findViewById(R.id.card_all);
        cardView1 = findViewById(R.id.status_use);
        cardView2 = findViewById(R.id.card_lundry);
        cardView3 = findViewById(R.id.card_washing);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function_status.this , showall.class);
                startActivity(intent);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function_status.this , UseStatus.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function_status.this , LundryStatus.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"card2" , Toast.LENGTH_SHORT).show();
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function_status.this , WashStatus.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"card3" , Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
            this.finish();
            Intent in = new Intent(this, Main2Activity.class);
            in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(in);
        }


//        this.finish();
//        Intent in = new Intent(this,MainActivity.class);
//        startActivity(in);
//        overridePendingTransition(0,0);
//        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        // moveTaskToBack(true);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(function_status.this , Main2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                break;
            case R.id.nav_add:
                Intent intent1 = new Intent(function_status.this , Main3Activity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent1);
                break;
            case R.id.nav_show:
                Intent intent2 = new Intent(function_status.this , Main5Activity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
            case R.id.nav_all:
                Intent intent3 = new Intent(function_status.this , showall.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent3);
            case R.id.nav_use:
                Intent intent4 = new Intent(function_status.this , UseStatus.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                break;
            case R.id.nav_basket:
                Intent intent5 = new Intent(function_status.this, LundryStatus.class);
                intent5.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent5);
                break;
            case R.id.nav_wash:
                Intent intent6 = new Intent(function_status.this , WashStatus.class);
                intent6.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent6);
            case R.id.nav_search:
                Intent intent7 = new Intent(function_status.this , SearchClothesfromcam.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent7);
            case R.id.nav_match:
                Intent intent8 = new Intent(function_status.this , MatchCloth.class);
                intent8.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent8);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
