package com.paranike.scanpro;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.paranike.scanpro.core.BarCodeParser;
import com.paranike.scanpro.model.Item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText userName = null;
    EditText password = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbarLogin);
        setSupportActionBar(toolbar);
        findViewById(R.id.editTextPassword).requestFocus();


        //TODO
        /*
        For demo lets have dummy login with admin user and 12345 as password, We will add further db intercation later.
         */
        Button loginBtn = (Button) findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = (EditText) findViewById(R.id.editTextUserName);
                password= (EditText) findViewById(R.id.editTextPassword);
                String userNameVal = userName.getText().toString();
                String passwordVal = password.getText().toString();
                boolean isAllowed = isValidUser(userNameVal, passwordVal);
                if(isAllowed) {

                    Intent loginIntent = new Intent(LoginActivity.this, AreaCodeActivity.class);
                    startActivity(loginIntent);
                }
                else{
                    Toast.makeText(view.getContext(), "UserName password combination is not valid, Login denied", Toast.LENGTH_LONG).show();
                }
            }
        });



    }


    private boolean isValidUser(String user, String pass) {
        boolean isAllowed = false;
        if(user==null || user.isEmpty()) {
            return false;
        }
        if(pass==null || pass.isEmpty()) {
            return false;
        }
        if(user.equalsIgnoreCase("Admin") && pass.equalsIgnoreCase("12345")) {
            isAllowed = true;
        }
        return isAllowed;
    }
}
