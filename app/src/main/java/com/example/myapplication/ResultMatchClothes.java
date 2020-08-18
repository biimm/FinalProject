package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultMatchClothes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_match_clothes);
    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this,MatchCloth.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
