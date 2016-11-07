package com.example.hamza.finalyearproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hamza on 11/7/2016.
 */

public class DataBaseHelperClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ComplainDB";
    private static final String TABLE_NAME = "ComplainTable";
    private static final String COL_1 = "C_ID";
    private static final String COL_2 = "TOWN NAME";
    private static final String COL_3 = "UC";
    private static final String COL_4 = "ComplainType";
    private static final String COL_5 = "Description";
   // private static final String COL_6 = "Image";


    public DataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      //  db.execSQL("CREATE TABLE" + TABLE_NAME + "(C_ID INTEGER PRIMARY KEY AUTOINCREMENT,TOWN NAME VARCHAR(20),UC INTEGER,ComplainType VARCHAR(20),Description VARCHAR(250)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + DATABASE_NAME + " ( " +
                COL_1 + " TEXT PRIMARY KEY, " +
                COL_2 + " TEXT NOT NULL , " +
                COL_3 + " TEXT NOT NULL );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);

        onCreate(db);
    }
}
