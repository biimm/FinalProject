package com.example.myapplication.showlist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.GridView;

import com.example.myapplication.Adapter.ListLundryAdapter;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.function_status;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class LundryStatus extends AppCompatActivity {
    GridView gridviewcloth;

    Clothesmain clothesmain;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> date_cloth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lundry_status);

        gridviewcloth = findViewById(R.id.gridview_status);

        clothesmain = new Clothesmain(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();
        status_cloth = new ArrayList<>();
        date_cloth = new ArrayList<>();

        showlistfromdb();

        final ListLundryAdapter listLundryAdapter = new ListLundryAdapter(LundryStatus.this,id,pic_cloth,status_cloth,date_cloth);

        gridviewcloth.setAdapter(listLundryAdapter);


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
