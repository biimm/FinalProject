package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.connectDB.Clothesmain;

import java.util.Calendar;

public class EditClothes extends AppCompatActivity {

    ImageView mimage;
    Spinner spstatus;
    EditText edttype,edtdate;
    TextView textviewc1,textviewc2,textviewc3;
    Button save;

    String idedit = "";
    String imageedit = "";
    String typeedit = "";
    String dateedit = "";
    String color1edit = "";
    String color2edit = "";
    String color3edit = "";

    String V01 = "#0";
    String V02 = "#0";
    String V03 = "#0";


    String datatype , datastatus;


    Clothesmain mcloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_clothes);

        mimage = findViewById(R.id.image_edit);
        edttype = findViewById(R.id.edttype);
        edtdate = findViewById(R.id.edtdate);
        spstatus = findViewById(R.id.spstatus);
        textviewc1 = findViewById(R.id.textviewc1);
        textviewc2 = findViewById(R.id.textviewc2);
        textviewc3 = findViewById(R.id.textviewc3);
        save = findViewById(R.id.btn_save);

        //รับไอดี
        idedit = getIntent().getStringExtra("id_detail");
        imageedit = getIntent().getStringExtra("image_detail");
        typeedit = getIntent().getStringExtra("type_detail");
        dateedit = getIntent().getStringExtra("date_detail");
        color1edit = getIntent().getStringExtra("color1_detail");
        color2edit = getIntent().getStringExtra("color2_detail");
        color3edit = getIntent().getStringExtra("color3_detail");


        mcloth = new Clothesmain(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mcloth.updatestatus(idedit,imageedit,typeedit,dateedit,datastatus,color1edit,color2edit,color3edit);

                Toast.makeText(getApplicationContext(),"อัพเดทสำเร็จ",Toast.LENGTH_SHORT).show();

                Intent in = new Intent(EditClothes.this,Detaillistcloth.class);
                in.putExtra("id" , idedit);
                in.putExtra("pic_cloth",imageedit);
                in.putExtra("type_cloth" , typeedit);
                in.putExtra("date_cloth" , dateedit);
                in.putExtra("status_cloth" , datastatus);
                in.putExtra("color1_cloth" , color1edit);
                in.putExtra("color2_cloth" , color2edit);
                in.putExtra("color3_cloth" , color3edit);
                in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(in);

            }
        });

        final Uri image_uri = Uri.parse(imageedit);
        mimage.setImageURI(image_uri);

        edttype.setText(typeedit);
        edttype.setEnabled(false);

        edtdate.setText(dateedit);
        edtdate.setEnabled(false);

        ArrayAdapter<CharSequence> adapterstatus = ArrayAdapter.createFromResource(this,R.array.Spinner_Status,android.R.layout.simple_spinner_item);
        adapterstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spstatus.setAdapter(adapterstatus);
        spstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datastatus = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Intent bundle = getIntent();
        V01 = bundle.getStringExtra("color1_detail");
        if (V01.equals("#0") ) {
            textviewc1.setVisibility(View.GONE);
        } else {
            textviewc1.setBackgroundColor(Color.parseColor(V01));
        }

        V02 = bundle.getStringExtra("color2_detail");
        if (V02.equals("#0") ) {
            textviewc2.setVisibility(View.GONE);
        } else {
            textviewc2.setBackgroundColor(Color.parseColor(V02));
        }

        V03 = bundle.getStringExtra("color3_detail");
        if (V03.equals("#0") ) {
            textviewc3.setVisibility(View.GONE);
        } else {
            textviewc3.setBackgroundColor(Color.parseColor(V03));
        }



    }

}
