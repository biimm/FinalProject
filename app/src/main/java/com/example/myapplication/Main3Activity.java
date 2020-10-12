package com.example.myapplication;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;


public class Main3Activity extends AppCompatActivity {
    private static final int RQS_OPEN_IMAGE = 1;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;

    Uri targetUri = null;

    Bitmap bitmap;
    Bitmap imageBitmap;


    String currentPhotoPath;
    Uri image_uri;
    Button mCapture, mChoose;
    Button mSave;
    ImageView mImageView;
    CheckBox checkBox1, checkBox2, checkBox3;

    //check1
    String selectv1 = "#0";
    String colorv1 = "#0";

    //check2
    String selectv2 = "#0";
    String colorv2 = "#0";

    //check3
    String selectv3 = "#0";
    String colorv3 = "#0";

    //select tone
    String name_color_tone1 = "";
    String name_color_tone2 = "";
    String name_color_tone3 = "";
    String select_tone1 = "";
    String select_tone2 = "";
    String select_tone3 = "";


    Button edit1,edit2,edit3;
    int counter = 0;

    String v1 = "#0";
    String v2 = "#0";
    String v3 = "#0";

    boolean checkedit1 = false;
    boolean checkedit2 = false;
    boolean checkedit3 = false;

    boolean check1 = false;
    boolean check2 = false;
    boolean check3 = false;

