package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.showlist.Listclothes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main5Activity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,cardView9,cardView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this,Main2Activity.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
