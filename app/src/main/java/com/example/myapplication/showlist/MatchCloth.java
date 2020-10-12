package com.example.myapplication.showlist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListSearchAdapter;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;


public class MatchCloth extends AppCompatActivity {

    Spinner spcolor, sptype1, sptype2;
    Button search, match;
    CheckBox checkBox;
    GridView gridView;
    String datacolor, datatype1, datatype2;

    ListSearchAdapter listSearchAdapter;

    CompoundButton buttonView;

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

    Clothesmain clothesmain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_cloth);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spcolor = (Spinner) findViewById(R.id.spcolor);
        sptype1 = (Spinner) findViewById(R.id.sptype1);
        search = (Button) findViewById(R.id.search_btn);
        match = (Button) findViewById(R.id.match_btn);
        checkBox = findViewById(R.id.checkBox6);


        gridView = (GridView) findViewById(R.id.gridview_search);

        clothesmain = new Clothesmain(this);

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

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                showcolor();

                listSearchAdapter = new ListSearchAdapter(getApplicationContext(),id,pic_cloth,type_cloth,status_cloth,color1,color2,color3,tone1,tone2,tone3);

                gridView.setAdapter(listSearchAdapter);
                listSearchAdapter.notifyDataSetChanged();

            }
        });

        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchCloth.this , ResultMatchClothes.class);

                System.out.println("CHOOSE : "+listSearchAdapter.position_choose);
                intent.putExtra("picselect",pic_cloth.get(listSearchAdapter.position_choose));

                clothesmain.updatestatus(String.valueOf(id.get(listSearchAdapter.position_choose)) , "กำลังใช้งาน");
//                colorTone.updatestatus(String.valueOf(id.get(listSearchAdapter.position_choose)) , "กำลังใช้งาน");

                intent.putExtra("toneclothselect1" , tone1.get(listSearchAdapter.position_choose));
                intent.putExtra("toneclothselect2" , tone2.get(listSearchAdapter.position_choose));
                intent.putExtra("toneclothselect3" , tone3.get(listSearchAdapter.position_choose));
                //intent.putExtra("colorsearch" , datacolor);
                //intent.putExtra("typesearch" , datatype2);

                intent.putExtra("typeselect" , datatype1);

                startActivity(intent);
//                System.out.println("TEST BUTTON MATCH");
//                System.out.println(listSearchAdapter.position_choose);
            }
        });

        final ArrayAdapter<CharSequence> adaptercolor = ArrayAdapter.createFromResource(this, R.array.Spinner_Color, android.R.layout.simple_spinner_item);
        adaptercolor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spcolor.setAdapter(adaptercolor);
        spcolor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datacolor = (String) parent.getItemAtPosition(position);
                //adaptercolor.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final ArrayAdapter<CharSequence> adaptertype1 = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
        adaptertype1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptype1.setAdapter(adaptertype1);
        sptype1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datatype1 = (String) parent.getItemAtPosition(position);
                //adaptertype1.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        ArrayAdapter<CharSequence> adaptertype2 = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
