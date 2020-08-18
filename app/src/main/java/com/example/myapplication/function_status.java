package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class function_status extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_status);

        cardView1 = findViewById(R.id.status_use);
        cardView2 = findViewById(R.id.card_lundry);
        cardView3 = findViewById(R.id.card_washing);

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
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this,Main2Activity.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
