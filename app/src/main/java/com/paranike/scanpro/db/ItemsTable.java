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
    public static final String COLUMN_TIME_STAMP_STR_FORMAT = "timeStampStrFormat";
    public static final String COLUMN_SCANNED_BY_USER = "scannedByUser";
    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_BARCOE, COLUMN_SAP_CODE, COLUMN_TOOL_NAME, COLUMN_TOOL_BATCH_NUMBER,
            COLUMN_GRN_NUMBER, COLUMN_BATCH_NUMBER_RM, COLUMN_INSP_LOT_NUMBER, COLUMN_QUANTITY,
            COLUMN_SCAN_LOCATION,COLUMN_IS_RPT_GENRATED, COLUMN_TIME_STAMP_STR_FORMAT, COLUMN_SCANNED_BY_USER
    };
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
                    COLUMN_IS_RPT_GENRATED + " INTEGER," +
                    COLUMN_TIME_STAMP_STR_FORMAT + " TEXT, "  +
                    COLUMN_SCANNED_BY_USER + " TEXT "+
                    ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}

