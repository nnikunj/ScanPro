package com.paranike.scanpro.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.paranike.scanpro.model.Item;

import java.util.ArrayList;
import java.util.List;
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

    public List<Item> updateAndGetAllItemsForWhichRptInNotGenerated() {
        ArrayList<Item> allItems = new ArrayList<Item>();

        String[] filterData = {"0"};
       // Cursor cursor = database.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS, ItemsTable.COLUMN_IS_RPT_GENRATED + "=?" ,filterData, null, null, null);
        Cursor cursor = database.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS, null, null, null, null, ItemsTable.COLUMN_ID);

       // database.beginTransaction();
        try {
            while (cursor.moveToNext()) {
                Item item = new Item();
                item.setId(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_ID)));


                item.setBarCode(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_BARCOE)));
                item.setSapCode(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_SAP_CODE)));
                item.setToolName(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_TOOL_NAME)));

                item.setToolBatchNumber(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_TOOL_BATCH_NUMBER)));
                item.setGrnNumber(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_GRN_NUMBER)));
                item.setInspLotNumber(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_INSP_LOT_NUMBER)));

                item.setQuantity(cursor.getInt(
                        cursor.getColumnIndex(ItemsTable.COLUMN_QUANTITY)));

                item.setScanLocation(cursor.getString(
                        cursor.getColumnIndex(ItemsTable.COLUMN_SCAN_LOCATION)));
//(cursor.getInt(
//                        cursor.getColumnIndex(ItemsTable.COLUMN_IS_RPT_GENRATED)) == 0) ? false : true
                item.setRptGenerated(true);
                item.setUser(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_SCANNED_BY_USER)));
                item.setScanTimeStamp(Long.parseLong(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_TIME_STAMP_STR_FORMAT))));
              //  database.update(ItemsTable.TABLE_ITEMS, item.toValues(),"_id="+item.getId(), null);
                allItems.add(item);

            //    database.setTransactionSuccessful();
              //  database.endTransaction();
            }
        } catch (Exception e) {
          //  database.endTransaction();
            throw new RuntimeException(e.getMessage(),e);
        }

        database.endTransaction();
        cursor.close();
        return allItems;
    }

    public List<Item> getAllItems() {
        ArrayList<Item> allItems = new ArrayList<Item>();

        Cursor cursor = database.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS, null, null, null, null, ItemsTable.COLUMN_ID);

        while (cursor.moveToNext()) {
            Item item = new Item();
            item.setId(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ID)));


            item.setBarCode(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_BARCOE)));
            item.setSapCode(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_SAP_CODE)));
            item.setToolName(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TOOL_NAME)));

            item.setToolBatchNumber(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TOOL_BATCH_NUMBER)));
            item.setGrnNumber(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_GRN_NUMBER)));
            item.setInspLotNumber(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_INSP_LOT_NUMBER)));

            item.setQuantity(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_QUANTITY)));

            item.setScanLocation(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_SCAN_LOCATION)));

            item.setRptGenerated((cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_IS_RPT_GENRATED)) == 0) ? false : true);


            allItems.add(item);
        }
        cursor.close();
        return allItems;
    }
}
