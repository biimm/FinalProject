package com.example.myapplication.showlist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListWashAdapter;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.ClothesWash;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.function_status;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;


public class WashStatus extends AppCompatActivity {

    GridView gridviewcloth;
    ClothesWash clothesWash;
    Clothesmain clothesmain;

    Button sendback;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> date_wash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_status);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sendback = findViewById(R.id.washcloth);

        gridviewcloth = findViewById(R.id.gridview_status);

        clothesWash = new ClothesWash(this);
        clothesmain = new Clothesmain(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        date_wash = new ArrayList<>();

        showlistfromdb();

        final ListWashAdapter listWashAdapter = new ListWashAdapter(WashStatus.this,id,pic_cloth,date_wash);

        gridviewcloth.setAdapter(listWashAdapter);

        sendback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WashStatus.this , WashStatus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

                for(int i=0;i<listWashAdapter.position_test.size();++i){

                    if(!listWashAdapter.position_test.get(i).equals("null")){
                        clothesmain.updatestatus(listWashAdapter.position_test.get(i), "พร้อมใช้งาน");
                    }


                }
                Toast.makeText(WashStatus.this , "เสื้อผ้าพร้อมใช้งาน" , Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showlistfromdb() {
        SQLiteDatabase db = clothesmain.getWritableDatabase();
        Cursor resdbcloth = db.rawQuery("select * from " + TABLE_NAME1+" where statuscloth = "+ '"' +"ส่งซักรีด"+ '"',null);

        int countresdbcloth = resdbcloth.getCount();

        if(countresdbcloth == 0){
            return;
        }
        else {
            while (resdbcloth.moveToNext()){
                id.add(resdbcloth.getString(0));
                pic_cloth.add(resdbcloth.getString(1));
            }
        }

    }


    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        Intent in = new Intent(this, function_status.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
