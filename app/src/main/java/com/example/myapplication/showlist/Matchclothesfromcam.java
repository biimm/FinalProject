package com.example.myapplication.showlist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.myapplication.Adapter.ListShowresultfromcam;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.SearchClothesfromcam;
import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class Matchclothesfromcam extends AppCompatActivity {

    ImageView mImageView;
    Button ok;
    GridView gridView;


    Clothesmain clothesmain;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> type_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> color1;
    ArrayList<String> color2;
    ArrayList<String> color3;
    ArrayList<String> tone1;
    ArrayList<String> tone2;
    ArrayList<String> tone3;

    String tonecloth_getsc1 = "";
    String tonecloth_getsc2 = "";
    String tonecloth_getsc3 = "";

    String piccloth_getsc = "";
    String typecloth_getsc = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchclothfromcam);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mImageView = findViewById(R.id.image_select);
        ok = findViewById(R.id.use_btn);
        gridView = findViewById(R.id.gridview_result);

        tonecloth_getsc1 = getIntent().getStringExtra("colorTone1");
        tonecloth_getsc2 = getIntent().getStringExtra("colorTone2");
        tonecloth_getsc3 = getIntent().getStringExtra("colorTone3");

        piccloth_getsc = getIntent().getStringExtra("pictofind");
        typecloth_getsc = getIntent().getStringExtra("typecloth");


        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        type_cloth = new ArrayList<>();
        status_cloth = new ArrayList<>();
        color1 = new ArrayList<>();
        color2 = new ArrayList<>();
        color3 = new ArrayList<>();
        tone1 = new ArrayList<>();
        tone2 = new ArrayList<>();
        tone3 = new ArrayList<>();


        clothesmain = new Clothesmain(this);


        final Uri image_uri = Uri.parse(piccloth_getsc);
        mImageView.setImageURI(image_uri);


        System.out.println("Tone from sc :" + tonecloth_getsc1+" " + tonecloth_getsc2 + " "+ tonecloth_getsc3);
        System.out.println("Type from sc :" + typecloth_getsc);

        showdatabase();

        final ListShowresultfromcam listShowresultfromcam = new ListShowresultfromcam(getApplicationContext(), id, pic_cloth, type_cloth, status_cloth, color1, color2, color3, tone1,tone2,tone3);
        gridView.setAdapter(listShowresultfromcam);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Matchclothesfromcam.this , Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void showdatabase(){

        if((tonecloth_getsc1.equals("Black") || tonecloth_getsc2.equals("Black") || tonecloth_getsc3.equals("Black"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม") || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db1 = clothesmain.getWritableDatabase();
            Cursor c1 = db1.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Olive" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Olive" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3= " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Olive" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth1 = c1.getCount();

            if (countresdbcloth1 == 0) {
                return;
            } else {
                while (c1.moveToNext()) {
                    id.add(c1.getString(0));
                    pic_cloth.add(c1.getString(1));
                    status_cloth.add(c1.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("White") || tonecloth_getsc2.equals("White") || tonecloth_getsc3.equals("White"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม") || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db2 = clothesmain.getWritableDatabase();
            Cursor c2 = db2.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or  typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or  typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth2 = c2.getCount();

            if (countresdbcloth2 == 0) {
                return;
            } else {
                while (c2.moveToNext()) {
                    id.add(c2.getString(0));
                    pic_cloth.add(c2.getString(1));
                    status_cloth.add(c2.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Gray") || tonecloth_getsc2.equals("Gray") || tonecloth_getsc3.equals("Gray"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db3 = clothesmain.getWritableDatabase();
            Cursor c3 = db3.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + ")", null);
            int countresdbcloth3 = c3.getCount();

            if (countresdbcloth3 == 0) {
                return;
            } else {
                while (c3.moveToNext()) {
                    id.add(c3.getString(0));
                    pic_cloth.add(c3.getString(1));
                    status_cloth.add(c3.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Navy") || tonecloth_getsc2.equals("Navy") || tonecloth_getsc3.equals("Navy"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db4 = clothesmain.getWritableDatabase();
            Cursor c4 = db4.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2= " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth4 = c4.getCount();

            if (countresdbcloth4 == 0) {
                return;
            } else {
                while (c4.moveToNext()) {
                    id.add(c4.getString(0));
                    pic_cloth.add(c4.getString(1));
                    status_cloth.add(c4.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Red") || tonecloth_getsc2.equals("Red") || tonecloth_getsc3.equals("Red"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db5 = clothesmain.getWritableDatabase();
            Cursor c5 = db5.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth5 = c5.getCount();

            if (countresdbcloth5 == 0) {
                return;
            } else {
                while (c5.moveToNext()) {
                    id.add(c5.getString(0));
                    pic_cloth.add(c5.getString(1));
                    status_cloth.add(c5.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Orange") || tonecloth_getsc2.equals("Orange") || tonecloth_getsc3.equals("Orange"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db6 = clothesmain.getWritableDatabase();
            Cursor c6 = db6.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + ")", null);
            int countresdbcloth6 = c6.getCount();

            if (countresdbcloth6 == 0) {
                return;
            } else {
                while (c6.moveToNext()) {
                    id.add(c6.getString(0));
                    pic_cloth.add(c6.getString(1));
                    status_cloth.add(c6.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Yellow") || tonecloth_getsc2.equals("Yellow") || tonecloth_getsc3.equals("Yellow"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db7 = clothesmain.getWritableDatabase();
            Cursor c7 = db7.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth7 = c7.getCount();

            if (countresdbcloth7 == 0) {
                return;
            } else {
                while (c7.moveToNext()) {
                    id.add(c7.getString(0));
                    pic_cloth.add(c7.getString(1));
                    status_cloth.add(c7.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Green") || tonecloth_getsc2.equals("Green") || tonecloth_getsc3.equals("Green"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db8 = clothesmain.getWritableDatabase();
            Cursor c8 = db8.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " and typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " and typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth8 = c8.getCount();

            if (countresdbcloth8 == 0) {
                return;
            } else {
                while (c8.moveToNext()) {
                    id.add(c8.getString(0));
                    pic_cloth.add(c8.getString(1));
                    status_cloth.add(c8.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Blue") || tonecloth_getsc2.equals("Blue") || tonecloth_getsc3.equals("Blue"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db9 = clothesmain.getWritableDatabase();
            Cursor c9 = db9.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth9 = c9.getCount();

            if (countresdbcloth9 == 0) {
                return;
            } else {
                while (c9.moveToNext()) {
                    id.add(c9.getString(0));
                    pic_cloth.add(c9.getString(1));
                    status_cloth.add(c9.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Purple") || tonecloth_getsc2.equals("Purple") || tonecloth_getsc3.equals("Purple"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db10 = clothesmain.getWritableDatabase();
            Cursor c10 = db10.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + ")", null);
            int countresdbcloth10 = c10.getCount();

            if (countresdbcloth10 == 0) {
                return;
            } else {
                while (c10.moveToNext()) {
                    id.add(c10.getString(0));
                    pic_cloth.add(c10.getString(1));
                    status_cloth.add(c10.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Brown") || tonecloth_getsc2.equals("Brown") || tonecloth_getsc3.equals("Brown"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db11 = clothesmain.getWritableDatabase();
            Cursor c11 = db11.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth11 = c11.getCount();

            if (countresdbcloth11 == 0) {
                return;
            } else {
                while (c11.moveToNext()) {
                    id.add(c11.getString(0));
                    pic_cloth.add(c11.getString(1));
                    status_cloth.add(c11.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Beige") || tonecloth_getsc2.equals("Beige") || tonecloth_getsc3.equals("Beige"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db12 = clothesmain.getWritableDatabase();
            Cursor c12 = db12.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth12 = c12.getCount();

            if (countresdbcloth12 == 0) {
                return;
            } else {
                while (c12.moveToNext()) {
                    id.add(c12.getString(0));
                    pic_cloth.add(c12.getString(1));
                    status_cloth.add(c12.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Tan") || tonecloth_getsc2.equals("Tan") || tonecloth_getsc3.equals("Tan"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db13 = clothesmain.getWritableDatabase();
            Cursor c13 = db13.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth13 = c13.getCount();

            if (countresdbcloth13 == 0) {
                return;
            } else {
                while (c13.moveToNext()) {
                    id.add(c13.getString(0));
                    pic_cloth.add(c13.getString(1));
                    status_cloth.add(c13.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Watercress") || tonecloth_getsc2.equals("Watercress") || tonecloth_getsc3.equals("Watercress"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db14 = clothesmain.getWritableDatabase();
            Cursor c14 = db14.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth14 = c14.getCount();

            if (countresdbcloth14 == 0) {
                return;
            } else {
                while (c14.moveToNext()) {
                    id.add(c14.getString(0));
                    pic_cloth.add(c14.getString(1));
                    status_cloth.add(c14.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightpink") || tonecloth_getsc2.equals("Lightpink") || tonecloth_getsc3.equals("Lightpink"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db16 = clothesmain.getWritableDatabase();
            Cursor c16 = db16.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + ")", null);
            int countresdbcloth16 = c16.getCount();

            if (countresdbcloth16 == 0) {
                return;
            } else {
                while (c16.moveToNext()) {
                    id.add(c16.getString(0));
                    pic_cloth.add(c16.getString(1));
                    status_cloth.add(c16.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("lightcoral") || tonecloth_getsc2.equals("lightcoral") || tonecloth_getsc3.equals("lightcoral"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db17 = clothesmain.getWritableDatabase();
            Cursor c17 = db17.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth17 = c17.getCount();

            if (countresdbcloth17 == 0) {
                return;
            } else {
                while (c17.moveToNext()) {
                    id.add(c17.getString(0));
                    pic_cloth.add(c17.getString(1));
                    status_cloth.add(c17.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightblue") || tonecloth_getsc2.equals("Lightblue") ||tonecloth_getsc3.equals("Lightblue"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db18 = clothesmain.getWritableDatabase();
            Cursor c18 = db18.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth18 = c18.getCount();

            if (countresdbcloth18 == 0) {
                return;
            } else {
                while (c18.moveToNext()) {
                    id.add(c18.getString(0));
                    pic_cloth.add(c18.getString(1));
                    status_cloth.add(c18.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("LightSalmon") || tonecloth_getsc2.equals("LightSalmon") || tonecloth_getsc3.equals("LightSalmon"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db19 = clothesmain.getWritableDatabase();
            Cursor c19 = db19.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "LightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "LightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "LightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth19 = c19.getCount();

            if (countresdbcloth19 == 0) {
                return;
            } else {
                while (c19.moveToNext()) {
                    id.add(c19.getString(0));
                    pic_cloth.add(c19.getString(1));
                    status_cloth.add(c19.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightyellow") || tonecloth_getsc2.equals("Lightyellow") || tonecloth_getsc3.equals("Lightyellow"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db20 = clothesmain.getWritableDatabase();
            Cursor c20 = db20.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "LightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "LightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "LightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth20 = c20.getCount();

            if (countresdbcloth20 == 0) {
                return;
            } else {
                while (c20.moveToNext()) {
                    id.add(c20.getString(0));
                    pic_cloth.add(c20.getString(1));
                    status_cloth.add(c20.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightgreen") || tonecloth_getsc2.equals("Lightgreen") || tonecloth_getsc3.equals("Lightgreen"))
                && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db21 = clothesmain.getWritableDatabase();
            Cursor c21 = db21.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth21 = c21.getCount();

            if (countresdbcloth21 == 0) {
                return;
            } else {
                while (c21.moveToNext()) {
                    id.add(c21.getString(0));
                    pic_cloth.add(c21.getString(1));
                    status_cloth.add(c21.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Black") || tonecloth_getsc2.equals("Black") || tonecloth_getsc3.equals("Black"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db22 = clothesmain.getWritableDatabase();
            Cursor c22 = db22.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Olive" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Olive" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3= " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Olive" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth22 = c22.getCount();
            if (countresdbcloth22 == 0) {
                return;
            } else {
                while (c22.moveToNext()) {
                    id.add(c22.getString(0));
                    pic_cloth.add(c22.getString(1));
                    status_cloth.add(c22.getString(2));
                }
            }

        }

        if((tonecloth_getsc1.equals("White") || tonecloth_getsc2.equals("White") || tonecloth_getsc3.equals("White"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db23 = clothesmain.getWritableDatabase();
            Cursor c23 = db23.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth23 = c23.getCount();
            if (countresdbcloth23 == 0) {
                return;
            } else {
                while (c23.moveToNext()) {
                    id.add(c23.getString(0));
                    pic_cloth.add(c23.getString(1));
                    status_cloth.add(c23.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Gray") || tonecloth_getsc2.equals("Gray") || tonecloth_getsc3.equals("Gray"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db24 = clothesmain.getWritableDatabase();
            Cursor c24 = db24.rawQuery(
                    " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                            + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                            + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                            + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                            + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                            + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                            + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                            + " and " + "(tone1 = " + '"' + "Black" + '"'
                            + " or tone1 = " + '"' + "White" + '"'
                            + " or tone1 = " + '"' + "Gray" + '"'
                            + " or tone1 = " + '"' + "Yellow" + '"'
                            + " or tone1 = " + '"' + "Green" + '"'
                            + " or tone1 = " + '"' + "Navy" + '"'
                            + " or tone1 = " + '"' + "Red" + '"'
                            + " or tone1 = " + '"' + "Brown" + '"'
                            + " or tone1 = " + '"' + "Purple" + '"'
                            + " or tone1 = " + '"' + "Lightpink" + '"'
                            + " or tone2 = " + '"' + "Black" + '"'
                            + " or tone2 = " + '"' + "White" + '"'
                            + " or tone2 = " + '"' + "Gray" + '"'
                            + " or tone2 = " + '"' + "Yellow" + '"'
                            + " or tone2 = " + '"' + "Green" + '"'
                            + " or tone2 = " + '"' + "Navy" + '"'
                            + " or tone2 = " + '"' + "Red" + '"'
                            + " or tone2 = " + '"' + "Brown" + '"'
                            + " or tone2 = " + '"' + "Purple" + '"'
                            + " or tone2 = " + '"' + "Lightpink" + '"'
                            + " or tone3 = " + '"' + "Black" + '"'
                            + " or tone3 = " + '"' + "White" + '"'
                            + " or tone3 = " + '"' + "Gray" + '"'
                            + " or tone3 = " + '"' + "Yellow" + '"'
                            + " or tone3 = " + '"' + "Green" + '"'
                            + " or tone3 = " + '"' + "Navy" + '"'
                            + " or tone3 = " + '"' + "Red" + '"'
                            + " or tone3 = " + '"' + "Brown" + '"'
                            + " or tone3 = " + '"' + "Purple" + '"'
                            + " or tone3 = " + '"' + "Lightpink" + '"'
                            + ")", null);
            int countresdbcloth24 = c24.getCount();
            if (countresdbcloth24 == 0) {
                return;
            } else {
                while (c24.moveToNext()) {
                    id.add(c24.getString(0));
                    pic_cloth.add(c24.getString(1));
                    status_cloth.add(c24.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Navy") || tonecloth_getsc2.equals("Navy") || tonecloth_getsc3.equals("Navy"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db25 = clothesmain.getWritableDatabase();
            Cursor c25 = db25.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2= " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth25 = c25.getCount();
            if (countresdbcloth25 == 0) {
                return;
            } else {
                while (c25.moveToNext()) {
                    id.add(c25.getString(0));
                    pic_cloth.add(c25.getString(1));
                    status_cloth.add(c25.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Red") || tonecloth_getsc2.equals("Red") ||tonecloth_getsc3.equals("Red"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db26 = clothesmain.getWritableDatabase();
            Cursor c26 = db26.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth26 = c26.getCount();
            if (countresdbcloth26 == 0) {
                return;
            } else {
                while (c26.moveToNext()) {
                    id.add(c26.getString(0));
                    pic_cloth.add(c26.getString(1));
                    status_cloth.add(c26.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Orange") || tonecloth_getsc2.equals("Orange") || tonecloth_getsc3.equals("Orange"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db27 = clothesmain.getWritableDatabase();
            Cursor c27 = db27.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "lightSalmon" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "lightSalmon" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "lightSalmon" + '"'
                    + ")", null);
            int countresdbcloth27 = c27.getCount();
            if (countresdbcloth27== 0) {
                return;
            } else {
                while (c27.moveToNext()) {
                    id.add(c27.getString(0));
                    pic_cloth.add(c27.getString(1));
                    status_cloth.add(c27.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Yellow") || tonecloth_getsc2.equals("Yellow") || tonecloth_getsc3.equals("Yellow"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db28 = clothesmain.getWritableDatabase();
            Cursor c28 = db28.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth28 = c28.getCount();
            if (countresdbcloth28 == 0) {
                return;
            } else {
                while (c28.moveToNext()) {
                    id.add(c28.getString(0));
                    pic_cloth.add(c28.getString(1));
                    status_cloth.add(c28.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Green") || tonecloth_getsc2.equals("Green") || tonecloth_getsc3.equals("Green"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db29 = clothesmain.getWritableDatabase();
            Cursor c29 = db29.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth29 = c29.getCount();
            if (countresdbcloth29 == 0) {
                return;
            } else {
                while (c29.moveToNext()) {
                    id.add(c29.getString(0));
                    pic_cloth.add(c29.getString(1));
                    status_cloth.add(c29.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Blue") || tonecloth_getsc2.equals("Blue") || tonecloth_getsc3.equals("Blue"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db31 = clothesmain.getWritableDatabase();
            Cursor c31 = db31.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Blue" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Yellow" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Blue" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Yellow" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Blue" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Yellow" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth31 = c31.getCount();
            if (countresdbcloth31 == 0) {
                return;
            } else {
                while (c31.moveToNext()) {
                    id.add(c31.getString(0));
                    pic_cloth.add(c31.getString(1));
                    status_cloth.add(c31.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Purple") || tonecloth_getsc2.equals("Purple") || tonecloth_getsc3.equals("Purple"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db32 = clothesmain.getWritableDatabase();
            Cursor c32 = db32.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + ")", null);
            int countresdbcloth32 = c32.getCount();
            if (countresdbcloth32 == 0) {
                return;
            } else {
                while (c32.moveToNext()) {
                    id.add(c32.getString(0));
                    pic_cloth.add(c32.getString(1));
                    status_cloth.add(c32.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Brown") || tonecloth_getsc2.equals("Brown") || tonecloth_getsc3.equals("Brown"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db33 = clothesmain.getWritableDatabase();
            Cursor c33 = db33.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth33 = c33.getCount();
            if (countresdbcloth33 == 0) {
                return;
            } else {
                while (c33.moveToNext()) {
                    id.add(c33.getString(0));
                    pic_cloth.add(c33.getString(1));
                    status_cloth.add(c33.getString(2));
                }
            }

        }

        if((tonecloth_getsc1.equals("Beige") || tonecloth_getsc2.equals("Beige") || tonecloth_getsc3.equals("Beige"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db34 = clothesmain.getWritableDatabase();
            Cursor c34 = db34.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Green" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Green" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Green" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth34 = c34.getCount();
            if (countresdbcloth34 == 0) {
                return;
            } else {
                while (c34.moveToNext()) {
                    id.add(c34.getString(0));
                    pic_cloth.add(c34.getString(1));
                    status_cloth.add(c34.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Tan") || tonecloth_getsc2.equals("Tan") || tonecloth_getsc3.equals("Tan"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db35 = clothesmain.getWritableDatabase();
            Cursor c35 = db35.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth35 = c35.getCount();
            if (countresdbcloth35 == 0) {
                return;
            } else {
                while (c35.moveToNext()) {
                    id.add(c35.getString(0));
                    pic_cloth.add(c35.getString(1));
                    status_cloth.add(c35.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Watercress") || tonecloth_getsc2.equals("Watercress") || tonecloth_getsc3.equals("Watercress"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db37 = clothesmain.getWritableDatabase();
            Cursor c37 = db37.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth37 = c37.getCount();
            if (countresdbcloth37 == 0) {
                return;
            } else {
                while (c37.moveToNext()) {
                    id.add(c37.getString(0));
                    pic_cloth.add(c37.getString(1));
                    status_cloth.add(c37.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightpink") || tonecloth_getsc2.equals("Lightpink") ||tonecloth_getsc3.equals("Lightpink"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){

            SQLiteDatabase db38 = clothesmain.getWritableDatabase();
            Cursor c38 = db38.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + ")", null);
            int countresdbcloth38 = c38.getCount();
            if (countresdbcloth38 == 0) {
                return;
            } else {
                while (c38.moveToNext()) {
                    id.add(c38.getString(0));
                    pic_cloth.add(c38.getString(1));
                    status_cloth.add(c38.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("lightcoral") || tonecloth_getsc2.equals("lightcoral") || tonecloth_getsc3.equals("lightcoral"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db39 = clothesmain.getWritableDatabase();
            Cursor c39 = db39.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth39 = c39.getCount();
            if (countresdbcloth39 == 0) {
                return;
            } else {
                while (c39.moveToNext()) {
                    id.add(c39.getString(0));
                    pic_cloth.add(c39.getString(1));
                    status_cloth.add(c39.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightblue") ||tonecloth_getsc2.equals("Lightblue") || tonecloth_getsc3.equals("Lightblue"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db40 = clothesmain.getWritableDatabase();
            Cursor c40 = db40.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Purple" + '"'
                    + " or tone1 = " + '"' + "Red" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Orange" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Purple" + '"'
                    + " or tone2 = " + '"' + "Red" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Orange" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Purple" + '"'
                    + " or tone3 = " + '"' + "Red" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Orange" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth40 = c40.getCount();
            if (countresdbcloth40 == 0) {
                return;
            } else {
                while (c40.moveToNext()) {
                    id.add(c40.getString(0));
                    pic_cloth.add(c40.getString(1));
                    status_cloth.add(c40.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("LightSalmon") || tonecloth_getsc2.equals("LightSalmon") || tonecloth_getsc3.equals("LightSalmon"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db41 = clothesmain.getWritableDatabase();
            Cursor c41 = db41.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "LightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "LightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "LightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth41 = c41.getCount();
            if (countresdbcloth41 == 0) {
                return;
            } else {
                while (c41.moveToNext()) {
                    id.add(c41.getString(0));
                    pic_cloth.add(c41.getString(1));
                    status_cloth.add(c41.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightyellow") ||tonecloth_getsc2.equals("Lightyellow") || tonecloth_getsc3.equals("Lightyellow"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db42 = clothesmain.getWritableDatabase();
            Cursor c42 = db42.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Lightpink" + '"'
                    + " or tone1 = " + '"' + "Lightcoral" + '"'
                    + " or tone1 = " + '"' + "LightSalmon" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightblue" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Lightpink" + '"'
                    + " or tone2 = " + '"' + "Lightcoral" + '"'
                    + " or tone2 = " + '"' + "LightSalmon" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightblue" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Lightpink" + '"'
                    + " or tone3 = " + '"' + "Lightcoral" + '"'
                    + " or tone3 = " + '"' + "LightSalmon" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightblue" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth42 = c42.getCount();
            if (countresdbcloth42 == 0) {
                return;
            } else {
                while (c42.moveToNext()) {
                    id.add(c42.getString(0));
                    pic_cloth.add(c42.getString(1));
                    status_cloth.add(c42.getString(2));
                }
            }
        }

        if((tonecloth_getsc1.equals("Lightgreen") || tonecloth_getsc2.equals("Lightgreen") || tonecloth_getsc3.equals("Lightgreen"))
                && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db43 = clothesmain.getWritableDatabase();
            Cursor c43 = db43.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(tone1 = " + '"' + "Black" + '"'
                    + " or tone1 = " + '"' + "White" + '"'
                    + " or tone1 = " + '"' + "Gray" + '"'
                    + " or tone1 = " + '"' + "Navy" + '"'
                    + " or tone1 = " + '"' + "Brown" + '"'
                    + " or tone1 = " + '"' + "Beige" + '"'
                    + " or tone1 = " + '"' + "Tan" + '"'
                    + " or tone1 = " + '"' + "Watercress" + '"'
                    + " or tone1 = " + '"' + "Lightyellow" + '"'
                    + " or tone1 = " + '"' + "Lightgreen" + '"'
                    + " or tone2 = " + '"' + "Black" + '"'
                    + " or tone2 = " + '"' + "White" + '"'
                    + " or tone2 = " + '"' + "Gray" + '"'
                    + " or tone2 = " + '"' + "Navy" + '"'
                    + " or tone2 = " + '"' + "Brown" + '"'
                    + " or tone2 = " + '"' + "Beige" + '"'
                    + " or tone2 = " + '"' + "Tan" + '"'
                    + " or tone2 = " + '"' + "Watercress" + '"'
                    + " or tone2 = " + '"' + "Lightyellow" + '"'
                    + " or tone2 = " + '"' + "Lightgreen" + '"'
                    + " or tone3 = " + '"' + "Black" + '"'
                    + " or tone3 = " + '"' + "White" + '"'
                    + " or tone3 = " + '"' + "Gray" + '"'
                    + " or tone3 = " + '"' + "Navy" + '"'
                    + " or tone3 = " + '"' + "Brown" + '"'
                    + " or tone3 = " + '"' + "Beige" + '"'
                    + " or tone3 = " + '"' + "Tan" + '"'
                    + " or tone3 = " + '"' + "Watercress" + '"'
                    + " or tone3 = " + '"' + "Lightyellow" + '"'
                    + " or tone3 = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth43 = c43.getCount();
            if (countresdbcloth43 == 0) {
                return;
            } else {
                while (c43.moveToNext()) {
                    id.add(c43.getString(0));
                    pic_cloth.add(c43.getString(1));
                    status_cloth.add(c43.getString(2));
                }
            }
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this, SearchClothesfromcam.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }

}
