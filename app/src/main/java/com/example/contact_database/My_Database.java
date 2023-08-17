package com.example.contact_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class My_Database extends SQLiteOpenHelper {
    public My_Database(@Nullable Context context) {
        super(context, "CONTACTS", null, 1);
        Log.d("YYY", "My_Database: Created Database");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table Contacts (ID integer primary key autoincrement,NAME text, SURNAME text, NUMBER text)";
        db.execSQL(query);
        Log.d("YYY", "onCreate: Created Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContacts(String name, String surname, String number) {
        String query="insert into Contacts(NAME,SURNAME,NUMBER)values('"+name+"','"+surname+"','"+number+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor showdata() {
        String query="select * from Contacts";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        return  cursor;
    }



    public void updateContact(int id, String name, String surname, String number) {
        String query="update Contacts set NAME='"+name+"', "+" SURNAME = '"+surname+"', NUMBER  = '"+number+"' where ID ="+id+"";

        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
        Log.d("TTT", "UpdateContact:database "+name);
    }

    public void DeleteDataBase(int id) {
     String query= "delete from Contacts where ID="+id+"";
     SQLiteDatabase db=getWritableDatabase();
     db.execSQL(query);
    }
}
