package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    private static final int PERMISSION_CODE =1000;
    private int IMAGE_CAPTURE_CODE = 1001;
    private static final int CAMERA_REQUEST_CODE = 102;
    private int GALLERY_REQUEST_CODE = 105;
    private Bitmap bitmap;
    String currentPhotoPath;
    Uri image_uri;
    Button mCapture, mChoose;
    Button mSave;
    ImageView mImageView;
//    TextView textview1, textview2, textview3;
    CheckBox checkBox1,checkBox2,checkBox3;
    int counter=0;
    int colorR=0;
    int colorG=0;
    int colorB =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mImageView = findViewById(R.id.image_view);
//        textview1 = (TextView) findViewById(R.id.textview1);
//        textview2 = (TextView) findViewById(R.id.textview2);
//        textview3 = (TextView) findViewById(R.id.textview3);
        mCapture = findViewById(R.id.capture_image_btn);
        mChoose = findViewById(R.id.choose_image_btn);
        mSave = findViewById(R.id.save_button);
        checkBox1 =  findViewById(R.id.checkBox);
        checkBox2 =  findViewById(R.id.checkBox2);
        checkBox3 =  findViewById(R.id.checkBox3);
        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);

        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    counter++;
                    bitmap = mImageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);
                    colorR = r;
                    colorG = g;
                    colorB = b;

                    if (counter == 1) {
                        checkBox1.setBackgroundColor(Color.rgb(r, g, b));
                        checkBox1.setText("R:" + r + " G:" + g + " B:" + b);
                    } else if (counter == 2) {
                        checkBox2.setBackgroundColor(Color.rgb(r, g, b));
                        checkBox2.setText("R:" + r + " G:" + g + " B:" + b);
                    } else if (counter == 3) {
                        checkBox3.setBackgroundColor(Color.rgb(r, g, b));
                        checkBox3.setText("R:" + r + " G:" + g + " B:" + b);
                    }
                }
                return true;
            }
        });




        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox) v).isChecked()){
                    Toast.makeText(Main3Activity.this,"select this 1" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox) v).isChecked()){
                    Toast.makeText(Main3Activity.this,"select this 2" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox) v).isChecked()){
                    Toast.makeText(Main3Activity.this,"select this 3" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        mChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });

        mCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                            || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permission = {Manifest.permission.CAMERA , Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permission,PERMISSION_CODE);
                    }
                    else{
                        opemCamera();
                    }
                }
                else{
                    opemCamera();
                }
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                intent.putExtra("image_uri", image_uri.toString());

                intent.putExtra("Checked1" , checkBox1.getTextColors().toString());
                intent.putExtra("Checked2" , checkBox2.getTextColors().toString());
                intent.putExtra("Checked3" , checkBox3.getTextColors().toString());

                startActivity(intent);
            }
        });
    }


//    public void itemClicked(View v) {
//        //code to check if this checkbox is checked!
//        CheckBox checkBox1 = (CheckBox)v;
//        CheckBox checkBox2 = (CheckBox)v;
//        CheckBox checkBox3 = (CheckBox)v;
//        if(checkBox1.isChecked()){
//            Toast.makeText(Main3Activity.this,
//                    "Checked", Toast.LENGTH_LONG).show();
//        }
//        if(checkBox2.isChecked()){
//            Toast.makeText(Main3Activity.this,
//                    "Checked", Toast.LENGTH_LONG).show();
//        }
//        if(checkBox3.isChecked()){
//            Toast.makeText(Main3Activity.this,
//                    "Checked", Toast.LENGTH_LONG).show();
//        }
//
//    }




    private void opemCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION,"From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,image_uri);
        startActivityForResult(camera,IMAGE_CAPTURE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE: {
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    opemCamera();
                }
                else{
                    Toast.makeText(this , "PERMISSION denied..." , Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //// show image
        if(resultCode == Activity.RESULT_OK){
            mImageView.setImageURI(image_uri);
        }
        //// show folder image
        if(requestCode == GALLERY_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                Uri contentUri = data.getData();
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStamp +"."+getFileExt(contentUri);
                Log.d("tag", "onActivityResult: Gallery Image Uri:  " +  imageFileName);
                mImageView.setImageURI(contentUri);
            }
        }
    }

    private String getFileExt(Uri contentUri) {
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(contentUri));
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "net.smallacademy.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
            }
        }
    }
}
