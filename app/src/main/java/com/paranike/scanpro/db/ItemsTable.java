package com.paranike.scanpro.db;


public class ItemsTable {

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BARCOE = "barCode";
    public static final String COLUMN_SAP_CODE = "sapCode";
    public static final String COLUMN_TOOL_NAME = "toolName";
    public static final String COLUMN_TOOL_BATCH_NUMBER = "toolBatchNumber";
    public static final String COLUMN_GRN_NUMBER = "grnNumber";
    public static final String COLUMN_BATCH_NUMBER_RM = "rmBatchNumber";
    public static final String COLUMN_INSP_LOT_NUMBER = "inspLotNumber";

    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SCAN_LOCATION = "scanLocation";
    public static final String COLUMN_IS_RPT_GENRATED = "isRptGenerated";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_BARCOE + " TEXT," +
                    COLUMN_SAP_CODE + " TEXT," +
                    COLUMN_TOOL_NAME + " TEXT," +
                    COLUMN_TOOL_BATCH_NUMBER + " TEXT," +
                    COLUMN_GRN_NUMBER + " TEXT," +
                    COLUMN_BATCH_NUMBER_RM + " TEXT," +
                    COLUMN_INSP_LOT_NUMBER + " TEXT," +
                    COLUMN_QUANTITY + " INTEGER," +
                    COLUMN_SCAN_LOCATION + " TEXT," +
                    COLUMN_IS_RPT_GENRATED + " INTEGER" +
                    ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}