//        adaptertype2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sptype2.setAdapter(adaptertype2);
//        sptype2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                datatype2 = (String) parent.getItemAtPosition(position);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


    }


    private void showcolor() {

        if (datacolor.equals("ขาว-ดำ")) {
            if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                SQLiteDatabase db1 = clothesmain.getWritableDatabase();
                Cursor cursor1 = db1.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth1 = cursor1.getCount();

                if (countresdbcloth1 == 0) {
                    return;
                } else {
                    while (cursor1.moveToNext()) {
                        id.add(cursor1.getString(0));
                        pic_cloth.add(cursor1.getString(1));
                        tone1.add(cursor1.getString(8));
                        tone2.add(cursor1.getString(9));
                        tone3.add(cursor1.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อยืดแขนยาว")) {
                SQLiteDatabase db2 = clothesmain.getWritableDatabase();
                Cursor cursor2 = db2.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth2 = cursor2.getCount();
                if (countresdbcloth2 == 0) {
                    return;
                } else {
                    while (cursor2.moveToNext()) {
                        id.add(cursor2.getString(0));
                        pic_cloth.add(cursor2.getString(1));
                        tone1.add(cursor2.getString(8));
                        tone2.add(cursor2.getString(9));
                        tone3.add(cursor2.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                SQLiteDatabase db3 = clothesmain.getWritableDatabase();
                Cursor cursor3 = db3.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth3 = cursor3.getCount();

                if (countresdbcloth3 == 0) {
                    return;
                } else {
                    while (cursor3.moveToNext()) {
                        id.add(cursor3.getString(0));
                        pic_cloth.add(cursor3.getString(1));
                        tone1.add(cursor3.getString(8));
                        tone2.add(cursor3.getString(9));
                        tone3.add(cursor3.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนยาว")) {
                SQLiteDatabase db4 = clothesmain.getWritableDatabase();
                Cursor cursor4 = db4.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth4 = cursor4.getCount();

                if (countresdbcloth4 == 0) {
                    return;
                } else {
                    while (cursor4.moveToNext()) {
                        id.add(cursor4.getString(0));
                        pic_cloth.add(cursor4.getString(1));
                        tone1.add(cursor4.getString(8));
                        tone2.add(cursor4.getString(9));
                        tone3.add(cursor4.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อไหมพรม")) {
                SQLiteDatabase db5 = clothesmain.getWritableDatabase();
                Cursor cursor5 = db5.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth5 = cursor5.getCount();

                if (countresdbcloth5 == 0) {
                    return;
                } else {
                    while (cursor5.moveToNext()) {
                        id.add(cursor5.getString(0));
                        pic_cloth.add(cursor5.getString(1));
                        tone1.add(cursor5.getString(8));
                        tone2.add(cursor5.getString(9));
                        tone3.add(cursor5.getString(10));
                    }
                }
            } else if (datatype1.equals("ชุดเดรส")) {
                SQLiteDatabase db6 = clothesmain.getWritableDatabase();
                Cursor cursor6 = db6.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth6 = cursor6.getCount();

                if (countresdbcloth6 == 0) {
                    return;
                } else {
                    while (cursor6.moveToNext()) {
                        id.add(cursor6.getString(0));
                        pic_cloth.add(cursor6.getString(1));
                        tone1.add(cursor6.getString(8));
                        tone2.add(cursor6.getString(9));
                        tone3.add(cursor6.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขายาว")) {
                SQLiteDatabase db7 = clothesmain.getWritableDatabase();
                Cursor cursor7 = db7.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);

                int countresdbcloth7 = cursor7.getCount();

                if (countresdbcloth7 == 0) {
                    return;
                } else {
                    while (cursor7.moveToNext()) {
                        id.add(cursor7.getString(0));
                        pic_cloth.add(cursor7.getString(1));
                        tone1.add(cursor7.getString(8));
                        tone2.add(cursor7.getString(9));
                        tone3.add(cursor7.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขาสั้น")) {
                SQLiteDatabase db8 = clothesmain.getWritableDatabase();
                Cursor cursor8 = db8.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth8 = cursor8.getCount();

                if (countresdbcloth8 == 0) {
                    return;
                } else {
                    while (cursor8.moveToNext()) {
                        id.add(cursor8.getString(0));
                        pic_cloth.add(cursor8.getString(1));
                        tone1.add(cursor8.getString(8));
                        tone2.add(cursor8.getString(9));
                        tone3.add(cursor8.getString(10));
                    }
                }
            } else if (datatype1.equals("กระโปรง")) {
                SQLiteDatabase db9 = clothesmain.getWritableDatabase();
                Cursor cursor9 = db9.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth9 = cursor9.getCount();

                if (countresdbcloth9 == 0) {
                    return;
                } else {
                    while (cursor9.moveToNext()) {
                        id.add(cursor9.getString(0));
                        pic_cloth.add(cursor9.getString(1));
                        tone1.add(cursor9.getString(8));
                        tone2.add(cursor9.getString(9));
                        tone3.add(cursor9.getString(10));
                    }
                }
            } else if (datatype1.equals("แจ็คเก็ต")) {
                SQLiteDatabase db10 = clothesmain.getWritableDatabase();
                Cursor cursor10 = db10.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "BLACK" + '"'
                        + " or tone1 = " + '"' + "White" + '"'
                        + " or tone1 = " + '"' + "Gray" + '"'
                        + " or tone1 = " + '"' + "Navy" + '"'
                        + " or tone2 = " + '"' + "Black" + '"'
                        + " or tone2 = " + '"' + "White" + '"'
                        + " or tone2 = " + '"' + "Gray" + '"'
                        + " or tone2 = " + '"' + "Navy" + '"'
                        + " or tone3 = " + '"' + "Black" + '"'
                        + " or tone3 = " + '"' + "White" + '"'
                        + " or tone3 = " + '"' + "Gray" + '"'
                        + " or tone3 = " + '"' + "Navy" + '"'
                        + ")", null);
                int countresdbcloth10 = cursor10.getCount();

                if (countresdbcloth10 == 0) {
                    return;
                } else {
                    while (cursor10.moveToNext()) {
                        id.add(cursor10.getString(0));
                        pic_cloth.add(cursor10.getString(1));
                        tone1.add(cursor10.getString(8));
                        tone2.add(cursor10.getString(9));
                        tone3.add(cursor10.getString(10));
                    }
                }
            }
        }

        /////////////// hot ///////////////////

        if (datacolor.equals("โทนร้อน")) {
            if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                SQLiteDatabase db11 = clothesmain.getWritableDatabase();
                Cursor cursor11 = db11.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth11 = cursor11.getCount();

                if (countresdbcloth11 == 0) {
                    return;
                } else {
                    while (cursor11.moveToNext()) {
                        id.add(cursor11.getString(0));
                        pic_cloth.add(cursor11.getString(1));
                        tone1.add(cursor11.getString(8));
                        tone2.add(cursor11.getString(9));
                        tone3.add(cursor11.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อยืดแขนยาว")) {
                SQLiteDatabase db12 = clothesmain.getWritableDatabase();
                Cursor cursor12 = db12.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth12 = cursor12.getCount();

                if (countresdbcloth12 == 0) {
                    return;
                } else {
                    while (cursor12.moveToNext()) {
                        id.add(cursor12.getString(0));
                        pic_cloth.add(cursor12.getString(1));
                        tone1.add(cursor12.getString(8));
                        tone2.add(cursor12.getString(9));
                        tone3.add(cursor12.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                SQLiteDatabase db13 = clothesmain.getWritableDatabase();
                Cursor cursor13 = db13.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth13 = cursor13.getCount();

                if (countresdbcloth13 == 0) {
                    return;
                } else {
                    while (cursor13.moveToNext()) {
                        id.add(cursor13.getString(0));
                        pic_cloth.add(cursor13.getString(1));
                        tone1.add(cursor13.getString(8));
                        tone2.add(cursor13.getString(9));
                        tone3.add(cursor13.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนยาว")) {
                SQLiteDatabase db14 = clothesmain.getWritableDatabase();
                Cursor cursor14 = db14.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth14 = cursor14.getCount();

                if (countresdbcloth14 == 0) {
                    return;
                } else {
                    while (cursor14.moveToNext()) {
                        id.add(cursor14.getString(0));
                        pic_cloth.add(cursor14.getString(1));
                        tone1.add(cursor14.getString(8));
                        tone2.add(cursor14.getString(9));
                        tone3.add(cursor14.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อไหมพรม")) {
                SQLiteDatabase db15 = clothesmain.getWritableDatabase();
                Cursor cursor15 = db15.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth15 = cursor15.getCount();

                if (countresdbcloth15 == 0) {
                    return;
                } else {
                    while (cursor15.moveToNext()) {
                        id.add(cursor15.getString(0));
                        pic_cloth.add(cursor15.getString(1));
                        tone1.add(cursor15.getString(8));
                        tone2.add(cursor15.getString(9));
                        tone3.add(cursor15.getString(10));
                    }
                }
            } else if (datatype1.equals("ชุดเดรส")) {
                SQLiteDatabase db16 = clothesmain.getWritableDatabase();
                Cursor cursor16 = db16.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth16 = cursor16.getCount();

                if (countresdbcloth16 == 0) {
                    return;
                } else {
                    while (cursor16.moveToNext()) {
                        id.add(cursor16.getString(0));
                        pic_cloth.add(cursor16.getString(1));
                        tone1.add(cursor16.getString(8));
                        tone2.add(cursor16.getString(9));
                        tone3.add(cursor16.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขายาว")) {
                SQLiteDatabase db17 = clothesmain.getWritableDatabase();
                Cursor cursor17 = db17.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth17 = cursor17.getCount();

                if (countresdbcloth17 == 0) {
                    return;
                } else {
                    while (cursor17.moveToNext()) {
                        id.add(cursor17.getString(0));
                        pic_cloth.add(cursor17.getString(1));
                        tone1.add(cursor17.getString(8));
                        tone2.add(cursor17.getString(9));
                        tone3.add(cursor17.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขาสั้น")) {
                SQLiteDatabase db18 = clothesmain.getWritableDatabase();
                Cursor cursor18 = db18.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth18 = cursor18.getCount();

                if (countresdbcloth18 == 0) {
                    return;
                } else {
                    while (cursor18.moveToNext()) {
                        id.add(cursor18.getString(0));
                        pic_cloth.add(cursor18.getString(1));
                        tone1.add(cursor18.getString(8));
                        tone2.add(cursor18.getString(9));
                        tone3.add(cursor18.getString(10));
                    }
                }
            } else if (datatype1.equals("กระโปรง")) {
                SQLiteDatabase db19 = clothesmain.getWritableDatabase();
                Cursor cursor19 = db19.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth19 = cursor19.getCount();

                if (countresdbcloth19 == 0) {
                    return;
                } else {
                    while (cursor19.moveToNext()) {
                        id.add(cursor19.getString(0));
                        pic_cloth.add(cursor19.getString(1));
                        tone1.add(cursor19.getString(8));
                        tone2.add(cursor19.getString(9));
                        tone3.add(cursor19.getString(10));
                    }
                }
            } else if (datatype1.equals("แจ็คเก็ต")) {
                SQLiteDatabase db20 = clothesmain.getWritableDatabase();
                Cursor cursor20 = db20.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth20 = cursor20.getCount();

                if (countresdbcloth20 == 0) {
                    return;
                } else {
                    while (cursor20.moveToNext()) {
                        id.add(cursor20.getString(0));
                        pic_cloth.add(cursor20.getString(1));
                        tone1.add(cursor20.getString(8));
                        tone2.add(cursor20.getString(9));
                        tone3.add(cursor20.getString(10));
                    }
                }
            }
        }

        /////////////////// cold /////////////////////

        if (datacolor.equals("โทนเย็น")) {
            if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                SQLiteDatabase db21 = clothesmain.getWritableDatabase();
                Cursor cursor21 = db21.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth21 = cursor21.getCount();

                if (countresdbcloth21 == 0) {
                    return;
                } else {
                    while (cursor21.moveToNext()) {
                        id.add(cursor21.getString(0));
                        pic_cloth.add(cursor21.getString(1));
                        tone1.add(cursor21.getString(8));
                        tone2.add(cursor21.getString(9));
                        tone3.add(cursor21.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อยืดแขนยาว")) {
                SQLiteDatabase db22 = clothesmain.getWritableDatabase();
                Cursor cursor22 = db22.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth22 = cursor22.getCount();

                if (countresdbcloth22 == 0) {
                    return;
                } else {
                    while (cursor22.moveToNext()) {
                        id.add(cursor22.getString(0));
                        pic_cloth.add(cursor22.getString(1));
                        tone1.add(cursor22.getString(8));
                        tone2.add(cursor22.getString(9));
                        tone3.add(cursor22.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                SQLiteDatabase db23 = clothesmain.getWritableDatabase();
                Cursor cursor23 = db23.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth23 = cursor23.getCount();

                if (countresdbcloth23 == 0) {
                    return;
                } else {
                    while (cursor23.moveToNext()) {
                        id.add(cursor23.getString(0));
                        pic_cloth.add(cursor23.getString(1));
                        tone1.add(cursor23.getString(8));
                        tone2.add(cursor23.getString(9));
                        tone3.add(cursor23.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนยาว")) {
                SQLiteDatabase db24 = clothesmain.getWritableDatabase();
                Cursor cursor24 = db24.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth24 = cursor24.getCount();

                if (countresdbcloth24 == 0) {
                    return;
                } else {
                    while (cursor24.moveToNext()) {
                        id.add(cursor24.getString(0));
                        pic_cloth.add(cursor24.getString(1));
                        tone1.add(cursor24.getString(8));
                        tone2.add(cursor24.getString(9));
                        tone3.add(cursor24.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อไหมพรม")) {
                SQLiteDatabase db25 = clothesmain.getWritableDatabase();
                Cursor cursor25 = db25.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth25 = cursor25.getCount();

                if (countresdbcloth25 == 0) {
                    return;
                } else {
                    while (cursor25.moveToNext()) {
                        id.add(cursor25.getString(0));
                        pic_cloth.add(cursor25.getString(1));
                        tone1.add(cursor25.getString(8));
                        tone2.add(cursor25.getString(9));
                        tone3.add(cursor25.getString(10));
                    }
                }
            } else if (datatype1.equals("ชุดเดรส")) {
                SQLiteDatabase db26 = clothesmain.getWritableDatabase();
                Cursor cursor26 = db26.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth26 = cursor26.getCount();

                if (countresdbcloth26 == 0) {
                    return;
                } else {
                    while (cursor26.moveToNext()) {
                        id.add(cursor26.getString(0));
                        pic_cloth.add(cursor26.getString(1));
                        tone1.add(cursor26.getString(8));
                        tone2.add(cursor26.getString(9));
                        tone3.add(cursor26.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขายาว")) {
                SQLiteDatabase db27 = clothesmain.getWritableDatabase();
                Cursor cursor27 = db27.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth27 = cursor27.getCount();

                if (countresdbcloth27 == 0) {
                    return;
                } else {
                    while (cursor27.moveToNext()) {
                        id.add(cursor27.getString(0));
                        pic_cloth.add(cursor27.getString(1));
                        tone1.add(cursor27.getString(8));
                        tone2.add(cursor27.getString(9));
                        tone3.add(cursor27.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขาสั้น")) {
                SQLiteDatabase db28 = clothesmain.getWritableDatabase();
                Cursor cursor28 = db28.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth28 = cursor28.getCount();

                if (countresdbcloth28 == 0) {
                    return;
                } else {
                    while (cursor28.moveToNext()) {
                        id.add(cursor28.getString(0));
                        pic_cloth.add(cursor28.getString(1));
                        tone1.add(cursor28.getString(8));
                        tone2.add(cursor28.getString(9));
                        tone3.add(cursor28.getString(10));
                    }
                }
            } else if (datatype1.equals("กระโปรง")) {
                SQLiteDatabase db29 = clothesmain.getWritableDatabase();
                Cursor cursor29 = db29.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth29 = cursor29.getCount();

                if (countresdbcloth29 == 0) {
                    return;
                } else {
                    while (cursor29.moveToNext()) {
                        id.add(cursor29.getString(0));
                        pic_cloth.add(cursor29.getString(1));
                        tone1.add(cursor29.getString(8));
                        tone2.add(cursor29.getString(9));
                        tone3.add(cursor29.getString(10));
                    }
                }
            } else if (datatype1.equals("แจ็คเก็ต")) {
                SQLiteDatabase db30 = clothesmain.getWritableDatabase();
                Cursor cursor30 = db30.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Green" + '"'
                        + " or tone1 = " + '"' + "Blue" + '"'
                        + " or tone1 = " + '"' + "Purple" + '"'
                        + " or tone2 = " + '"' + "Green" + '"'
                        + " or tone2 = " + '"' + "Blue" + '"'
                        + " or tone2= " + '"' + "Purple" + '"'
                        + " or tone3 = " + '"' + "Green" + '"'
                        + " or tone3 = " + '"' + "Blue" + '"'
                        + " or tone3 = " + '"' + "Purple" + '"'
                        + ")", null);
                int countresdbcloth30 = cursor30.getCount();

                if (countresdbcloth30 == 0) {
                    return;
                } else {
                    while (cursor30.moveToNext()) {
                        id.add(cursor30.getString(0));
                        pic_cloth.add(cursor30.getString(1));
                        tone1.add(cursor30.getString(8));
                        tone2.add(cursor30.getString(9));
                        tone3.add(cursor30.getString(10));
                    }
                }
            }
        }

        /////////////////////////////// earth /////////////////////////

        if (datacolor.equals("เอิร์ธโทน")) {
            if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                SQLiteDatabase db31 = clothesmain.getWritableDatabase();
                Cursor cursor31 = db31.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth31 = cursor31.getCount();

                if (countresdbcloth31 == 0) {
                    return;
                } else {
                    while (cursor31.moveToNext()) {
                        id.add(cursor31.getString(0));
                        pic_cloth.add(cursor31.getString(1));
                        tone1.add(cursor31.getString(8));
                        tone2.add(cursor31.getString(9));
                        tone3.add(cursor31.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อยืดแขนยาว")) {
                SQLiteDatabase db32 = clothesmain.getWritableDatabase();
                Cursor cursor32 = db32.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth32 = cursor32.getCount();

                if (countresdbcloth32 == 0) {
                    return;
                } else {
                    while (cursor32.moveToNext()) {
                        id.add(cursor32.getString(0));
                        pic_cloth.add(cursor32.getString(1));
                        tone1.add(cursor32.getString(8));
                        tone2.add(cursor32.getString(9));
                        tone3.add(cursor32.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                SQLiteDatabase db33 = clothesmain.getWritableDatabase();
                Cursor cursor33 = db33.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth33 = cursor33.getCount();

                if (countresdbcloth33 == 0) {
                    return;
                } else {
                    while (cursor33.moveToNext()) {
                        id.add(cursor33.getString(0));
                        pic_cloth.add(cursor33.getString(1));
                        tone1.add(cursor33.getString(8));
                        tone2.add(cursor33.getString(9));
                        tone3.add(cursor33.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนยาว")) {
                SQLiteDatabase db34 = clothesmain.getWritableDatabase();
                Cursor cursor34 = db34.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth34 = cursor34.getCount();

                if (countresdbcloth34 == 0) {
                    return;
                } else {
                    while (cursor34.moveToNext()) {
                        id.add(cursor34.getString(0));
                        pic_cloth.add(cursor34.getString(1));
                        tone1.add(cursor34.getString(8));
                        tone2.add(cursor34.getString(9));
                        tone3.add(cursor34.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อไหมพรม")) {
                SQLiteDatabase db35 = clothesmain.getWritableDatabase();
                Cursor cursor35 = db35.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth35 = cursor35.getCount();

                if (countresdbcloth35 == 0) {
                    return;
                } else {
                    while (cursor35.moveToNext()) {
                        id.add(cursor35.getString(0));
                        pic_cloth.add(cursor35.getString(1));
                        tone1.add(cursor35.getString(8));
                        tone2.add(cursor35.getString(9));
                        tone3.add(cursor35.getString(10));
                    }
                }
            } else if (datatype1.equals("ชุดเดรส")) {
                SQLiteDatabase db36 = clothesmain.getWritableDatabase();
                Cursor cursor36 = db36.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth36 = cursor36.getCount();

                if (countresdbcloth36 == 0) {
                    return;
                } else {
                    while (cursor36.moveToNext()) {
                        id.add(cursor36.getString(0));
                        pic_cloth.add(cursor36.getString(1));
                        tone1.add(cursor36.getString(8));
                        tone2.add(cursor36.getString(9));
                        tone3.add(cursor36.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขายาว")) {
                SQLiteDatabase db37 = clothesmain.getWritableDatabase();
                Cursor cursor37 = db37.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth37 = cursor37.getCount();

                if (countresdbcloth37 == 0) {
                    return;
                } else {
                    while (cursor37.moveToNext()) {
                        id.add(cursor37.getString(0));
                        pic_cloth.add(cursor37.getString(1));
                        tone1.add(cursor37.getString(8));
                        tone2.add(cursor37.getString(9));
                        tone3.add(cursor37.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขาสั้น")) {
                SQLiteDatabase db38 = clothesmain.getWritableDatabase();
                Cursor cursor38 = db38.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth38 = cursor38.getCount();

                if (countresdbcloth38 == 0) {
                    return;
                } else {
                    while (cursor38.moveToNext()) {
                        id.add(cursor38.getString(0));
                        pic_cloth.add(cursor38.getString(1));
                        tone1.add(cursor38.getString(8));
                        tone2.add(cursor38.getString(9));
                        tone3.add(cursor38.getString(10));
                    }
                }
            } else if (datatype1.equals("กระโปรง")) {
                SQLiteDatabase db39 = clothesmain.getWritableDatabase();
                Cursor cursor39 = db39.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth39 = cursor39.getCount();

                if (countresdbcloth39 == 0) {
                    return;
                } else {
                    while (cursor39.moveToNext()) {
                        id.add(cursor39.getString(0));
                        pic_cloth.add(cursor39.getString(1));
                        tone1.add(cursor39.getString(8));
                        tone2.add(cursor39.getString(9));
                        tone3.add(cursor39.getString(10));
                    }
                }
            } else if (datatype1.equals("แจ็คเก็ต")) {
                SQLiteDatabase db40 = clothesmain.getWritableDatabase();
                Cursor cursor40 = db40.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Brown" + '"'
                        + " or tone1 = " + '"' + "Beige" + '"'
                        + " or tone1 = " + '"' + "Tan" + '"'
                        + " or tone1 = " + '"' + "Watercress" + '"'
                        + " or tone2 = " + '"' + "Brown" + '"'
                        + " or tone2 = " + '"' + "Beige" + '"'
                        + " or tone2 = " + '"' + "Tan" + '"'
                        + " or tone2 = " + '"' + "Watercress" + '"'
                        + " or tone3 = " + '"' + "Brown" + '"'
                        + " or tone3 = " + '"' + "Beige" + '"'
                        + " or tone3 = " + '"' + "Tan" + '"'
                        + " or tone3 = " + '"' + "Watercress" + '"'
                        + ")", null);
                int countresdbcloth40 = cursor40.getCount();

                if (countresdbcloth40 == 0) {
                    return;
                } else {
                    while (cursor40.moveToNext()) {
                        id.add(cursor40.getString(0));
                        pic_cloth.add(cursor40.getString(1));
                        tone1.add(cursor40.getString(8));
                        tone2.add(cursor40.getString(9));
                        tone3.add(cursor40.getString(10));
                    }
                }
            }
        }

        ///////////////// pastel /////////////////////

        if (datacolor.equals("พาสเทล")) {
            if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                SQLiteDatabase db41 = clothesmain.getWritableDatabase();
                Cursor cursor41 = db41.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth41 = cursor41.getCount();

                if (countresdbcloth41 == 0) {
                    return;
                } else {
                    while (cursor41.moveToNext()) {
                        id.add(cursor41.getString(0));
                        pic_cloth.add(cursor41.getString(1));
                        tone1.add(cursor41.getString(8));
                        tone2.add(cursor41.getString(9));
                        tone3.add(cursor41.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อยืดแขนยาว")) {
                SQLiteDatabase db42 = clothesmain.getWritableDatabase();
                Cursor cursor42 = db42.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth42 = cursor42.getCount();

                if (countresdbcloth42 == 0) {
                    return;
                } else {
                    while (cursor42.moveToNext()) {
                        id.add(cursor42.getString(0));
                        pic_cloth.add(cursor42.getString(1));
                        tone1.add(cursor42.getString(8));
                        tone2.add(cursor42.getString(9));
                        tone3.add(cursor42.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                SQLiteDatabase db43 = clothesmain.getWritableDatabase();
                Cursor cursor43 = db43.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3 = " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth43 = cursor43.getCount();

                if (countresdbcloth43 == 0) {
                    return;
                } else {
                    while (cursor43.moveToNext()) {
                        id.add(cursor43.getString(0));
                        pic_cloth.add(cursor43.getString(1));
                        tone1.add(cursor43.getString(8));
                        tone2.add(cursor43.getString(9));
                        tone3.add(cursor43.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อเชิ้ตแขนยาว")) {
                SQLiteDatabase db44 = clothesmain.getWritableDatabase();
                Cursor cursor44 = db44.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3 = " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth44 = cursor44.getCount();

                if (countresdbcloth44 == 0) {
                    return;
                } else {
                    while (cursor44.moveToNext()) {
                        id.add(cursor44.getString(0));
                        pic_cloth.add(cursor44.getString(1));
                        tone1.add(cursor44.getString(8));
                        tone2.add(cursor44.getString(9));
                        tone3.add(cursor44.getString(10));
                    }
                }
            } else if (datatype1.equals("เสื้อไหมพรม")) {
                SQLiteDatabase db45 = clothesmain.getWritableDatabase();
                Cursor cursor45 = db45.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth45 = cursor45.getCount();

                if (countresdbcloth45 == 0) {
                    return;
                } else {
                    while (cursor45.moveToNext()) {
                        id.add(cursor45.getString(0));
                        pic_cloth.add(cursor45.getString(1));
                        tone1.add(cursor45.getString(8));
                        tone2.add(cursor45.getString(9));
                        tone3.add(cursor45.getString(10));
                    }
                }
            } else if (datatype1.equals("ชุดเดรส")) {
                SQLiteDatabase db46 = clothesmain.getWritableDatabase();
                Cursor cursor46 = db46.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth46 = cursor46.getCount();

                if (countresdbcloth46 == 0) {
                    return;
                } else {
                    while (cursor46.moveToNext()) {
                        id.add(cursor46.getString(0));
                        pic_cloth.add(cursor46.getString(1));
                        tone1.add(cursor46.getString(8));
                        tone2.add(cursor46.getString(9));
                        tone3.add(cursor46.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขายาว")) {
                SQLiteDatabase db47 = clothesmain.getWritableDatabase();
                Cursor cursor47 = db47.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth47 = cursor47.getCount();

                if (countresdbcloth47 == 0) {
                    return;
                } else {
                    while (cursor47.moveToNext()) {
                        id.add(cursor47.getString(0));
                        pic_cloth.add(cursor47.getString(1));
                        tone1.add(cursor47.getString(8));
                        tone2.add(cursor47.getString(9));
                        tone3.add(cursor47.getString(10));
                    }
                }
            } else if (datatype1.equals("กางเกงขาสั้น")) {
                SQLiteDatabase db48 = clothesmain.getWritableDatabase();
                Cursor cursor48 = db48.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth48 = cursor48.getCount();

                if (countresdbcloth48 == 0) {
                    return;
                } else {
                    while (cursor48.moveToNext()) {
                        id.add(cursor48.getString(0));
                        pic_cloth.add(cursor48.getString(1));
                        tone1.add(cursor48.getString(8));
                        tone2.add(cursor48.getString(9));
                        tone3.add(cursor48.getString(10));
                    }
                }
            } else if (datatype1.equals("กระโปรง")) {
                SQLiteDatabase db49 = clothesmain.getWritableDatabase();
                Cursor cursor49 = db49.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth49 = cursor49.getCount();

                if (countresdbcloth49 == 0) {
                    return;
                } else {
                    while (cursor49.moveToNext()) {
                        id.add(cursor49.getString(0));
                        pic_cloth.add(cursor49.getString(1));
                        tone1.add(cursor49.getString(8));
                        tone2.add(cursor49.getString(9));
                        tone3.add(cursor49.getString(10));
                    }
                }
            } else if (datatype1.equals("แจ็คเก็ต")) {
                SQLiteDatabase db50 = clothesmain.getWritableDatabase();
                Cursor cursor50 = db50.rawQuery("select * from " + TABLE_NAME1
                        + " where statuscloth = " + '"' + "พร้อมใช้งาน" + '"'
                        + " and typecloth = " + '"' + datatype1 + '"'
                        + " and " + "(tone1 = " + '"' + "Lightpink" + '"'
                        + " or tone1 = " + '"' + "Lightcoral" + '"'
                        + " or tone1 = " + '"' + "Lightblue" + '"'
                        + " or tone1 = " + '"' + "lightSalmon" + '"'
                        + " or tone1 = " + '"' + "Lightyellow" + '"'
                        + " or tone1 = " + '"' + "Lightgreen" + '"'
                        + " or tone2 = " + '"' + "Lightpink" + '"'
                        + " or tone2 = " + '"' + "Lightcoral" + '"'
                        + " or tone2 = " + '"' + "Lightblue" + '"'
                        + " or tone2 = " + '"' + "lightSalmon" + '"'
                        + " or tone2 = " + '"' + "Lightyellow" + '"'
                        + " or tone2 = " + '"' + "Lightgreen" + '"'
                        + " or tone3 = " + '"' + "Lightpink" + '"'
                        + " or tone3= " + '"' + "Lightcoral" + '"'
                        + " or tone3 = " + '"' + "Lightblue" + '"'
                        + " or tone3 = " + '"' + "lightSalmon" + '"'
                        + " or tone3 = " + '"' + "Lightyellow" + '"'
                        + " or tone3 = " + '"' + "Lightgreen" + '"'
                        + ")", null);
                int countresdbcloth50 = cursor50.getCount();

                if (countresdbcloth50 == 0) {
                    return;
                } else {
                    while (cursor50.moveToNext()) {
                        id.add(cursor50.getString(0));
                        pic_cloth.add(cursor50.getString(1));
                        tone1.add(cursor50.getString(8));
                        tone2.add(cursor50.getString(9));
                        tone3.add(cursor50.getString(10));
                    }
                }
            }
        }
    }
        // back
        public void onBackPressed () {
            super.onBackPressed();
            this.finish();
            Intent in = new Intent(this, Main2Activity.class);
            startActivity(in);
            overridePendingTransition(0, 0);
            in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
    }
