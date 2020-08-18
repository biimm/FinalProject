package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.palette.graphics.Palette;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Button edit1,edit2,edit3;
    int counter = 0;

    String v1 = "#0";
    String v2 = "#0";
    String v3 = "#0";

    boolean checkedit1 = false;
    boolean checkedit2 = false;
    boolean checkedit3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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
                                int r = Color.red(pixel);
                                int g = Color.green(pixel);
                                int b = Color.blue(pixel);
                                String hex = String.format("#%02x%02x%02x", r, g, b);
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
                                int r = Color.red(pixel);
                                int g = Color.green(pixel);
                                int b = Color.blue(pixel);
                                String hex = String.format("#%02x%02x%02x", r, g, b);
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
                                int r = Color.red(pixel);
                                int g = Color.green(pixel);
                                int b = Color.blue(pixel);
                                String hex = String.format("#%02x%02x%02x", r, g, b);
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
                } else {
                    selectv1 = "#0";
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

                } else {
                    selectv2 = "#0";
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
                } else {
                    selectv3 = "#0";
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

        //extract prominent colors
        private void extractProminentColors(Bitmap bitmap){
            int defaultColor = 0x000000;

            Palette p = Palette.from(bitmap).generate();

            /// สีสดปานกลาง
            int VibrantColor = p.getVibrantColor(defaultColor);
            v1 = String.format("#%X", VibrantColor);
            colorv1 = v1;
            checkBox1.setBackgroundColor(VibrantColor);

            /// สีหม่นออกสว่าง
            int MutedColorLight = p.getLightMutedColor(defaultColor);
            v2 = String.format("#%X", MutedColorLight);
            colorv2 = v2;
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

            int MutedColorDark = p.getDarkMutedColor(defaultColor);
            v3 = String.format("#%X", MutedColorDark);
            //textMutedDark.setText("MutedColorDark: " + String.format("#%X", MutedColorDark));
            colorv3 = v3;
            checkBox3.setBackgroundColor(MutedColorDark);



        }

    }
