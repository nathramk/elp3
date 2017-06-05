package com.example.usuario.examlp3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView viewNombre;
    TextView viewLastName;
    TextView viewUser;
    SharedPreferences sharedPreferences;

    public static final String mypreference = "mypref";
    public static final String Username1 = "nameKey";
    public static final String Username2 = "lastNameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewNombre = (TextView) findViewById(R.id.viewNombre);
        viewLastName = (TextView) findViewById(R.id.viewLastName);
        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        viewNombre.setText(sharedPreferences.getString(Username1,""));
        viewLastName.setText(sharedPreferences.getString(Username2,""));


    }

}
