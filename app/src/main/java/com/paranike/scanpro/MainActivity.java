package com.paranike.scanpro;


import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.paranike.scanpro.common.AppConstants;
import com.paranike.scanpro.core.BarCodeParser;
import com.paranike.scanpro.db.ItemsDataSource;
import com.paranike.scanpro.model.Item;

import java.util.Date;


public class MainActivity extends AppCompatActivity {


    ItemsDataSource itemsDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        itemsDataSource = new ItemsDataSource(this);
        itemsDataSource.open();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button saveBtn = (Button) findViewById(R.id.btnSave);
        Button resetBtn = (Button) findViewById(R.id.btnReset);
        final String areaCode = (String) getIntent().getExtras().get(AppConstants.SCAN_AREA_CODE_KEY);
        final String loggedInUser = (String) getIntent().getExtras().get(AppConstants.LOGGED_IN_USER_KEY);

        final EditText barCode = (EditText) findViewById(R.id.editTextBarcode);

        barCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String scannedBarCode = ((EditText) findViewById(R.id.editTextBarcode)).getText().toString();
                Item comps = new Item(scannedBarCode);

                BarCodeParser parser = new BarCodeParser();
                comps = parser.parsebarCode(comps);
                TextView sap = findViewById(R.id.textViewSapCodeData);
                TextView toolName = findViewById(R.id.textViewToolNameData);
                TextView toolBatchNumber = findViewById(R.id.textViewToolBNumberData);
                TextView grnNumber = findViewById(R.id.textViewToolGrnNumberData);
                TextView batchNumber = findViewById(R.id.textViewBNumberData);
                TextView inspLotNumber = findViewById(R.id.textViewInspLotData);
                TextView textViewLocation = findViewById(R.id.textViewLocationData);
                textViewLocation.setText(areaCode);
                sap.setText(comps.getSapCode());
                toolName.setText(comps.getToolName());
                toolBatchNumber.setText(comps.getToolBatchNumber());
                grnNumber.setText(comps.getGrnNumber());
                batchNumber.setText(comps.getRmBatchNumber());
                inspLotNumber.setText(comps.getInspLotNumber());
                EditText qty = (EditText) findViewById(R.id.textViewQtyData);
                qty.setText("1");
                qty.requestFocus();

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataAction(view, areaCode, loggedInUser);
            }
        });

        saveBtn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyCode == KeyEvent.KEYCODE_ENTER)
                    saveDataAction(view, areaCode, loggedInUser);
                    return true;
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });

    }

    private void saveDataAction(View view, String areaCode, String loggedInUser) {

        String scannedBarCode = ((EditText) findViewById(R.id.editTextBarcode)).getText().toString();
        if (scannedBarCode == null || scannedBarCode.isEmpty()) {
            Toast.makeText(view.getContext(), "Please scan before saving.", Toast.LENGTH_LONG).show();
            return;
        }
        Item scannedItem = new Item(scannedBarCode);

        BarCodeParser parser = new BarCodeParser();
        scannedItem = parser.parsebarCode(scannedItem);
        scannedItem.setRptGenerated(false);
        scannedItem.setScanLocation(areaCode);
        scannedItem.setUser(loggedInUser);
        scannedItem.setScanTimeStamp(new Date().getTime());
        EditText qty = (EditText) findViewById(R.id.textViewQtyData);
        String quant = qty.getText().toString();
        int q = 0;
        try {
            q = Integer.parseInt(quant);
        } catch (NumberFormatException nfe) {
            Toast.makeText(view.getContext(), "Qunatity could only be positive interger number.", Toast.LENGTH_LONG).show();
            return;
        }
        scannedItem.setQuantity(q);
        try {
            itemsDataSource.insertItem(scannedItem);
        } catch (SQLiteException sle) {
            Toast.makeText(view.getContext(), "Save Operation Failed!!!", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(view.getContext(), "Save Operation Successful!!!", Toast.LENGTH_SHORT).show();
        clearData();
    }

    private void clearData() {
        EditText barCode = (EditText) findViewById(R.id.editTextBarcode);
        barCode.setText("");
        EditText qty = (EditText) findViewById(R.id.textViewQtyData);
        qty.setText("");
        TextView textViewLocation = findViewById(R.id.textViewLocationData);
        textViewLocation.setText("");
        barCode.requestFocus();

    }

    @Override
    protected void onPause() {
        super.onPause();
        itemsDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemsDataSource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
