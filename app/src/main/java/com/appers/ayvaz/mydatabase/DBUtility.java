package com.appers.ayvaz.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;

/**
 * Created by Ayvaz on 10/12/2015.
 */
public class DBUtility{
    MeDataBase mydb;
    public static final String DATABASE_NAME = "my.db";
    public static final int DATABASE_VER = 1;
    SQLiteDatabase db;

    public DBUtility(Context context) {
        super();
        mydb = new MeDataBase(context, DATABASE_NAME, null, DATABASE_VER);
        db = mydb.getWritableDatabase();
    }

    public long insertData(String name, String num) {
        long id = 0;

        ContentValues content = new ContentValues();
        content.put(mydb.CUSTOMER_COLUMN_NAME, name);
        content.put(mydb.CUSTOMER_COLUMN_AMOUNT, num);

        id = db.insert(MeDataBase.CUSTOMERS_TABLE_NAME, null, content);
        return id;
    }

    public Cursor retreive() {
        //String where = mydb.CUSTOMERS_COLUMN_ID + "=?";
        //String[] where_args = {"" + id};
        String columns[] = {mydb.CUSTOMER_COLUMN_NAME, mydb.CUSTOMER_COLUMN_AMOUNT};
        Cursor cursor = db.query(MeDataBase.CUSTOMERS_TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }
    public Cursor retreiveAll(Context context) {
        File f = context.getDatabasePath(DATABASE_NAME);
        long dbSize = f.length();
        String where = mydb.CUSTOMERS_COLUMN_ID + "=?";
        String[] where_args = {"" + dbSize};
        String columns[] = {mydb.CUSTOMER_COLUMN_NAME, mydb.CUSTOMER_COLUMN_AMOUNT};
        Cursor cursor = db.query(MeDataBase.CUSTOMERS_TABLE_NAME, columns, where, where_args, null, null, null);
        return cursor;
    }

    public int delete(int id) {
        int rows = 0;
        String where = mydb.CUSTOMERS_COLUMN_ID + "=?";
        String[] where_args = {"" + id};
        rows = db.delete(MeDataBase.CUSTOMERS_TABLE_NAME, where, where_args);
        return rows;
    }
}
