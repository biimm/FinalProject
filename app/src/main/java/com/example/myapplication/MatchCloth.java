package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.connectDB.ColorClothes;

import java.util.ArrayList;

import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH1;
import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH2;
import static com.example.myapplication.connectDB.Clothesmaininterface.COLOR_CLOTH3;
import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;
import static com.example.myapplication.connectDB.ColorClothesinterface.TABLE_NAME5;

public class MatchCloth extends AppCompatActivity {

    Spinner spcolor, sptype1, sptype2;
    Button search, match;
    GridView gridView;
    String datacolor, datatype1, datatype2;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> color1;
    ArrayList<String> color2;
    ArrayList<String> color3;

    ColorClothes colorClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_cloth);

        spcolor = (Spinner) findViewById(R.id.spcolor);
        sptype1 = (Spinner) findViewById(R.id.sptype1);
        sptype2 = (Spinner) findViewById(R.id.sptype2);
        match = (Button) findViewById(R.id.match_btn);
        search = (Button) findViewById(R.id.search_btn);

        gridView = (GridView) findViewById(R.id.gridview_search);

        colorClothes = new ColorClothes(this);
        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        color1 = new ArrayList<>();
        color2 = new ArrayList<>();
        color3 = new ArrayList<>();

        ListSearchAdapter listSearchAdapter = new ListSearchAdapter(getApplicationContext(),id,pic_cloth,color1,color2,color3);
        gridView.setAdapter(listSearchAdapter);

        ArrayAdapter<CharSequence> adaptercolor = ArrayAdapter.createFromResource(this, R.array.Spinner_Color, android.R.layout.simple_spinner_item);
        adaptercolor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spcolor.setAdapter(adaptercolor);
        spcolor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datacolor = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adaptertype1 = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
        adaptertype1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptype1.setAdapter(adaptertype1);
        sptype1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datatype1 = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                showlistfromdb();
            }
        });


        ArrayAdapter<CharSequence> adaptertype2 = ArrayAdapter.createFromResource(this, R.array.Spinner_type, android.R.layout.simple_spinner_item);
        adaptertype2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptype2.setAdapter(adaptertype2);
        sptype2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datatype2 = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchCloth.this, ResultMatchClothes.class);
                startActivity(intent);
            }
        });

    }

    private void showlistfromdb() {
        SQLiteDatabase db = colorClothes.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME1,null);

        int countresdbcloth = cursor.getCount();

        if (countresdbcloth == 0) {
            return;
        }

        while (cursor.moveToNext()) {
            if (datacolor.equals("ขาว-ดำ")) {
                if (color1.equals("#fff") || color1.equals("#eee9e9") || color1.equals("#000") || color1.equals("#fffafa") || color1.equals("#cdc9c9") || color1.equals("#f5f5f5")
                        || color2.equals("#fff") || color2.equals("#eee9e9") || color2.equals("#000") || color2.equals("#fffafa") || color2.equals("#cdc9c9") || color2.equals("#f5f5f5")
                        || color3.equals("#fff") || color3.equals("#eee9e9") || color3.equals("#000") || color3.equals("#fffafa") || color3.equals("#cdc9c9") || color3.equals("#f5f5f5")) {
                    if (datatype1.equals("เสื้อยืดแขนสั้น")) {
                        id.add(cursor.getString(0));
                        pic_cloth.add(cursor.getString(1));
                    }
                }
                if (color1.equals("#fff") || color1.equals("#eee9e9") || color1.equals("#000") || color1.equals("#fffafa") || color1.equals("#cdc9c9") || color1.equals("#f5f5f5")
                        || color2.equals("#fff") || color2.equals("#eee9e9") || color2.equals("#000") || color2.equals("#fffafa") || color2.equals("#cdc9c9") || color2.equals("#f5f5f5")
                        || color3.equals("#fff") || color3.equals("#eee9e9") || color3.equals("#000") || color3.equals("#fffafa") || color3.equals("#cdc9c9") || color3.equals("#f5f5f5")) {
                    if (datatype1.equals("เสื้อยืดแขนยาว")) {
                        id.add(cursor.getString(0));
                        pic_cloth.add(cursor.getString(1));
                    }
                }
                if (color1.equals("#fff") || color1.equals("#eee9e9") || color1.equals("#000") || color1.equals("#fffafa") || color1.equals("#cdc9c9") || color1.equals("#f5f5f5")
                        || color2.equals("#fff") || color2.equals("#eee9e9") || color2.equals("#000") || color2.equals("#fffafa") || color2.equals("#cdc9c9") || color2.equals("#f5f5f5")
                        || color3.equals("#fff") || color3.equals("#eee9e9") || color3.equals("#000") || color3.equals("#fffafa") || color3.equals("#cdc9c9") || color3.equals("#f5f5f5")) {
                    if (datatype1.equals("เสื้อเชิ้ตแขนสั้น")) {
                        id.add(cursor.getString(0));
                        pic_cloth.add(cursor.getString(1));
                    }
                }
            }
        }
    }


        public void onBackPressed () {
            super.onBackPressed();
            this.finish();
            Intent in = new Intent(this, Main2Activity.class);
            startActivity(in);
            overridePendingTransition(0, 0);
            in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            // moveTaskToBack(true);
        }

}
