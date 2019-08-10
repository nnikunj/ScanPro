package com.paranike.scanpro;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.paranike.scanpro.core.BarCodeParser;
import com.paranike.scanpro.db.ItemsDataSource;
import com.paranike.scanpro.model.Items;


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
        Button saveBtn = (Button) findViewById(R.id.btnSave);
        Button resetBtn = (Button) findViewById(R.id.btnReset);

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
                Items comps = new Items(scannedBarCode);

                BarCodeParser parser = new BarCodeParser();
                comps = parser.parsebarCode(comps);
                TextView sap = findViewById(R.id.textViewSapCodeData);
                TextView toolName = findViewById(R.id.textViewToolNameData);
                TextView toolBatchNumber = findViewById(R.id.textViewToolBNumberData);
                TextView grnNumber = findViewById(R.id.textViewToolGrnNumberData);
                TextView batchNumber = findViewById(R.id.textViewBNumberData);
                TextView inspLotNumber = findViewById(R.id.textViewInspLotData);

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
                String text = ((EditText) findViewById(R.id.editTextBarcode)).getText().toString();
                Snackbar.make(view, "Scanned BarCode is " + text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText barCode = (EditText) findViewById(R.id.editTextBarcode);
                barCode.setText("");
                EditText qty = (EditText) findViewById(R.id.textViewQtyData);
                qty.setText("");
                ((EditText) findViewById(R.id.editTextBarcode)).requestFocus();
            }
        });

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
