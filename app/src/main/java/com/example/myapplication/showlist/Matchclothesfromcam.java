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
    ArrayList<String> tone;


    String tonecloth_getsc = "";
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

        tonecloth_getsc = getIntent().getStringExtra("colorTone");
        piccloth_getsc = getIntent().getStringExtra("pictofind");
        typecloth_getsc = getIntent().getStringExtra("typecloth");


        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        type_cloth = new ArrayList<>();
        status_cloth = new ArrayList<>();
        color1 = new ArrayList<>();
        color2 = new ArrayList<>();
        color3 = new ArrayList<>();
        tone = new ArrayList<>();

        clothesmain = new Clothesmain(this);


        final Uri image_uri = Uri.parse(piccloth_getsc);
        mImageView.setImageURI(image_uri);


        System.out.println("Tone from sc :" + tonecloth_getsc);
        System.out.println("Type from sc :" + typecloth_getsc);

        showdatabase();

        final ListShowresultfromcam listShowresultfromcam = new ListShowresultfromcam(getApplicationContext(), id, pic_cloth, type_cloth, status_cloth, color1, color2, color3, tone);
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

        if(tonecloth_getsc.equals("Black") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db1 = clothesmain.getWritableDatabase();
            Cursor cursor1 = db1.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Olive" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth1 = cursor1.getCount();

            if (countresdbcloth1 == 0) {
                return;
            } else {
                while (cursor1.moveToNext()) {
                    id.add(cursor1.getString(0));
                    pic_cloth.add(cursor1.getString(1));
                    tone.add(cursor1.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("White") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db2 = clothesmain.getWritableDatabase();
            Cursor cursor2 = db2.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or  typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or  typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Black" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth2 = cursor2.getCount();

            if (countresdbcloth2 == 0) {
                return;
            } else {
                while (cursor2.moveToNext()) {
                    id.add(cursor2.getString(0));
                    pic_cloth.add(cursor2.getString(1));
                    tone.add(cursor2.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Gray") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น")
                || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม") || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db3 = clothesmain.getWritableDatabase();
            Cursor cursor3 = db3.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + ")", null);
            int countresdbcloth3 = cursor3.getCount();

            if (countresdbcloth3 == 0) {
                return;
            } else {
                while (cursor3.moveToNext()) {
                    id.add(cursor3.getString(0));
                    pic_cloth.add(cursor3.getString(1));
                    tone.add(cursor3.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Navy") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db4 = clothesmain.getWritableDatabase();
            Cursor cursor4 = db4.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth4 = cursor4.getCount();

            if (countresdbcloth4 == 0) {
                return;
            } else {
                while (cursor4.moveToNext()) {
                    id.add(cursor4.getString(0));
                    pic_cloth.add(cursor4.getString(1));
                    tone.add(cursor4.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Red") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db5 = clothesmain.getWritableDatabase();
            Cursor cursor5 = db5.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"' + ")", null);
            int countresdbcloth5 = cursor5.getCount();

            if (countresdbcloth5 == 0) {
                return;
            } else {
                while (cursor5.moveToNext()) {
                    id.add(cursor5.getString(0));
                    pic_cloth.add(cursor5.getString(1));
                    tone.add(cursor5.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Orange") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db6 = clothesmain.getWritableDatabase();
            Cursor cursor6 = db6.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
                    + ")", null);
            int countresdbcloth6 = cursor6.getCount();

            if (countresdbcloth6 == 0) {
                return;
            } else {
                while (cursor6.moveToNext()) {
                    id.add(cursor6.getString(0));
                    pic_cloth.add(cursor6.getString(1));
                    tone.add(cursor6.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Yellow") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db7 = clothesmain.getWritableDatabase();
            Cursor cursor7 = db7.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth7 = cursor7.getCount();

            if (countresdbcloth7 == 0) {
                return;
            } else {
                while (cursor7.moveToNext()) {
                    id.add(cursor7.getString(0));
                    pic_cloth.add(cursor7.getString(1));
                    tone.add(cursor7.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Green") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db8 = clothesmain.getWritableDatabase();
            Cursor cursor8 = db8.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " and typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " and typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth8 = cursor8.getCount();

            if (countresdbcloth8 == 0) {
                return;
            } else {
                while (cursor8.moveToNext()) {
                    id.add(cursor8.getString(0));
                    pic_cloth.add(cursor8.getString(1));
                    tone.add(cursor8.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Blue") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db9 = clothesmain.getWritableDatabase();
            Cursor cursor9 = db9.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth9 = cursor9.getCount();

            if (countresdbcloth9 == 0) {
                return;
            } else {
                while (cursor9.moveToNext()) {
                    id.add(cursor9.getString(0));
                    pic_cloth.add(cursor9.getString(1));
                    tone.add(cursor9.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Purple") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db10 = clothesmain.getWritableDatabase();
            Cursor cursor10 = db10.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + ")", null);
            int countresdbcloth10 = cursor10.getCount();

            if (countresdbcloth10 == 0) {
                return;
            } else {
                while (cursor10.moveToNext()) {
                    id.add(cursor10.getString(0));
                    pic_cloth.add(cursor10.getString(1));
                    tone.add(cursor10.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Brown") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db11 = clothesmain.getWritableDatabase();
            Cursor cursor11 = db11.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth11 = cursor11.getCount();

            if (countresdbcloth11 == 0) {
                return;
            } else {
                while (cursor11.moveToNext()) {
                    id.add(cursor11.getString(0));
                    pic_cloth.add(cursor11.getString(1));
                    tone.add(cursor11.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Beige") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db12 = clothesmain.getWritableDatabase();
            Cursor cursor12 = db12.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth12 = cursor12.getCount();

            if (countresdbcloth12 == 0) {
                return;
            } else {
                while (cursor12.moveToNext()) {
                    id.add(cursor12.getString(0));
                    pic_cloth.add(cursor12.getString(1));
                    tone.add(cursor12.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Tan") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db13 = clothesmain.getWritableDatabase();
            Cursor cursor13 = db13.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + ")", null);
            int countresdbcloth13 = cursor13.getCount();

            if (countresdbcloth13 == 0) {
                return;
            } else {
                while (cursor13.moveToNext()) {
                    id.add(cursor13.getString(0));
                    pic_cloth.add(cursor13.getString(1));
                    tone.add(cursor13.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Watercress") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db14 = clothesmain.getWritableDatabase();
            Cursor cursor14 = db14.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth14 = cursor14.getCount();

            if (countresdbcloth14 == 0) {
                return;
            } else {
                while (cursor14.moveToNext()) {
                    id.add(cursor14.getString(0));
                    pic_cloth.add(cursor14.getString(1));
                    tone.add(cursor14.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Lightpink") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db16 = clothesmain.getWritableDatabase();
            Cursor cursor16 = db16.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + ")", null);
            int countresdbcloth16 = cursor16.getCount();

            if (countresdbcloth16 == 0) {
                return;
            } else {
                while (cursor16.moveToNext()) {
                    id.add(cursor16.getString(0));
                    pic_cloth.add(cursor16.getString(1));
                    tone.add(cursor16.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Lightcoral") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db17 = clothesmain.getWritableDatabase();
            Cursor cursor17 = db17.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth17 = cursor17.getCount();

            if (countresdbcloth17 == 0) {
                return;
            } else {
                while (cursor17.moveToNext()) {
                    id.add(cursor17.getString(0));
                    pic_cloth.add(cursor17.getString(1));
                    tone.add(cursor17.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Lightblue") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db18 = clothesmain.getWritableDatabase();
            Cursor cursor18 = db18.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + ")", null);
            int countresdbcloth18 = cursor18.getCount();

            if (countresdbcloth18 == 0) {
                return;
            } else {
                while (cursor18.moveToNext()) {
                    id.add(cursor18.getString(0));
                    pic_cloth.add(cursor18.getString(1));
                    tone.add(cursor18.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("LightSalmon") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db19 = clothesmain.getWritableDatabase();
            Cursor cursor19 = db19.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "LightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + ")", null);
            int countresdbcloth19 = cursor19.getCount();

            if (countresdbcloth19 == 0) {
                return;
            } else {
                while (cursor19.moveToNext()) {
                    id.add(cursor19.getString(0));
                    pic_cloth.add(cursor19.getString(1));
                    tone.add(cursor19.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Lightyellow") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db20 = clothesmain.getWritableDatabase();
            Cursor cursor20 = db20.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "LightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth20 = cursor20.getCount();

            if (countresdbcloth20 == 0) {
                return;
            } else {
                while (cursor20.moveToNext()) {
                    id.add(cursor20.getString(0));
                    pic_cloth.add(cursor20.getString(1));
                    tone.add(cursor20.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Lightgreen") && (typecloth_getsc.equals("เสื้อยืดแขนสั้น") || typecloth_getsc.equals("เสื้อยืดแขนยาว") || typecloth_getsc.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getsc.equals("เสื้อเชิ้ตแขนยาว") || typecloth_getsc.equals("เสื้อไหมพรม")
                || typecloth_getsc.equals("แจ็คเก็ต"))){
            SQLiteDatabase db21 = clothesmain.getWritableDatabase();
            Cursor cursor21 = db21.rawQuery("select * from " + TABLE_NAME1
                    + " where " + "(typecloth = " + '"' + "กางเกงขายาว" + '"'
                    + " or typecloth = " + '"' + "กางเกงขาสั้น" + '"'
                    + " or typecloth = " + '"' + "กระโปรง" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth21 = cursor21.getCount();

            if (countresdbcloth21 == 0) {
                return;
            } else {
                while (cursor21.moveToNext()) {
                    id.add(cursor21.getString(0));
                    pic_cloth.add(cursor21.getString(1));
                    tone.add(cursor21.getString(8));
                }
            }
        }

        if(tonecloth_getsc.equals("Black") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){

            SQLiteDatabase db22 = clothesmain.getWritableDatabase();
            Cursor c22 = db22.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Olive" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
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

        if(tonecloth_getsc.equals("White") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){

            SQLiteDatabase db23 = clothesmain.getWritableDatabase();
            Cursor c23 = db23.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Black" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
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

        if(tonecloth_getsc.equals("Gray")&& (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
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
                            + " and " + "(colortone = " + '"' + "BLACK" + '"'
                            + " or colortone = " + '"' + "White" + '"'
                            + " or colortone = " + '"' + "Gray" + '"'
                            + " or colortone = " + '"' + "Yellow" + '"'
                            + " or colortone = " + '"' + "Green" + '"'
                            + " or colortone = " + '"' + "Navy" + '"'
                            + " or colortone = " + '"' + "Red" + '"'
                            + " or colortone = " + '"' + "Brown" + '"'
                            + " or colortone = " + '"' + "Purple" + '"'
                            + " or colortone = " + '"' + "Lightpink" + '"'
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

        if(tonecloth_getsc.equals("Navy") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db25 = clothesmain.getWritableDatabase();
            Cursor c25 = db25.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
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

        if(tonecloth_getsc.equals("Red") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db26 = clothesmain.getWritableDatabase();
            Cursor c26 = db26.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
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

        if(tonecloth_getsc.equals("Orange") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db27 = clothesmain.getWritableDatabase();
            Cursor c27 = db27.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "lightSalmon" + '"'
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

        if(tonecloth_getsc.equals("Yellow")&& (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db28 = clothesmain.getWritableDatabase();
            Cursor c28 = db28.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
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

        if(tonecloth_getsc.equals("Green") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db29 = clothesmain.getWritableDatabase();
            Cursor c29 = db29.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
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

        if(tonecloth_getsc.equals("Green") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db30 = clothesmain.getWritableDatabase();
            Cursor c30 = db30.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + ")", null);
            int countresdbcloth30 = c30.getCount();
            if (countresdbcloth30 == 0) {
                return;
            } else {
                while (c30.moveToNext()) {
                    id.add(c30.getString(0));
                    pic_cloth.add(c30.getString(1));
                    status_cloth.add(c30.getString(2));
                }
            }
        }

        if(tonecloth_getsc.equals("Blue") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db31 = clothesmain.getWritableDatabase();
            Cursor c31 = db31.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Blue" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Yellow" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
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

        if(tonecloth_getsc.equals("Purple") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){

            SQLiteDatabase db32 = clothesmain.getWritableDatabase();
            Cursor c32 = db32.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
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

        if(tonecloth_getsc.equals("Brown") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db33 = clothesmain.getWritableDatabase();
            Cursor c33 = db33.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
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

        if(tonecloth_getsc.equals("Beige") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db34 = clothesmain.getWritableDatabase();
            Cursor c34 = db34.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Green" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
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

        if(tonecloth_getsc.equals("Tan") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db35 = clothesmain.getWritableDatabase();
            Cursor c35 = db35.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
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

        if(tonecloth_getsc.equals("Watercress") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db37 = clothesmain.getWritableDatabase();
            Cursor c37 = db37.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
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

        if(tonecloth_getsc.equals("Lightpink") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){

            SQLiteDatabase db38 = clothesmain.getWritableDatabase();
            Cursor c38 = db38.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
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

        if(tonecloth_getsc.equals("Lightcoral") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db39 = clothesmain.getWritableDatabase();
            Cursor c39 = db39.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
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

        if(tonecloth_getsc.equals("Lightblue") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db40 = clothesmain.getWritableDatabase();
            Cursor c40 = db40.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Purple" + '"'
                    + " or colortone = " + '"' + "Red" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Orange" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
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

        if(tonecloth_getsc.equals("LightSalmon") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db41 = clothesmain.getWritableDatabase();
            Cursor c41 = db41.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "LightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
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

        if(tonecloth_getsc.equals("Lightyellow") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db42 = clothesmain.getWritableDatabase();
            Cursor c42 = db42.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Lightpink" + '"'
                    + " or colortone = " + '"' + "Lightcoral" + '"'
                    + " or colortone = " + '"' + "LightSalmon" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightblue" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
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

        if(tonecloth_getsc.equals("Lightgreen") && (typecloth_getsc.equals("กางเกงขายาว") || typecloth_getsc.equals("กางเกงขาสั้น")
                || typecloth_getsc.equals("กระโปรง"))){
            SQLiteDatabase db43 = clothesmain.getWritableDatabase();
            Cursor c43 = db43.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                    + " and " + "(typecloth = " + '"' + "เสื้อยืดแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อยืดแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนสั้น" + '"'
                    + " or typecloth = " + '"' + "เสื้อเชิ้ตแขนยาว" + '"'
                    + " or typecloth = " + '"' + "เสื้อไหมพรม" + '"'
                    + " or typecloth = " + '"' + "แจ็คเก็ต" + '"' + ")"
                    + " and " + "(colortone = " + '"' + "BLACK" + '"'
                    + " or colortone = " + '"' + "White" + '"'
                    + " or colortone = " + '"' + "Gray" + '"'
                    + " or colortone = " + '"' + "Navy" + '"'
                    + " or colortone = " + '"' + "Brown" + '"'
                    + " or colortone = " + '"' + "Beige" + '"'
                    + " or colortone = " + '"' + "Tan" + '"'
                    + " or colortone = " + '"' + "Watercress" + '"'
                    + " or colortone = " + '"' + "Lightyellow" + '"'
                    + " or colortone = " + '"' + "Lightgreen" + '"'
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

}
