package com.example.myapplication.showlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.FindClothes;
import com.example.myapplication.R;
import com.example.myapplication.connectDB.Clothesmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ExampleResultMatch extends AppCompatActivity {

    ImageView imageView1,imageView2;
    Button use;

    String pic1getfromResult , pic2getfromResult , typefromResult;

    Clothesmain clothesmain;
    String idmatch , idresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_result_match);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clothesmain = new Clothesmain(this);

        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);

        use = findViewById(R.id.use);

        //get pic type from ResultMatchClothes
        pic1getfromResult = getIntent().getStringExtra("imageExam");
        pic2getfromResult = getIntent().getStringExtra("imageselectExam");
        typefromResult = getIntent().getStringExtra("typetoExam");

        idmatch = getIntent().getStringExtra("idfrommatch");
        idresult = getIntent().getStringExtra("idfromresult");

        System.out.print("Type : " + typefromResult);

        final Uri image_uri1 = Uri.parse(pic1getfromResult);

        final Uri image_uri2 = Uri.parse(pic2getfromResult);

        if(typefromResult.equals("กางเกงขายาว")|| typefromResult.equals("กางเกงขาสั้น") || typefromResult.equals("กระโปรง")){
            imageView2.setImageURI(image_uri1);

            imageView1.setImageURI(image_uri2);
        }
        else{
            imageView1.setImageURI(image_uri1);

            imageView2.setImageURI(image_uri2);
        }

        //update status pic1,pic2
        use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"กำลังใช้งาน",Toast.LENGTH_SHORT).show();
                //clothesmain.updatestatus(String.valueOf(id.get(listSearchAdapter.position_choose)) , "กำลังใช้งาน");
                clothesmain.updatestatus(String.valueOf(idmatch) , "กำลังใช้งาน");
                clothesmain.updatestatus(String.valueOf(idresult) , "กำลังใช้งาน");

                Intent intent = new Intent(ExampleResultMatch.this , FindClothes.class);
                startActivity(intent);
            }
        });

    }
}
