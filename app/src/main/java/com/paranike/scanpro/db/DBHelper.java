package com.paranike.scanpro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "scan_pro.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UsersTable.SQL_CREATE);
        sqLiteDatabase.execSQL(InventoryTable.SQL_CREATE);
        sqLiteDatabase.execSQL(ItemsTable.SQL_CREATE);

        for(String userIdx: UsersTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(userIdx);
        }
        for(String inventoryIdx: InventoryTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(inventoryIdx);
            sqLiteDatabase.execSQL(inventoryIdx);
        }
        for(String itemIdx: ItemsTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(itemIdx);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for(String userIdx: UsersTable.DROP_INDICES) {
            sqLiteDatabase.execSQL(userIdx);
        }
        for(String inventoryIdx: InventoryTable.DROP_INDICES) {
            sqLiteDatabase.execSQL(inventoryIdx);
            sqLiteDatabase.execSQL(inventoryIdx);
        }
        for(String itemIdx: ItemsTable.DROP_INDICES) {
            sqLiteDatabase.execSQL(itemIdx);
        }
        sqLiteDatabase.execSQL(UsersTable.SQL_DELETE);
        sqLiteDatabase.execSQL(UsersTable.SQL_CREATE);
        sqLiteDatabase.execSQL(ItemsTable.SQL_DELETE);
        sqLiteDatabase.execSQL(ItemsTable.SQL_CREATE);

        for(String userIdx: UsersTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(userIdx);
        }
        for(String inventoryIdx: InventoryTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(inventoryIdx);
            sqLiteDatabase.execSQL(inventoryIdx);
        }
        for(String itemIdx: ItemsTable.CREATE_INDICES) {
            sqLiteDatabase.execSQL(itemIdx);
        }
    }
}
