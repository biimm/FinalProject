package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.showlist.Matchclothesfromcam;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SearchClothesfromcam2 extends AppCompatActivity {

    Spinner sptype;
    ImageView mImageView;
    Button searchdata;
    TextView textViewc1,textViewc2,textViewc3,txt1;

    String datatype;

    byte[] testimg;

    String testimg1= "";
    String V01 = "#0";
    String V02 = "#0";
    String V03 = "#0";
    String tone = "";

    String formattedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takepictofind2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sptype = (Spinner) findViewById(R.id.sptype);
        mImageView = findViewById(R.id.image_view);
        searchdata = (Button) findViewById(R.id.btn_search);
        textViewc1 = (TextView) findViewById(R.id.textViewc1);
        textViewc2 = (TextView) findViewById(R.id.textViewc2);
        textViewc3 = (TextView) findViewById(R.id.textViewc3);
        txt1 = (TextView) findViewById(R.id.txt1);

        testimg = new byte[0];

        /////// get image from Main3activity
        testimg1 = getIntent().getExtras().getString("image");
        final Uri image_uri = Uri.parse(testimg1);
        mImageView.setImageURI(image_uri);
        testimg = imageViewToByte(mImageView);



        tone = getIntent().getStringExtra("color_name");
        System.out.print("tonecam2 : " + tone);

        ////// get check color
        Intent bundle = getIntent();
        V01 = bundle.getStringExtra("color1");
        if (V01.equals("#0") ) {
            textViewc1.setVisibility(View.GONE);
        } else {
            textViewc1.setBackgroundColor(Color.parseColor(V01));
        }

        V02 = bundle.getStringExtra("color2");
        if (V02.equals("#0") ) {
            textViewc2.setVisibility(View.GONE);
        } else {
            textViewc2.setBackgroundColor(Color.parseColor(V02));
        }

        V03 = bundle.getStringExtra("color3");
        if (V03.equals("#0") ) {
            textViewc3.setVisibility(View.GONE);
        } else {
            textViewc3.setBackgroundColor(Color.parseColor(V03));
        }

        /////// Spinner type
        ArrayAdapter<CharSequence> adaptertype = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
        adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptype.setAdapter(adaptertype);
        sptype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datatype = (String) parent.getItemAtPosition(position);
//               Toast.makeText(getApplicationContext(),"Select type : "+datatype,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



        searchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(SearchClothesfromcam2.this, Matchclothesfromcam.class);
                    intent.putExtra("pictofind" , testimg1);
                    intent.putExtra("typecloth" , datatype);
                    intent.putExtra("colorTone" , tone);
                    startActivity(intent);

            }
        });
    }

    public byte[] imageViewToByte(ImageView mImageView) {
        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }




}
