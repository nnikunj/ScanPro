package com.paranike.scanpro.core;

import com.paranike.scanpro.model.BarCodeCoponents;

public class BarCodeParser {

    public BarCodeCoponents parsebarCode(BarCodeCoponents barcodeModel) {
        if (barcodeModel == null) {
            return null;
        }
        String barCode = barcodeModel.getBarCode();
        if (barCode != null && barCode.length() > 0) {
            String splitCode[] = barCode.split("$");
            for (int i = 0; i < splitCode.length; i++) {
                if (i == 0) {
                    barcodeModel.setSapCode(splitCode[i]);
                }
                if (i == 1) {
                    barcodeModel.setToolName(splitCode[i]);
                }
                if (i == 2) {
                    barcodeModel.setToolBatchNumber(splitCode[i]);
                }
                if (i == 3) {
                    barcodeModel.setGrnNumber(splitCode[i]);
                }
                if (i == 4) {
                    barcodeModel.setRmBatchNumber(splitCode[i]);
                }
                if (i == 5) {
                    barcodeModel.setInspLotNumber(splitCode[i]);
                }
            }
        }
        return barcodeModel;

    }
}
