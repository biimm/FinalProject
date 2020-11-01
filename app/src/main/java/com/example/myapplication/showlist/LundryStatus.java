package com.example.myapplication.showlist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupMenu;

import com.example.myapplication.Adapter.ListLundryAdapter;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.ClothesWash;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.function_status;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.myapplication.connectDB.Clothesmaininterface.TABLE_NAME1;

public class LundryStatus extends AppCompatActivity {
    GridView gridviewcloth;

    Clothesmain clothesmain;
    ClothesWash clothesWash;

    Button dropdown;

    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> date_cloth;

    ListLundryAdapter listLundryAdapter;

    String formattedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lundry_status);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       dropdown = findViewById(R.id.show_dropdown_menu);


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

        final PopupMenu popupMenu = new PopupMenu(this,dropdown);

        popupMenu.getMenuInflater().inflate(R.menu.drop_down_menu , popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.dropdown_menu1){
                    Intent intent1 = new Intent(LundryStatus.this , LundryStatus.class);
                    for(int i=0;i<listLundryAdapter.position_test.size();++i){
                        if(!listLundryAdapter.position_test.get(i).equals("null")){
                            clothesmain.updatestatus(listLundryAdapter.position_test.get(i), "พร้อมใช้งาน");
                        }
                    }
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent1);
                }
                else if(id == R.id.dropdown_menu2){
                    Intent intent2 = new Intent(LundryStatus.this , LundryStatus.class);
                    for(int i=0;i<listLundryAdapter.position_test.size();++i){
                        if(!listLundryAdapter.position_test.get(i).equals("null")){
                            clothesmain.updatestatus(listLundryAdapter.position_test.get(i), "กำลังใช้งาน");
                        }
                    }
                    intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent2);
                }
                else if(id == R.id.dropdown_menu3){
                    Intent intent3 = new Intent(LundryStatus.this , LundryStatus.class);
                    for(int i=0;i<listLundryAdapter.position_test.size();++i){
                        if(!listLundryAdapter.position_test.get(i).equals("null")){
                            clothesmain.updatestatus(listLundryAdapter.position_test.get(i), "อยู่ในตะกร้าผ้า");
                        }
                    }
                    intent3.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent3);
                }
                else if(id == R.id.dropdown_menu4){
                    Intent intent4 = new Intent(LundryStatus.this , LundryStatus.class);
                    for(int i=0;i<listLundryAdapter.position_test.size();++i){
                        if(!listLundryAdapter.position_test.get(i).equals("null")){
                            clothesmain.updatestatus(listLundryAdapter.position_test.get(i), "ส่งซักรีด");
                        }
                    }
                    intent4.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent4);
                }
                return false;
            }
        });

        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
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


