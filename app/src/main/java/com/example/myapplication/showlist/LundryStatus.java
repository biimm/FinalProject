package com.example.myapplication.showlist;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListLundryAdapter;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.ClothesWash;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.function_status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myapplication.connectDB.ClothesWashinterface.PIC_CLOTH;
import static com.example.myapplication.connectDB.ClothesWashinterface.TABLE_NAME4;
import static com.example.myapplication.connectDB.ClothesWashinterface.WASH_SENT;
import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class LundryStatus extends AppCompatActivity {
    GridView gridviewcloth;

    Clothesmain clothesmain;
    ClothesWash clothesWash;

    Button sendtolundry;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> date_cloth;


    String formattedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lundry_status);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sendtolundry = findViewById(R.id.washcloth);


        gridviewcloth = findViewById(R.id.gridview_status);


        clothesmain = new Clothesmain(this);

        clothesWash = new ClothesWash(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        status_cloth = new ArrayList<>();
        date_cloth = new ArrayList<>();

        showlistfromdb();

        final ListLundryAdapter listLundryAdapter = new ListLundryAdapter(LundryStatus.this,id,pic_cloth,status_cloth,date_cloth);

        gridviewcloth.setAdapter(listLundryAdapter);

        sendtolundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LundryStatus.this , LundryStatus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

                for(int i=0;i<listLundryAdapter.position_test.size();++i){

                    if(!listLundryAdapter.position_test.get(i).equals("null")){
                        clothesmain.updatestatus(listLundryAdapter.position_test.get(i), "ส่งซักรีด");
                    }


                }



                Calendar c = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = df.format(c.getTime());

                SQLiteDatabase dbccloth = clothesWash.getWritableDatabase();
                ContentValues addwash = new ContentValues();
                addwash.put(PIC_CLOTH , pic_cloth.get(listLundryAdapter.position_choose));
                addwash.put(WASH_SENT , formattedDate);
                dbccloth.insert(TABLE_NAME4,null,addwash);

                Toast.makeText(LundryStatus.this , "ส่งซักรีด : " + formattedDate , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showlistfromdb() {
        SQLiteDatabase db = clothesmain.getWritableDatabase();
        Cursor resdbcloth = db.rawQuery("select * from " + TABLE_NAME1+" where statuscloth = "+ '"' +"อยู่ในตะกร้าผ้า"+ '"',null);

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
