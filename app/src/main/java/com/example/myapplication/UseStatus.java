package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class UseStatus extends AppCompatActivity {

    GridView gridviewcloth;
    Button checkall , cancelcheck , basket;
    Clothesmain clothesmain;
    CheckBox check;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_status);

        checkall = findViewById(R.id.checkAll);
        cancelcheck = findViewById(R.id.cancelcheck);
        basket = findViewById(R.id.basketcloth);
        check = findViewById(R.id.checkBox);

        gridviewcloth = findViewById(R.id.gridview_status);

        clothesmain = new Clothesmain(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();

//        checkall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int count = gridviewcloth.getAdapter().getCount();
//                for (int i = 0; i < count; i++) {
//                    LinearLayout itemLayout = (LinearLayout)gridviewcloth.getChildAt(i); // Find by under LinearLayout
//                    CheckBox checkbox = (CheckBox)itemLayout.findViewById(R.id.checkBox);
//                    checkbox.setChecked(true);
//                }
//            }
//        });
//
//        cancelcheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int count = gridviewcloth.getAdapter().getCount();
//                for (int i = 0; i < count; i++) {
//                    LinearLayout itemLayout = (LinearLayout)gridviewcloth.getChildAt(i); // Find by under LinearLayout
//                    CheckBox checkbox = (CheckBox)itemLayout.findViewById(R.id.checkBox);
//                    checkbox.setChecked(false);
//                }
//            }
//        });

        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(UseStatus.this,LundryStatus.class);
                    intent.putExtra("pic_use" , pic_cloth);
                    startActivity(intent);
                    System.out.println("sent to lundry");

            }
        });

        showlistfromdb();

        final ListStatusAdapter listStatusAdapter = new ListStatusAdapter(UseStatus.this,id,pic_cloth);

        gridviewcloth.setAdapter(listStatusAdapter);
    }

    private void showlistfromdb() {
        SQLiteDatabase db = clothesmain.getWritableDatabase();
        Cursor resdbcloth = db.rawQuery("select * from " + TABLE_NAME1+" where statuscloth = "+ '"' +"กำลังใช้งาน"+ '"',null);

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
