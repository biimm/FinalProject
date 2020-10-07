package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.connectDB.ColorClothes;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH1;
import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH2;
import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH3;
import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_TONE;
import static com.example.myapplication.connectDB.Clothesmaininterface.DATE_CLOTH;
import static com.example.myapplication.connectDB.Clothesmaininterface.PIC_CLOTH;
import static com.example.myapplication.connectDB.Clothesmaininterface.STATUS_CLOTH;
import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;
import static com.example.myapplication.connectDB.Clothesmaininterface.TYPE_CLOTH;
import static com.example.myapplication.connectDB.ColorClothesinterface.TABLE_NAME5;

public class Main4Activity extends AppCompatActivity {
    Spinner sptype,spstatus;
    ImageView mImageView;
    Button adddata;
    EditText edtdate;
    TextView textViewc1,textViewc2,textViewc3,txt1,txt2;

    Clothesmain clothesmain;
    ColorClothes colorclothes;
    ColorTone colorTone;

    String datatype , datastatus;

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
        setContentView(R.layout.activity_main4);

        sptype = (Spinner) findViewById(R.id.sptype);
        spstatus = (Spinner) findViewById(R.id.spstatus);
        mImageView = findViewById(R.id.image_view);
        edtdate = (EditText) findViewById(R.id.edtdate);
        adddata = (Button) findViewById(R.id.btn_add);
        textViewc1 = (TextView) findViewById(R.id.textViewc1);
        textViewc2 = (TextView) findViewById(R.id.textViewc2);
        textViewc3 = (TextView) findViewById(R.id.textViewc3);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);

        testimg = new byte[0];

        clothesmain = new Clothesmain(getApplicationContext());
        colorclothes = new ColorClothes(getApplicationContext());

        /////// get image from Main3activity
        testimg1 = getIntent().getExtras().getString("image");
        final Uri image_uri = Uri.parse(testimg1);
        mImageView.setImageURI(image_uri);
        testimg = imageViewToByte(mImageView);



        tone = getIntent().getStringExtra("colorname");

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


        ////// Spinner status
        ArrayAdapter<CharSequence> adapterstatus = ArrayAdapter.createFromResource(this,R.array.Spinner_Status,android.R.layout.simple_spinner_item);
        adapterstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spstatus.setAdapter(adapterstatus);
        spstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 datastatus = (String) parent.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),"Select status : "+datastatus,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = df.format(c.getTime()).toString();
        edtdate.setText(formattedDate);

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datatype.equals("โปรดเลือกประเภทเสื้อผ้า")|| datastatus.equals("โปรดเลือกสถานะเสื้อผ้า") ){
                    if(datatype.equals("โปรดเลือกประเภทเสื้อผ้า")){
                        txt1.setText("กรุณาเลือกประเภทเสื้อผ้า");
                    }
                    else{
                        txt1.setText("");
                    }
                    if(datastatus.equals("โปรดเลือกสถานะเสื้อผ้า")){
                        txt2.setText("กรุณาเลือกสถานะเสื้อผ้า");
                    }
                    else{
                        txt2.setText("");
                    }
                }
                else {
                    saveClothes();
                    saveColor();
                    Toast.makeText(getApplicationContext() , "เพิ่มข้อมูลสำเร็จ" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Main4Activity.this, Main2Activity.class);
                    startActivity(intent);
                }
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


    public void saveClothes(){

        /// add to Clothesmain
        SQLiteDatabase dbclothesmain = clothesmain.getWritableDatabase();
        ContentValues adddbclothesmain = new ContentValues();
        adddbclothesmain.put(PIC_CLOTH, testimg1);
        adddbclothesmain.put(TYPE_CLOTH, datatype);
        adddbclothesmain.put(DATE_CLOTH, formattedDate);
        adddbclothesmain.put(STATUS_CLOTH, datastatus);
        adddbclothesmain.put(COLOR_CLOTH1 , V01);
        adddbclothesmain.put(COLOR_CLOTH2 , V02);
        adddbclothesmain.put(COLOR_CLOTH3 , V03);
        adddbclothesmain.put(COLOR_TONE , tone);
        dbclothesmain.insertOrThrow(TABLE_NAME1,null,adddbclothesmain);
    }

    public void saveColor(){
        /// add color to ColorClothes
        SQLiteDatabase dbcclothcolor = colorclothes.getWritableDatabase();
        ContentValues addcolor = new ContentValues();
        addcolor.put(PIC_CLOTH , testimg1);
        addcolor.put(COLOR_CLOTH1 , V01);
        addcolor.put(COLOR_CLOTH2 , V02);
        addcolor.put(COLOR_CLOTH3 , V03);
        addcolor.put(COLOR_TONE , tone);
        dbcclothcolor.insertOrThrow(TABLE_NAME5 , null , addcolor);
    }








}