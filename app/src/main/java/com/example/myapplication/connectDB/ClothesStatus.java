package com.example.myapplication.connectDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.myapplication.connectDB.ClothesStatusinterface.STATUS_ID;
import static com.example.myapplication.connectDB.ClothesStatusinterface.STATUS_NAME;
import static com.example.myapplication.connectDB.ClothesStatusinterface.TABLE_NAME2;

public class ClothesStatus extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ClothesStatus.db";
    private static final int DATABASE_VERSION = 1;

    public ClothesStatus(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + " (" + STATUS_ID + " INT, " + STATUS_NAME + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
