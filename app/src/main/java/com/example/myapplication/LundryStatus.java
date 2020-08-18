package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class LundryStatus extends AppCompatActivity {
    GridView gridviewcloth;
    Button checkall , cancelcheck , washing;
    Clothesmain clothesmain;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;

    String pic_use = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lundry_status);

        checkall = findViewById(R.id.checkAll);
        cancelcheck = findViewById(R.id.cancelcheck);
        washing = findViewById(R.id.washcloth);

        gridviewcloth = findViewById(R.id.gridview_status);

        clothesmain = new Clothesmain(this);

        id = new ArrayList<>();
        pic_cloth = new ArrayList<>();

        pic_use = getIntent().getStringExtra("pic_use");



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
