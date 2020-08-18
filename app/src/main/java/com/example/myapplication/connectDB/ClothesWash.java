package com.example.myapplication.connectDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;


import static com.example.myapplication.connectDB.ClothesWashinterface.TABLE_NAME4;
import static com.example.myapplication.connectDB.ClothesWashinterface.WASH_BACK;
import static com.example.myapplication.connectDB.ClothesWashinterface.WASH_SENT;
import static com.example.myapplication.connectDB.ClothesWashinterface.PIC_CLOTH;


public class ClothesWash extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ClothesWash.db";
    private static final int DATABASE_VERSION = 1;

    public ClothesWash(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME4 + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PIC_CLOTH + " TEXT NOT NULL, " + WASH_SENT + " TEXT NOT NULL, " + WASH_BACK + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
