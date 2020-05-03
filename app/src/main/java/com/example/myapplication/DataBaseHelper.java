package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "DataBase.db";
    public static final String TABLE_NAME = "Database";

    public static String COL_1 = "rollno";
    public static String COL_2 = "name";
    public static String COL_3 = "score";

    public DataBaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(rollno INTEGER PRIMARY KEY AUTO INCRREMEANT,name TEXT,score TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);
    }
}
