package com.example.asse.sweapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class UserServices extends AppCompatActivity {
    Button pizabutton = null;
    Button hospital = null;
    Context myContext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_services);
        myContext2 = this.getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pizabutton = (Button)findViewById(R.id.pizza);
        hospital = (Button)findViewById(R.id.hospital);
        pizabutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent piza_intent = new Intent(myContext2, Piza_houses.class);
                startActivity(piza_intent);
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent hospital_intent = new Intent(myContext2, Hospital.class);
                startActivity(hospital_intent);
            }
        });
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

}
