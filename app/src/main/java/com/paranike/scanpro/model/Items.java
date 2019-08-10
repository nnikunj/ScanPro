package com.paranike.scanpro.model;

import android.content.ContentValues;

import com.paranike.scanpro.db.ItemsTable;

import java.util.Objects;

public class Items {

    private final int NUMBER_OF_FIELDS = 8;
    private String id;
    private final String barCode;
    private String sapCode;
    private String toolName;
    private String toolBatchNumber;
    private String grnNumber;
    private String rmBatchNumber;
    private String inspLotNumber;
    private int quantity;
    private String scanLocation;


    public Items(String barCode) {
        this.barCode = barCode;
    }

    public String getId() {
        return id;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getSapCode() {
        return sapCode;
    }

    public void setId(String id) {
        this.id = id;
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

    public ContentValues toValues() {
        ContentValues values = new ContentValues(NUMBER_OF_FIELDS);
        values.put(ItemsTable.COLUMN_ID, this.id);
        values.put(ItemsTable.COLUMN_BARCOE, this.barCode);
        values.put(ItemsTable.COLUMN_SAP_CODE, this.sapCode);
        //  private String toolName;
        // private String toolBatchNumber;
        // private String grnNumber;
        // private String rmBatchNumber;
        //private String inspLotNumber;

        values.put(ItemsTable.COLUMN_ID, this.toolName);
        values.put(ItemsTable.COLUMN_ID, this.toolBatchNumber);
        values.put(ItemsTable.COLUMN_ID, this.grnNumber);
        values.put(ItemsTable.COLUMN_ID, this.rmBatchNumber);
        values.put(ItemsTable.COLUMN_ID, this.inspLotNumber);


        return values;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items that = (Items) o;
        return barCode.equals(that.barCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }


}
