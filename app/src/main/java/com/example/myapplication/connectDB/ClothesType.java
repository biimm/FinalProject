package com.example.myapplication.connectDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import static com.example.myapplication.connectDB.ClothesTypeinterface.TABLE_NAME3;
import static com.example.myapplication.connectDB.ClothesTypeinterface.TYPE_ID;
import static com.example.myapplication.connectDB.ClothesTypeinterface.TYPE_NAME;

public class ClothesType extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ClothesType.db";
    private static final int DATABASE_VERSION = 1;

    public ClothesType(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME3 + " (" + TYPE_ID + " INT , " + TYPE_NAME + " TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
