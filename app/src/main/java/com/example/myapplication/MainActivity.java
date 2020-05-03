package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText txt_RollNo,txt_Name,txt_Score;
    Button btn_Insert,btn_Delete,btn_Modify,btn_View;
    SQLiteDatabase db;
    SQLiteOpenHelper sqLiteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = sqLiteOpenHelper.getWritableDatabase();
                String rollno = txt_RollNo.getText().toString();
                String name = txt_Name.getText().toString();
                String score = txt_Score.getText().toString();

                insertData(rollno,name,score);
            }
        });


        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = sqLiteOpenHelper.getWritableDatabase();
                String rollno = txt_RollNo.getText().toString();
                deleteData(rollno);
            }
        });
    }

    public void initView()
    {
          txt_RollNo = findViewById(R.id.txt_RollNumber);
          txt_Name = findViewById(R.id.txt_Name);
          txt_Score = findViewById(R.id.txt_Score);
          btn_Insert = findViewById(R.id.btn_Insert);
          btn_Delete = findViewById(R.id.btn_Delete);
          btn_Modify = findViewById(R.id.btn_Modify);
          btn_View = findViewById(R.id.btn_View);
          sqLiteOpenHelper = new DataBaseHelper(this);
    }

     public void insertData(String rollno,String name,String score)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_1,rollno);
        contentValues.put(DataBaseHelper.COL_2,name);
        contentValues.put(DataBaseHelper.COL_3,score);
        long id = db.insert(DataBaseHelper.TABLE_NAME,null,contentValues);
    }


    public void deleteData(String rollno)
    {
        db.delete(DataBaseHelper.TABLE_NAME,DataBaseHelper.COL_1 = "?",String[][rollno]);
    }


}
