package com.example.pavel.finalpj10;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contact1.db";
    public static final String TABLE_CONTACTS = "contacts1";
    public static final String KEY_ID = "_id";
    public static final String KEY_DATA = "data";
    public static final String KEY_EDIT1 = "ediit1";
    public static final String KEY_EDIT2 = "ediit2";
    public static final String KEY_EDIT3 = "ediit3";
    public static final String KEY_EDIT4 = "ediit4";
    public static final String KEY_EDIT5 = "ediit5";
    public static final String KEY_EDIT6 = "ediit6";

    public DBHelper2(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //определяются поля для таблицы
    public DBHelper2(Context context) { super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="create table " + TABLE_CONTACTS + " ( " + KEY_ID + " integer primary key autoincrement, " +KEY_DATA+" text,"+KEY_EDIT1+" text,"+
                KEY_EDIT2 +" text,"+ KEY_EDIT3 +" text,"+ KEY_EDIT4+" text,"+ KEY_EDIT5 +" text,"+ KEY_EDIT6+" text);";
//создаётся таблица
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);
        onCreate(db);
    }
}