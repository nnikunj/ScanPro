package com.paranike.scanpro.model;

import android.content.ContentValues;

import com.paranike.scanpro.db.ItemsTable;

import java.util.Objects;


public class Item {

    private final int NUMBER_OF_FIELDS = 12;
    private String id;
    private  String barCode;
    private String sapCode;
    private String toolName;
    private String toolBatchNumber;
    private String grnNumber;
    private String rmBatchNumber;
    private String inspLotNumber;
    private int quantity;
    private String scanLocation;
    private int isRptGenerated;
    private long scanTimeStamp;

    public Item() {

    }
    public Item(String barCode) {
        this.barCode = barCode;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRptGenerated() {
        if (isRptGenerated == 0) {
            return false;
        } else {
            return true;
        }

    }

    public void setRptGenerated(boolean rptGenerated) {
        if (rptGenerated == false) {
            isRptGenerated = 1;
        } else {
            isRptGenerated = 0;
        }

    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getSapCode() {
        return sapCode;
    }

    public long getScanTimeStamp() {
        return scanTimeStamp;
    }

    public void setScanTimeStamp(long scanTimeStamp) {
        this.scanTimeStamp = scanTimeStamp;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolBatchNumber() {
        return toolBatchNumber;
    }

    public void setToolBatchNumber(String toolBatchNumber) {
        this.toolBatchNumber = toolBatchNumber;
    }

    public String getGrnNumber() {
        return grnNumber;
    }

    public void setGrnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
    }

    public String getRmBatchNumber() {
        return rmBatchNumber;
    }

    public void setRmBatchNumber(String rmBatchNumber) {
        this.rmBatchNumber = rmBatchNumber;
    }

    public String getInspLotNumber() {
        return inspLotNumber;
    }

    public void setInspLotNumber(String inspLotNumber) {
        this.inspLotNumber = inspLotNumber;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScanLocation() {
        return scanLocation;
    }

    public void setScanLocation(String scanLocation) {
        this.scanLocation = scanLocation;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(NUMBER_OF_FIELDS);
        values.put(ItemsTable.COLUMN_ID, this.id);
        values.put(ItemsTable.COLUMN_BARCOE, this.barCode);
        values.put(ItemsTable.COLUMN_SAP_CODE, this.sapCode);
        values.put(ItemsTable.COLUMN_TOOL_NAME, this.toolName);
        values.put(ItemsTable.COLUMN_TOOL_BATCH_NUMBER, this.toolBatchNumber);
        values.put(ItemsTable.COLUMN_GRN_NUMBER, this.grnNumber);
        values.put(ItemsTable.COLUMN_BATCH_NUMBER_RM, this.rmBatchNumber);
        values.put(ItemsTable.COLUMN_INSP_LOT_NUMBER, this.inspLotNumber);
        values.put(ItemsTable.COLUMN_QUANTITY, this.quantity);
        values.put(ItemsTable.COLUMN_SCAN_LOCATION, this.scanLocation);
        values.put(ItemsTable.COLUMN_IS_RPT_GENRATED, this.isRptGenerated);
        values.put(ItemsTable.COLUMN_TIME_STAMP_STR_FORMAT, String.valueOf(this.scanTimeStamp));

        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item that = (Item) o;
        return barCode.equals(that.barCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id='").append(id).append('\'');
        sb.append(", barCode='").append(barCode).append('\'');
        sb.append(", sapCode='").append(sapCode).append('\'');
        sb.append(", toolName='").append(toolName).append('\'');
        sb.append(", toolBatchNumber='").append(toolBatchNumber).append('\'');
        sb.append(", grnNumber='").append(grnNumber).append('\'');
        sb.append(", rmBatchNumber='").append(rmBatchNumber).append('\'');
        sb.append(", inspLotNumber='").append(inspLotNumber).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", scanLocation='").append(scanLocation).append('\'');
        sb.append(", isRptGenerated=").append(isRptGenerated);
        sb.append(", scanTimeStamp=").append(scanTimeStamp);
        sb.append('}');
        return sb.toString();
    }
}
