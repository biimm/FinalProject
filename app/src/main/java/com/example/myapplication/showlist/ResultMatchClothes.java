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
import android.widget.Toast;

import com.example.myapplication.Adapter.ListShowResult;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class ResultMatchClothes extends AppCompatActivity {

    ImageView mImageView ;
    Button use;
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


    String tonecloth_getmatch = "";
    String clothselect_getmatch = "";
    String typecloth_getmatch = "";
    String piccloth_getmatch = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_match_clothes);

        mImageView=  findViewById(R.id.image_select);
        use =  findViewById(R.id.use_btn);
        gridView = findViewById(R.id.gridview_result);

        tonecloth_getmatch = getIntent().getStringExtra("toneclothselect");
        clothselect_getmatch = getIntent().getStringExtra("typeselect");
        typecloth_getmatch = getIntent().getStringExtra("typesearch");

        piccloth_getmatch = getIntent().getStringExtra("picselect");


        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        type_cloth = new ArrayList<>();
        status_cloth = new ArrayList<>();
        color1 = new ArrayList<>();
        color2 = new ArrayList<>();
        color3 = new ArrayList<>();
        tone = new ArrayList<>();

        clothesmain = new Clothesmain(this);


        final Uri image_uri = Uri.parse(piccloth_getmatch);
        mImageView.setImageURI(image_uri);


        System.out.println("Tone from Match :"+tonecloth_getmatch);
        System.out.println("Type from Match :"+typecloth_getmatch);
        System.out.println("Type Search from Match :"+clothselect_getmatch);


        showcloth();
        final ListShowResult listShowResult = new ListShowResult(getApplicationContext(),id,pic_cloth,type_cloth,status_cloth,color1,color2,color3,tone);
        gridView.setAdapter(listShowResult);

        use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothesmain.updatestatus(String.valueOf(id.get(listShowResult.position_choose)) , "กำลังใช้งาน");

                Toast.makeText(getApplicationContext(),"กำลังใช้งาน" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    public void showcloth(){
        if(tonecloth_getmatch.equals("Black") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
        || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db1 = clothesmain.getWritableDatabase();
                Cursor c1 = db1.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("White") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db2 = clothesmain.getWritableDatabase();
                Cursor c2 = db2.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }
        if(tonecloth_getmatch.equals("Gray") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db3 = clothesmain.getWritableDatabase();
                Cursor c3 = db3.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Navy") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db4 = clothesmain.getWritableDatabase();
                Cursor c4 = db4.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Red") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db5 = clothesmain.getWritableDatabase();
                Cursor c5 = db5.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + ")", null);
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
        }

        if(tonecloth_getmatch.equals("Orange") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db6 = clothesmain.getWritableDatabase();
                Cursor c6 = db6.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"' + " or colortone = " + '"' + "Yellow" + '"'
                        + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Yellow") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db7 = clothesmain.getWritableDatabase();
                Cursor c7 = db7.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Orange" + '"' + " or colortone = " + '"' + "Yellow" + '"'
                        + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Green") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db8 = clothesmain.getWritableDatabase();
                Cursor c8 = db8.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Red" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Blue") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db9 = clothesmain.getWritableDatabase();
                Cursor c9 = db9.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
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
        }

        if(tonecloth_getmatch.equals("Purple") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db10 = clothesmain.getWritableDatabase();
                Cursor c10 = db10.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Brown") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db11 = clothesmain.getWritableDatabase();
                Cursor c11 = db11.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Red" + '"'
                        + " or colortone = " + '"' + "Olive" + '"'  + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Beige") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db12 = clothesmain.getWritableDatabase();
                Cursor c12 = db12.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Olive" + '"'
                        + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightpink" + '"'
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
        }

        if(tonecloth_getmatch.equals("Tan") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db13 = clothesmain.getWritableDatabase();
                Cursor c13 = db13.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Olive" + '"'
                        + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Watercress" + '"'
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
        }

        if(tonecloth_getmatch.equals("Olive") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db14 = clothesmain.getWritableDatabase();
                Cursor c14 = db14.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"'+ " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"'  + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Watercress") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db15 = clothesmain.getWritableDatabase();
                Cursor c15 = db15.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"'
                        + " or colortone = " + '"' + "White" + '"'
                        + " or colortone = " + '"' + "Gray" + '"'
                        + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"'
                        + " or colortone = " + '"' + "Watercress" + '"'
                        + " or colortone = " + '"' + "Lightyellow" + '"'
                        + ")", null);
                int countresdbcloth15 = c15.getCount();
                if (countresdbcloth15 == 0) {
                    return;
                } else {
                    while (c15.moveToNext()) {
                        id.add(c15.getString(0));
                        pic_cloth.add(c15.getString(1));
                        status_cloth.add(c15.getString(2));
                    }
                }
            }
        }

        if(tonecloth_getmatch.equals("Lightpink") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db16 = clothesmain.getWritableDatabase();
                Cursor c16 = db16.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"'
                        + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "LightSalmon" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightcoral") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db17 = clothesmain.getWritableDatabase();
                Cursor c17 = db17.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"'
                        + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightblue") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db18 = clothesmain.getWritableDatabase();
                Cursor c18 = db18.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
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
        }

        if(tonecloth_getmatch.equals("LightSalmon") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db19 = clothesmain.getWritableDatabase();
                Cursor c19 = db19.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightyellow") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db20 = clothesmain.getWritableDatabase();
                Cursor c20 = db20.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightgreen") && (clothselect_getmatch.equals("เสื้อยืดแขนสั้น") || clothselect_getmatch.equals("เสื้อยืดแขนยาว") || clothselect_getmatch.equals("เสื้อเชิ้ตแขนสั้น")
                || clothselect_getmatch.equals("เสื้อเชิ้ตแขนยาว") || clothselect_getmatch.equals("เสื้อไหมพรม") || clothselect_getmatch.equals("เแจ็คเก็ต"))){
            if(typecloth_getmatch.equals("กางเกงขายาว") || typecloth_getmatch.equals("กางเกงขาสั้น") || typecloth_getmatch.equals("กระโปรง")){
                SQLiteDatabase db21 = clothesmain.getWritableDatabase();
                Cursor c21 = db21.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Black") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db22 = clothesmain.getWritableDatabase();
                Cursor c22 = db22.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("White") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db23 = clothesmain.getWritableDatabase();
                Cursor c23 = db23.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Gray") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db24 = clothesmain.getWritableDatabase();
                Cursor c24 = db24.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Navy") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db25 = clothesmain.getWritableDatabase();
                Cursor c25 = db25.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"'
                        + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Blue" + '"' + " or colortone = " + '"' + "Purple" + '"' + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"'
                        + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
                        + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Red") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db26 = clothesmain.getWritableDatabase();
                Cursor c26 = db26.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Orange" + '"' + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Green" + '"'
                        + " or colortone = " + '"' + "Brown" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Orange") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db27 = clothesmain.getWritableDatabase();
                Cursor c27 = db27.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Orange" + '"' + " or colortone = " + '"' + "Brown" + '"'
                        + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "lightSalmon" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Yellow") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db28 = clothesmain.getWritableDatabase();
                Cursor c28 = db28.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Yellow" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Green") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db29 = clothesmain.getWritableDatabase();
                Cursor c29 = db29.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Yellow" + '"'
                        + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Green") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db30 = clothesmain.getWritableDatabase();
                Cursor c30 = db30.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Yellow" + '"'
                        + " or colortone = " + '"' + "Green" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Blue") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db31 = clothesmain.getWritableDatabase();
                Cursor c31 = db31.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Lightblue" + '"'
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
        }

        if(tonecloth_getmatch.equals("Purple") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db32 = clothesmain.getWritableDatabase();
                Cursor c32 = db32.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"'
                        + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightyellow" + '"'
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
        }

        if(tonecloth_getmatch.equals("Brown") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db33 = clothesmain.getWritableDatabase();
                Cursor c33 = db33.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"'
                        + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Beige") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db34 = clothesmain.getWritableDatabase();
                Cursor c34 = db34.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Brown" + '"'
                        + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Tan") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db35 = clothesmain.getWritableDatabase();
                Cursor c35 = db35.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Navy" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Brown" + '"'
                        + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Tan" + '"' + " or colortone = " + '"' + "Olive" + '"' + " or colortone = " + '"' + "Watercress" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Olive") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db36 = clothesmain.getWritableDatabase();
                Cursor c36 = db36.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Olive" + '"'
                        + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth36 = c36.getCount();
                if (countresdbcloth36 == 0) {
                    return;
                } else {
                    while (c36.moveToNext()) {
                        id.add(c36.getString(0));
                        pic_cloth.add(c36.getString(1));
                        status_cloth.add(c36.getString(2));
                    }
                }
            }
        }

        if(tonecloth_getmatch.equals("Watercress") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db37 = clothesmain.getWritableDatabase();
                Cursor c37 = db37.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "(colortone = " + '"' + "BLACK" + '"' + " or colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Red" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Olive" + '"'
                        + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightpink") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db38 = clothesmain.getWritableDatabase();
                Cursor c38 = db38.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "LightSalmon" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightcoral") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db39 = clothesmain.getWritableDatabase();
                Cursor c39 = db39.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "LightSalmon" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightblue") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db40 = clothesmain.getWritableDatabase();
                Cursor c40 = db40.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightgreen" + '"' + " or colortone = " + '"' + "LightSalmon" + '"'
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
        }

        if(tonecloth_getmatch.equals("LightSalmon") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db41 = clothesmain.getWritableDatabase();
                Cursor c41 = db41.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"' + " or colortone = " + '"' + "LightSalmon" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightyellow") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db42 = clothesmain.getWritableDatabase();
                Cursor c42 = db42.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightblue" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'
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
        }

        if(tonecloth_getmatch.equals("Lightgreen") && (clothselect_getmatch.equals("กางเกงขายาว") || clothselect_getmatch.equals("กางเกงขาสั้น") || clothselect_getmatch.equals("กระโปรง"))){
            if(typecloth_getmatch.equals("เสื้อยืดแขนสั้น") || typecloth_getmatch.equals("เสื้อยืดแขนยาว") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนสั้น") || typecloth_getmatch.equals("เสื้อเชิ้ตแขนยาว")
                    || typecloth_getmatch.equals("เสื้อไหมพรม") || typecloth_getmatch.equals("เแจ็คเก็ต")){
                SQLiteDatabase db43 = clothesmain.getWritableDatabase();
                Cursor c43 = db43.rawQuery( " select * from " + TABLE_NAME1 + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"' + " and typecloth = " + '"' + typecloth_getmatch + '"'
                        + " and " + "( colortone = " + '"' + "White" + '"' + " or colortone = " + '"' + "Gray" + '"' + " or colortone = " + '"' + "Beige" + '"' + " or colortone = " + '"' + "Lightpink" + '"' + " or colortone = " + '"' + "Lightyellow" + '"' + " or colortone = " + '"' + "Lightcoral" + '"'
                        + " or colortone = " + '"' + "LightSalmon" + '"' + " or colortone = " + '"' + "Lightgreen" + '"'+ " or colortone = " + '"' + "Lightblue" + '"'
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

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this, MatchCloth.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
