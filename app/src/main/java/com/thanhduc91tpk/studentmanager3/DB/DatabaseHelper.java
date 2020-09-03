package com.thanhduc91tpk.studentmanager3.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentDB";
    private static final int VERSION_DB = 1;
    public static final String COLUM_MALOP = "MaLop";
    public static final String COLUM_TENLOP = "TenLop";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateClass = "CREATE TABLE Classroom (MaLop text PRIMARY KEY,TenLop text)";
       // String sqlCreateClass = "CREATE TABLE Classroom (MaLop text PRIMARY KEY,TenLop text)";
        db.execSQL(sqlCreateClass);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Classroom");
        onCreate(db);
    }
}
