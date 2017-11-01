package com.example.edenbarhum.myfriend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eden barhum on 02/07/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cmd = "CREATE TABLE IF NOT EXISTS friends(Name TEXT, LastName TEXT, Age INT);";

        try {
            sqLiteDatabase.execSQL(cmd);
        }catch (SQLiteException e){
            e.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
