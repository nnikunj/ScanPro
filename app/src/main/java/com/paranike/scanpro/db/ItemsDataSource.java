package com.paranike.scanpro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.paranike.scanpro.model.Item;

import java.util.UUID;

public class ItemsDataSource {
    private final Context context;
    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public ItemsDataSource(Context context) {
        this.context = context;
        this.dbHelper = new DBHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
    }

    public void open() {
        this.database = this.dbHelper.getWritableDatabase();
    }

    public void close() {
        this.dbHelper.close();
    }

    public Item insertItem(Item item) {
        if (item == null) {
            return null;
        }
        if (item.getId() == null || item.getId().isEmpty()) {
            item.setId(UUID.randomUUID().toString());
        }

        database.insert(ItemsTable.TABLE_ITEMS, null, item.toValues());

        return item;
    }
}
