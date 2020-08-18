package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class WashStatus extends AppCompatActivity {

    GridView gridviewcloth;
    Button checkall , cancelcheck , washing;
    Clothesmain clothesmain;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_status);

        checkall = findViewById(R.id.checkAll);
        cancelcheck = findViewById(R.id.cancelcheck);
        washing = findViewById(R.id.wardrobecloth);

        gridviewcloth = findViewById(R.id.gridview_status);

        clothesmain = new Clothesmain(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();

        showlistfromdb();

        final ListStatusAdapter listStatusAdapter = new ListStatusAdapter(WashStatus.this,id,pic_cloth);

        gridviewcloth.setAdapter(listStatusAdapter);
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
        Intent in = new Intent(this,function_status.class);
        startActivity(in);
        overridePendingTransition(0,0);
        in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        // moveTaskToBack(true);
    }
}
