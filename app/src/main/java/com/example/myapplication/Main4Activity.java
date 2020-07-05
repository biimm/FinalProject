package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sptype,spstatus;
    ImageView mImageView;
    Button adddata;
//   CheckBox checkBox;
    TextView textView;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        sptype = (Spinner) findViewById(R.id.sptype);
        spstatus = (Spinner) findViewById(R.id.spstatus);
        mImageView = findViewById(R.id.image_view);
        adddata = (Button) findViewById(R.id.btn_add);
//        checkBox = (CheckBox) findViewById(R.id.checkBox4);
        textView = (TextView) findViewById(R.id.textView);

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

        /////// get image from Mainactivity
        Uri image_uri = Uri.parse(getIntent().getExtras().getString("image_uri"));
        mImageView.setImageURI(image_uri);

        ////// get check



        /////// Spinner type
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptype.setAdapter(adapter);
        sptype.setOnItemSelectedListener(this);

        ////// Spinner status
        ArrayAdapter<CharSequence> adapterstatus = ArrayAdapter.createFromResource(this,R.array.Spinner_Status,android.R.layout.simple_spinner_item);
        adapterstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spstatus.setAdapter(adapterstatus);
        spstatus.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}