package com.example.edenbarhum.myfriend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;

/**
 * Created by eden barhum on 02/07/2017.
 */

public class DBHandler {

    private Context context;
    private DBHelper helper;

    public DBHandler(Context context){
        this.context = context;
        helper = new DBHelper(context, "myFriends.db", null ,1);
    }

    public void addFriend(String name, String lastName, int age){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("LastName", lastName);
        values.put("Age", age);


        try{
            db.insertOrThrow("friends", null, values);
        }catch (SQLiteException e){

        }finally {
            if (db.isOpen())
                db.close();
        }
    }

    public ArrayList<String> getAllFriends(){
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = null;
        SQLiteDatabase db = helper.getReadableDatabase();

        try {
            cursor = db.query("friends", null, null, null, null, null, null);
        }
        catch (SQLiteException e){
            e.getMessage();
        }

        while (cursor.moveToNext()){

            String name =cursor.getString(0);
            String lastName = cursor.getString(1);
            int age = cursor.getInt(2);
            list.add(name + " " + lastName + " " + age);
        }

        return list;
    }


}
