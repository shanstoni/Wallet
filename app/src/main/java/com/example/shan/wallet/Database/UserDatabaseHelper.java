package com.example.shan.wallet.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shan.wallet.Models.UserModelClass;

/**
 * Created by shan on 04.09.2017.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userDatabase.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COLUMN_1 = "ID ";
    public static final String COLUMN_2 = "USERNAME";
    public static final String COLUMN_3 = "NAME";
    public static final String COLUMN_4 = "SURNAME";
    public static final String COLUMN_5 = "PASSWORD";
    public static final String COLUMN_6 = "GENDER";
    public static final String COLUMN_7 = "EMAIL";
    public static final String COLUMN_8 = "ROLES";



    public UserDatabaseHelper(Context context) {
        //super(context, DATABASE_NAME, factory, version);
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, NAME TEXT, SURNAME TEXT, PASSWORD TEXT, GENDER TEXT, EMAIL TEXT, ROLES TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public boolean RegisterUser(UserModelClass userModelClass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2,userModelClass.getUsername());
        contentValues.put(COLUMN_3,userModelClass.getName());
        contentValues.put(COLUMN_4,userModelClass.getSurname());
        contentValues.put(COLUMN_5,userModelClass.getPassword());
        contentValues.put(COLUMN_6,userModelClass.getGender());
        contentValues.put(COLUMN_7,userModelClass.getEmail());
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }
}