    ArrayList<ColorName> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = findViewById(R.id.image_view);
        mCapture = findViewById(R.id.capture_image_btn);
        mChoose = findViewById(R.id.choose_image_btn);
        mSave = findViewById(R.id.save_button);

        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        edit1 = (Button) findViewById(R.id.edit1);
        edit2 = (Button) findViewById(R.id.edit2);
        edit3 = (Button) findViewById(R.id.edit3);

        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);




        mChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT >=
                        Build.VERSION_CODES.KITKAT) {
                    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                } else {
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                }
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                // set MIME type for image
                intent.setType("image/*");
                startActivityForResult(intent, RQS_OPEN_IMAGE);

                selectv1 = "#0";
                selectv2 = "#0";
                selectv3 = "#0";

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        mCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                            || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permission, PERMISSION_CODE);
                    } else {
                        openCamera();
                    }
                } else {
                    openCamera();
                }

                selectv1 = "#0";
                selectv2 = "#0";
                selectv3 = "#0";

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });


        final ArrayList<ColorName> colorList = new ArrayList<ColorName>();
        colorList.add(new ColorName("Black", 0x00, 0x00, 0x00)); // BW
        colorList.add(new ColorName("White", 0xff, 0xff, 0xff)); // BW
        colorList.add(new ColorName("Gray", 0x80, 0x80, 0x80)); // BW
        colorList.add(new ColorName("Navy" , 0x00, 0x00, 0x80)); // BW

        colorList.add(new ColorName("Red", 0xff, 0x00, 0x00)); // hot
        colorList.add(new ColorName("Orange", 0xff, 0x80, 0x00)); // hot
        colorList.add(new ColorName("Yellow", 0xff, 0xff, 0x00)); // hot

        colorList.add(new ColorName("Green", 0x00, 0xff, 0x00)); // cold
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0xff)); // cold
        colorList.add(new ColorName("Purple", 0x80, 0x00, 0x80)); // cold

        colorList.add(new ColorName("Brown", 0xa5, 0x2a, 0x2a)); // earth
        colorList.add(new ColorName("Beige" , 0xf5, 0xf5, 0xdc)); // earth
        colorList.add(new ColorName("Tan" , 0xd2, 0xb4, 0x8c)); // earth
        colorList.add(new ColorName("Watercress" , 0x6e , 0x93 , 0x77)); // earth


        colorList.add(new ColorName("Lightpink", 0xff, 0xb6, 0xc1)); // pastel
        colorList.add(new ColorName("Lightcoral" , 0xf0, 0x80, 0x80)); //pastel
        colorList.add(new ColorName("Lightblue" ,0xad, 0xd8, 0xe6)); // pastel
        colorList.add(new ColorName("lightSalmon" , 0xff, 0xa0, 0x7a)); // pastel
        colorList.add(new ColorName("Lightyellow" , 0xff, 0xff, 0xe0)); //pastel
        colorList.add(new ColorName("Lightgreen" , 0x90, 0xee, 0x90)); // pastel


        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedit1 = true;
                checkBox1.getBackground().clearColorFilter();
                checkBox1.setText("โปรดเลือกสีอีกครั้ง");
                v1 = "#0";
                colorv1 = "#0";

                mImageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                            if(checkedit1 == true) {
                                Bitmap bitmap = mImageView.getDrawingCache();
                                int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                                int redvalue = Color.red(pixel);
                                int greenvalue = Color.green(pixel);
                                int bluevalue = Color.blue(pixel);


                                int min = Integer.MAX_VALUE;
                                int name = 0;
                                int mse_correct;
                                String current_name = "" ;
                                int mse1 , mse2 , mse3;
                                //ColorName closestMatch = new ColorName();
                                for(int i=0;i<colorList.size();i++){

                                    mse1 = Math.abs(colorList.get(i).getR()- redvalue);
                                    mse2 = Math.abs(colorList.get(i).getG() - greenvalue);
                                    mse3 = Math.abs(colorList.get(i).getB() - bluevalue);

                                    mse_correct = mse1+mse2+mse3;
                                    //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
                                    if(mse_correct < min){
                                        min = mse_correct;
                                        name = mse_correct;
                                        current_name = colorList.get(i).getName();
                                        //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
                                    }
                                }
                                name_color_tone1 = current_name;
                                System.out.println("NAME COLOR : "+current_name);

                                String hex = String.format("#%02x%02x%02x", redvalue, greenvalue, bluevalue);
                                v1 = hex;
                                colorv1 = v1;
                                checkBox1.setBackgroundColor(Color.parseColor(hex));
                                System.out.println("Hex : " + hex);
                                checkBox1.setText("");
                                checkedit1 = false;
                            }
                        }
                        return true;
                    }
                });
            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedit2 = true;
                checkBox2.getBackground().clearColorFilter();
                checkBox2.setText("โปรดเลือกสีอีกครั้ง");
                v2 = "#0";
                colorv2 = "#0";
                mImageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                            if(checkedit2 == true) {
                                Bitmap bitmap = mImageView.getDrawingCache();
                                int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                                int redvalue = Color.red(pixel);
                                int greenvalue = Color.green(pixel);
                                int bluevalue = Color.blue(pixel);

                                int min = Integer.MAX_VALUE;
                                int name = 0;
                                int mse_correct;
                                String current_name = "" ;
                                int mse1 , mse2 , mse3;
                                //ColorName closestMatch = new ColorName();
                                for(int i=0;i<colorList.size();i++){

                                    mse1 = Math.abs(colorList.get(i).getR()- redvalue);
                                    mse2 = Math.abs(colorList.get(i).getG() - greenvalue);
                                    mse3 = Math.abs(colorList.get(i).getB() - bluevalue);

                                    mse_correct = mse1+mse2+mse3;
                                    //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
                                    if(mse_correct < min){
                                        min = mse_correct;
                                        name = mse_correct;
                                        current_name = colorList.get(i).getName();
                                        //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
                                    }
                                }
                                name_color_tone2 = current_name;
                                System.out.println("NAME COLOR : "+current_name);

                                String hex = String.format("#%02x%02x%02x", redvalue, greenvalue, bluevalue);
                                v2 = hex;
                                colorv2 = v2;
                                checkBox2.setBackgroundColor(Color.parseColor(hex));
                                System.out.println("Hex : " + hex);
                                checkBox2.setText("");
                                checkedit2 = false;
                            }
                        }
                        return true;
                    }
                });
            }
        });

        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedit3 = true;
                checkBox3.getBackground().clearColorFilter();
                checkBox3.setText("โปรดเลือกสีอีกครั้ง");
                v3 = "#0";
                colorv3 = "#0";

                mImageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                            if(checkedit3 == true) {
                                Bitmap bitmap = mImageView.getDrawingCache();
                                int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                                int redvalue = Color.red(pixel);
                                int greenvalue = Color.green(pixel);
                                int bluevalue = Color.blue(pixel);

                                int min = Integer.MAX_VALUE;
                                int name = 0;
                                int mse_correct;
                                String current_name = "" ;
                                int mse1 , mse2 , mse3;
                                //ColorName closestMatch = new ColorName();
                                for(int i=0;i<colorList.size();i++){

                                    mse1 = Math.abs(colorList.get(i).getR()- redvalue);
                                    mse2 = Math.abs(colorList.get(i).getG() - greenvalue);
                                    mse3 = Math.abs(colorList.get(i).getB() - bluevalue);

                                    mse_correct = mse1+mse2+mse3;
                                    //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
                                    if(mse_correct < min){
                                        min = mse_correct;
                                        name = mse_correct;
                                        current_name = colorList.get(i).getName();
                                        //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
                                    }
                                }

                                name_color_tone3 = current_name;

                                System.out.println("NAME COLOR : "+current_name);

                                String hex = String.format("#%02x%02x%02x", redvalue, greenvalue, bluevalue);
                                v3 = hex;
                                colorv3 = v3;
                                checkBox3.setBackgroundColor(Color.parseColor(hex));
                                System.out.println("Hex : " + hex);
                                checkBox3.setText("");
                                checkedit3 = false;
                            }
                        }
                        return true;
                    }
                });
            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    //Toast.makeText(Main3Activity.this, "select c1", Toast.LENGTH_SHORT).show();
                    selectv1 = colorv1;
                    System.out.println(selectv1);
                    //name_color = name_color1;
                    select_tone1 = name_color_tone1;
                    System.out.println("name_select : " + select_tone1);

                } else {
                    selectv1 = "#0";
                    select_tone1 = "";
                }
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    //Toast.makeText(Main3Activity.this, "select c2", Toast.LENGTH_SHORT).show();
                    selectv2 = colorv2;
                    System.out.println(selectv2);
                    // name_color = name_color2;
                    select_tone2 = name_color_tone2;
                    System.out.println("name_select : " + select_tone2);

                } else {
                    selectv2 = "#0";
                    select_tone2 = "";
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    //Toast.makeText(Main3Activity.this, "select c3", Toast.LENGTH_SHORT).show();
                    selectv3 = colorv3;
                    System.out.println(selectv3);
                    //name_color = name_color3;
                    select_tone3 = name_color_tone3;
                    System.out.println("name_select : " + select_tone3);

                } else {
                    selectv3 = "#0";
                    select_tone3 = "";
                }
            }
        });



        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                intent.putExtra("image" , targetUri.toString());
                intent.putExtra("color1", selectv1);
                intent.putExtra("color2", selectv2);
                intent.putExtra("color3", selectv3);
                intent.putExtra("tone1" , select_tone1);
                intent.putExtra("tone2" , select_tone2);
                intent.putExtra("tone3" , select_tone3);

                startActivity(intent);
            }
        });
    }
    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Caamera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT ,image_uri);
        startActivityForResult(camera, IMAGE_CAPTURE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else{

                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Uri dataUri = data.getData();

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == RQS_OPEN_IMAGE) {
                System.out.println("noCam");
                targetUri = data.getData();
                updatImage(data.getData());
            } else {
                mImageView.setImageURI(image_uri);
                targetUri = image_uri;
                try {
                    extractProminentColors(BitmapFactory.decodeStream(
                            getContentResolver()
                                    .openInputStream(image_uri)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Cam");
            }
        }
    }

    private void updatImage(Uri uri){
        if (uri != null){
            Bitmap bm;
            try {
                bm = BitmapFactory.decodeStream(
                        getContentResolver()
                                .openInputStream(uri));
                mImageView.setImageBitmap(bm);

                extractProminentColors(bm);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    //extract dominent colors
    private void extractProminentColors(Bitmap bitmap){
        int defaultColor = 0x000000;

        String current_name = "" ;

        final ArrayList<ColorName> colorList = new ArrayList<ColorName>();
        colorList.add(new ColorName("Black", 0x00, 0x00, 0x00)); // BW
        colorList.add(new ColorName("White", 0xff, 0xff, 0xff)); // BW
        colorList.add(new ColorName("Gray", 0x80, 0x80, 0x80)); // BW
        colorList.add(new ColorName("Navy" , 0x00, 0x00, 0x80)); // BW

        colorList.add(new ColorName("Red", 0xff, 0x00, 0x00)); // hot
        colorList.add(new ColorName("Orange", 0xff, 0x80, 0x00)); // hot
        colorList.add(new ColorName("Yellow", 0xff, 0xff, 0x00)); // hot

        colorList.add(new ColorName("Green", 0x00, 0xff, 0x00)); // cold
        colorList.add(new ColorName("Blue", 0x00, 0x00, 0xff)); // cold
        colorList.add(new ColorName("Purple", 0x80, 0x00, 0x80)); // cold

        colorList.add(new ColorName("Brown", 0xa5, 0x2a, 0x2a)); // earth
        colorList.add(new ColorName("Beige" , 0xf5, 0xf5, 0xdc)); // earth
        colorList.add(new ColorName("Tan" , 0xd2, 0xb4, 0x8c)); // earth
        colorList.add(new ColorName("Olive" , 0x80, 0x80, 0x00)); // earth
        colorList.add(new ColorName("Watercress" , 0x6e , 0x93 , 0x77)); // earth


        colorList.add(new ColorName("Lightpink", 0xff, 0xb6, 0xc1)); // pastel
        colorList.add(new ColorName("Lightcoral" , 0xf0, 0x80, 0x80)); //pastel
        colorList.add(new ColorName("Lightblue" ,0xad, 0xd8, 0xe6)); // pastel
        colorList.add(new ColorName("lightSalmon" , 0xff, 0xa0, 0x7a)); // pastel
        colorList.add(new ColorName("Lightyellow" , 0xff, 0xff, 0xe0)); //pastel
        colorList.add(new ColorName("Lightgreen" , 0x90, 0xee, 0x90)); // pastel


        Palette p = Palette.from(bitmap).generate();

        int VibrantColor = p.getVibrantColor(defaultColor);
        v1 = String.format("#%X", VibrantColor);
        colorv1 = v1;
        System.out.println("Vi : "+VibrantColor);
        System.out.println("colorv1 : "+colorv1);

//          System.out.println("ColorList : " + colorList.size());
//
        int c1 = Color.parseColor(colorv1);
        int red1 = Color.red(c1);
        int green1 = Color.green(c1);
        int blue1 = Color.blue(c1);

        int mse1,mse2,mse3,mse_correct1;
        int min1 = Integer.MAX_VALUE;

        String testname1 = "";

        for(int i=0;i<colorList.size();i++){

            mse1 = Math.abs(colorList.get(i).getR()- red1);
            mse2 = Math.abs(colorList.get(i).getG() - green1);
            mse3 = Math.abs(colorList.get(i).getB() - blue1);

            mse_correct1 = mse1+mse2+mse3;
            //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
            if(mse_correct1 < min1){
                min1 = mse_correct1;
//                    name = mse_correct;
                testname1 = colorList.get(i).getName();

                //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
            }
        }
        name_color_tone1 = testname1;
        //System.out.println("C1 : " + c1);
        System.out.println("test1 :" + testname1);

        checkBox1.setBackgroundColor(VibrantColor);

        /// สีหม่นออกสว่าง



        int MutedColorLight = p.getLightMutedColor(defaultColor);
        v2 = String.format("#%X", MutedColorLight);
        colorv2 = v2;
        System.out.println("colorv2 : "+colorv2);

        int c2 = Color.parseColor(colorv2);
        int red2 = Color.red(c2);
        int green2 = Color.green(c2);
        int blue2 = Color.blue(c2);

        int mse4,mse5,mse6,mse_correct2;
        int min2 = Integer.MAX_VALUE;

        String testname2 = "";

        for(int i=0;i<colorList.size();i++){

            mse4 = Math.abs(colorList.get(i).getR()- red2);
            mse5 = Math.abs(colorList.get(i).getG() - green2);
            mse6 = Math.abs(colorList.get(i).getB() - blue2);

            mse_correct2 = mse4+mse5+mse6;
            //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
            if(mse_correct2 < min2){
                min2 = mse_correct2;
//                    name = mse_correct;
                testname2 = colorList.get(i).getName();

                //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
            }
        }
        name_color_tone2 = testname2;
        //System.out.println("C2 : " + c2);
        System.out.println("test2 :" + testname2);

        checkBox2.setBackgroundColor(MutedColorLight);

        /// สีหม่นปานกลาง
//            int MutedColor = p.getMutedColor(defaultColor);
//            v3 = String.format("#%X", MutedColor);
//            colorv3 = v3;
//            checkBox3.setBackgroundColor(MutedColor);

//            int VibrantColorLight = p.getLightVibrantColor(defaultColor);
//            v2 = String.format("#%X", VibrantColorLight);
//            colorv2 = v2;
//            checkBox2.setBackgroundColor(VibrantColorLight);

//            int VibrantColorDark = p.getDarkVibrantColor(defaultColor);
//            v2 = String.format("#%X", VibrantColorDark);
//            checkBox2.setText("VibrantColorDark: " + String.format("#%X", VibrantColorDark));
//            checkBox2.setBackgroundColor(VibrantColorDark);

        ///

        int MutedColorDark = p.getDarkMutedColor(defaultColor);
        v3 = String.format("#%X", MutedColorDark);
        colorv3 = v3;
        System.out.println("colorv3 : "+colorv3);
        int c3 = Color.parseColor(colorv3);
        int red3 = Color.red(c3);
        int green3 = Color.green(c3);
        int blue3 = Color.blue(c3);

        int mse7,mse8,mse9,mse_correct3;
        int min3 = Integer.MAX_VALUE;

        String testname3 = "";

        for(int i=0;i<colorList.size();i++){

            mse7 = Math.abs(colorList.get(i).getR()- red3);
            mse8 = Math.abs(colorList.get(i).getG() - green3);
            mse9 = Math.abs(colorList.get(i).getB() - blue3);

            mse_correct3 = mse7+mse8+mse9;
            //System.out.println("1---"+mse1+" 2---"+ mse2+" 3---"+mse3);
            if(mse_correct3 < min3){
                min3 = mse_correct3;
//                    name = mse_correct;
                testname3 = colorList.get(i).getName();

                //System.out.println("mse_correct : " + name+" "+colorList.get(i).getName());
            }
        }
        name_color_tone3 = testname3;
        //System.out.println("C3 : " + c3);
        System.out.println("test3 :" + testname3);

        checkBox3.setBackgroundColor(MutedColorDark);

    }
}