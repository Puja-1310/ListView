package com.example.listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "emp_database";
    private static final String TABLE_NAME1 = "employee";
    private static final String COL_EMP_NAME = "name";
    private static final String COL_EMP_SURNAME = "surname";
    private static final String COL_EMP_GENDER = "gender";
    private static final String COL_EMP_DOB = "dob";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";
    private static final String COL_RETYPEPASSWORD = "ReTypePassword";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME1 + " (" +
                COL_EMP_NAME + " TEXT, " +
                COL_EMP_SURNAME + " TEXT, " +
                COL_EMP_GENDER + " TEXT, " +
                COL_EMP_DOB + " TEXT, " +
                COL_USERNAME + " TEXT, " +
                COL_PASSWORD + " TEXT, " +
                COL_RETYPEPASSWORD + " TEXT )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE " + TABLE_NAME1 + " ADD COLUMN " + COL_EMP_DOB + " TEXT");
            db.execSQL("ALTER TABLE " + TABLE_NAME1 + " ADD COLUMN " + COL_RETYPEPASSWORD + " TEXT");
        }
//        onCreate(db);
    }

    public long insertData(String name, String surname, String gender,String dob, String userName, String password, String ReTypePassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_EMP_NAME, name);
        values.put(COL_EMP_SURNAME, surname);
        values.put(COL_EMP_GENDER, gender);
        values.put(COL_EMP_DOB,dob);
        values.put(COL_USERNAME, userName);
        values.put(COL_PASSWORD,password);
        values.put(COL_RETYPEPASSWORD,ReTypePassword);

        long result = db.insert(TABLE_NAME1, null, values);
        db.close();
        return result ;
    }

    public List<String> getAllRecords(){
        List<String> recordsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        if (cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMP_NAME));
                recordsList.add(name);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recordsList;
    }
}


