package com.paranike.scanpro.core;

import com.paranike.scanpro.model.Item;

public class BarCodeParser {

    private int sapCodePos = 0;
    private int toolNamePos = 5;
    private int toolBatchNoPos = 4;
    private int grnNoPos = 1;
    private int rmBatchNoPos = 2;
    private int inspLotNoPos = 3;

    public Item parsebarCode(Item barcodeModel) {
        if (barcodeModel == null) {
            return null;
        }
        String barCode = barcodeModel.getBarCode();
        if (barCode != null && barCode.length() > 0) {
            String splitCode[] = barCode.split("\\$");
            for (int i = 0; i < splitCode.length; i++) {
                if (i == sapCodePos) {
                    barcodeModel.setSapCode(splitCode[i]);
                }
                if (i == toolNamePos) {
                    barcodeModel.setToolName(splitCode[i]);
                }
                if (i == toolBatchNoPos) {
                    barcodeModel.setToolBatchNumber(splitCode[i]);
                }
                if (i == grnNoPos) {
                    barcodeModel.setGrnNumber(splitCode[i]);
                }
                if (i == rmBatchNoPos) {
                    barcodeModel.setRmBatchNumber(splitCode[i]);
                }
                if (i == inspLotNoPos) {
                    barcodeModel.setInspLotNumber(splitCode[i]);
                }
            }
        }
        return barcodeModel;

    }
}
