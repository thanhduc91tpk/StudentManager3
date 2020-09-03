package com.thanhduc91tpk.studentmanager3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thanhduc91tpk.studentmanager3.DB.DatabaseHelper;
import com.thanhduc91tpk.studentmanager3.model.ClassObject;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Context context;
    private final String TABLE_NAME = "Classroom";

    public ClassDAO(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public int addClass(ClassObject classObject){
        String maLop = classObject.getmId();
        String tenLop = classObject.getmName();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUM_MALOP,maLop);
        contentValues.put(DatabaseHelper.COLUM_TENLOP,tenLop);
        if(database.insert(TABLE_NAME,null,contentValues) == -1){
            return -1;
        }
        return 1;
    }

    public int update(ClassObject classObject){
        String maLop = classObject.getmId();
        String tenLop = classObject.getmName();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUM_MALOP,maLop);
        contentValues.put(DatabaseHelper.COLUM_TENLOP,tenLop);
        if(database.update(TABLE_NAME,contentValues,"MaLop=?",new String[]{classObject.getmId()}) == -1){
            return -1;
        }
        return 1;
    }

    public int delClass(String id){
        if( database.delete(TABLE_NAME,"MaLop=?",new String[]{id}) == -1) return -1;
        return 1;
    }

    public List<ClassObject> getAll(){
        List<ClassObject> lsClass = new ArrayList<>();

        Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            String maLop = cursor.getString(0);
            String tenLop = cursor.getString(1);
            ClassObject classObject = new ClassObject(maLop,tenLop);
            lsClass.add(classObject);
            cursor.moveToNext();
        }
        cursor.close();
        return lsClass;
    }
}
