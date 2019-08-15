package com.paranike.scanpro;

import android.content.Intent;
import android.os.Bundle;

import com.paranike.scanpro.common.AppConstants;
import com.paranike.scanpro.db.ItemsDataSource;
import com.paranike.scanpro.model.Item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class AreaCodeActivity extends AppCompatActivity {
    EditText scanAreaLoc = null;
    ItemsDataSource itemsDataSource;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_code);
        Toolbar toolbar = findViewById(R.id.toolbar);
        itemsDataSource = new ItemsDataSource(this);
        itemsDataSource.open();
        setSupportActionBar(toolbar);
        final String loggedInUser = (String) getIntent().getExtras().get(AppConstants.LOGGED_IN_USER_KEY);

        Button loginBtn = (Button) findViewById(R.id.btnNext);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scanAreaLoc = (EditText) findViewById(R.id.editTextAreaLocation);

                String areaLocation = scanAreaLoc.getText().toString();


                if (areaLocation != null && !areaLocation.isEmpty()) {

                    Intent mainIntent = new Intent(AreaCodeActivity.this, MainActivity.class);
                    mainIntent.putExtra(AppConstants.SCAN_AREA_CODE_KEY, areaLocation);
                    mainIntent.putExtra(AppConstants.LOGGED_IN_USER_KEY, loggedInUser);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(view.getContext(), "Scan Area location before going to next screen", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button csvBtn = (Button) findViewById(R.id.btnGenerateCSV);


        csvBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Log.i("BLA", "JAI Hind");
                    List<Item> items = itemsDataSource.updateAndGetAllItemsForWhichRptInNotGenerated();
                    if (items.size() == 0) {
                        Toast.makeText(view.getContext(), "No data for report generation available.", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Log.i("BLA", items.toString());
                    File op = new File(Environment.getExternalStorageDirectory(), "storage/data_export.csv");
                    //FileUtils.deleteQuietly(op);
                    op.setReadable(true);
                    op.setWritable(true);
                    op.setExecutable(true);


                    StringWriter sw = new StringWriter();
                    String pattern = "yyyy-MMM-dd HH:mm:ss";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                    CSVPrinter csvPrinter = new CSVPrinter(sw, CSVFormat.DEFAULT.withHeader("Tool Name", "SAP Code", "Batch No (RM)", "Tool Batch No", "GRN No", "Insp Lot No", "Qty",
                            "Storage Location (From Scanner)", "Stock Taken By", "Date time"));
                    for (Item it : items) {


                        String date = simpleDateFormat.format(it.getScanTimeStamp());
                        csvPrinter.printRecord(it.getToolName(), it.getSapCode(), it.getRmBatchNumber(), it.getToolBatchNumber(), it.getGrnNumber(),
                                it.getInspLotNumber(), it.getQuantity(), it.getScanLocation(), it.getUser(), date);

                    }
                    csvPrinter.flush();
                    Toast.makeText(view.getContext(), "Generated Report.", Toast.LENGTH_LONG).show();
                    FileUtils.write(op, sw.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(view.getContext(), "Could not write output csv."+e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}
