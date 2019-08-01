package com.paranike.scanpro.model;

import java.util.Objects;

public class BarCodeCoponents {

    private final String barCode;
    private String sapCode;
    private String toolName;
    private String toolBatchNumber;
    private String grnNumber;
    private String rmBatchNumber;
    private String inspLotNumber;

    public BarCodeCoponents(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getSapCode() {
        return sapCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BarCodeCoponents)) return false;
        BarCodeCoponents that = (BarCodeCoponents) o;
        return barCode.equals(that.barCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BarCodeCoponents{");
        sb.append("barCode='").append(barCode).append('\'');
        sb.append(", sapCode='").append(sapCode).append('\'');
        sb.append(", toolName='").append(toolName).append('\'');
        sb.append(", toolBatchNumber='").append(toolBatchNumber).append('\'');
        sb.append(", grnNumber='").append(grnNumber).append('\'');
        sb.append(", rmBatchNumber='").append(rmBatchNumber).append('\'');
        sb.append(", inspLotNumber='").append(inspLotNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
