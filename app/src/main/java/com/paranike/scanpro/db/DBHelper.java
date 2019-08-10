package com.paranike.scanpro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.paranike.scanpro.db.ItemsTable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "scan_pro.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ItemsTable.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ItemsTable.SQL_DELETE);
        sqLiteDatabase.execSQL(ItemsTable.SQL_CREATE);
    }
}
