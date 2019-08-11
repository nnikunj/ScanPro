package com.paranike.scanpro;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.paranike.scanpro.common.AppConstants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AreaCodeActivity extends AppCompatActivity {
    EditText scanAreaLoc = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_code);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String loggedInUser=(String) getIntent().getExtras().get(AppConstants.LOGGED_IN_USER_KEY);
        
        Button loginBtn = (Button) findViewById(R.id.btnNext);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scanAreaLoc = (EditText) findViewById(R.id.editTextAreaLocation);

                String areaLocation = scanAreaLoc.getText().toString();


                if(areaLocation!=null && !areaLocation.isEmpty()) {

                    Intent mainIntent = new Intent(AreaCodeActivity.this, MainActivity.class);
                    mainIntent.putExtra(AppConstants.SCAN_AREA_CODE_KEY, areaLocation);
                    mainIntent.putExtra(AppConstants.LOGGED_IN_USER_KEY, loggedInUser);
                    startActivity(mainIntent);
                }
                else{
                    Toast.makeText(view.getContext(), "Scan Area location before going to next screen", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
