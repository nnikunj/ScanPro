package com.paranike.scanpro.db;

public class InventoryTable {
    public static final String TABLE_INVENTORY = "inventory";
    public static final String COLUMN_ID = "id";

    public static final String COLUMN_ITEM_CODE = "item_code";

    public static final String COLUMN_STOCK = "stock";

    public static final String COLUMN_TOOL_TYPE = "tool_type";
    public static final String[] ALL_COLUMNS = {
            COLUMN_ID, //
            COLUMN_ITEM_CODE, //
            COLUMN_STOCK, //
            COLUMN_TOOL_TYPE //
    };

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_INVENTORY + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_ITEM_CODE + " TEXT," +
                    COLUMN_STOCK + " INTEGER," +
                    COLUMN_TOOL_TYPE + " TEXT " +

                    ");";

    public static final String[] CREATE_INDICES = {
            "CREATE INDEX IF NOT EXISTS "+TABLE_INVENTORY+"_"+COLUMN_ID+"_idx "+ TABLE_INVENTORY+"("+COLUMN_ID+");",
            "CREATE INDEX IF NOT EXISTS "+TABLE_INVENTORY+"_"+COLUMN_ITEM_CODE+"_idx "+ TABLE_INVENTORY+"("+COLUMN_ITEM_CODE+");"
    };
    public static final String[] DROP_INDICES = {
            "DROP INDEX IF EXISTS "+TABLE_INVENTORY+"_"+COLUMN_ID+"_idx ;",
            "DROP INDEX IF EXISTS "+TABLE_INVENTORY+"_"+COLUMN_ITEM_CODE+"_idx ;"

    };
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_INVENTORY;

}
