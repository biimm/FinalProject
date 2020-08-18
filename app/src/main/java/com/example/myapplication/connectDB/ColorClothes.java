package com.example.myapplication.connectDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import static com.example.myapplication.connectDB.ClothesWashinterface.PIC_CLOTH;
import static com.example.myapplication.connectDB.ColorClothesinterface.COLOR_CLOTH1;
import static com.example.myapplication.connectDB.ColorClothesinterface.COLOR_CLOTH2;
import static com.example.myapplication.connectDB.ColorClothesinterface.COLOR_CLOTH3;
import static com.example.myapplication.connectDB.ColorClothesinterface.TABLE_NAME5;


public class ColorClothes extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ClothesColor.db";
    private static final int DATABASE_VERSION = 1;

    public ColorClothes(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME5 + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PIC_CLOTH + " BLOB NOT NULL, " + COLOR_CLOTH1 + " TEXT NOT NULL, " + COLOR_CLOTH2 + " TEXT NOT NULL," +  COLOR_CLOTH3
                + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
