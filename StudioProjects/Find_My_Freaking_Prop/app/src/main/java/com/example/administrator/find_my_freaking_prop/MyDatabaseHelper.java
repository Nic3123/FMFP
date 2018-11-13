package com.example.administrator.find_my_freaking_prop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //Items table
    public static final String DATABASE_NAME = "inventory.db";
    public static final String TABLE_ITEMS = "items";
    public static final String COL_1 = "itemID";
    public static final String COL_2 = "itemName";
    public static final String COL_3 = "itemLocation";
    public static final String COL_4 = "itemDescription";
    public static final String COL_5 = "renterID";
    public static final String COL_6 = "itemInStock";
    //Person table
    public static final String TABLE_PERSON = "person";


    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Still need to add foreign key to other table after testin
        db.execSQL("create table " + TABLE_PERSON + " (personID INTEGER PRIMARY KEY AUTOINCREMENT, fName TEXT, lName TEXT, phone TEXT, email TEXT)");
        db.execSQL("create table " + TABLE_ITEMS + " (itemID INTEGER PRIMARY KEY AUTOINCREMENT, personID INTEGER, itemName TEXT, itemLocation TEXT, itemDescription TEXT, itemInStock BOOLEAN, dueDate DATE, FOREIGN KEY(personID) REFERENCES person(personID))");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

}
